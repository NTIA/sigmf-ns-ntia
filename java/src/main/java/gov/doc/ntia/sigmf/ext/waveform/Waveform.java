package gov.doc.ntia.sigmf.ext.waveform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.ext.waveform.Ieee80211p;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "model")
@JsonSubTypes({@JsonSubTypes.Type(value = Ieee80211p.class, name = "IEEE80211p")})
public class Waveform implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "model", required = true)
  protected String model;

  @JsonProperty(value = "description", required = false)
  protected String description;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
