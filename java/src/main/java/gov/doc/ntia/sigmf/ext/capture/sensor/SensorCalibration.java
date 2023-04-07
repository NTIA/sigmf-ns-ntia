package gov.doc.ntia.sigmf.ext.capture.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorCalibration extends Calibration {}
