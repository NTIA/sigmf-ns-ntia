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
public class Receiver implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="model", required = true)
    protected String model;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="low_frequency", required = false)
    protected  Double lowFrequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="high_frequency", required = false)
    protected Double highFrequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="noise_figure", required = false)
    protected Double noiseFigure;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="max_power", required = false)
    protected Double maxPower;

    @JsonProperty(value="a2d_bits", required = false)
    protected Long a2dBits;

    protected Map<String, Object> otherFields = new HashMap<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Double getNoiseFigure() {
        return noiseFigure;
    }

    public void setNoiseFigure(Double noiseFigure) {
        this.noiseFigure = noiseFigure;
    }

    public Double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Double maxPower) {
        this.maxPower = maxPower;
    }

    public Long getA2dBits() {
        return a2dBits;
    }

    public void setA2dBits(Long a2dBits) {
        this.a2dBits = a2dBits;
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
