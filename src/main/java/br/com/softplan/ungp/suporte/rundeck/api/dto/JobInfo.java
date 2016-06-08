package br.com.softplan.ungp.suporte.rundeck.api.dto;

/**
 * Created by andre.lima on 07/06/2016.
 */

import java.net.URI;

/**
 * <job id='4411650d-dcca-4407-a9b8-83bdc0c28011' href='https://rundeck-ungp.softplan.com.br/api/17/job/4411650d-dcca-4407-a9b8-83bdc0c28011' permalink='https://rundeck-ungp.softplan.com.br/project/PMSBC-TST/job/show/4411650d-dcca-4407-a9b8-83bdc0c28011'
 * scheduled='false' scheduleEnabled='true' enabled='true'>
 * <name>Ações do Ambiente</name>
 * <group />
 * <project>PMSBC-TST</project>
 * <description>run, start, stop, restart, rm, rmi</description>
 * </job>
 */
public class JobInfo {

    private String id;
    private URI href;
    private URI permalink;
    private Boolean scheduled;
    private Boolean scheduleEnabled;
    private Boolean enabled;
    private String name;
    private String group;
    private String project;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }

    public URI getPermalink() {
        return permalink;
    }

    public void setPermalink(URI permalink) {
        this.permalink = permalink;
    }

    public Boolean getScheduled() {
        return scheduled;
    }

    public void setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
    }

    public Boolean getScheduleEnabled() {
        return scheduleEnabled;
    }

    public void setScheduleEnabled(Boolean scheduleEnabled) {
        this.scheduleEnabled = scheduleEnabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
