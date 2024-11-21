package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = DFT.class),
  @JsonSubTypes.Type(value = DigitalFilter.class)
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractProcessing {
  @NotNull
  @JsonProperty(required = true)
  protected String id;

  @JsonProperty(required = false)
  protected String description;

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
}
