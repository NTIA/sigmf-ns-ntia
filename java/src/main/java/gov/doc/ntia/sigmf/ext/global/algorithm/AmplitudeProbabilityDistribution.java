package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.beans.Transient;

public class AmplitudeProbabilityDistribution extends  DataProduct{

  @JsonProperty(required = true)
  protected Long length;

  @JsonProperty(required = true)
  protected Long samples;

  @JsonProperty(required = true)
  protected String units;

  @JsonProperty(value = "amplitude_bin_size", required = true)
  protected Double amplitudeBinSize;

  @JsonProperty(required = false)
  protected String reference;

  @JsonProperty(value = "max_amplitude", required = true)
  protected Double maxAmplitude;

  @JsonProperty(value = "min_amplitude", required = true)
  protected Double minAmplitude;

  @JsonProperty(value = "probability_units")
  protected String probabilityUnits;

  public Long getLengths() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }

  public Long getSamples() {
    return samples;
  }

  public void setSamples(Long samples) {
    this.samples = samples;
  }

  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public Double getAmplitudeBinSize() {
    return amplitudeBinSize;
  }

  public void setAmplitudeBinSize(Double amplitudeBinSize) {
    this.amplitudeBinSize = amplitudeBinSize;
  }

  public String getReference() {
    return reference;
  }

  @JsonIgnore
  @Transient
  @Override
  public String getFieldName() {
    return "amplitude_probability_distribution";
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Double getMaxAmplitude() {
    return maxAmplitude;
  }

  public void setMaxAmplitude(Double power) {
    maxAmplitude = power;
  }

  public Double getMinAmplitude() {
    return minAmplitude;
  }

  public void setMinAmplitude(Double minAmplitude) {
    this.minAmplitude = minAmplitude;
  }

  public String getProbabilityUnits() {
    return probabilityUnits;
  }

  public void setProbabilityUnits(String probabilityUnits) {
    this.probabilityUnits = probabilityUnits;
  }
}
