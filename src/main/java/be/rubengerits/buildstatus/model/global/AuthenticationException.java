package be.rubengerits.buildstatus.model.global;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class AuthenticationException extends WebApplicationException {

	public AuthenticationException(Exception e) {
		super(Response.status(Response.Status.BAD_REQUEST).entity(getAuthenticationResponse(e)).build());
	}

	private static AuthenticationResponse getAuthenticationResponse(Exception e) {
		AuthenticationResponse response = new AuthenticationResponse();
		response.setMessage(e.getMessage());
		return response;
	}

}
