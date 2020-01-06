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

    @JsonProperty(value="cal_source", required = false)
    protected CalSource calSource;

    @JsonProperty(value="filters", required = false)
    protected Filter[] filters;

    @JsonProperty(value="amplifiers", required = false)
    protected  Amplifier[] amplifiers;

    @JsonProperty(value="rf_paths", required = false)
    protected RFPath[] rfPaths;

    public HardwareSpec getPreselectorSpec() {
        return preselectorSpec;
    }

    public void setPreselectorSpec(HardwareSpec preselectorSpec) {
        this.preselectorSpec = preselectorSpec;
    }

    public CalSource getCalSource() {
        return calSource;
    }

    public void setCalSource(CalSource calSource) {
        this.calSource = calSource;
    }

    public void setFilters(Filter[] filters) {
        this.filters = filters;
    }
    public Filter[] getFilters() {
        return filters;
    }

    public Amplifier[] getAmplifiers() {
        return amplifiers;
    }

    public void setAmplifiers(Amplifier[] amplifiers) {
        this.amplifiers = amplifiers;
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
