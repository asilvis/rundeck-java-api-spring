package br.com.softplan.ungp.suporte.rundeck.api.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="executions")
public class ExecutionList {
	
	private List<Execution> executions;

	@XmlElement(name="execution")
	public List<Execution> getExecutions() {
		return executions;
	}

	public void setExecutions(List<Execution> executions) {
		this.executions = executions;
	}
}
