package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calibration {

  protected Double gain;

  @JsonProperty(value = "noise_figure")
  protected Double noiseFigure;

  protected Double temperature;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  protected Date datetime;

  @JsonProperty(value = "1db_compression_point", required = false)
  protected Double compressionPoint;

  protected Double enbw;

  @JsonProperty(value = "mean_noise_power", required = false)
  protected Double meanNoisePower;

  @JsonProperty(value = "mean_noise_power_units", required = false)
  protected String meanNoisePowerUnits;

  protected String reference;

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

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

  public Double getCompressionPoint() {
    return compressionPoint;
  }

  public void setCompressionPoint(Double compressionPoint) {
    this.compressionPoint = compressionPoint;
  }

  public Double getEnbw() {
    return enbw;
  }

  public void setEnbw(Double enbw) {
    this.enbw = enbw;
  }

  public Double getMeanNoisePower() {
    return meanNoisePower;
  }

  public void setMeanNoisePower(Double meanNoisePower) {
    this.meanNoisePower = meanNoisePower;
  }

  public String getMeanNoisePowerUnits() {
    return meanNoisePowerUnits;
  }

  public void setMeanNoisePowerUnits(String meanNoisePowerUnits) {
    this.meanNoisePowerUnits = meanNoisePowerUnits;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}
