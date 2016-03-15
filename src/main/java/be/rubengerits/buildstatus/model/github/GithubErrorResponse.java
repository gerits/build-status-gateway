package be.rubengerits.buildstatus.model.github;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubErrorResponse {
	private String message;
	private List<GithubError> errors;
	@SerializedName("documentation_url")
	private String documentationUrl;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<GithubError> getErrors() {
		return errors;
	}

	public void setErrors(List<GithubError> errors) {
		this.errors = errors;
	}

	public String getDocumentationUrl() {
		return documentationUrl;
	}

	public void setDocumentationUrl(String documentationUrl) {
		this.documentationUrl = documentationUrl;
	}

	public static class GithubError {
		private String resource;
		private String field;
		private String code;

		public String getResource() {
			return resource;
		}

		public void setResource(String resource) {
			this.resource = resource;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

}
