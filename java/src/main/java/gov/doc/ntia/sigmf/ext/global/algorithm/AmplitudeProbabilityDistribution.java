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

  @JsonProperty(value = "power_bin_size", required = true)
  protected Double powerBinSize;

  @JsonProperty(required = false)
  protected String reference;

  @JsonProperty(value = "max_power", required = true)
  protected Double maxPower;

  @JsonProperty(value = "min_power", required = true)
  protected Double minPower;

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

  public Double getPowerBinSize() {
    return powerBinSize;
  }

  public void setPowerBinSize(Double powerBinSize) {
    this.powerBinSize = powerBinSize;
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

  public Double getMaxPower(){
    return maxPower;
  }

  public void setMaxPower(Double power){
    maxPower = power;
  }

  public Double getMinPower() {
    return minPower;
  }

  public void setMinPower(Double minPower) {
    this.minPower = minPower;
  }
}
