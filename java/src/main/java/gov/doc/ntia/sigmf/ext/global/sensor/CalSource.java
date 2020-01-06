package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;

public class CalSource {

    @JsonProperty(value="cal_source_spec", required = false)
    protected HardwareSpec calSourceSpec;

    @JsonProperty(value="type", required = false)
    protected String type;

    public HardwareSpec getCalSourceSpec() {
        return calSourceSpec;
    }

    public void setCalSourceSpec(HardwareSpec calSourceSpec) {
        this.calSourceSpec = calSourceSpec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnr() {
        return enr;
    }

    public void setEnr(String enr) {
        this.enr = enr;
    }

    @JsonProperty(value="enr", required = false)
    protected String enr;


}
