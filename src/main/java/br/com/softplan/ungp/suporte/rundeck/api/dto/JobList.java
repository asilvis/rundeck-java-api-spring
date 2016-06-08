package br.com.softplan.ungp.suporte.rundeck.api.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by andre.lima on 08/06/2016.
 */
@XmlRootElement(name = "joblist")
public class JobList {

    private List<JobDefinition> jobs;

    @XmlElement(name = "job")
    public List<JobDefinition> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDefinition> jobs) {
        this.jobs = jobs;
    }
}
