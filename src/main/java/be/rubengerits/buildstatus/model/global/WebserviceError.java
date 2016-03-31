package be.rubengerits.buildstatus.model.global;

public interface WebserviceError {
	Integer getStatus();

	void setStatus(Integer status);

	String getMessage();

	void setMessage(String message);
}
