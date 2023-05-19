package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.validation.constraints.NotNull;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "product_type")
@JsonSubTypes({
  @JsonSubTypes.Type(
      value = AmplitudeProbabilityDistribution.class,
      name = "amplitude_probability_distribution"),
  @JsonSubTypes.Type(value = PeriodicFramePower.class, name = "periodic_frame_power"),
  @JsonSubTypes.Type(value = PowerSpectralDensity.class, name = "power_spectral_density"),
  @JsonSubTypes.Type(value = TimeSeriesPower.class, name = "time_series_power")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class DataProduct implements IDataProduct {

  @NotNull
  @JsonProperty(value = "length", required = true)
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
