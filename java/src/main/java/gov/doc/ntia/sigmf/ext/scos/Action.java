package gov.doc.ntia.sigmf.ext.scos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "name", required = true)
  protected String name;

  @JsonProperty(value = "description", required = false)
  protected String description;

  @JsonProperty(value = "summary", required = false)
  protected String summary;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
}
