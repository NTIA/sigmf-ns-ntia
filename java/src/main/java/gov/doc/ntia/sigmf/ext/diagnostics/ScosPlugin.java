package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScosPlugin {

  @NotNull
  @JsonProperty(required = true)
  protected String name;

  @NotNull
  @JsonProperty(required = true)
  protected String version;

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
}
