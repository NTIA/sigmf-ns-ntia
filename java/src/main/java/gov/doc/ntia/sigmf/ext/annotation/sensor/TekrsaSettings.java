package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TekrsaSettings extends SiganSettings {

  @JsonProperty(value = "ntia-sensor:reference_level", required = false)
  protected Double referenceLevel;

  @JsonProperty(value = "ntia-sensor:iq_bandwidth", required = false)
  protected Double iqBandwidth;

  @JsonProperty(value = "ntia-sensor:preamp_enable", required = false)
  protected Boolean preampEnable;

  @JsonProperty(value = "ntia-sensor:auto_attenuation_enable", required = false)
  protected Boolean autoAttenuationEnable;

  @JsonProperty(value = "ntia-sensor:attenuation", required = false)
  protected Double attenuation;

  public Double getReferenceLevel() {
    return referenceLevel;
  }

  public void setReferenceLevel(Double referenceLevel) {
    this.referenceLevel = referenceLevel;
  }

  public Double getIqBandwidth() {
    return iqBandwidth;
  }

  public void setIqBandwidth(Double iqBandwidth) {
    this.iqBandwidth = iqBandwidth;
  }

  public Boolean getPreampEnable() {
    return preampEnable;
  }

  public void setPreampEnable(Boolean preampEnable) {
    this.preampEnable = preampEnable;
  }

  public Boolean getAutoAttenuationEnable() {
    return this.autoAttenuationEnable;
  }

  public void setAutoAttenuationEnable(Boolean autoAttenuationEnabled) {
    this.autoAttenuationEnable = autoAttenuationEnabled;
  }

  public Double getAttenuation() {
    return attenuation;
  }

  public void setAttenuation(Double attenuation) {
    this.attenuation = attenuation;
  }
}
