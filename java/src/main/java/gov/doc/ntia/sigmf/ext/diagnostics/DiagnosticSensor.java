package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiagnosticSensor {

  @JsonProperty protected String name;

  @JsonProperty protected String description;

  @JsonProperty(value = "expected_value")
  protected Double expectedValue;

  @JsonProperty(value = "maximum_allowed")
  protected Double maximumAllowed;

  @JsonProperty(value = "minimum_allowed")
  protected Double minimumAllowed;

  @JsonProperty protected Double value;

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

  public Double getExpectedValue() {
    return expectedValue;
  }

  public void setExpectedValue(Double expectedValue) {
    this.expectedValue = expectedValue;
  }

  public Double getMaximumAllowed() {
    return maximumAllowed;
  }

  public void setMaximumAllowed(Double maximumAllowed) {
    this.maximumAllowed = maximumAllowed;
  }

  public Double getMinimumAllowed() {
    return minimumAllowed;
  }

  public void setMinimumAllowed(Double minimumAllowed) {
    this.minimumAllowed = minimumAllowed;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
