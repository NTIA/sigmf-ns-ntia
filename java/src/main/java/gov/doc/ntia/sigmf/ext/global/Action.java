package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {

    @JsonProperty(value="ntia-scos:name", required = false)
    protected String name;

    @JsonProperty(value="ntia-scos:description", required =  false)
    protected  String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
