using Newtonsoft.Json;

namespace sigmf
{
    public class SignalAnalyzer
    {
        [JsonProperty("sigan_spec")]
        protected HardwareSpec siganSpec;

        [JsonProperty("low_frequency")]
        protected double lowFrequency;

        [JsonProperty("high_frequency")]
        protected double highFrequency;

        [JsonProperty("noise_figure")]
        protected double noiseFigure;

        [JsonProperty("max_power")]
        protected double maxPower;

        [JsonProperty("a2d_bits")]
        protected int a2dBits;

        public HardwareSpec SiganSpec { get => siganSpec; set => siganSpec = value; }
        public double LowFrequency { get => lowFrequency; set => lowFrequency = value; }
        public double HighFrequency { get => highFrequency; set => highFrequency = value; }
        public double NoiseFigure { get => noiseFigure; set => noiseFigure = value; }
        public double MaxPower { get => maxPower; set => maxPower = value; }
        public int A2dBits { get => a2dBits; set => a2dBits = value; }
    }
}