using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable()]
    public class DigitalFilter
    {
        private static readonly long serialVersionUID = 1L;

        //not required 

        [JsonProperty("filter_type", NullValueHandling = NullValueHandling.Ignore)]
        protected string filterType;

        [JsonProperty("FIR_coefficients", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] firCoefficients;

        [JsonProperty("IIR_numerator_coefficients", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] iirNumeratorCoefficients;

        [JsonProperty("IIR_denominator_coefficients", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] iirDenominatorCoefficients;

        [JsonProperty("cutoff_frequency", NullValueHandling = NullValueHandling.Ignore)]
        protected double cutoffFrequency;

        [JsonProperty("cutoff_attenuation", NullValueHandling = NullValueHandling.Ignore)]
        protected double cutoffAttenuation;

        [JsonProperty("ripple_passband", NullValueHandling = NullValueHandling.Ignore)]
        protected double ripplePassband;

        [JsonProperty("attenuation_stopband", NullValueHandling = NullValueHandling.Ignore)]
        protected double attenuationStopband;

        [JsonProperty("frequency_stopband", NullValueHandling = NullValueHandling.Ignore)]
        protected double frequencyStopband;

        protected Dictionary<String, Object> otherFields = new Dictionary<String, Object>();

        public string FilterType { get => filterType; set => filterType = value; }
        public double[] FirCoefficients { get => firCoefficients; set => firCoefficients = value; }
        public double[] IirNumeratorCoefficients { get => iirNumeratorCoefficients; set => iirNumeratorCoefficients = value; }
        public double[] IirDenominatorCoefficients { get => iirDenominatorCoefficients; set => iirDenominatorCoefficients = value; }
        public double CutoffFrequency { get => cutoffFrequency; set => cutoffFrequency = value; }
        public double CutoffAttenuation { get => cutoffAttenuation; set => cutoffAttenuation = value; }
        public double RipplePassband { get => ripplePassband; set => ripplePassband = value; }
        public double AttenuationStopband { get => attenuationStopband; set => attenuationStopband = value; }
        public double FrequencyStopband { get => frequencyStopband; set => frequencyStopband = value; }

        public Dictionary<String, Object> getOtherFields() {
            return otherFields;
        }
        public void add(string key, object value) {
            otherFields.Add(key, value); 
        }
    }
}