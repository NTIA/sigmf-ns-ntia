package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsrpSettings extends SiganSettings {

  @JsonProperty(value = "ntia-sensor:gain", required = false)
  protected Double gain;

  @JsonProperty(value = "ntia-sensor:clock_rate", required = false)
  protected Double clockRate;

  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }

  public Double getClockRate() {
    return clockRate;
  }

  public void setClockRate(Double clockRate) {
    this.clockRate = clockRate;
  }
}
