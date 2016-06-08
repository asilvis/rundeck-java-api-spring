package br.com.softplan.ungp.suporte.rundeck.api;

import br.com.softplan.ungp.suporte.rundeck.RunDeckProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by andre.lima on 07/06/2016.
 */
@Component
public class DefaultRestExecutor {

    @Autowired
    private RunDeckProperties runDeckProperties;

    public <T> ResponseEntity<T> execute(String endPoint, HttpMethod method, Class<T> clazz) {
        return internalExecute(endPoint, method, clazz, null);
    }

    public <T> ResponseEntity<T> execute(String endPoint, HttpMethod method, ParameterizedTypeReference<T> parameterizedType) {
        return internalExecute(endPoint, method, null, parameterizedType);
    }

    private <T> ResponseEntity<T> internalExecute(String endPoint, HttpMethod method, Class<T> clazz, ParameterizedTypeReference<T> parameterizedType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = buildHeaders();
        try {
            if (parameterizedType != null) {
                return restTemplate.exchange(buildUrl(endPoint), method, httpEntity, parameterizedType);
            } else {
                return restTemplate.exchange(buildUrl(endPoint), method, httpEntity, clazz);
            }
        } catch (HttpClientErrorException hcex) {
            hcex.getResponseBodyAsString();
            throw hcex;
        }
    }

    private HttpEntity<String> buildHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Rundeck-Auth-Token", runDeckProperties.getAuthToken());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.valueOf("text/xml;charset=UTF-8"), MediaType.TEXT_PLAIN));
        return new HttpEntity<>(httpHeaders);
    }

    private String buildUrl(String endPoint) {
        endPoint = endPoint.replaceAll(":version", String.valueOf(runDeckProperties.getVersion()));
        return runDeckProperties.getUrl() + endPoint;
    }
}
