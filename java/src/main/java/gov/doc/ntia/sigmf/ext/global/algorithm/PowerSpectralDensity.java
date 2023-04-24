package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.beans.Transient;

public class PowerSpectralDensity extends TraceDataProduct {

  @JsonProperty(value = "equivalent_noise_bandwidth", required = true)
  protected Double equivalentNoiseBandwidth;

  @JsonProperty(value = "ffts", required = true)
  protected Integer ffts;

  @JsonProperty(value = "units", required = true)
  protected String units;

  @JsonProperty(value = "window", required = true)
  protected String window;

  public Double getEquivalentNoiseBandwidth() {
    return equivalentNoiseBandwidth;
  }

  public void setEquivalentNoiseBandwidth(Double equivalentNoiseBandwidth) {
    this.equivalentNoiseBandwidth = equivalentNoiseBandwidth;
  }

  public Integer getFfts() {
    return ffts;
  }

  public void setFfts(Integer ffts) {
    this.ffts = ffts;
  }

  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public String getWindow() {
    return window;
  }

  public void setWindow(String window) {
    this.window = window;
  }

  @JsonIgnore
  @Transient
  @Override
  public String getFieldName() {
    return "power_spectral_density";
  }
}
