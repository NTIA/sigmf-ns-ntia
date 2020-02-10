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

        [JsonProperty("antenna_spec")]
        protected HardwareSpec antennaSpec;

        [JsonProperty("type")]
        protected string type;

        [JsonProperty("low_frequency")]
        protected double lowFrequency;

        [JsonProperty("high_frequency")]
        protected double highFrequency;

        [JsonProperty("gain")]
        protected double gain;

        [JsonProperty("polarization")]
        protected string polarization;

        [JsonProperty("cross_polar_discrimination")]
        protected double crossPolarDiscrimination;

        [JsonProperty("horizontal_gain_pattern")]
        protected List<double> horizontalGainPattern;

        [JsonProperty("vertical_gain_pattern")]
        protected List<double> verticalGainPattern;

        [JsonProperty("horizontal_beam_width")]
        protected double horizontalBeamWidth;

        [JsonProperty("vertical_beam_width")]
        protected double verticalBeamWidth;

        [JsonProperty("voltage_standing_wave_ratio")]
        protected double voltageStandingWaveRatio;

        [JsonProperty("cable_loss")]
        protected double cableLoss;

        [JsonProperty("steerable")]
        protected bool steerable;

        [JsonProperty("azimuth_angle")]
        protected double azimuthAngle;

        [JsonProperty("elevation_angle")]
        protected double elevationAngle;

        [JsonProperty("mobile")]
        protected bool mobile;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();

        public HardwareSpec AntennaSpec { get => antennaSpec; set => antennaSpec = value; }
        public string Type { get => type; set => type = value; }
        public double LowFrequency { get => lowFrequency; set => lowFrequency = value; }
        public double HighFrequency { get => highFrequency; set => highFrequency = value; }
        public double Gain { get => gain; set => gain = value; }
        public string Polarization { get => polarization; set => polarization = value; }
        public double CrossPolarDiscrimination { get => crossPolarDiscrimination; set => crossPolarDiscrimination = value; }
        public List<double> HorizontalGainPattern { get => horizontalGainPattern; set => horizontalGainPattern = value; }
        public List<double> VerticalGainPattern { get => verticalGainPattern; set => verticalGainPattern = value; }
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
