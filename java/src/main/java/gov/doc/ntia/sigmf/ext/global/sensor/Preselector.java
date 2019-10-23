package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="preselector_spec", required =  false)
    protected HardwareSpec preselectorSpec;

    @JsonProperty(value="cal_source_spec", required = false)
    protected HardwareSpec calSourceSpec;

    @JsonProperty(value="lna_spec", required = false)
    protected HardwareSpec lnaSpec;

    @JsonProperty(value="filter_spec", required = false)
    protected HardwareSpec[] filterSpec;


    @JsonProperty(value="rf_paths", required = false)
    protected RFPath[] rfPaths;

    public HardwareSpec getPreselectorSpec() {
        return preselectorSpec;
    }

    public void setPreselectorSpec(HardwareSpec preselectorSpec) {
        this.preselectorSpec = preselectorSpec;
    }

    public HardwareSpec getCalSourceSpec() {
        return calSourceSpec;
    }

    public void setCalSourceSpec(HardwareSpec calSourceSpec) {
        this.calSourceSpec = calSourceSpec;
    }

    public HardwareSpec getLnaSpec() {
        return lnaSpec;
    }

    public void setLnaSpec(HardwareSpec lnaSpec) {
        this.lnaSpec = lnaSpec;
    }

    public HardwareSpec[] getFilterSpec() {
        return filterSpec;
    }

    public void setFilterSpec(HardwareSpec[] filterSpec) {
        this.filterSpec = filterSpec;
    }

    public void setOtherFields(Map<String, Object> otherFields) {
        this.otherFields = otherFields;
    }

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