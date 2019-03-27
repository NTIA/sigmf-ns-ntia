package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorEnvironment extends Environment {
    @JsonProperty(value="ntia-environment:sensor_id", required = true)
    protected String sensorId;

}
