package br.com.softplan.ungp.suporte.rundeck.api;

import br.com.softplan.ungp.suporte.rundeck.api.dto.JobDefinition;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobInfo;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class JobApi {
    private static String ENDPOINT_VERSION = "/api/:version/";
    private static String ENDPOINT_PROJECTS_JOBS = ENDPOINT_VERSION + "project/:project/jobs";
    private static String ENDPOINT_JOB = ENDPOINT_VERSION + "job/:id";

    @Autowired
    private DefaultRestExecutor defaultRestExecutor;

    public List<JobInfo> list(String project) {
        String endPoint = ENDPOINT_PROJECTS_JOBS.replaceAll(":project", project);
        ResponseEntity<List<JobInfo>> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, new ParameterizedTypeReference<List<JobInfo>>() {
        });
        return responseEntity.getBody();
    }

    public JobDefinition definition(String jobId) {
        String endPoint = ENDPOINT_JOB.replaceAll(":id", jobId) + "?format=xml";
        ResponseEntity<JobList> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, JobList.class);
        return responseEntity.getBody().getJobs().stream().findFirst().get();
    }

}
