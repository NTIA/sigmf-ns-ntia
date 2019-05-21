package gov.doc.ntia.sigmf.ext.global.emitter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.ext.global.Antenna;
import gov.doc.ntia.sigmf.ext.global.Mover;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Emitter extends Mover implements Serializable  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = false)
    protected String id;

    @JsonProperty(value="description", required = false)
    protected String description;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="power", required = false)
    protected Double power;

    @JsonProperty(value="antenna", required = false)
    protected Antenna antenna;

    @JsonProperty(value="waveform", required = false)
    protected Waveform waveform;

    @JsonProperty(value="transmitter", required = false)
    protected Transmitter transmitter;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
