package gov.doc.ntia.sigmf.ext.annotation.emitter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.ext.global.Antenna;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Emitter extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-emitter:id", required = true)
    protected String id;

    @JsonProperty(value="ntia-emitter:power", required = false)
    protected Double power;

    @JsonProperty(value="ntia-antenna:antenna", required = false)
    protected Antenna antenna;

    //todo add waveform

    @JsonProperty(value="ntia-emitter:latitude", required = false)
    protected  Double latitude;

    @JsonProperty(value="ntia-emitter:longitude", required = false)
    protected Double longitude;

    @JsonProperty(value="ntia-emitter:altitude", required = false)
    protected Double altitude;

    @JsonProperty(value="ntia-emitter:speed", required = false)
    protected Double speed;

    @JsonProperty(value="ntia-emitter:bearing", required = false)
    protected Double bearing;


}
