package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeDomainDetection extends DomainDetection  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-algorithm:number_of_samples", required = true)
    protected Long numberOfSamples;

    @JsonProperty(value="ntia-algorithm:time", required = false)
    protected Double[] time;

    @JsonProperty(value="ntia-algorithm:time_start", required=false)
    protected Double timeStart;

    @JsonProperty(value="ntia-algorithm:time_stop", required=false)
    protected Double timeStop;

    @JsonProperty(value="ntia-algorithm:time_step", required=false)
    protected Double timeStep;

    public Double[] getTime() {
        return time;
    }

    public void setTime(Double[] time) {
        this.time = time;
    }

    public Double getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Double timeStart) {
        this.timeStart = timeStart;
    }

    public Double getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Double timeStop) {
        this.timeStop = timeStop;
    }

    public Double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(Double timeStep) {
        this.timeStep = timeStep;
    }


    public TimeDomainDetection(){
        this.detectionDomain="time";
    }

    public Long getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(Long numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }










}
