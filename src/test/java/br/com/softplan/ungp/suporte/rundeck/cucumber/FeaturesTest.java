package br.com.softplan.ungp.suporte.rundeck.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json" },
        snippets = SnippetType.CAMELCASE
)
public class FeaturesTest {

}
