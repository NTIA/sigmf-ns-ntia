package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RFPath implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="rf_path_number", required = false)
    protected Long rfPathNumber;

    @JsonProperty(value="low_frequency_passband", required = false)
    protected Double lowFrequencyPassband;

    @JsonProperty(value="hig_frequency_passband", required = false)
    protected Double highFrequencyPassband;

    @JsonProperty(value="low_frequency_stopband", required = false)
    protected Double getLowFrequencyStopband;

    @JsonProperty(value ="high_frequency_stopband", required = false)
    protected Double getHighFrequencyStopband;

    @JsonProperty(value="lna_noise_figure", required = false)
    protected Double lnaNoiseFigure;

    @JsonProperty(value = "cal_source_type", required = false)
    protected String calSourceType;

    public Long getRfPathNumber() {
        return rfPathNumber;
    }

    public void setRfPathNumber(Long rfPathNumber) {
        this.rfPathNumber = rfPathNumber;
    }

    public Double getLowFrequencyPassband() {
        return lowFrequencyPassband;
    }

    public void setLowFrequencyPassband(Double lowFrequencyPassband) {
        this.lowFrequencyPassband = lowFrequencyPassband;
    }

    public Double getHighFrequencyPassband() {
        return highFrequencyPassband;
    }

    public void setHighFrequencyPassband(Double highFrequencyPassband) {
        this.highFrequencyPassband = highFrequencyPassband;
    }

    public Double getGetLowFrequencyStopband() {
        return getLowFrequencyStopband;
    }

    public void setGetLowFrequencyStopband(Double getLowFrequencyStopband) {
        this.getLowFrequencyStopband = getLowFrequencyStopband;
    }

    public Double getGetHighFrequencyStopband() {
        return getHighFrequencyStopband;
    }

    public void setGetHighFrequencyStopband(Double getHighFrequencyStopband) {
        this.getHighFrequencyStopband = getHighFrequencyStopband;
    }

    public Double getLnaNoiseFigure() {
        return lnaNoiseFigure;
    }

    public void setLnaNoiseFigure(Double lnaNoiseFigure) {
        this.lnaNoiseFigure = lnaNoiseFigure;
    }

    public String getCalSourceType() {
        return calSourceType;
    }

    public void setCalSourceType(String calSourceType) {
        this.calSourceType = calSourceType;
    }




}
