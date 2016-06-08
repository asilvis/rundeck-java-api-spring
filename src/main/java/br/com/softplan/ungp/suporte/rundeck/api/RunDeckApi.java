package br.com.softplan.ungp.suporte.rundeck.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class RunDeckApi {

    @Autowired
    private ProjectApi projectApi;

    @Autowired
    private JobApi jobApi;

    public RunDeckApi() {
    }

    public ProjectApi projects() {
        return projectApi;
    }

    public JobApi jobs() {
        return jobApi;
    }

}
