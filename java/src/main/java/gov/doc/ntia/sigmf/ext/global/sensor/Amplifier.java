package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;

public class Amplifier {
    @JsonProperty(value="amplifier_spec", required = false)
    protected HardwareSpec amplifierSpec;

    @JsonProperty(value ="gain", required = false)
    protected Double gain;


    @JsonProperty(value="noise_figure", required = false)
    protected Double noiseFigure;

    @JsonProperty(value= "max_power", required = false)
    protected  Double maxPower;

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
