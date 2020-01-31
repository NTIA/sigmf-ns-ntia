package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeDomainDetection extends DomainDetection  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-algorithm:number_of_samples", required = true)
    protected Long numberOfSamples;

    @JsonProperty(value="ntia-algorithm:times", required = false)
    protected Double[] times;


    public Double[] getTimes() {
        return times;
    }

    public void setTimes(Double[] times) {
        this.times = times;
    }

    public Long getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(Long numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }










}
