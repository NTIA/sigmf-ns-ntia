package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SensorAnnotation extends Annotation  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-sensor:rf_path_index", required = false)
    protected Integer rfPathIndex;


    @JsonProperty(value="ntia-sensor:overload", required = false)
    protected Boolean overload;


    @JsonProperty(value="ntia-sensor:attenuation_setting_sigan", required = false)
    protected Double attenuationSettingSigan;


    @JsonProperty(value="ntia-sensor:gain_setting_sigan", required = false)
    protected Double gainSettingSigan;


    @JsonProperty(value="ntia-sensor:latitude", required = false)
    protected Double sensorLatitude;


    @JsonProperty(value="ntia-sensor:longitude", required = false)
    protected Double sensorLongitude;


    @JsonProperty(value="ntia-sensor:altitude", required = false)
    protected Double altitude;


    @JsonProperty(value="ntia-sensor:speed", required = false)
    protected Double speed;


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


    public Boolean getOverload() {
        return overload;
    }

    public void setOverload(Boolean overload) {
        this.overload = overload;
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
    public void setLatitude(Double latitude) {
        this.sensorLatitude = latitude;
    }
    @Override
    public void setLongitude(Double longitude) {
       this.sensorLongitude = longitude;
    }

    public Double getSensorLongitude(){
        return sensorLongitude;
    }

    public Double getSensorLatitude(){
        return sensorLatitude;
    }

    @Override
    @JsonIgnore
    public Double getLongitude() {
      return sensorLongitude;
    }

    @Override
    @JsonIgnore
    public Double getLatitude() {
        return sensorLatitude;
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
