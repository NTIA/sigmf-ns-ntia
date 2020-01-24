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
    @JsonProperty(value="start_time", required = true)
    protected Date startTime;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="end_time", required =  true)
    protected Date endTime;



    @JsonProperty(value="low_frequency", required = false)
    protected Double lowFrequency;

    @JsonProperty(value="high_frequency", required = false)
    protected Double highFrequency;

    @JsonProperty(value="center_frequency", required = false)
    protected Double centerFrequency;

    @JsonProperty(value="domain", required = true)
    protected String domain;


    @JsonProperty(value="measurement_type", required = false)
    protected String measurementType;

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

    public Double getCenterFrequency() {
        return centerFrequency;
    }

    public void setCenterFrequency(Double centerFrequency) {
        this.centerFrequency = centerFrequency;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

}
