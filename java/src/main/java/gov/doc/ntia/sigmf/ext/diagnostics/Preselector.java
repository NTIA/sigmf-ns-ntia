package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector {

  @JsonProperty protected Double temp;

  @JsonProperty(value = "noise_diode_temp")
  protected Double noiseDiodeTemp;

  @JsonProperty(value = "lna_temp")
  protected Double lnaTemp;

  protected Double humidity;

  @JsonProperty(value = "door_closed")
  protected Boolean doorClosed;

  @JsonProperty(value = "noise_diode_path_enabled")
  protected Boolean noiseDiodePathEnabled;

  @JsonProperty(value = "antenna_path_enabled")
  protected Boolean antennaPathEnabled;

  @JsonProperty(value = "noise_diode_powered")
  protected Boolean noiseDiodePowered;

  @JsonProperty(value = "lna_powered")
  protected Boolean lnaPowered;

  public Double getNoiseDiodeTemp() {
    return noiseDiodeTemp;
  }

  public void setNoiseDiodeTemp(Double noiseDiodeTemp) {
    this.noiseDiodeTemp = noiseDiodeTemp;
  }

  public Double getLnaTemp() {
    return lnaTemp;
  }

  public void setLnaTemp(Double lnaTemp) {
    this.lnaTemp = lnaTemp;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public Boolean getDoorClosed() {
    return doorClosed;
  }

  public void setDoorClosed(Boolean doorClosed) {
    this.doorClosed = doorClosed;
  }

  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Boolean getNoiseDiodePathEnabled() {
    return noiseDiodePathEnabled;
  }

  public void setNoiseDiodePathEnabled(Boolean noiseDiodePathEnabled) {
    this.noiseDiodePathEnabled = noiseDiodePathEnabled;
  }

  public Boolean getAntennaPathEnabled() {
    return antennaPathEnabled;
  }

  public void setAntennaPathEnabled(Boolean antennaPathEnabled) {
    this.antennaPathEnabled = antennaPathEnabled;
  }

  public Boolean getNoiseDiodePowered() {
    return noiseDiodePowered;
  }

  public void setNoiseDiodePowered(Boolean noiseDiodePowered) {
    this.noiseDiodePowered = noiseDiodePowered;
  }

  public Boolean getLnaPowered() {
    return lnaPowered;
  }

  public void setLnaPowered(Boolean lnaPowered) {
    this.lnaPowered = lnaPowered;
  }
}
