package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttenuationSettings extends SiganSettings{

    @JsonProperty(value = "ntia-sensor:attenuation", required = false)
    protected Double attenuation;

    public Double getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(Double attenuation) {
        this.attenuation = attenuation;
    }
}
