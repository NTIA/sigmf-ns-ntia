package gov.doc.ntia.sigmf.ext.global.emitter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import gov.doc.ntia.sigmf.ext.global.location.Location;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Emitter implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "id", required = false)
  protected String id;

  @JsonProperty(value = "description", required = false)
  protected String description;

  @JsonProperty(value = "power", required = false)
  protected Double power;

  @JsonProperty(value = "antenna", required = false)
  protected Antenna antenna;

  @JsonProperty(value = "transmitter", required = false)
  protected HardwareSpec transmitter;

  @JsonProperty(value = "center_frequency", required = false)
  protected Double centerFrequency;

  @JsonProperty(value = "waveform", required = false)
  protected Waveform waveform;

  @JsonProperty(value = "location", required = false)
  protected Location location;

  @JsonProperty(value = "environment", required = false)
  protected Environment environment;

  protected Map<String, Object> otherFields = new HashMap<>();

  public HardwareSpec getTransmitter() {
    return transmitter;
  }

  public void setTransmitter(HardwareSpec transmitter) {
    this.transmitter = transmitter;
  }

  public void setOtherFields(Map<String, Object> otherFields) {
    this.otherFields = otherFields;
  }

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

  public Double getCenterFrequency() {
    return centerFrequency;
  }

  public void setCenterFrequency(Double centerFrequency) {
    this.centerFrequency = centerFrequency;
  }

  public Waveform getWaveform() {
    return waveform;
  }

  public void setWaveform(Waveform waveform) {
    this.waveform = waveform;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
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

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }
}
