package be.rubengerits.buildstatus.model.global;

import be.rubengerits.buildstatus.model.travisci.Repository;

import java.util.List;

public class RepositoriesResponse implements WebserviceError {
	private List<Repository> repositories;

	private Integer status;

	private String message;

	public RepositoriesResponse() {
	}

	public RepositoriesResponse(List<Repository> repositories) {
		this.repositories = repositories;
	}

	public List<Repository> getRepositories() {
		return repositories;
	}

	public void setRepositories(List<Repository> repositories) {
		this.repositories = repositories;
	}

	@Override
	public Integer getStatus() {
		return status;
	}

	@Override
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}
