package be.rubengerits.buildstatus.model.travisci;

import be.rubengerits.buildstatus.api.global.Repository;
import be.rubengerits.buildstatus.api.travisci.Account;

import java.util.List;

public class TravisCiRepositoriesResponse {

	private List<Repository> repos;

	public List<Repository> getRepos() {
		return repos;
	}

	public void setRepos(List<Repository> repos) {
		this.repos = repos;
	}
}
