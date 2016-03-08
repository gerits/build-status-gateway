package be.rubengerits.buildstatus;

import be.rubengerits.buildstatus.consumer.GithubConsumer;
import be.rubengerits.buildstatus.consumer.TravisCiConsumer;
import be.rubengerits.buildstatus.model.github.GithubAuthenticationResponse;
import be.rubengerits.buildstatus.model.global.AuthenticationException;
import be.rubengerits.buildstatus.model.global.AuthenticationResponse;
import be.rubengerits.buildstatus.model.travisci.TravisCiAuthResponse;

import javax.ws.rs.*;

@Path("/authenticate")
public class Authenticate {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public AuthenticationResponse doPost(@HeaderParam("Authorization") String authentication) throws WebApplicationException {
		GithubAuthenticationResponse githubResponse = null;
		try {
			githubResponse = GithubConsumer.createAuth(authentication);

			TravisCiAuthResponse travisToken = TravisCiConsumer.createAuth(githubResponse.getToken());

			return new AuthenticationResponse(travisToken.getAccessToken());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			if (githubResponse != null) {
				try {
					GithubConsumer.deleteAuth(authentication, githubResponse.getId());
				} catch (Exception e) {
					e.printStackTrace();
					throw new AuthenticationException(e);
				}
			}
		}
	}
}