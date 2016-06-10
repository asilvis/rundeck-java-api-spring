package br.com.softplan.ungp.suporte.rundeck.api.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Execution {
	
	private String id;
	private String href;
	private String permalink;
	private String status;
	private String project;
	private String user;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	@XmlAttribute
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@XmlAttribute
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@XmlAttribute
	public String getProject() {
		return project;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
}
