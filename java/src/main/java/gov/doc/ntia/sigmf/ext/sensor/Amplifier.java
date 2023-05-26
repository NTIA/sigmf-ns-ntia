package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import javax.validation.Valid;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Amplifier implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @JsonProperty(value = "amplifier_spec", required = false)
  protected HardwareSpec amplifierSpec;

  @JsonProperty(value = "gain", required = false)
  protected Double gain;

  @JsonProperty(value = "noise_figure", required = false)
  protected Double noiseFigure;

  @JsonProperty(value = "max_power", required = false)
  protected Double maxPower;

  public HardwareSpec getAmplifierSpec() {
    return amplifierSpec;
  }

  public void setAmplifierSpec(HardwareSpec spec) {
    this.amplifierSpec = spec;
  }

  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
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
}
