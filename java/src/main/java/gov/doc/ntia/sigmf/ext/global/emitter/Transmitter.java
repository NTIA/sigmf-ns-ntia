package gov.doc.ntia.sigmf.ext.global.emitter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transmitter {

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty(value="model", required =  false)
    protected String model;

}
