package be.rubengerits.buildstatus.model.travisci;

import java.util.Arrays;
import java.util.List;

public class TravisCiRepositoriesResponse {

	private List<Repository> repos;

	public TravisCiRepositoriesResponse(Repository[] repositories) {
		repos = Arrays.asList(repositories);
	}

	public List<Repository> getRepos() {
		return repos;
	}

	public void setRepos(List<Repository> repos) {
		this.repos = repos;
	}
}
