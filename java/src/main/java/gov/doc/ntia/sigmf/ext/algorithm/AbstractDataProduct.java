package gov.doc.ntia.sigmf.ext.algorithm;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({@JsonSubTypes.Type(value = Graph.class)})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractDataProduct {

  @JsonProperty(required = false)
  protected List<String> processing;

  @NotNull
  @JsonProperty(required = true)
  protected String name;

  @JsonProperty(required = false)
  protected String description;

  public String getName(){
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription(){
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getProcessing() {
    return processing;
  }

  public void setProcessing(List<String> processing) {
    this.processing = processing;
  }

  public void addProcessing(String processingID) {
    if (this.processing == null) {
      processing = new ArrayList<>();
    }
    processing.add(processingID);
  }

  public void removeProcessing(String processingID) {
    if (this.processing != null) {
      processing.remove(processingID);
    }
  }
}
