package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Receiver {
    @JsonProperty(value="ntia-sensor:model", required = true)
    protected String model;

    @JsonProperty(value="ntia-sensor:low_frequency", required = false)
    protected  Double lowFrequency;

    @JsonProperty(value="ntia-sensor:high_frequency", required = false)
    protected Double highFrequency;

    @JsonProperty(value="ntia-sensor:noise_figure", required = false)
    protected Double noiseFigure;

    @JsonProperty(value="ntia-sensor:max_power", required = false)
    protected Double maxPower;

    @JsonProperty(value="ntia-sensor:a2d_bits", required = false)
    protected Long a2dBits;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Long getA2dBits() {
        return a2dBits;
    }

    public void setA2dBits(Long a2dBits) {
        this.a2dBits = a2dBits;
    }




}
