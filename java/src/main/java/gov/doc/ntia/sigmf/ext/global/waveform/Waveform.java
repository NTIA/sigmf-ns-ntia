package gov.doc.ntia.sigmf.ext.global.waveform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.TimeDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.callibration.CalibrationAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.emitter.EmitterAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.environment.EmitterEnvironment;
import gov.doc.ntia.sigmf.ext.annotation.environment.SensorEnvironment;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "ntia-waveform:model")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IEEE80211p.class, name ="IEEE80211p")
})
public class Waveform  implements Serializable {

    private static final long serialVersionUID = 1L;
}
