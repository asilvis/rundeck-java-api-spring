package br.com.softplan.ungp.suporte.rundeck.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.softplan.ungp.suporte.rundeck.RunDeckProperties;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class DefaultRestExecutor {

    @Autowired
    private RunDeckProperties runDeckProperties;

    public <T, K> ResponseEntity<T> execute(String endPoint, HttpMethod method, Class<T> clazz, K parameters) {
        return internalExecute(endPoint, method, clazz, null,parameters);
    }
    
    public <T> ResponseEntity<T> execute(String endPoint, HttpMethod method, Class<T> clazz) {
        return internalExecute(endPoint, method, clazz, null,null);
    }

    public <T> ResponseEntity<T> execute(String endPoint, HttpMethod method, ParameterizedTypeReference<T> parameterizedType) {
        return internalExecute(endPoint, method, null, parameterizedType,null);
    }

    private <T, K> ResponseEntity<T> internalExecute(String endPoint, HttpMethod method, Class<T> clazz, ParameterizedTypeReference<T> parameterizedType, K parameters) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = new HttpEntity<>(parameters,buildHeaders());
        try {
        	if(HttpMethod.POST.equals(method)){
        		return restTemplate.exchange(buildUrl(endPoint),method, httpEntity, clazz);
        	}
        	else if (parameterizedType != null) {
                return restTemplate.exchange(buildUrl(endPoint), method, httpEntity, parameterizedType);
            } else {
                return restTemplate.exchange(buildUrl(endPoint), method, httpEntity, clazz);
            }
        } catch (HttpClientErrorException hcex) {
            hcex.getResponseBodyAsString();
            throw hcex;
        }
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Rundeck-Auth-Token", runDeckProperties.getAuthToken());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.valueOf("text/xml;charset=UTF-8"), MediaType.TEXT_PLAIN));
        return httpHeaders;
    }

    private String buildUrl(String endPoint) {
        endPoint = endPoint.replaceAll(":version", String.valueOf(runDeckProperties.getVersion()));
        return runDeckProperties.getUrl() + endPoint;
    }
}
