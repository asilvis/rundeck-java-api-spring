package br.com.softplan.ungp.suporte.rundeck.cucumber.steps;

import br.com.softplan.ungp.suporte.rundeck.api.RunDeckApi;
import br.com.softplan.ungp.suporte.rundeck.api.dto.ContextOption;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobDefinition;
import br.com.softplan.ungp.suporte.rundeck.api.dto.JobInfo;
import br.com.softplan.ungp.suporte.rundeck.api.dto.ProjectInfo;
import br.com.softplan.ungp.suporte.rundeck.cucumber.configuration.SpringTest;
import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.Context;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andre.lima on 01/04/2016.
 */
public class JobSteps extends SpringTest {

    @Autowired
    private RunDeckApi api;
    private List<JobInfo> list;
    private JobDefinition jobDefinition;

    @Quando("^buscar os jobs do projeto \"([^\"]*)\"$")
    public void buscarOsJobsDoProjeto(String project) throws Throwable {
        list = api.jobs().list(project);
    }

    @Então("^retornará os jobs \"([^\"]*)\"$")
    public void retornaráOsJobs(List<String> nomes) throws Throwable {
        assertThat(list).isNotEmpty().extracting("name").containsAll(nomes);
    }

    @Quando("^buscar as definições do job com id \"([^\"]*)\"$")
    public void buscarAsDefiniçõesDoJobComId(String jobId) throws Throwable {
        jobDefinition = api.jobs().definition(jobId);
    }

    @Então("^retornará a definição de job:$")
    public void retornará_a_definição_de_job(List<JobDefinition> jds) throws Throwable {
        JobDefinition jd = jds.stream().findFirst().get();
        assertThat(this.jobDefinition).isNotNull().isEqualToIgnoringNullFields(jd);
    }

    @E("^na definição de job estarão presentes as opções:$")
    public void na_definição_de_job_estarão_presentes_as_opções(List<ContextOption> options) throws Throwable {
        List<ContextOption> contextOptions = jobDefinition.getContext().getOptions();
        assertThat(contextOptions).isNotNull();

        for (int i = 0; i < contextOptions.size(); i++) {
            assertThat(contextOptions.get(i)).isEqualToIgnoringGivenFields(options.get(i), "valuesUrl", "description");
        }
    }
}
