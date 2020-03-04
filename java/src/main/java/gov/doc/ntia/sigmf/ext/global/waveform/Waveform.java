package gov.doc.ntia.sigmf.ext.global.waveform;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "model")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IEEE80211p.class, name ="IEEE80211p")
})
public class Waveform  implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Map<String, Object> otherFields = new HashMap<>();


    @JsonProperty(value="model", required = true)
    protected String model;

    @JsonProperty(value="description", required = false)
    protected String description;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

}
