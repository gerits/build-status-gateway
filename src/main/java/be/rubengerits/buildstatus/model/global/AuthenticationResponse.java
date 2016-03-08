package be.rubengerits.buildstatus.model.global;

public class AuthenticationResponse {

	private String accessToken;

	private String message;

	public AuthenticationResponse() {
	}

	public AuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
