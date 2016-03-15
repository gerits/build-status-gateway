package be.rubengerits.buildstatus.model.global;

import be.rubengerits.buildstatus.model.travisci.Build;

import java.util.List;

public class RepositoryBuildResponse implements WebserviceError {
    private List<Build> builds;

    private Integer status;

    private String message;

    public RepositoryBuildResponse() {
    }

    public RepositoryBuildResponse(List<Build> builds) {
        this.builds = builds;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
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
