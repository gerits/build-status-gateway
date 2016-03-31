package be.rubengerits.buildstatus.model.github;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class GithubAuthenticationRequest {

	private final List<String> scopes = new ArrayList<String>();

	private String note;

	public List<String> getScopes() {
		return scopes;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
