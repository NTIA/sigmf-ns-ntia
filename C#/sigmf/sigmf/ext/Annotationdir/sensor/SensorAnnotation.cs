using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class SensorAnnotation : Annotation
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-sensor:rf_path_index")]
        protected int rfPathIndex;

        [JsonProperty("ntia-sensor:overload_sensor")]
        protected bool overloadSensor;

        [JsonProperty("ntia-sensor:overload_sigan")]
        protected bool overloadSigan;

        [JsonProperty("ntia-sensor:attenuation_setting_sigan")]
        protected double attenuationSettingSigan;

        [JsonProperty("ntia-sensor:gain_setting_sigan")]
        protected double gainSettingSigan;

        [JsonProperty("ntia-sensor:latitude")]
        protected double sensorLatitude;

        [JsonProperty("ntia-sensor:longitude")]
        protected double sensorLongitude;

        [JsonProperty("ntia-sensor:altitude")]
        protected double altitude;

        [JsonProperty("ntia-sensor:speed")]
        protected double speed;

        [JsonProperty("ntia-sensor:bearing")]
        protected double bearing;

        [JsonProperty("ntia-sensor:gps_nmea")]
        protected string gpsNmea;

        public int RfPathIndex { get => rfPathIndex; set => rfPathIndex = value; }
        public bool OverloadSensor { get => overloadSensor; set => overloadSensor = value; }
        public bool OverloadSigan { get => overloadSigan; set => overloadSigan = value; }
        public double AttenuationSettingSigan { get => attenuationSettingSigan; set => attenuationSettingSigan = value; }
        public double GainSettingSigan { get => gainSettingSigan; set => gainSettingSigan = value; }
        public double SensorLatitude { get => sensorLatitude; set => sensorLatitude = value; }
        public double SensorLongitude { get => sensorLongitude; set => sensorLongitude = value; }
        public double Altitude { get => altitude; set => altitude = value; }
        public double Speed { get => speed; set => speed = value; }
        public double Bearing { get => bearing; set => bearing = value; }
        public string GpsNmea { get => gpsNmea; set => gpsNmea = value; }
    }
}
