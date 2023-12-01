package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SPU {

  @JsonProperty(value = "preselector_powered")
  protected Boolean preselectorPowered;

  @JsonProperty(value = "sigan_powered")
  protected Boolean siganPowered;

  @JsonProperty(value = "temperature_control_powered")
  protected Boolean tempControlPowered;

  @JsonProperty protected Boolean cooling;

  @JsonProperty protected Boolean heating;

  @JsonProperty(value = "door_closed")
  protected Boolean doorClosed;

  @JsonProperty(value = "humidity_sensors")
  protected List<DiagnosticSensor> humiditySensors;

  @JsonProperty(value = "temperature_sensors")
  protected List<DiagnosticSensor> temperatureSensors;

  @JsonProperty(value = "power_sensors")
  protected List<DiagnosticSensor> powerSensors;

  public Boolean getPreselectorPowered() {
    return preselectorPowered;
  }

  public void setPreselectorPowered(Boolean preselectorPowered) {
    this.preselectorPowered = preselectorPowered;
  }

  public Boolean getSiganPowered() {
    return siganPowered;
  }

  public void setSiganPowered(Boolean siganPowered) {
    this.siganPowered = siganPowered;
  }

  public Boolean getTempControlPowered() {
    return tempControlPowered;
  }

  public void setTempControlPowered(Boolean tempControlPowered) {
    this.tempControlPowered = tempControlPowered;
  }

  public Boolean getCooling() {
    return cooling;
  }

  public void setCooling(Boolean cooling) {
    this.cooling = cooling;
  }

  public Boolean getHeating() {
    return heating;
  }

  public void setHeating(Boolean heating) {
    this.heating = heating;
  }

  public Boolean getDoorClosed() {
    return doorClosed;
  }

  public void setDoorClosed(Boolean doorClosed) {
    this.doorClosed = doorClosed;
  }

  public List<DiagnosticSensor> getHumiditySensors() {
    return humiditySensors;
  }

  public void setHumiditySensors(List<DiagnosticSensor> humiditySensors) {
    this.humiditySensors = humiditySensors;
  }

  public List<DiagnosticSensor> getTemperatureSensors() {
    return temperatureSensors;
  }

  public void setTemperatureSensors(List<DiagnosticSensor> temperatureSensors) {
    this.temperatureSensors = temperatureSensors;
  }

  public List<DiagnosticSensor> getPowerSensors() {
    return powerSensors;
  }

  public void setPowerSensors(List<DiagnosticSensor> powerSensors) {
    this.powerSensors = powerSensors;
  }
}
