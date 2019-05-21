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

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:altitude", required = false)
    protected Double altitude;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:speed", required = false)
    protected Double speed;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:bearing", required = false)
    protected Double bearing;

    @JsonProperty(value="ntia-sensor:preselector_rf_path_number", required = false)
    protected Integer preselectorPathNumber;

    @JsonProperty(value="ntia-sensor:gps_nmea", required = false)
    protected String gpsNmea;

    @JsonProperty(value="ntia-sensor:overload_flag", required = false)
    protected Boolean overload;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-sensor:receiver_attenuation", required = false)
    protected Double receiverAttenuation;

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
        return preselectorPathNumber;
    }

    public void setPreselectorPathNumber(Integer preselectorPathNumber) {
        this.preselectorPathNumber = preselectorPathNumber;
    }

    public String getGpsNmea() {
        return gpsNmea;
    }

    public void setGpsNmea(String gpsNmea) {
        this.gpsNmea = gpsNmea;
    }

    public Boolean getOverload() {
        return overload;
    }

    public void setOverload(Boolean overload) {
        this.overload = overload;
    }

    public Double getReceiverAttenuation() {
        return receiverAttenuation;
    }

    public void setReceiverAttenuation(Double receiverAttenuation) {
        this.receiverAttenuation = receiverAttenuation;
    }

}
