package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FrequencyDomainDetection extends DomainDetection {


    @JsonProperty(value="ntia-algorithm:number_of_ffts", required =  true)
    protected int numberOfFfts;

    @JsonProperty(value="ntia-algorithm:number_of_samples_in_fft", required = true)
    protected int numberOfSamplesInFft;

    @JsonProperty(value="ntia-algorithm:window", required = true)
    protected String window;

    @JsonProperty(value = "ntia-algorithm:equivalent_noise_bandwidth", required = false)
    protected Double equivalentNoiseBandwidth;




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
