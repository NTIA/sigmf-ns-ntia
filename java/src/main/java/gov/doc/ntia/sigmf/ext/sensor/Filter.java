package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import java.io.Serializable;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @JsonProperty(value = "filter_spec", required = false)
  protected HardwareSpec filterSpec;

  @JsonProperty(value = "frequency_low_passband", required = false)
  protected Double frequencyLowPassband;

  @JsonProperty(value = "frequency_high_passband", required = false)
  protected Double frequencyHighPassband;

  @JsonProperty(value = "frequency_low_stopband", required = false)
  protected Double frequencyLowStopband;

  @JsonProperty(value = "frequency_high_stopband", required = false)
  protected Double frequencyHighStopband;

  public HardwareSpec getFilterSpec() {
    return filterSpec;
  }

  public void setFilterSpec(HardwareSpec filterSpec) {
    this.filterSpec = filterSpec;
  }

  public Double getFrequencyLowPassband() {
    return frequencyLowPassband;
  }

  public void setFrequencyLowPassband(Double frequencyLowPassband) {
    this.frequencyLowPassband = frequencyLowPassband;
  }

  public Double getFrequencyHighPassband() {
    return frequencyHighPassband;
  }

  public void setFrequencyHighPassband(Double frequencyHighPassband) {
    this.frequencyHighPassband = frequencyHighPassband;
  }

  public Double getFrequencyLowStopband() {
    return frequencyLowStopband;
  }

  public void setFrequencyLowStopband(Double frequencyLowStopband) {
    this.frequencyLowStopband = frequencyLowStopband;
  }

  public Double getFrequencyHighStopband() {
    return frequencyHighStopband;
  }

  public void setFrequencyHighStopband(Double frequencyHighStopband) {
    this.frequencyHighStopband = frequencyHighStopband;
  }
}
