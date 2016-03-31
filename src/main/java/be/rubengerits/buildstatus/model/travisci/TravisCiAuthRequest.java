package be.rubengerits.buildstatus.model.travisci;

import com.google.gson.annotations.SerializedName;

public class TravisCiAuthRequest {
    @SerializedName("github_token")
    private String githubToken;

    public String getGithubToken() {
        return githubToken;
    }

    public void setGithubToken(String githubToken) {
        this.githubToken = githubToken;
    }
}
