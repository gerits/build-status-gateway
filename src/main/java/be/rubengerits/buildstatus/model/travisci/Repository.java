package be.rubengerits.buildstatus.model.travisci;

import com.google.gson.annotations.SerializedName;

public class Repository {

	private int id;
	private String slug;
	private String description;
	@SerializedName("last_build_id")
	private Integer lastBuildId;
	@SerializedName("last_build_number")
	private String lastBuildNumber;
	@SerializedName("last_build_state")
	private String lastBuildState;
	@SerializedName("last_build_duration")
	private long lastBuildDuration;
	@SerializedName("last_build_started_at")
	private String lastBuildStartedAt;
	@SerializedName("last_build_finished_at")
	private String lastBuildFinishedAt;
	@SerializedName("github_language")
	private String githubLanguage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLastBuildId() {
		return lastBuildId;
	}

	public void setLastBuildId(Integer lastBuildId) {
		this.lastBuildId = lastBuildId;
	}

	public String getLastBuildNumber() {
		return lastBuildNumber;
	}

	public void setLastBuildNumber(String lastBuildNumber) {
		this.lastBuildNumber = lastBuildNumber;
	}

	public String getLastBuildState() {
		return lastBuildState;
	}

	public void setLastBuildState(String lastBuildState) {
		this.lastBuildState = lastBuildState;
	}

	public long getLastBuildDuration() {
		return lastBuildDuration;
	}

	public void setLastBuildDuration(long lastBuildDuration) {
		this.lastBuildDuration = lastBuildDuration;
	}

	public String getLastBuildStartedAt() {
		return lastBuildStartedAt;
	}

	public void setLastBuildStartedAt(String lastBuildStartedAt) {
		this.lastBuildStartedAt = lastBuildStartedAt;
	}

	public String getLastBuildFinishedAt() {
		return lastBuildFinishedAt;
	}

	public void setLastBuildFinishedAt(String lastBuildFinishedAt) {
		this.lastBuildFinishedAt = lastBuildFinishedAt;
	}

	public String getGithubLanguage() {
		return githubLanguage;
	}

	public void setGithubLanguage(String githubLanguage) {
		this.githubLanguage = githubLanguage;
	}
}
