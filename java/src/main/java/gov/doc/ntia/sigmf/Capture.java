package gov.doc.ntia.sigmf;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.ext.sensor.SensorCalibration;
import gov.doc.ntia.sigmf.ext.sensor.SiganCalibration;
import gov.doc.ntia.sigmf.ext.sensor.SiganSettings;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = DEDUCTION)
public class Capture implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "core:sample_start", required = true)
  protected long sampleStart;

  @JsonProperty(value = "core:global_index", required = false)
  protected Long globalIndex;

  @JsonProperty(value = "core:header_bytes", required = false)
  protected Long headerBytes;

  @JsonProperty(value = "core:frequency", required = false)
  protected Double frequency;

  // 2019-04-30T15:24:24.153922Z
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "core:datetime", required = false)
  protected Date dateTime;

  // Added by ntia-sensor:

  @JsonProperty(value = "ntia-sensor:overload")
  protected Boolean overload;

  @Valid
  @JsonProperty(value = "ntia-sensor:sigan_calibration")
  protected SiganCalibration siganCalibration;

  @Valid
  @JsonProperty(value = "ntia-sensor:sensor_calibration")
  protected SensorCalibration sensorCalibration;

  @JsonProperty(value = "ntia-sensor:duration")
  protected Integer duration;

  @Valid
  @JsonProperty(value = "ntia-sensor:sigan_settings")
  protected SiganSettings siganSettings;

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public Long getGlobalIndex() {
    return globalIndex;
  }

  public void setGlobalIndex(Long globalIndex) {
    this.globalIndex = globalIndex;
  }

  public Long getHeaderBytes() {
    return headerBytes;
  }

  public void setHeaderBytes(Long headerBytes) {
    this.headerBytes = headerBytes;
  }

  public Double getFrequency() {
    return frequency;
  }

  public void setFrequency(Double frequency) {
    this.frequency = frequency;
  }

  public Long getSampleStart() {
    return sampleStart;
  }

  public void setSampleStart(int sampleStart) {
    this.sampleStart = sampleStart;
  }

  // Setters/getters for ntia-sensor

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
