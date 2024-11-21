package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilter extends AbstractProcessing implements Serializable {

  @NotNull
  @JsonProperty(value = "filter_type", required = true)
  protected FilterTypeEnum filterType;

  @JsonProperty(value = "feedforward_coefficients", required = false)
  protected Double[] feedforwardCoefficients;

  @JsonProperty(value = "feedback_coefficients", required = false)
  protected Double[] feedbackCoefficients;

  @JsonProperty(value = "attenuation_cutoff", required = false)
  protected Double attenuationCutoff;

  @JsonProperty(value = "frequency_cutoff", required = false)
  protected Double frequencyCutoff;

  public DigitalFilter() {}

  public FilterTypeEnum getFilterType() {
    return filterType;
  }

  public void setFilterType(FilterTypeEnum filterType) {
    this.filterType = filterType;
  }

  public Double[] getFeedforwardCoefficients() {
    return feedforwardCoefficients;
  }

  public void setFeedforwardCoefficients(Double[] feedforwardCoefficients) {
    this.feedforwardCoefficients = feedforwardCoefficients;
  }

  public Double[] getFeedbackCoefficients() {
    return feedbackCoefficients;
  }

  public void setFeedbackCoefficients(Double[] feedbackCoefficients) {
    this.feedbackCoefficients = feedbackCoefficients;
  }

  public Double getAttenuationCutoff() {
    return attenuationCutoff;
  }

  public void setAttenuationCutoff(Double attenuationCutoff) {
    this.attenuationCutoff = attenuationCutoff;
  }

  public Double getFrequencyCutoff() {
    return frequencyCutoff;
  }

  public void setFrequencyCutoff(Double frequencyCutoff) {
    this.frequencyCutoff = frequencyCutoff;
  }

}
