package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "id", required = true)
  protected String id;

  @JsonProperty(value = "sensor_spec", required = false)
  protected HardwareSpec sensorSpec;

  @JsonProperty(value = "antenna", required = false)
  protected Antenna antenna;

  @JsonProperty(value = "preselector", required = false)
  protected gov.doc.ntia.sigmf.ext.sensor.Preselector preselector;

  @JsonProperty(value = "signal_analyzer", required = false)
  protected SignalAnalyzer signalAnalyzer;

  @JsonProperty(value = "computer_spec", required = false)
  protected HardwareSpec computerSpec;

  @JsonProperty(value = "mobile", required = false)
  protected Boolean mobile;

  @JsonProperty(value = "environment", required = false)
  protected Environment environment;

  protected Map<String, Object> otherFields = new HashMap<>();

  @JsonProperty(value = "sensor_sha512")
  protected String sensorSha512;

  public HardwareSpec getSensorSpec() {
    return sensorSpec;
  }

  public void setSensorSpec(HardwareSpec sensorSpec) {
    this.sensorSpec = sensorSpec;
  }

  public HardwareSpec getComputerSpec() {
    return computerSpec;
  }

  public void setComputerSpec(HardwareSpec computerSpec) {
    this.computerSpec = computerSpec;
  }

  public Boolean getMobile() {
    return mobile;
  }

  public void setMobile(Boolean mobile) {
    this.mobile = mobile;
  }

  public Boolean isMobile() {
    return mobile;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Antenna getAntenna() {
    return antenna;
  }

  public void setAntenna(Antenna antenna) {
    this.antenna = antenna;
  }

  public gov.doc.ntia.sigmf.ext.sensor.Preselector getPreselector() {
    return preselector;
  }

  public void setPreselector(Preselector preselector) {
    this.preselector = preselector;
  }

  public SignalAnalyzer getSignalAnalyzer() {
    return signalAnalyzer;
  }

  public void setSignalAnalyzer(SignalAnalyzer signalAnalyzer) {
    this.signalAnalyzer = signalAnalyzer;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  public void setOtherFields(Map<String, Object> otherFields) {
    this.otherFields = otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }

  public String getSensorSha512() {
    return sensorSha512;
  }

  public void setSensorSha512(String sensorSha512) {
    this.sensorSha512 = sensorSha512;
  }
}
