package br.com.softplan.ungp.suporte.rundeck;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = RunDeckProperties.PREFIX)
public class RunDeckProperties {

    public static final String PREFIX = "rundeck.api";

    /**
     * URL pointing to RunDeck
     */
    private String url;


    /**
     * Version of RunDeckApi
     */
    private Integer version;

    /**
     * Authorization Token
     */
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
