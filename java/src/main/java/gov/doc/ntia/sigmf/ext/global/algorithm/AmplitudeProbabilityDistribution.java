package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class AmplitudeProbabilityDistribution extends DataProduct {

  @NotNull
  @JsonProperty(required = true)
  protected Long samples;

  @NotNull
  @JsonProperty(required = true)
  protected String units;

  @JsonProperty(value = "amplitude_bin_size", required = false)
  protected Double amplitudeBinSize;

  @JsonProperty(value = "max_amplitude", required = false)
  protected Double maxAmplitude;

  @JsonProperty(value = "min_amplitude", required = false)
  protected Double minAmplitude;

  @JsonProperty(value = "probability_units")
  protected String probabilityUnits;

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
