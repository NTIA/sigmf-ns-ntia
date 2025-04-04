package gov.doc.ntia.sigmf.ext.emitter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.GeoJsonPoint;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import gov.doc.ntia.sigmf.ext.waveform.Waveform;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Emitter implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "id", required = true)
  protected String id;

  @JsonProperty(value = "description", required = false)
  protected String description;

  @JsonProperty(value = "power", required = false)
  protected Double power;

  @Valid
  @JsonProperty(value = "antenna", required = false)
  protected List<Antenna> antenna;

  @Valid
  @JsonProperty(value = "transmitter", required = false)
  protected HardwareSpec transmitter;

  @Valid
  @JsonProperty(value = "center_frequency", required = false)
  protected Double centerFrequency;

  @Valid
  @JsonProperty(value = "waveform", required = false)
  protected Waveform waveform;

  @Valid
  @JsonProperty(value = "geolocation", required = false)
  protected GeoJsonPoint geolocation;

  @Valid
  @JsonProperty(value = "environment", required = false)
  protected Environment environment;

  public HardwareSpec getTransmitter() {
    return transmitter;
  }

  public void setTransmitter(HardwareSpec transmitter) {
    this.transmitter = transmitter;
  }

  public Double getPower() {
    return power;
  }

  public void setPower(Double power) {
    this.power = power;
  }

  public List<Antenna> getAntenna() {
    return antenna;
  }

  public void setAntenna(List<Antenna> antenna) {
    this.antenna = antenna;
  }

  public void addAntenna(Antenna antenna){
    if(this.antenna == null){
      this.antenna = new ArrayList<>();
    }
    this.antenna.add(antenna);
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

  public GeoJsonPoint getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(GeoJsonPoint location) {
    this.geolocation = location;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

}
