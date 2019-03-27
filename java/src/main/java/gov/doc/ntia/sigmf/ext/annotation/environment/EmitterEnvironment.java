package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmitterEnvironment {
    @JsonProperty(value="ntia-environment:emitter_id", required = true)
    protected String emitter_id;
}
