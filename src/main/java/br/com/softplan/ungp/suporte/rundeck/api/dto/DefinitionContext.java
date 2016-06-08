package br.com.softplan.ungp.suporte.rundeck.api.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by andre.lima on 07/06/2016.
 */
public class DefinitionContext {

    List<ContextOption> options;

    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    public List<ContextOption> getOptions() {
        return options;
    }

    public void setOptions(List<ContextOption> options) {
        this.options = options;
    }
}
