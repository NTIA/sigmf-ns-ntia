package gov.doc.ntia.sigmf.ext.global.scos;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="name", required = true)
    protected String name;

    @JsonProperty(value="description", required =  false)
    protected  String description;

    @JsonProperty(value="summary", required =false)
    protected String summary;

    protected Map<String, Object> otherFields = new HashMap<>();

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

    @JsonAnyGetter
    public Map<String, Object> getOtherFields(){
        return otherFields;
    }

    @JsonAnySetter
    public void add(String key, Object value){
        otherFields.put(key, value);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
