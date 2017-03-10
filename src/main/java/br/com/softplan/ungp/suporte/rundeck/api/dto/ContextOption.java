package br.com.softplan.ungp.suporte.rundeck.api.dto;

/**
 * Created by andre.lima on 07/06/2016.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * enforcedvalues='true' name='editorswf_atual' required='true' valuesUrl='http://server2125:82/editor.json' multivalued='true'
 */
public class ContextOption {
    private boolean enforcedvalues;
    private String name;
    private boolean required;
    private boolean multivalued;
    private String valuesUrl;
    private String values;
    private String description;

    public boolean isEnforcedvalues() {
        return enforcedvalues;
    }

    @XmlAttribute
    public void setEnforcedvalues(boolean enforcedvalues) {
        this.enforcedvalues = enforcedvalues;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @XmlAttribute
    public String getValuesUrl() {
        return valuesUrl;
    }

    public void setValuesUrl(String valuesUrl) {
        this.valuesUrl = valuesUrl;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlAttribute
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @XmlAttribute
    public boolean isMultivalued() {
        return multivalued;
    }

    public void setMultivalued(boolean multivalued) {
        this.multivalued = multivalued;
    }
}
