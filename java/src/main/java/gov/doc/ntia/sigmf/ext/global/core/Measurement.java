package gov.doc.ntia.sigmf.ext.global.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Measurement implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="time_start", required = true)
    protected Date timeStart;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="time_stop", required =  true)
    protected Date timeStop;

    @JsonProperty(value="frequency_low", required = false)
    protected Double frequencyLow;

    @JsonProperty(value="frequency_high", required = false)
    protected Double frequencyHigh;

    @JsonProperty(value="domain", required = true)
    protected String domain;


    @JsonProperty(value="measurement_type", required = false)
    protected String measurementType;

    @JsonProperty(value="frequency_step", required = false)
    protected Double frequencyStep;


    public Double getFrequencyLow() {
        return frequencyLow;
    }

    public void setFrequencyLow(Double lowFrequency) {
        this.frequencyLow = lowFrequency;
    }

    public Double getHighFrequency() {
        return frequencyHigh;
    }

    public void setFrequencyHigh(Double highFrequency) {
        this.frequencyHigh = highFrequency;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public Date getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Date timeStop) {
        this.timeStop = timeStop;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Double getFrequencyStep() {
        return frequencyStep;
    }

    public void setFrequencyStep(Double frequencyStep) {
        this.frequencyStep = frequencyStep;
    }

}
