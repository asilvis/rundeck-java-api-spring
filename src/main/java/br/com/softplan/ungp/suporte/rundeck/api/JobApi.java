package br.com.softplan.ungp.suporte.rundeck.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.softplan.ungp.suporte.rundeck.api.dto.Execution;
import br.com.softplan.ungp.suporte.rundeck.api.dto.ExecutionList;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobDefinition;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobInfo;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobList;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobParameters;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class JobApi {
    private static final String ENDPOINT_VERSION = "/api/:version/";
    private static final String ENDPOINT_PROJECTS_JOBS = ENDPOINT_VERSION + "project/:project/jobs";
    private static final String ENDPOINT_JOB = ENDPOINT_VERSION + "job/:id";
    private static final String ENDPOINT_JOB_RUN = ENDPOINT_JOB + "/run";
    private static final String ENDPOINT_JOB_EXECUTION_STATUS = ENDPOINT_VERSION + "execution/:execution";
    private static final String FORMAT ="?format=xml";
  
    @Autowired
    private DefaultRestExecutor defaultRestExecutor;

    public List<JobInfo> list(String project) { 
        String endPoint = ENDPOINT_PROJECTS_JOBS.replaceAll(":project", project);
        ResponseEntity<List<JobInfo>> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, new ParameterizedTypeReference<List<JobInfo>>() {
        });
        return responseEntity.getBody();
    }

    public JobDefinition definition(String jobId) {
        String endPoint = ENDPOINT_JOB.replaceAll(":id", jobId) + FORMAT;
        ResponseEntity<JobList> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, JobList.class);
        return responseEntity.getBody().getJobs().stream().findFirst().get();
    }
    
    public Execution run(String jobId,JobParameters parameters){
    	String endPoint = ENDPOINT_JOB_RUN.replaceAll(":id", jobId) + FORMAT;
    	ResponseEntity<ExecutionList> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.POST, ExecutionList.class, parameters);
    	return responseEntity.getBody().getExecutions().stream().findFirst().get();
    }
    
    public Execution getExecutionsInfo(String executionId){
    	String endPoint =  ENDPOINT_JOB_EXECUTION_STATUS.replaceAll(":execution", executionId)+FORMAT;
       	ResponseEntity<ExecutionList> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, ExecutionList.class);
    	return responseEntity.getBody().getExecutions().stream().findFirst().get();
    }
}
