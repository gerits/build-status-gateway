package be.rubengerits.buildstatus.model.global;

import be.rubengerits.buildstatus.api.global.Authentication;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Locale;
import java.util.ResourceBundle;

public class AuthenticationException extends WebApplicationException {

    public static final String ERROR_MESSAGES = "be.rubengerits.buildstatus.ErrorMessages";

    public AuthenticationException(Exception e) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(getAuthenticationResponse(e)).build());
    }

    private static Authentication getAuthenticationResponse(Exception e) {
        if (e instanceof WebApplicationException) {
            Response response = ((WebApplicationException) e).getResponse();
            int status = response.getStatus();

            if (status == 401) {
                return getAuthenticationResponse(status, "authentication.bad.credentials");
            } else if (status == 403) {
                return getAuthenticationResponse(status, "authentication.forbidden");
            }
        }

        return getAuthenticationResponse(400, "default.error");
    }

    private static Authentication getAuthenticationResponse(int errorCode, String messageKey) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(ERROR_MESSAGES, Locale.getDefault());
        Authentication response = new Authentication();
        response.setStatus(errorCode);
        response.setMessage(resourceBundle.getString(messageKey));
        return response;
    }

}
