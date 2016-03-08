package be.rubengerits.buildstatus.model.github;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubAuthenticationResponse {
	private String id;
	private String url;
	private List<String> scopes;
	private String token;
	//@JsonProperty("token_last_eight")
	@SerializedName("token_last_eight")
	private String tokenLastEight;
	//@JsonProperty("hashed_token")
	@SerializedName("hashed_token")
	private String hashedToken;
	private App app;
	private String note;
	//@JsonProperty("note_url")
	@SerializedName("note_url")
	private String noteUrl;
	//@JsonProperty("updated_at")
	@SerializedName("updated_at")
	private String updatedAt;
	//@JsonProperty("created_at")
	@SerializedName("created_at")
	private String createdAt;
	private String fingerprint;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public void setScopes(List<String> scopes) {
		this.scopes = scopes;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenLastEight() {
		return tokenLastEight;
	}

	public void setTokenLastEight(String tokenLastEight) {
		this.tokenLastEight = tokenLastEight;
	}

	public String getHashedToken() {
		return hashedToken;
	}

	public void setHashedToken(String hashedToken) {
		this.hashedToken = hashedToken;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNoteUrl() {
		return noteUrl;
	}

	public void setNoteUrl(String noteUrl) {
		this.noteUrl = noteUrl;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public static class App {
		private String url;
		private String name;
		//@JsonProperty("client_id")
		@SerializedName("client_id")
		private String clientId;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getClientId() {
			return clientId;
		}

		public void setClientId(String clientId) {
			this.clientId = clientId;
		}
	}
}
