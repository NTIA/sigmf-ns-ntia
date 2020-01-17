package gov.doc.ntia.sigmf.ext.global.scos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = true)
    protected Integer id;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="end_time", required =  true)
    protected Date endTime;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="start_time", required = true)
    protected Date startTime;


    @JsonProperty(value="recording", required = false)
    protected Integer recording;

    @JsonProperty(value="low_frequency", required = false)
    protected Double lowFrequency;

    @JsonProperty(value="high_frequency", required = false)
    protected Double highFrequency;

    @JsonProperty(value="center_frequency", required = false)
    protected Double centerFrequency;

    @JsonProperty(value="domain", required = true)
    protected String domeain;


    @JsonProperty(value="measurement_type", required = true)
    protected String measuremenType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecording() {
        return recording;
    }

    public void setRecording(Integer recording) {
        this.recording = recording;
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

    public Double getCenterFrequency() {
        return centerFrequency;
    }

    public void setCenterFrequency(Double centerFrequency) {
        this.centerFrequency = centerFrequency;
    }

    public String getDomeain() {
        return domeain;
    }

    public void setDomeain(String domeain) {
        this.domeain = domeain;
    }

    public String getMeasuremenType() {
        return measuremenType;
    }

    public void setMeasuremenType(String measuremenType) {
        this.measuremenType = measuremenType;
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
