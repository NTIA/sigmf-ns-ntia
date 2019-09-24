package gov.doc.ntia.sigmf.ext.annotation.emitter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmitterAnnotation extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-emitter:id", required = true)
    protected String id;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-emitter:power", required = false)
    protected Double power;

    @JsonProperty(value="ntia-emitter:antenna", required = false)
    protected Antenna antenna;

    @JsonProperty(value="ntia-emitter:waveform", required = false)
    protected Waveform waveform;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-emitter:altitude", required = false)
    protected Double altitude;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-emitter:speed", required = false)
    protected Double speed;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-emitter:bearing", required = false)
    protected Double bearing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Antenna getAntenna() {
        return antenna;
    }

    public void setAntenna(Antenna antenna) {
        this.antenna = antenna;
    }

    public Waveform getWaveform() {
        return waveform;
    }

    public void setWaveform(Waveform waveform) {
        this.waveform = waveform;
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




}
