package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="rf_paths", required = false)
    protected RFPath[] rfPaths;

    protected Map<String, Object> otherFields = new HashMap<>();

    public RFPath[] getRfPaths() {
        return rfPaths;
    }

    public void setRfPaths(RFPath[] rfPaths) {
        this.rfPaths = rfPaths;
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
