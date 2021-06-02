using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class CalibrationAnnotation : Annotation
    {
        [JsonProperty("ntia-sensor:gain_sigan")]
        protected double gainSigan;

        [JsonProperty("ntia-sensor:noise_figure_sigan")]
        protected double noiseFigureSigan;

        [JsonProperty("ntia-sensor:ldb_compression_point_sigan")]
        protected double oneDbCompressionPointSigan;

        [JsonProperty("ntia-sensor:enbw_sigan")]
        protected double enbwSigan;

        [JsonProperty("ntia-sensor:gain_preselector")]
        protected double gainPreselector;

        [JsonProperty("ntia-sensor:noise_figure_sensor")]
        protected double noiseFigureSensor;

        [JsonProperty("ntia-sensor:1db_compression_point_sensor")]
        protected double oneDbCompressionPointSensor;

        [JsonProperty("ntia-sensor:enbw_sensor")]
        protected double enbwSensor;

        [JsonProperty("ntia-sensor:mean_noise_power_sensor")]
        protected double meanNoisePowerSensor;

        public double GainSigan { get => gainSigan; set => gainSigan = value; }
        public double NoiseFigureSigan { get => noiseFigureSigan; set => noiseFigureSigan = value; }
        public double OneDbCompressionPointSigan { get => oneDbCompressionPointSigan; set => oneDbCompressionPointSigan = value; }
        public double EnbwSigan { get => enbwSigan; set => enbwSigan = value; }
        public double GainPreselector { get => gainPreselector; set => gainPreselector = value; }
        public double NoiseFigureSensor { get => noiseFigureSensor; set => noiseFigureSensor = value; }
        public double OneDbCompressionPointSensor { get => oneDbCompressionPointSensor; set => oneDbCompressionPointSensor = value; }
        public double EnbwSensor { get => enbwSensor; set => enbwSensor = value; }
        public double MeanNoisePowerSensor { get => meanNoisePowerSensor; set => meanNoisePowerSensor = value; }
    }
}
