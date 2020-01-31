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
public class EmitterAnnotation extends Annotation  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-emitter:id", required = true)
    protected String id;


    @JsonProperty(value="ntia-emitter:waveform", required = false)
    protected Waveform waveform;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Waveform getWaveform() {
        return waveform;
    }

    public void setWaveform(Waveform waveform) {
        this.waveform = waveform;
    }

}
