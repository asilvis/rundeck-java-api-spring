package br.com.softplan.ungp.suporte.rundeck.api;

import br.com.softplan.ungp.suporte.rundeck.api.dto.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class ProjectApi {
    private static String ENDPOINT_VERSION = "/api/:version/";
    private static String ENDPOINT_PROJECTS = ENDPOINT_VERSION + "projects";
    private static String ENDPOINT_PROJECT =  ENDPOINT_VERSION + "project";

    @Autowired
    private DefaultRestExecutor defaultRestExecutor;

    public List<ProjectInfo> list() {
        ResponseEntity<List<ProjectInfo>> responseEntity = defaultRestExecutor.execute(ENDPOINT_PROJECTS, HttpMethod.GET, new ParameterizedTypeReference<List<ProjectInfo>>() {});
        return responseEntity.getBody();
    }

    public void create() {
        throw new NotImplementedException();
    }

    public ProjectInfo info(String project) {
        String endPoint = ENDPOINT_PROJECT + "/" + project;
        ResponseEntity<ProjectInfo> responseEntity = defaultRestExecutor.execute(endPoint, HttpMethod.GET, new ParameterizedTypeReference<ProjectInfo>() {});
        return responseEntity.getBody();
    }

    public void delete() {
        throw new NotImplementedException();
    }

    public void configuration() {
        throw new NotImplementedException();
    }

    public void configurationKeys() {
        throw new NotImplementedException();
    }

    public void archiveExport() {
        throw new NotImplementedException();
    }

    public void archiveImport() {
        throw new NotImplementedException();
    }

    public void readme() {
        throw new NotImplementedException();
    }

    public void ACLs() {
        throw new NotImplementedException();
    }
}
