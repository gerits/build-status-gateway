package be.rubengerits.buildstatus.model.global;

import be.rubengerits.buildstatus.api.global.Repositories;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Locale;
import java.util.ResourceBundle;

public class RepositoriesException extends WebApplicationException {

	public static final String ERROR_MESSAGES = "be.rubengerits.buildstatus.ErrorMessages";

	public RepositoriesException(Exception e) {
		super(Response.status(Response.Status.BAD_REQUEST).entity(getAuthenticationResponse(e)).build());
	}

	private static Repositories getAuthenticationResponse(Exception e) {
//		if (e instanceof WebApplicationException) {
//			Response response = ((WebApplicationException) e).getResponse();
//			int status = response.getStatus();
//
//			if (status == 401) {
//				return getAuthenticationResponse(status, "authentication.bad.credentials");
//			} else if (status == 403) {
//				return getAuthenticationResponse(status, "authentication.forbidden");
//			}
//		}

		return getAuthenticationResponse(400, "default.error");
	}

	private static Repositories getAuthenticationResponse(int errorCode, String messageKey) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(ERROR_MESSAGES, Locale.getDefault());
		Repositories response = new Repositories();
		response.setStatus(errorCode);
		response.setMessage(resourceBundle.getString(messageKey));
		return response;
	}

}
