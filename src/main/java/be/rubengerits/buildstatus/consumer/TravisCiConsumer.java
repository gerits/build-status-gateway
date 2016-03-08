package be.rubengerits.buildstatus.consumer;

import be.rubengerits.buildstatus.model.travisci.TravisCiAuthRequest;
import be.rubengerits.buildstatus.model.travisci.TravisCiAuthResponse;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.core.MediaType;

public class TravisCiConsumer {

	public static final String TRAVIS_API = "https://api.travis-ci.org";

	public static TravisCiAuthResponse createAuth(String githubToken) throws Exception {
		TravisCiAuthRequest request = new TravisCiAuthRequest();
		request.setGithubToken(githubToken);

		ClientResponse response = createTravisCiClient(null, "/auth/github")
				.body(MediaType.APPLICATION_JSON_TYPE, request)
				.post();

		if (response.getStatus() == 200) {
			return (TravisCiAuthResponse) response.getEntity(TravisCiAuthResponse.class);
		}

		throw new Exception("Something wrong?");
	}

	private static ClientRequest createTravisCiClient(String token, String url) {
		ClientRequest request = new ClientRequest(TRAVIS_API + url);
		request.accept(MediaType.APPLICATION_JSON_TYPE);
		request.header("User-Agent", "TravisBuildStatus/1.0.0");
		if (token != null) {
			request.header("Authorization", token);
		}
		request.header("Accept", "application/vnd.travis-ci.2+json");
		return request;
	}

}
