package gov.doc.ntia.sigmf.ext.global.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Measurement implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "domain", required = true)
  protected String domain;

  @JsonProperty(value = "measurement_type", required = true)
  protected String measurementType;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "time_start", required = true)
  protected Date timeStart;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "time_stop", required = true)
  protected Date timeStop;

  @JsonProperty(value = "frequency_tuned_low", required = false)
  protected Double frequencyTunedLow;

  @JsonProperty(value = "frequency_tuned_high", required = false)
  protected Double frequencyTunedHigh;

  @JsonProperty(value = "frequency_tuned_step", required = false)
  protected Double frequencyTunedStep;

  @JsonProperty(value = "frequencies_tuned", required = false)
  protected Double[] frequenciesTuned;

  @JsonProperty(value = "classification", required = true)
  protected String classification;

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getMeasurementType() {
    return measurementType;
  }

  public void setMeasurementType(String measurementType) {

    this.measurementType = measurementType;
  }

  public Date getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(Date timeStart) {
    this.timeStart = timeStart;
  }

  public Double getFrequencyTunedLow() {
    return frequencyTunedLow;
  }

  public void setFrequencyTunedLow(Double lowFrequency) {

    this.frequencyTunedLow = lowFrequency;
  }

  public Date getTimeStop() {
    return timeStop;
  }

  public void setTimeStop(Date timeStop) {
    this.timeStop = timeStop;
  }

  public Double getFrequencyTunedHigh() {
    return frequencyTunedHigh;
  }

  public void setFrequencyTunedHigh(Double highFrequency) {
    this.frequencyTunedHigh = highFrequency;
  }

  public Double getFrequencyTunedStep() {
    return frequencyTunedStep;
  }

  public void setFrequencyTunedStep(Double frequencyTunedStep) {
    this.frequencyTunedStep = frequencyTunedStep;
  }

  public Double[] getFrequenciesTuned() {
    return frequenciesTuned;
  }

  public void setFrequenciesTuned(Double[] frequenciesTuned) {
    this.frequenciesTuned = frequenciesTuned;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }
}
