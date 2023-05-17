package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractUnitRequiredTraceDataProduct extends TraceDataProduct{

    @JsonProperty(value = "units", required = false)
    protected String units;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
