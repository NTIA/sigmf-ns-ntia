package gov.doc.ntia.sigmf.ext.capture.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Capture;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorCapture extends Capture {

  @JsonProperty(value = "ntia-sensor:overload")
  protected Boolean overload;

  @JsonProperty(value = "ntia-sensor:sigan_calibration")
  protected SiganCalibration siganCalibration;

  @JsonProperty(value = "ntia-sensor:sensor_calibration")
  protected SensorCalibration sensorCalibration;

  @JsonProperty(value = "ntia-sensor:duration")
  protected Integer duration;

  @JsonProperty(value = "ntia-sensor:sigan_settings")
  protected SiganSettings siganSettings;

  public Boolean getOverload() {
    return overload;
  }

  public void setOverload(Boolean overload) {
    this.overload = overload;
  }

  public SiganCalibration getSiganCalibration() {
    return siganCalibration;
  }

  public void setSiganCalibration(SiganCalibration siganCalibration) {
    this.siganCalibration = siganCalibration;
  }

  public SensorCalibration getSensorCalibration() {
    return sensorCalibration;
  }

  public void setSensorCalibration(SensorCalibration sensorCalibration) {
    this.sensorCalibration = sensorCalibration;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public SiganSettings getSiganSettings() {
    return siganSettings;
  }

  public void setSiganSettings(SiganSettings siganSettings) {
    this.siganSettings = siganSettings;
  }
}
