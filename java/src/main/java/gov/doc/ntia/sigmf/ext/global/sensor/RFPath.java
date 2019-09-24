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
    @JsonProperty(value="low_frequency_passband_filter", required = false)
    protected Double lowFrequencyPassbandFilter;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="high_frequency_passband_filter", required = false)
    protected Double highFrequencyPassbandFilter;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="low_frequency_stopband_filter", required = false)
    protected Double lowFrequencyStopbandFilter;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value ="high_frequency_stopband_filter", required = false)
    protected Double highFrequencyStopbandFilter;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value ="gain_lna", required = false)
    protected Double gainLna;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="noise_figure_lna", required = false)
    protected Double noiseFigureLna;

    @JsonProperty(value = "type_cal_source", required = false)
    protected String typeCalSource;

    public Double getGainLna() {
        return gainLna;
    }

    public void setGainLna(Double gainLna) {
        this.gainLna = gainLna;
    }

    public void setOtherFields(Map<String, Object> otherFields) {
        this.otherFields = otherFields;
    }


    protected Map<String, Object> otherFields = new HashMap<>();

    public Double getLowFrequencyPassbandFilter() {
        return lowFrequencyPassbandFilter;
    }

    public void setLowFrequencyPassbandFilter(Double lowFrequencyPassbandFilter) {
        this.lowFrequencyPassbandFilter = lowFrequencyPassbandFilter;
    }

    public Double getHighFrequencyPassbandFilter() {
        return highFrequencyPassbandFilter;
    }

    public void setHighFrequencyPassbandFilter(Double highFrequencyPassbandFilter) {
        this.highFrequencyPassbandFilter = highFrequencyPassbandFilter;
    }

    public Double getLowFrequencyStopbandFilter() {
        return lowFrequencyStopbandFilter;
    }

    public void setLowFrequencyStopbandFilter(Double getLowFrequencyStopband) {
        this.lowFrequencyStopbandFilter = getLowFrequencyStopband;
    }

    public Double getHighFrequencyStopbandFilter() {
        return highFrequencyStopbandFilter;
    }

    public void setHighFrequencyStopbandFilter(Double getHighFrequencyStopband) {
        this.highFrequencyStopbandFilter = getHighFrequencyStopband;
    }

    public Double getNoiseFigureLna() {
        return noiseFigureLna;
    }

    public void setNoiseFigureLna(Double noiseFigureLna) {
        this.noiseFigureLna = noiseFigureLna;
    }

    public String getTypeCalSource() {
        return typeCalSource;
    }

    public void setTypeCalSource(String typeCalSource) {
        this.typeCalSource = typeCalSource;
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
