package gov.doc.ntia.sigmf.ext.annotation.callibration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemNoise extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="mean_power_density", required = true)
    protected Double meanPowerDensity;

    @JsonProperty(value="reference", required = true)
    protected String reference;

    @JsonProperty(value="units", required = true)
    protected String units;

    public Double getMeanPowerDensity() {
        return meanPowerDensity;
    }

    public void setMeanPowerDensity(Double meanPowerDensity) {
        this.meanPowerDensity = meanPowerDensity;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
