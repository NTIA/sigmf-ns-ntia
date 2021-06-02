using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable]
    public class Antenna
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("antenna_spec", Required = Required.Always)]
        protected HardwareSpec antennaSpec;

        [JsonProperty("type", NullValueHandling = NullValueHandling.Ignore)]
        protected string type;

        [JsonProperty("low_frequency", NullValueHandling = NullValueHandling.Ignore)]
        protected double lowFrequency;

        [JsonProperty("high_frequency", NullValueHandling = NullValueHandling.Ignore)]
        protected double highFrequency;

        [JsonProperty("gain", NullValueHandling = NullValueHandling.Ignore)]
        protected double gain;

        [JsonProperty("polarization", NullValueHandling = NullValueHandling.Ignore)]
        protected string polarization;

        [JsonProperty("cross_polar_discrimination", NullValueHandling = NullValueHandling.Ignore)]
        protected double crossPolarDiscrimination;

        [JsonProperty("horizontal_gain_pattern", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] horizontalGainPattern;

        [JsonProperty("vertical_gain_pattern", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] verticalGainPattern;

        [JsonProperty("horizontal_beam_width", NullValueHandling = NullValueHandling.Ignore)]
        protected double horizontalBeamWidth;

        [JsonProperty("vertical_beam_width", NullValueHandling = NullValueHandling.Ignore)]
        protected double verticalBeamWidth;

        [JsonProperty("voltage_standing_wave_ratio", NullValueHandling = NullValueHandling.Ignore)]
        protected double voltageStandingWaveRatio;

        [JsonProperty("cable_loss", NullValueHandling = NullValueHandling.Ignore)]
        protected double cableLoss;

        [JsonProperty("steerable", NullValueHandling = NullValueHandling.Ignore)]
        protected bool steerable;

        [JsonProperty("azimuth_angle", NullValueHandling = NullValueHandling.Ignore)]
        protected double azimuthAngle;

        [JsonProperty("elevation_angle", NullValueHandling = NullValueHandling.Ignore)]
        protected double elevationAngle;

        [JsonProperty("mobile", NullValueHandling = NullValueHandling.Ignore)]
        protected bool mobile;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();

        public HardwareSpec AntennaSpec { get => antennaSpec; set => antennaSpec = value; }
        public string Type { get => type; set => type = value; }
        public double LowFrequency { get => lowFrequency; set => lowFrequency = value; }
        public double HighFrequency { get => highFrequency; set => highFrequency = value; }
        public double Gain { get => gain; set => gain = value; }
        public string Polarization { get => polarization; set => polarization = value; }
        public double CrossPolarDiscrimination { get => crossPolarDiscrimination; set => crossPolarDiscrimination = value; }
        public double[] HorizontalGainPattern { get => horizontalGainPattern; set => horizontalGainPattern = value; }
        public double[] VerticalGainPattern { get => verticalGainPattern; set => verticalGainPattern = value; }
        public double HorizontalBeamWidth { get => horizontalBeamWidth; set => horizontalBeamWidth = value; }
        public double VerticalBeamWidth { get => verticalBeamWidth; set => verticalBeamWidth = value; }
        public double VoltageStandingWaveRatio { get => voltageStandingWaveRatio; set => voltageStandingWaveRatio = value; }
        public double CableLoss { get => cableLoss; set => cableLoss = value; }
        public bool Steerable { get => steerable; set => steerable = value; }
        public double AzimuthAngle { get => azimuthAngle; set => azimuthAngle = value; }
        public double ElevationAngle { get => elevationAngle; set => elevationAngle = value; }
        public bool Mobile { get => mobile; set => mobile = value; }

        public Dictionary<string, object> getOtherFields() {
            return otherfields;
        }
        public void add(string key, object value) {
            otherfields.Add(key, value);
        }
    }
}
