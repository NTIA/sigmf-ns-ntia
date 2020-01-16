package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmitterEnvironment extends Environment {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-environment:emitter_id", required = true)
    protected String emitter_id;

    public String getEmitter_id() {
        return emitter_id;
    }

    public void setEmitter_id(String emitter_id) {
        this.emitter_id = emitter_id;
    }


}
