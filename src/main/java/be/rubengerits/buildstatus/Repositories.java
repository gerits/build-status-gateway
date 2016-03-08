package be.rubengerits.buildstatus;

import be.rubengerits.buildstatus.model.global.AuthenticationException;
import be.rubengerits.buildstatus.model.global.RepositoriesResponse;

import javax.ws.rs.*;

@Path("/repositories")
public class Repositories {

	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public RepositoriesResponse doGet(@HeaderParam("Authorization") String authentication) throws WebApplicationException {
		try {

			return new RepositoriesResponse();
		} catch (Exception e) {
			throw new AuthenticationException(e);
		}
	}
}