package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorEnvironment extends Environment {
    @JsonProperty(value="ntia-environment:sensor_id", required = true)
    protected String sensorId;

}
