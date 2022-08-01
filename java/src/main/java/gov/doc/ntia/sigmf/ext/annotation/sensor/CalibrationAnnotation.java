package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

public class CalibrationAnnotation extends Annotation {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "ntia-sensor:gain_sigan", required = false)
  protected Double gainSigan;

  @JsonProperty(value = "ntia-sensor:gain_sensor", required = false)
  protected Double gainSensor;

  @JsonProperty(value = "ntia-sensor:noise_figure_sigan", required = false)
  protected Double noiseFigureSigan;

  @JsonProperty(value = "ntia-sensor:ldb_compression_point_sigan", required = false)
  protected Double oneDbCompressionPointSigan;

  @JsonProperty(value = "ntia-sensor:enbw_sigan", required = false)
  protected Double enbwSigan;

  @JsonProperty(value = "ntia-sensor:gain_preselector", required = false)
  protected Double gainPreselector;

  @JsonProperty(value = "ntia-sensor:noise_figure_sensor", required = false)
  protected Double noiseFigureSensor;

  @JsonProperty(value = "ntia-sensor:1db_compression_point_sensor", required = false)
  protected Double oneDbCompressionPointSensor;

  @JsonProperty(value = "ntia-sensor:enbw_sensor", required = false)
  protected Double enbwSensor;

  @JsonProperty(value = "ntia-sensor:mean_noise_power_sensor", required = false)
  protected Double meanNoisePowerSensor;

  @JsonProperty(value = "ntia-sensor:temperature", required = false)
  protected Double temperature;

  @JsonProperty(value = "ntia-sensor:mean_noise_power_units", required = false)
  protected String meanNoisePowerUnits;

  @JsonProperty(value = "ntia-sensor:mean_noise_power_reference", required = false)
  protected String meanNoisePowerReference;

  public Double getEnbwSigan() {
    return enbwSigan;
  }

  public void setEnbwSigan(Double enbwSigan) {
    this.enbwSigan = enbwSigan;
  }

  public Double getGainPreselector() {
    return gainPreselector;
  }

  public void setGainPreselector(Double gainPreselector) {
    this.gainPreselector = gainPreselector;
  }

  public Double getNoiseFigureSensor() {
    return noiseFigureSensor;
  }

  public void setNoiseFigureSensor(Double noiseFigureSensor) {
    this.noiseFigureSensor = noiseFigureSensor;
  }

  public Double getOneDbCompressionPointSensor() {
    return oneDbCompressionPointSensor;
  }

  public void setOneDbCompressionPointSensor(Double oneDbCompressionPointSensor) {
    this.oneDbCompressionPointSensor = oneDbCompressionPointSensor;
  }

  public Double getEnbwSensor() {
    return enbwSensor;
  }

  public void setEnbwSensor(Double enbwSensor) {
    this.enbwSensor = enbwSensor;
  }

  public Double getMeanNoisePowerSensor() {
    return meanNoisePowerSensor;
  }

  public void setMeanNoisePowerSensor(Double meanNoisePowerSensor) {
    this.meanNoisePowerSensor = meanNoisePowerSensor;
  }

  public Double getGainSigan() {
    return gainSigan;
  }

  public void setGainSigan(Double gainSigan) {
    this.gainSigan = gainSigan;
  }

  public Double getOneDbCompressionPointSigan() {
    return oneDbCompressionPointSigan;
  }

  public void setOneDbCompressionPointSigan(Double oneDbCompressionPointSigan) {
    this.oneDbCompressionPointSigan = oneDbCompressionPointSigan;
  }

  public void set1DbCompressionPointSigan(Double oneDbCompressionPointSigan) {
    this.oneDbCompressionPointSigan = oneDbCompressionPointSigan;
  }

  public Double getNoiseFigureSigan() {
    return noiseFigureSigan;
  }

  public void setNoiseFigureSigan(Double noiseFigureSigan) {
    this.noiseFigureSigan = noiseFigureSigan;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public String getMeanNoisePowerUnits() {
    return meanNoisePowerUnits;
  }

  public void setMeanNoisePowerUnits(String meanNoisePowerUnits) {
    this.meanNoisePowerUnits = meanNoisePowerUnits;
  }

  public String getMeanNoisePowerReference() {
    return meanNoisePowerReference;
  }

  public void setMeanNoisePowerReference(String meanNoisePowerReference) {
    this.meanNoisePowerReference = meanNoisePowerReference;
  }

  public Double getGainSensor() {
    return gainSensor;
  }

  public void setGainSensor(Double gainSensor) {
    this.gainSensor = gainSensor;
  }
}
