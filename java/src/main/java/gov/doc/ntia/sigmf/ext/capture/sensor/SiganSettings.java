package gov.doc.ntia.sigmf.ext.capture.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiganSettings {

    protected Double attenuation;

    protected Double gain;

    @JsonProperty(value = "reference_level")
    protected Double referenceLevel;

    @JsonProperty(value = "preamp_enable")
    protected Boolean preampEnable;

  public Double getAttenuation() {
    return attenuation;
  }

  public void setAttenuation(Double attenuation) {
    this.attenuation = attenuation;
  }

  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }

  public Double getReferenceLevel() {
    return referenceLevel;
  }

  public void setReferenceLevel(Double referenceLevel) {
    this.referenceLevel = referenceLevel;
  }

  public Boolean getPreampEnable() {
    return preampEnable;
  }

  public void setPreampEnable(Boolean preampEnable) {
    this.preampEnable = preampEnable;
  }
}
