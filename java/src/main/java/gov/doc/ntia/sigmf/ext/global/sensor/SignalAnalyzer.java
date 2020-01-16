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

    @JsonProperty(value = "low_frequency", required = false)
    protected Double lowFrequency;

    @JsonProperty(value = "high_frequency", required = false)
    protected Double highFrequency;

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

    public Integer getA2dBits() {
        return a2dBits;
    }

    public void setA2dBits(Integer a2dBits) {
        this.a2dBits = a2dBits;
    }


}
