package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class DFT extends AbstractProcessing implements IBaseband{

  @NotNull
  @JsonProperty(value = "equivalent_noise_bandwidth", required = true)
  protected Double equivalentNoiseBandwidth;

  @NotNull
  @JsonProperty(required = true)
  protected Integer samples;

  @NotNull
  @JsonProperty(required = true)
  protected Integer dfts;

  @NotNull
  @JsonProperty(required = true)
  protected String window;

  @NotNull
  @JsonProperty(required = true)
  protected Boolean baseband;

  public DFT() {}

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

  public Integer getDfts() {
    return dfts;
  }

  public void setDfts(Integer dfts) {
    this.dfts = dfts;
  }

  public String getWindow() {
    return window;
  }

  public void setWindow(String window) {
    this.window = window;
  }

  public Boolean isBaseband() {
    return baseband;
  }

  public void setBaseband(Boolean baseband) {
    this.baseband = baseband;
  }

}
