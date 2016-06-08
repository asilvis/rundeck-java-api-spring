package br.com.softplan.ungp.suporte.rundeck;

import br.com.softplan.ungp.suporte.rundeck.api.RunDeckApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(RunDeckProperties.class)
@ConditionalOnProperty(prefix = "rundeck.api", name = "url")
public class RunDeckApiConfiguration {

}
