package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeDomainDetection {

    @JsonProperty(value="ntia-algorithm:number_of_samples", required = true)
    protected Long numberOfSamples;


    public Long getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(Long numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }










}
