package br.com.softplan.ungp.suporte.rundeck.api.dto;

public class JobParameters {
	
	private String argString;
	private String loglevel;
	private String asUser;
	private String filter;
	private String url;
	
	public String getArgString() {
		return argString;
	}
	public void setArgString(String argString) {
		this.argString = argString;
	}
	public String getLoglevel() {
		return loglevel;
	}
	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}
	public String getAsUser() {
		return asUser;
	}
	public void setAsUser(String asUser) {
		this.asUser = asUser;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
