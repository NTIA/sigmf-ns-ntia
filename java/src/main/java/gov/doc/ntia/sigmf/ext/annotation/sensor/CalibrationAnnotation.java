package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalibrationAnnotation extends Annotation {

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:gain_sigan", required = false)
    protected Double gainSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:noise_figure_sigan", required = false)
    protected Double noiseFigureSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:ldb_compression_point_sigan", required = false)
    protected Double oneDbCompressionPointSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:enbw_sigan", required = false)
    protected Double enbwSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:gain_preselector", required = false)
    protected Double gainPreselector;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:noise_figure_sensor", required = false)
    protected Double noiseFigureSensor;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:1db_compression_point_sensor", required = false)
    protected Double oneDbCompressionPointSensor;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value = "ntia-sensor:enbw_sensor", required = false)
    protected Double enbwSensor;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value = "ntia-sensor:mean_noise_power_sensor", required = false)
    protected Double meanNoisePowerSensor;

    public void setGainSigan(Double gainSigan) {
        this.gainSigan = gainSigan;
    }

    public void setOneDbCompressionPointSigan(Double oneDbCompressionPointSigan) {
        this.oneDbCompressionPointSigan = oneDbCompressionPointSigan;
    }

    public Double getEnbwSigan() {
        return enbwSigan;
    }

    public void setEnbwSigan(Double enbwSigan) {
        this.enbwSigan = enbwSigan;
    }

    public Double getGainPreselector() {
        return gainPreselector;
    }

    public void setGainPreselector(Double gainPreselector) {
        this.gainPreselector = gainPreselector;
    }

    public Double getNoiseFigureSensor() {
        return noiseFigureSensor;
    }

    public void setNoiseFigureSensor(Double noiseFigureSensor) {
        this.noiseFigureSensor = noiseFigureSensor;
    }

    public Double getOneDbCompressionPointSensor() {
        return oneDbCompressionPointSensor;
    }

    public void setOneDbCompressionPointSensor(Double oneDbCompressionPointSensor) {
        this.oneDbCompressionPointSensor = oneDbCompressionPointSensor;
    }

    public Double getEnbwSensor() {
        return enbwSensor;
    }

    public void setEnbwSensor(Double enbwSensor) {
        this.enbwSensor = enbwSensor;
    }

    public Double getMeanNoisePowerSensor() {
        return meanNoisePowerSensor;
    }

    public void setMeanNoisePowerSensor(Double meanNoisePowerSensor) {
        this.meanNoisePowerSensor = meanNoisePowerSensor;
    }

    public Double getGainSigan() {
        return gainSigan;
    }

    public Double getOneDbCompressionPointSigan() {
        return oneDbCompressionPointSigan;
    }

    public void set1DbCompressionPointSigan(Double oneDbCompressionPointSigan) {
        this.oneDbCompressionPointSigan = oneDbCompressionPointSigan;
    }

    public Double getNoiseFigureSigan() {
        return noiseFigureSigan;
    }

    public void setNoiseFigureSigan(Double noiseFigureSigan) {
        this.noiseFigureSigan = noiseFigureSigan;
    }

}
