using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class DigitalFilterAnnotation : Annotation
    {
        [JsonProperty("algorithm:filter_type")]
        protected string filterType;

        [JsonProperty("ntia-algorithm:FIR_coefficients")]
        protected List<double> firCoefficients;

        [JsonProperty("ntia-algorithm:IIR_numerator_coefficients")]
        protected List<double> iirNumeratorCoefficients;

        [JsonProperty("ntia-algorithm:IIR_denominator_coefficients")]
        protected List<double> iirDenominatorCoefficients;

        [JsonProperty("ntia-algorithm:frequency_cutoff")]
        protected double frequencyCutoff;

        [JsonProperty("ntia-algorithm:attenuation_cutoff")]
        protected double attenuationCutoff;

        [JsonProperty("ntia-algorithm:ripple_passband")]
        protected double ripplePassband;

        [JsonProperty("ntia-algorithm:attenuation_stopband")]
        protected double attenuationStopband;

        [JsonProperty("ntia-algorithm:frequency_stopband")]
        protected double frequencyStopband;

        public string FilterType { get => filterType; set => filterType = value; }
        public List<double> FirCoefficients { get => firCoefficients; set => firCoefficients = value; }
        public List<double> IirNumeratorCoefficients { get => iirNumeratorCoefficients; set => iirNumeratorCoefficients = value; }
        public List<double> IirDenominatorCoefficients { get => iirDenominatorCoefficients; set => iirDenominatorCoefficients = value; }
        public double FrequencyCutoff { get => frequencyCutoff; set => frequencyCutoff = value; }
        public double AttenuationCutoff { get => attenuationCutoff; set => attenuationCutoff = value; }
        public double RipplePassband { get => ripplePassband; set => ripplePassband = value; }
        public double AttenuationStopband { get => attenuationStopband; set => attenuationStopband = value; }
        public double FrequencyStopband { get => frequencyStopband; set => frequencyStopband = value; }
    }
}
