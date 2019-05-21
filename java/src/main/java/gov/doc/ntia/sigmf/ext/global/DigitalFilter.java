package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="filter_type", required = false)
    protected String filterType;

    @JsonProperty(value="FIR_coefficients", required = false)
    protected  Double[] firCoefficients;

    @JsonProperty(value="IIR_numerator_coefficients", required = false)
    protected Double[] iirNumeratorCoefficients;

    @JsonProperty(value="IIR_denominator_coefficients", required = false)
    protected Double[] iirDenominatorCoefficients;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="cutoff_frequency", required = false)
    protected Double cutoffFrequency;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="cutoff_attenuation", required = false)
    protected Double cutoffAttenuation;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ripple_passband", required = false)
    protected Double ripplePassband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="attenuation_stopband", required = false)
    protected Double attenuationStopband;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="frequency_stopband", required = false)
    protected Double frequencyStopband;

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

    public void setIirNumeratorCoefficients(Double[] iirNumeratorCoefficients) {
        this.iirNumeratorCoefficients = iirNumeratorCoefficients;
    }

    public Double[] getIirDenominatorCoefficients() {
        return iirDenominatorCoefficients;
    }

    public void setIirDenominatorCoefficients(Double[] iirDenominatorCoefficients) {
        this.iirDenominatorCoefficients = iirDenominatorCoefficients;
    }

    public Double getCutoffFrequency() {
        return cutoffFrequency;
    }

    public void setCutoffFrequency(Double cutoffFrequency) {
        this.cutoffFrequency = cutoffFrequency;
    }

    public Double getCutoffAttenuation() {
        return cutoffAttenuation;
    }

    public void setCutoffAttenuation(Double cutoffAttenuation) {
        this.cutoffAttenuation = cutoffAttenuation;
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






}
