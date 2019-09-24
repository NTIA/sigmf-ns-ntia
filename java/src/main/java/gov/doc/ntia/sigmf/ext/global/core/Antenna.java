package gov.doc.ntia.sigmf.ext.global.core;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Antenna implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = true)
    protected String id;

    @JsonProperty(value="model", required = true)
    protected String model;

    @JsonProperty(value="type", required=false)
    protected  String type;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="low_frequency", required = false)
    protected Double lowFrequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="high_frequency", required = false)
    protected Double highFrequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="gain", required=false)
    protected Double gain;

    @JsonProperty(value="polarization", required = false)
    protected String polarization;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="cross_polar_discrimination", required = false)
    protected Double crossPolarDiscrimination;

    @JsonProperty(value="horizontal_gain_pattern", required = false)
    protected Double[] horizontalGainPattern;

    @JsonProperty(value="vertical_gain_pattern", required = false)
    protected  Double[] verticalGainPattern;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="horizontal_beam_width", required = false)
    protected Double horizontalBeamWidth;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="vertical_beam_width", required = false)
    protected Double verticalBeamWidth;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="voltage_standing_wave_ratio", required = false)
    protected Double voltageStandingWaveRatio;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="cable_loss", required = false)
    protected Double cableLoss;

    @JsonProperty(value="steerable", required = false)
    protected Boolean steerable;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="azimuth_angle", required = false)
    protected Double azimuthAngle;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="elevation_angle", required = false)
    protected Double elevationAngle;

    @JsonProperty(value="mobile", required = false)
    protected Boolean mobile;

    protected Map<String, Object> otherFields = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolarization() {
        return polarization;
    }

    public void setPolarization(String polarization) {
        this.polarization = polarization;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLowFrequency() {
        return lowFrequency;
    }

    public void setLowFrequency(Double lowFrequency) {
        this.lowFrequency = lowFrequency;
    }

    public Double getHighFrequency() {
        return highFrequency;
    }

    public void setHighFrequency(Double highFrequency) {
        this.highFrequency = highFrequency;
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

    public Double getHorizontalBeamWidth() {
        return horizontalBeamWidth;
    }

    public void setHorizontalBeamWidth(Double horizontalBeamWidth) {
        this.horizontalBeamWidth = horizontalBeamWidth;
    }

    public Double getVerticalBeamWidth() {
        return verticalBeamWidth;
    }

    public void setVerticalBeamWidth(Double verticalBeamWidth) {
        this.verticalBeamWidth = verticalBeamWidth;
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

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherFields(){
        return otherFields;
    }

    @JsonAnySetter
    public void add(String key, Object value){
        otherFields.put(key, value);
    }

}
