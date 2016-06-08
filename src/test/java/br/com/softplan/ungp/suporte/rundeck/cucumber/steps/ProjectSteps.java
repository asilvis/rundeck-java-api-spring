package br.com.softplan.ungp.suporte.rundeck.cucumber.steps;

import br.com.softplan.ungp.suporte.rundeck.api.RunDeckApi;
import br.com.softplan.ungp.suporte.rundeck.api.dto.ProjectInfo;
import br.com.softplan.ungp.suporte.rundeck.cucumber.configuration.SpringTest;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andre.lima on 01/04/2016.
 */
public class ProjectSteps extends SpringTest {

    @Autowired
    private RunDeckApi api;
    private List<ProjectInfo> list;
    ProjectInfo projectInfo;

    @Dado("^que estou autenticado via Token$")
    public void queEstouAutenticadoViaToken() throws Throwable {
        //Não tem que fazer nada... ou pelo menos não sei o que fazer >:)
    }

    @Quando("^buscar os projetos existentes$")
    public void buscarOsProjetosExistentes() throws Throwable {
        list = api.projects().list();
    }

    @Então("^retornará a listagem de definições do projetos$")
    public void retornaráAListagemDeDefiniçõesDoProjetos() throws Throwable {
        assertThat(list).isNotEmpty();
    }

    @Quando("^buscar o projeto \"([^\"]*)\"$")
    public void buscarOProjeto(String nomeProjeto) throws Throwable {
        projectInfo = api.projects().info(nomeProjeto);
    }

    @Então("^retornará a definição:$")
    public void retornaráADefinição(List<ProjectInfo> infos) throws Throwable {
        ProjectInfo info = infos.get(0);
        assertThat(this.projectInfo).isNotNull().isEqualToComparingFieldByField(info);
    }
}
