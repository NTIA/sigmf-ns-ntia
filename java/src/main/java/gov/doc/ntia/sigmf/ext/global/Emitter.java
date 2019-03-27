package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emitter {

    @JsonProperty(value="ntia-emitter:id", required = false)
    protected String id;

    @JsonProperty(value="ntia-emitter:description", required = false)
    protected String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
