package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilterAnnotation extends Annotation {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-algorithm:filter_type", required = false)
    protected String filterType;

    @JsonProperty(value="ntia-algorithm:FIR_coefficients", required = false)
    protected  Double[] firCoefficients;

    @JsonProperty(value="ntia-algorithm:IIR_numerator_coefficients", required = false)
    protected Double[] iirNumeratorCoefficients;

    @JsonProperty(value="ntia-algorithm:IIR_denominator_coefficients", required = false)
    protected Double[] iirDenominatorCoefficients;


    @JsonProperty(value="ntia-algorithm:frequency_cutoff", required = false)
    protected Double frequencyCutoff;


    @JsonProperty(value="ntia-algorithm:attenuation_cutoff", required = false)
    protected Double attenuationCutoff;


    @JsonProperty(value="ntia-algorithm:ripple_passband", required = false)
    protected Double ripplePassband;


    @JsonProperty(value="ntia-algorithm:attenuation_stopband", required = false)
    protected Double attenuationStopband;


    @JsonProperty(value="ntia-algorithm:frequency_stopband", required = false)
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



}
