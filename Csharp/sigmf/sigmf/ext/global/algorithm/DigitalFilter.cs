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

        [JsonProperty("filter_type")]
        protected string filterType;

        [JsonProperty("FIR_coefficients")]
        protected List<double> firCoefficients;

        [JsonProperty("IIR_numerator_coefficients")]
        protected List<double> iirNumeratorCoefficients;

        [JsonProperty("IIR_denominator_coefficients")]
        protected List<double> iirDenominatorCoefficients;

        [JsonProperty("cutoff_frequency")]
        protected double cutoffFrequency;

        [JsonProperty("cutoff_attenuation")]
        protected double cutoffAttenuation;

        [JsonProperty("ripple_passband")]
        protected double ripplePassband;

        [JsonProperty("attenuation_stopband")]
        protected double attenuationStopband;

        [JsonProperty("frequency_stopband")]
        protected double frequencyStopband;

        protected Dictionary<String, Object> otherFields = new Dictionary<String, Object>();

        public string FilterType { get => filterType; set => filterType = value; }
        public List<double> FirCoefficients { get => firCoefficients; set => firCoefficients = value; }
        public List<double> IirNumeratorCoefficients { get => iirNumeratorCoefficients; set => iirNumeratorCoefficients = value; }
        public List<double> IirDenominatorCoefficients { get => iirDenominatorCoefficients; set => iirDenominatorCoefficients = value; }
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