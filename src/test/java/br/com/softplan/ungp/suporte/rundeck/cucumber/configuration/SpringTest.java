package br.com.softplan.ungp.suporte.rundeck.cucumber.configuration;

import br.com.softplan.ungp.suporte.rundeck.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings({"unchecked", "rawtypes"})
@ContextConfiguration(classes = TestApplication.class, loader = SpringApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest("server.port=0")
public abstract class SpringTest {

}
