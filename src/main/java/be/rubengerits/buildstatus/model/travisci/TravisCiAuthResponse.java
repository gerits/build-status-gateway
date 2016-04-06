package be.rubengerits.buildstatus.model.travisci;

import com.google.gson.annotations.SerializedName;

public class TravisCiAuthResponse {
	@SerializedName("access_token")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
