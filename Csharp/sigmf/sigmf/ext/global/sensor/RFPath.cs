using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable()]
    public class RFPath
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("low_frequency_passband_filter")]
        protected double lowFrequencyPassbandFilter;

        [JsonProperty("high_frequency_passband_filter")]
        protected double highFrequencyPassbandFilter;

        [JsonProperty("low_frequency_stopband_filter")]
        protected double lowFrequencyStopbandFilter;

        [JsonProperty("high_frequency_stopband_filter")]
        protected double highFrequencyStopbandFilter;

        [JsonProperty("gain_lna")]
        protected double gainLna;

        [JsonProperty("noise_figure_lna")]
        protected double noiseFigureLna;

        [JsonProperty("type_cal_source")]
        protected string typeCalSource;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public double LowFrequencyPassbandFilter { get => lowFrequencyPassbandFilter; set => lowFrequencyPassbandFilter = value; }
        public double HighFrequencyPassbandFilter { get => highFrequencyPassbandFilter; set => highFrequencyPassbandFilter = value; }
        public double LowFrequencyStopbandFilter { get => lowFrequencyStopbandFilter; set => lowFrequencyStopbandFilter = value; }
        public double HighFrequencyStopbandFilter { get => highFrequencyStopbandFilter; set => highFrequencyStopbandFilter = value; }
        public double GainLna { get => gainLna; set => gainLna = value; }
        public double NoiseFigureLna { get => noiseFigureLna; set => noiseFigureLna = value; }
        public string TypeCalSource { get => typeCalSource; set => typeCalSource = value; }

        public Dictionary<string, object> getOtherFields()
        {
            return otherfields;
        }
        public void add(string key, object value)
        {
            otherfields.Add(key, value);
        }
    }
}