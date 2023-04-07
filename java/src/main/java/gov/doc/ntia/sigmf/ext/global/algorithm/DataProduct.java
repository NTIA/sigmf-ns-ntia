package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*@JsonSubTypes({
  @JsonSubTypes.Type(value = TimeSeriesPower.class, name = "time_domain_power_series"),
  @JsonSubTypes.Type(value = PeriodicFramePower.class),
  @JsonSubTypes.Type(value = AmplitudeProbabilityDistribution.class)})*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class DataProduct implements IDataProduct {

  @JsonProperty(value = "length", required = false)
  protected Long length;

  @JsonProperty(value = "reference", required = false)
  protected String reference;

  public Long getLength() {
    return length;
  }

  public void setLength(Long length) {
    this.length = length;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

}
