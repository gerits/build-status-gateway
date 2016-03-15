package be.rubengerits.buildstatus.model.travisci;

import com.google.gson.annotations.SerializedName;

public class Account {

	@SerializedName("repos_count")
	private int reposCount;
	private String name;
	private String id;
	private String type;
	private String login;

	public int getReposCount() {
		return reposCount;
	}

	public void setReposCount(int reposCount) {
		this.reposCount = reposCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
