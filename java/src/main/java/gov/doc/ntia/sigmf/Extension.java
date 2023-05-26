package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Extension implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(required = true)
  protected String name;

  @NotNull
  @JsonProperty(required = true)
  protected String version;

  @NotNull
  @JsonProperty(required = true)
  protected Boolean optional;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Boolean getOptional() {
    return optional;
  }

  public void setOptional(Boolean optional) {
    this.optional = optional;
  }
}
