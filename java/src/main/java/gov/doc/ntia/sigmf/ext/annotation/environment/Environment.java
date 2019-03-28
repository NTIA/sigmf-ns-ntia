package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Environment extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-environment:temperature", required = false)
    protected Double temperature;

    @JsonProperty(value="ntia-environment:humidity", required = false)
    protected Double humidity;

    @JsonProperty(value="ntia-environment:weather", required = false)
    protected String weather;

    @JsonProperty(value="ntia-environment:environment", required =true)
    protected String environment;


}
