package be.rubengerits.buildstatus.consumer;

import be.rubengerits.buildstatus.api.global.Repositories;
import be.rubengerits.buildstatus.api.global.RepositoryBuild;
import be.rubengerits.buildstatus.api.travisci.Account;
import be.rubengerits.buildstatus.model.travisci.TravisCiAccountsResponse;
import be.rubengerits.buildstatus.model.travisci.TravisCiAuthRequest;
import be.rubengerits.buildstatus.model.travisci.TravisCiAuthResponse;
import be.rubengerits.buildstatus.model.travisci.TravisCiRepositoriesResponse;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

public class TravisCiConsumer {

    public static final String TRAVIS_API = "https://api.travis-ci.org";
    public static final String USER_AGENT = "TravisBuildStatus/1.0.0";
    public static final String ACCEPT = "application/vnd.travis-ci.2+json";

    public static TravisCiAuthResponse createAuth(String githubToken) throws Exception {
        TravisCiAuthRequest request = new TravisCiAuthRequest();
        request.setGithubToken(githubToken);

        ClientResponse response = createTravisCiClient(null, "/auth/github")
                .body(MediaType.APPLICATION_JSON_TYPE, request)
                .post();

        if (response.getStatus() == 200) {
            return (TravisCiAuthResponse) response.getEntity(TravisCiAuthResponse.class);
        }

        throw new WebApplicationException(response);
    }

    public static TravisCiAccountsResponse getAccounts(String authorization) throws Exception {
        ClientResponse response = createTravisCiClient(authorization, "/accounts").get();

        if (response.getStatus() == 200) {
            return (TravisCiAccountsResponse) response.getEntity(TravisCiAccountsResponse.class);
        }

        throw new WebApplicationException(response);
    }

    public static TravisCiRepositoriesResponse getRepositories(String authorization, Account account) throws Exception {
        ClientResponse response = createTravisCiClient(authorization, "/repos/?member=" + account.getLogin()).get();

        if (response.getStatus() == 200) {
            return (TravisCiRepositoriesResponse) response.getEntity(TravisCiRepositoriesResponse.class);
        }

        throw new WebApplicationException(response);
    }

    public static RepositoryBuild getRepositoryBuilds(String authorization, String id) throws Exception {
        ClientResponse response = createTravisCiClient(authorization, "/builds/?repository_id=" + id).get();

        if (response.getStatus() == 200) {
            return (RepositoryBuild) response.getEntity(RepositoryBuild.class);
        }

        throw new WebApplicationException(response);
    }

    private static ClientRequest createTravisCiClient(String authorization, String url) {
        ClientRequest request = new ClientRequest(TRAVIS_API + url);
        request.accept(ACCEPT);
        request.header("User-Agent", USER_AGENT);
        if (authorization != null) {
            request.header("Authorization", authorization);
        }
        return request;
    }
}
