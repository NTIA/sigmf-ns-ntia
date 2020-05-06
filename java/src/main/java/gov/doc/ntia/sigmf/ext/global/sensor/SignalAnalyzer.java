package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignalAnalyzer implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "sigan_spec", required = false)
  protected HardwareSpec siganSpec;

  @JsonProperty(value = "frequency_low", required = false)
  protected Double frequencyLow;

  @JsonProperty(value = "frequency_high", required = false)
  protected Double frequencyHigh;

  @JsonProperty(value = "noise_figure", required = false)
  protected Double noiseFigure;

  @JsonProperty(value = "max_power", required = false)
  protected Double maxPower;

  @JsonProperty(value = "a2d_bits", required = false)
  protected int a2dBits;

  public HardwareSpec getSiganSpec() {
    return siganSpec;
  }

  public void setSiganSpec(HardwareSpec siganSpec) {
    this.siganSpec = siganSpec;
  }

  public Double getFrequencyLow() {
    return frequencyLow;
  }

  public void setFrequencyLow(Double frequencyLow) {
    this.frequencyLow = frequencyLow;
  }

  public Double getFrequencyHigh() {
    return frequencyHigh;
  }

  public void setFrequencyHigh(Double frequencyHigh) {
    this.frequencyHigh = frequencyHigh;
  }

  public Double getNoiseFigure() {
    return noiseFigure;
  }

  public void setNoiseFigure(Double noiseFigure) {
    this.noiseFigure = noiseFigure;
  }

  public Double getMaxPower() {
    return maxPower;
  }

  public void setMaxPower(Double maxPower) {
    this.maxPower = maxPower;
  }

  public Integer getA2dBits() {
    return a2dBits;
  }

  public void setA2dBits(Integer a2dBits) {
    this.a2dBits = a2dBits;
  }
}
