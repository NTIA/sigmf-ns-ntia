package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @NotNull
  @JsonProperty(value = "sensor_spec", required = true)
  protected HardwareSpec sensorSpec;

  @Valid
  @JsonProperty(value = "antenna", required = false)
  protected Antenna antenna;

  @Valid
  @JsonProperty(value = "preselector", required = false)
  protected gov.doc.ntia.sigmf.ext.sensor.Preselector preselector;

  @Valid
  @JsonProperty(value = "signal_analyzer", required = false)
  protected SignalAnalyzer signalAnalyzer;

  @Valid
  @JsonProperty(value = "computer_spec", required = false)
  protected HardwareSpec computerSpec;

  @JsonProperty(value = "mobile", required = false)
  protected Boolean mobile;

  @Valid
  @JsonProperty(value = "environment", required = false)
  protected Environment environment;

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

  public String getSensorSha512() {
    return sensorSha512;
  }

  public void setSensorSha512(String sensorSha512) {
    this.sensorSha512 = sensorSha512;
  }
}
