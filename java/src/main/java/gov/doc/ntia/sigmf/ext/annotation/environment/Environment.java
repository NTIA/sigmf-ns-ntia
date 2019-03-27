package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

public class Environment extends Annotation {

    @JsonProperty(value="ntia-environment:temperature", required = false)
    protected Double temperature;

    @JsonProperty(value="ntia-environment:humidity", required = false)
    protected Double humidity;

    @JsonProperty(value="ntia-environment:weather", required = false)
    protected String weather;

    @JsonProperty(value="ntia-environment:environment", required =true)
    protected String environment;


}
