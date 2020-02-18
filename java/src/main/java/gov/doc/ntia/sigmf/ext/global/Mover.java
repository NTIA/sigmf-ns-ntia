package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Mover implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="latitude", required = false)
    protected Double latitude;

    @JsonProperty(value="longitude", required = false)
    protected Double longitude;

    @JsonProperty(value="speed", required = false)
    protected Double speed;

    @JsonProperty(value="bearing", required = false)
    protected Double bearing;

    @JsonProperty(value="altitude", required = false)
    protected Double altitude;

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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


}
