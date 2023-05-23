package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class FFT implements IProcessing {

  @NotNull
  @JsonProperty(required = true)
  protected String id;

  @NotNull
  @JsonProperty(value = "equivalent_noise_bandwidth", required = true)
  protected Double equivalentNoiseBandwidth;

  @JsonProperty protected Integer samples;

  @NotNull
  @JsonProperty(required = true)
  protected Integer ffts;

  @NotNull
  @JsonProperty(required = true)
  protected String window;

  @JsonProperty protected String units;

  @NotNull
  @JsonProperty(required = true)
  protected Boolean baseband;

  @JsonProperty protected String description;

  public FFT() {}

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String d) {
    description = d;
  }

  public Double getEquivalentNoiseBandwidth() {
    return equivalentNoiseBandwidth;
  }

  public void setEquivalentNoiseBandwidth(Double equivalentNoiseBandwidth) {
    this.equivalentNoiseBandwidth = equivalentNoiseBandwidth;
  }

  public Integer getSamples() {
    return samples;
  }

  public void setSamples(Integer samples) {
    this.samples = samples;
  }

  public Integer getFfts() {
    return ffts;
  }

  public void setFfts(Integer ffts) {
    this.ffts = ffts;
  }

  public String getWindow() {
    return window;
  }

  public void setWindow(String window) {
    this.window = window;
  }

  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public Boolean getBaseband() {
    return baseband;
  }

  public void setBaseband(Boolean baseband) {
    this.baseband = baseband;
  }
}
