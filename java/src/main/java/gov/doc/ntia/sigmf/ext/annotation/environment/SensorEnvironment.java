package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorEnvironment extends Environment implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-environment:sensor_id", required = true)
    protected String sensorId;

}
