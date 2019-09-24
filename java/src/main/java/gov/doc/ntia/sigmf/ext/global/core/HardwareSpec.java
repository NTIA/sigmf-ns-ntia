package gov.doc.ntia.sigmf.ext.global.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HardwareSpec {

    @JsonProperty(value="id", required=true)
    protected String id;

    @JsonProperty(value="model", required = false)
    protected String model;

    @JsonProperty(value="version", required = false)
    protected String version;

    @JsonProperty(value="description", required = false)
    protected String description;

    @JsonProperty(value="supplemental_information", required = false)
    protected String supplemental_information;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplemental_information() {
        return supplemental_information;
    }

    public void setSupplemental_information(String supplemental_information) {
        this.supplemental_information = supplemental_information;
    }

}
