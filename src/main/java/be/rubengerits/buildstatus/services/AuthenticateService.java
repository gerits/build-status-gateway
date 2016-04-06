package be.rubengerits.buildstatus.services;

import be.rubengerits.buildstatus.api.global.Authentication;
import be.rubengerits.buildstatus.consumer.GithubConsumer;
import be.rubengerits.buildstatus.consumer.TravisCiConsumer;
import be.rubengerits.buildstatus.model.github.GithubAuthenticationResponse;
import be.rubengerits.buildstatus.model.global.AuthenticationException;
import be.rubengerits.buildstatus.model.travisci.TravisCiAuthResponse;
import org.jboss.resteasy.logging.Logger;

import javax.ws.rs.*;

@Path("/authenticate")
public class AuthenticateService {
    private static final Logger LOGGER = Logger.getLogger(AuthenticateService.class);

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Authentication doPost(@HeaderParam("Authorization") String authentication) throws WebApplicationException {
        GithubAuthenticationResponse githubResponse = null;
        try {
            githubResponse = GithubConsumer.createAuth(authentication);

            TravisCiAuthResponse travisToken = TravisCiConsumer.createAuth(githubResponse.getToken());

            return new Authentication(travisToken.getAccessToken());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new AuthenticationException(e);
        } finally {
            if (githubResponse != null) {
                try {
                    GithubConsumer.deleteAuth(authentication, githubResponse.getId());
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                    throw new AuthenticationException(e);
                }
            }
        }
    }
}