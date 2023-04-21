package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeDomainDetection extends DomainDetection {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "ntia-algorithm:number_of_samples", required = true)
  protected Long numberOfSamples;

  public Long getNumberOfSamples() {
    return numberOfSamples;
  }

  public void setNumberOfSamples(Long numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
  }
}
