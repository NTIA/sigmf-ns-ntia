package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor extends Annotation {

    @JsonProperty(value="ntia-sensor:altitude", required = false)
    protected Double altitude;

    @JsonProperty(value="ntia-sensor:speed", required = false)
    protected Double speed;

    @JsonProperty(value="ntia-sensor:bearing", required = false)
    protected Double bearing;

    @JsonProperty(value="ntia-sensor:preselector_rf_path_number", required = false)
    protected Integer preselectorPathNumber;

    @JsonProperty(value="ntia-sensor:gps_fix_quality", required = false)
    protected String gpsQuality;

    @JsonProperty(value="ntia-sensor:overload_flag", required = false)
    protected Boolean overload;

    @JsonProperty(value="ntia-sensor:receiver_attenuation", required = false)
    protected Double receiverAttenuation;

    @JsonProperty(value="ntia-sensor:system_noise", required = false)
    protected SystemNoise systemNoise;


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

    public String getGpsQuality() {
        return gpsQuality;
    }

    public void setGpsQuality(String gpsQuality) {
        this.gpsQuality = gpsQuality;
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

    public SystemNoise getSystemNoise() {
        return systemNoise;
    }

    public void setSystemNoise(SystemNoise systemNoise) {
        this.systemNoise = systemNoise;
    }


}
