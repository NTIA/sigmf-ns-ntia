package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmitterEnvironment {
    @JsonProperty(value="ntia-environment:emitter_id", required = true)
    protected String emitter_id;
}
