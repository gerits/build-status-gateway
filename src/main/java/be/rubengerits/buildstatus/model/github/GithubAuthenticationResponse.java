package be.rubengerits.buildstatus.model.github;

public class GithubAuthenticationResponse {
	private String id;
	private String token;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
