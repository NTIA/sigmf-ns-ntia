package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ntia-core:annotation_type")
public class SensorAnnotation extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-sensor:rf_path_index", required = false)
    protected Integer rfPathIndex;

    @JsonProperty(value="ntia-sensor:overload_sensor", required = false)
    protected Boolean overloadSensor;

    @JsonProperty(value="ntia-sensor:overload_sigan", required = false)
    protected Boolean overloadSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:attenuation_setting_sigan", required = false)
    protected Double attenuationSettingSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:gain_setting_sigan", required = false)
    protected Double gainSettingSigan;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:latitude", required = false)
    protected Double sensorLatitude;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:longitude", required = false)
    protected Double sensorLongitude;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:altitude", required = false)
    protected Double altitude;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:speed", required = false)
    protected Double speed;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:bearing", required = false)
    protected Double bearing;

    @JsonProperty(value="ntia-sensor:gps_nmea", required = false)
    protected String gpsNmea;


    public Integer getRfPathIndex() {
        return rfPathIndex;
    }

    public void setRfPathIndex(Integer rfPathIndex) {
        this.rfPathIndex = rfPathIndex;
    }

    public Boolean getOverloadSensor() {
        return overloadSensor;
    }

    public void setOverloadSensor(Boolean overloadSensor) {
        this.overloadSensor = overloadSensor;
    }

    public Boolean getOverloadSigan() {
        return overloadSigan;
    }

    public void setOverloadSigan(Boolean overloadSigan) {
        this.overloadSigan = overloadSigan;
    }

    public Double getAttenuationSettingSigan() {
        return attenuationSettingSigan;
    }

    public void setAttenuationSettingSigan(Double attenuationSettingSigan) {
        this.attenuationSettingSigan = attenuationSettingSigan;
    }

    public Double getGainSettingSigan() {
        return gainSettingSigan;
    }

    public void setGainSettingSigan(Double gainSettingSigan) {
        this.gainSettingSigan = gainSettingSigan;
    }

    @Override
    public Double getLatitude() {
        return sensorLatitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        sensorLatitude = latitude;
    }

    @Override
    public Double getLongitude() {
        return sensorLongitude;
    }

    @Override
    public void setLongitude(Double longitude) {
        sensorLongitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getBearing() {
        return bearing;
    }

    public void setBearing(Double bearing) {
        this.bearing = bearing;
    }

    public Integer getPreselectorPathNumber() {
        return rfPathIndex;
    }

    public void setPreselectorPathNumber(Integer preselectorPathNumber) {
        this.rfPathIndex = preselectorPathNumber;
    }

    public String getGpsNmea() {
        return gpsNmea;
    }

    public void setGpsNmea(String gpsNmea) {
        this.gpsNmea = gpsNmea;
    }



}
