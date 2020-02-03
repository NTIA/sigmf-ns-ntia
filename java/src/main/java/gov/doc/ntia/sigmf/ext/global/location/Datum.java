package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Datum implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = false)
    protected String id;

    @JsonProperty(value="description", required = false)
    protected String description;

    @JsonProperty(value= "spheroid", required = false)
    protected Spheroid spheroid;


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

    public Spheroid getSpheroid() {
        return spheroid;
    }

    public void setSpheroid(Spheroid spheroid) {
        this.spheroid = spheroid;
    }



}
