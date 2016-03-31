package be.rubengerits.buildstatus.services;

import be.rubengerits.buildstatus.api.global.Repositories;
import be.rubengerits.buildstatus.api.global.Repository;
import be.rubengerits.buildstatus.api.global.RepositoryBuild;
import be.rubengerits.buildstatus.api.travisci.Account;
import be.rubengerits.buildstatus.consumer.TravisCiConsumer;
import be.rubengerits.buildstatus.model.global.RepositoriesException;
import be.rubengerits.buildstatus.model.travisci.TravisCiAccountsResponse;
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
    public Repositories doGet(@HeaderParam("Authorization") String authorization) throws WebApplicationException {
        try {
            TravisCiAccountsResponse accounts = TravisCiConsumer.getAccounts(authorization);

            List<Repository> repositories = new ArrayList<>();

            for (Account account : accounts.getAccounts()) {
                repositories.addAll(TravisCiConsumer.getRepositories(authorization, account).getRepos());
            }

            return new Repositories(repositories);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RepositoriesException(e);
        }
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public RepositoryBuild doGet(@HeaderParam("Authorization") String authorization, @PathParam("id") String id) throws WebApplicationException {
        try {
            RepositoryBuild repositoryBuilds = TravisCiConsumer.getRepositoryBuilds(authorization, id);

            return new RepositoryBuild(repositoryBuilds.getBuilds());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RepositoriesException(e);
        }
    }
}