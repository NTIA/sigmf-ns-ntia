package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilter implements Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String id;
  
  @JsonProperty(value = "filter_type", required = false)
  protected String filterType;

  @JsonProperty(value = "FIR_coefficients", required = false)
  protected Double[] firCoefficients;

  @JsonProperty(value = "IIR_numerator_coefficients", required = false)
  protected Double[] iirNumeratorCoefficients;

  @JsonProperty(value = "IIR_denominator_coefficients", required = false)
  protected Double[] iirDenominatorCoefficients;

  @JsonProperty(value = "frequency_cutoff", required = false)
  protected Double frequencyCutoff;

  @JsonProperty(value = "attenuation_cutoff", required = false)
  protected Double attenuationCutoff;

  @JsonProperty(value = "ripple_passband", required = false)
  protected Double ripplePassband;

  @JsonProperty(value = "attenuation_stopband", required = false)
  protected Double attenuationStopband;

  @JsonProperty(value = "frequency_stopband", required = false)
  protected Double frequencyStopband;

  protected Map<String, Object> otherFields = new HashMap<>();

  public String getFilterType() {
    return filterType;
  }

  public void setFilterType(String filterType) {
    this.filterType = filterType;
  }

  public Double[] getFirCoefficients() {
    return firCoefficients;
  }

  public void setFirCoefficients(Double[] firCoefficients) {
    this.firCoefficients = firCoefficients;
  }

  public Double[] getIirNumeratorCoefficients() {
    return iirNumeratorCoefficients;
  }

  public DigitalFilter(){}

  public void setIirNumeratorCoefficients(Double[] iirNumeratorCoefficients) {
    this.iirNumeratorCoefficients = iirNumeratorCoefficients;
  }

  public Double[] getIirDenominatorCoefficients() {
    return iirDenominatorCoefficients;
  }

  public void setIirDenominatorCoefficients(Double[] iirDenominatorCoefficients) {
    this.iirDenominatorCoefficients = iirDenominatorCoefficients;
  }

  public Double getFrequencyCutoff() {
    return frequencyCutoff;
  }

  public void setFrequencyCutoff(Double frequencyCutoff) {
    this.frequencyCutoff = frequencyCutoff;
  }

  public Double getAttenuationCutoff() {
    return attenuationCutoff;
  }

  public void setAttenuationCutoff(Double attenuationCutoff) {
    this.attenuationCutoff = attenuationCutoff;
  }

  public Double getRipplePassband() {
    return ripplePassband;
  }

  public void setRipplePassband(Double ripplePassband) {
    this.ripplePassband = ripplePassband;
  }

  public Double getAttenuationStopband() {
    return attenuationStopband;
  }

  public void setAttenuationStopband(Double attenuationStopband) {
    this.attenuationStopband = attenuationStopband;
  }

  public Double getFrequencyStopband() {
    return frequencyStopband;
  }

  public void setFrequencyStopband(Double frequencyStopband) {
    this.frequencyStopband = frequencyStopband;
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
