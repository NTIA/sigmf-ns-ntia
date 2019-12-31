package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;


import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FrequencyDomainDetection extends DomainDetection implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-algorithm:number_of_ffts", required =  true)
    protected int numberOfFfts;

    @JsonProperty(value="ntia-algorithm:number_of_samples_in_fft", required = true)
    protected int numberOfSamplesInFft;

    @JsonProperty(value="ntia-algorithm:window", required = true)
    protected String window;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value = "ntia-algorithm:equivalent_noise_bandwidth", required = false)
    protected Double equivalentNoiseBandwidth;


    @JsonProperty(value="ntia-algorithm:frequency", required = false)
    protected Double[] frequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-algorithm:frequency_start", required = false)
    protected Double frequencyStart;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-algorithm:frequency_stop", required = false)
    protected Double frequencyStop;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-algorithm:frequency_step", required = false)
    protected Double frequencyStep;


    public Double[] getFrequency() {
        return frequency;
    }

    public void setFrequency(Double[] frequency) {
        this.frequency = frequency;
    }

    public Double getFrequencyStart() {
        return frequencyStart;
    }

    public void setFrequencyStart(Double frequencyStart) {
        this.frequencyStart = frequencyStart;
    }

    public Double getFrequencyStop() {
        return frequencyStop;
    }

    public void setFrequencyStop(Double frequencyStop) {
        this.frequencyStop = frequencyStop;
    }

    public Double getFrequencyStep() {
        return frequencyStep;
    }

    public void setFrequencyStep(Double frequencyStep) {
        this.frequencyStep = frequencyStep;
    }


    public FrequencyDomainDetection(){
        this.detectionDomain = "frequency";
    }


    public int getNumberOfFfts() {
        return numberOfFfts;
    }

    public void setNumberOfFfts(int numberOfFfts) {
        this.numberOfFfts = numberOfFfts;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }


    public int getNumberOfSamplesInFft() {
        return numberOfSamplesInFft;
    }

    public void setNumberOfSamplesInFft(int numberOfSamplesInFft) {
        this.numberOfSamplesInFft = numberOfSamplesInFft;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public Double getEquivalentNoiseBandwidth() {
        return equivalentNoiseBandwidth;
    }

    public void setEquivalentNoiseBandwidth(Double equivalentNoiseBandwidth) {
        this.equivalentNoiseBandwidth = equivalentNoiseBandwidth;
    }



}
