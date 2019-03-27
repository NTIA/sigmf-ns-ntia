package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemNoise {

    @JsonProperty(value="ntia-sensor:detector", required = false)
    protected String detector;

    @JsonProperty(value="ntia-sensor:reference", required = false)
    protected String reference;

    @JsonProperty(value="ntia-sensor:system_noise", required = false)
    protected Double systemNoise;

    @JsonProperty(value="ntia-sensor:units", required = false)
    protected String units;

    public String getDetector() {
        return detector;
    }

    public void setDetector(String detector) {
        this.detector = detector;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getSystemNoise() {
        return systemNoise;
    }

    public void setSystemNoise(Double systemNoise) {
        this.systemNoise = systemNoise;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }





}
