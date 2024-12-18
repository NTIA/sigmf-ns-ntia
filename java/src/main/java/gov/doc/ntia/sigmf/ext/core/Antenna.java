package gov.doc.ntia.sigmf.ext.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Antenna implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @NotNull
  @JsonProperty(value = "antenna_spec", required = true)
  protected HardwareSpec antennaSpec;

  @JsonProperty(value = "type", required = false)
  protected String type;

  @JsonProperty(value = "frequency_low", required = false)
  protected Double frequencyLow;

  @JsonProperty(value = "frequency_high", required = false)
  protected Double frequencyHigh;

  @JsonProperty(value = "gain", required = false)
  protected Double gain;

  @JsonProperty(value = "polarization", required = false)
  protected String polarization;

  @JsonProperty(value = "cross_polar_discrimination", required = false)
  protected Double crossPolarDiscrimination;

  @JsonProperty(value = "horizontal_gain_pattern", required = false)
  protected Double[] horizontalGainPattern;

  @JsonProperty(value = "vertical_gain_pattern", required = false)
  protected Double[] verticalGainPattern;

  @JsonProperty(value = "horizontal_beamwidth", required = false)
  protected Double horizontalBeamwidth;

  @JsonProperty(value = "vertical_beamwidth", required = false)
  protected Double verticalBeamwidth;

  @JsonProperty(value = "voltage_standing_wave_ratio", required = false)
  protected Double voltageStandingWaveRatio;

  @JsonProperty(value = "cable_loss", required = false)
  protected Double cableLoss;

  @JsonProperty(value = "steerable", required = false)
  protected Boolean steerable;

  @JsonProperty(value = "azimuth_angle", required = false)
  protected Double azimuthAngle;

  @JsonProperty(value = "elevation_angle", required = false)
  protected Double elevationAngle;

  public HardwareSpec getAntennaSpec() {
    return antennaSpec;
  }

  public void setAntennaSpec(HardwareSpec antennaSpec) {
    this.antennaSpec = antennaSpec;
  }

  public String getPolarization() {
    return polarization;
  }

  public void setPolarization(String polarization) {
    this.polarization = polarization;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }

  public Double[] getHorizontalGainPattern() {
    return horizontalGainPattern;
  }

  public void setHorizontalGainPattern(Double[] horizontalGainPattern) {
    this.horizontalGainPattern = horizontalGainPattern;
  }

  public Double[] getVerticalGainPattern() {
    return verticalGainPattern;
  }

  public void setVerticalGainPattern(Double[] verticalGainPattern) {
    this.verticalGainPattern = verticalGainPattern;
  }

  public Double getHorizontalBeamwidth() {
    return horizontalBeamwidth;
  }

  public void setHorizontalBeamwidth(Double horizontalBeamwidth) {
    this.horizontalBeamwidth = horizontalBeamwidth;
  }

  public Double getVerticalBeamwidth() {
    return verticalBeamwidth;
  }

  public void setVerticalBeamwidth(Double verticalBeamwidth) {
    this.verticalBeamwidth = verticalBeamwidth;
  }

  public Double getCrossPolarDiscrimination() {
    return crossPolarDiscrimination;
  }

  public void setCrossPolarDiscrimination(Double crossPolarDiscrimination) {
    this.crossPolarDiscrimination = crossPolarDiscrimination;
  }

  public Double getVoltageStandingWaveRatio() {
    return voltageStandingWaveRatio;
  }

  public void setVoltageStandingWaveRatio(Double voltageStandingWaveRatio) {
    this.voltageStandingWaveRatio = voltageStandingWaveRatio;
  }

  public Double getCableLoss() {
    return cableLoss;
  }

  public void setCableLoss(Double cableLoss) {
    this.cableLoss = cableLoss;
  }

  public Boolean getSteerable() {
    return steerable;
  }

  public void setSteerable(Boolean steerable) {
    this.steerable = steerable;
  }

  public Double getAzimuthAngle() {
    return azimuthAngle;
  }

  public void setAzimuthAngle(Double azimuthAngle) {
    this.azimuthAngle = azimuthAngle;
  }

  public Double getElevationAngle() {
    return elevationAngle;
  }

  public void setElevationAngle(Double elevationAngle) {
    this.elevationAngle = elevationAngle;
  }
}
