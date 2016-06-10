package br.com.softplan.ungp.suporte.rundeck.api.dto;

/**
 * Created by andre.lima on 07/06/2016.
 */
public class JobDefinition {

    private DefinitionContext context;
    private DefinitionSequence sequence;
    private String description;
    private String name;
    private String id;

    public DefinitionContext getContext() {
        return context;
    }

    public void setContext(DefinitionContext context) {
        this.context = context;
    }

    public DefinitionSequence getSequence() {
        return sequence;
    }

    public void setSequence(DefinitionSequence sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
