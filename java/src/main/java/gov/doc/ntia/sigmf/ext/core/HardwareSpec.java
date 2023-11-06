package gov.doc.ntia.sigmf.ext.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class HardwareSpec implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "id", required = true)
  protected String id;

  @JsonProperty(value = "model", required = false)
  protected String model;

  @JsonProperty(value = "version", required = false)
  protected String version;

  @JsonProperty(value = "description", required = false)
  protected String description;

  @JsonProperty(value = "supplemental_information", required = false)
  protected String supplementalInformation;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSupplementalInformation() {
    return supplementalInformation;
  }

  public void setSupplementalInformation(String supplementalInformation) {
    this.supplementalInformation = supplementalInformation;
  }
}
