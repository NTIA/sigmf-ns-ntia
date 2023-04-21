package gov.doc.ntia.sigmf.ext.capture.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calibration {

  protected Double gain;

  @JsonProperty(value = "noise_figure")
  protected Double noiseFigure;

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
}
