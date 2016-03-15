package be.rubengerits.buildstatus.services;

import be.rubengerits.buildstatus.consumer.TravisCiConsumer;
import be.rubengerits.buildstatus.model.global.RepositoriesException;
import be.rubengerits.buildstatus.model.global.RepositoriesResponse;
import be.rubengerits.buildstatus.model.global.RepositoryBuildResponse;
import be.rubengerits.buildstatus.model.travisci.Account;
import be.rubengerits.buildstatus.model.travisci.Repository;
import be.rubengerits.buildstatus.model.travisci.TravisCiAccountsResponse;
import be.rubengerits.buildstatus.model.travisci.TravisCiRepositoryBuildResponse;
import org.jboss.resteasy.logging.Logger;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/repositories")
public class RepositoriesService {
    private static final Logger LOGGER = Logger.getLogger(RepositoriesService.class);

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public RepositoriesResponse doGet(@HeaderParam("Authorization") String authorization) throws WebApplicationException {
        try {
            TravisCiAccountsResponse accounts = TravisCiConsumer.getAccounts(authorization);

            List<Repository> repositories = new ArrayList<>();

            for (Account account : accounts.getAccounts()) {
                repositories.addAll(TravisCiConsumer.getRepositories(authorization, account).getRepos());
            }

            return new RepositoriesResponse(repositories);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RepositoriesException(e);
        }
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public RepositoryBuildResponse doGet(@HeaderParam("Authorization") String authorization, @PathParam("id") String id) throws WebApplicationException {
        try {
            TravisCiRepositoryBuildResponse repositoryBuilds = TravisCiConsumer.getRepositoryBuilds(authorization, id);

            return new RepositoryBuildResponse(repositoryBuilds.getBuilds());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RepositoriesException(e);
        }
    }
}