package be.rubengerits.buildstatus.consumer;

import be.rubengerits.buildstatus.model.github.GithubAuthenticationRequest;
import be.rubengerits.buildstatus.model.github.GithubAuthenticationResponse;
import be.rubengerits.buildstatus.model.github.GithubErrorResponse;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class GithubConsumer {

	public static final String GITHUB_API = "https://api.github.com";
	public static final String AUTHORIZATIONS = "/authorizations";

	public static GithubAuthenticationResponse createAuth(String authorization) throws Exception {
		GithubAuthenticationRequest authenticationRequest = new GithubAuthenticationRequest();

		List<String> scopes = authenticationRequest.getScopes();
		scopes.add("read:org");
		scopes.add("user:email");
		scopes.add("repo_deployment");
		scopes.add("repo:status");
		scopes.add("write:repo_hook");
		authenticationRequest.setNote("Build Status Gateway");

		ClientResponse response = createGithubClient(authorization, AUTHORIZATIONS)
				.body(MediaType.APPLICATION_JSON_TYPE, authenticationRequest)
				.post();

		if (response.getStatus() == 201) {
			return (GithubAuthenticationResponse) response.getEntity(GithubAuthenticationResponse.class);
		}

		GithubErrorResponse githubError = (GithubErrorResponse) response.getEntity(GithubErrorResponse.class);
		throw new Exception(githubError.getMessage());
	}

	public static void deleteAuth(String authorization, String id) throws Exception {
		createGithubClient(authorization, AUTHORIZATIONS + "/" + id).delete();
	}

	private static ClientRequest createGithubClient(String authorization, String url) {
		ClientRequest request = new ClientRequest(GITHUB_API + url);
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("Authorization", authorization);
		request.header("Accept", "application/vnd.github.v3+json");
		return request;
	}

}
