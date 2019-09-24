package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RFPath implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="low_frequency_passband", required = false)
    protected Double lowFrequencyPassband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="high_frequency_passband", required = false)
    protected Double highFrequencyPassband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="low_frequency_stopband", required = false)
    protected Double lowFrequencyStopband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value ="high_frequency_stopband", required = false)
    protected Double highFrequencyStopband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="lna_noise_figure", required = false)
    protected Double lnaNoiseFigure;

    @JsonProperty(value = "cal_source_type", required = false)
    protected String calSourceType;

    protected Map<String, Object> otherFields = new HashMap<>();

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

    public Double getLowFrequencyStopband() {
        return lowFrequencyStopband;
    }

    public void setLowFrequencyStopband(Double getLowFrequencyStopband) {
        this.lowFrequencyStopband = getLowFrequencyStopband;
    }

    public Double getHighFrequencyStopband() {
        return highFrequencyStopband;
    }

    public void setHighFrequencyStopband(Double getHighFrequencyStopband) {
        this.highFrequencyStopband = getHighFrequencyStopband;
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

    @JsonAnyGetter
    public Map<String, Object> getOtherFields(){
        return otherFields;
    }

    @JsonAnySetter
    public void add(String key, Object value){
        otherFields.put(key, value);
    }



}
