package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preselector {

  @JsonProperty protected Double temp;

  @JsonProperty(value = "noise_diode_temp")
  protected Double noiseDiodeTemp;

  @JsonProperty(value = "lna_temp")
  protected Double lnaTemp;

  protected Double humidity;

  @JsonProperty(value = "door_closed")
  protected Boolean doorClosed;

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
}
