using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable()]
    public class Sensor
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("id")]
        protected string id;

        [JsonProperty("sensor_spec")]
        protected HardwareSpec sensorSpec;

        [JsonProperty("antenna")]
        protected Antenna antenna;

        [JsonProperty("preselector")]
        protected Preselector preselector;

        [JsonProperty("signal_analyzer")]
        protected SignalAnalyzer signalAnalyzer;

        [JsonProperty("computer_spec")]
        protected HardwareSpec computerSpec;

        [JsonProperty("mobile")]
        protected bool mobile;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public string Id { get => id; set => id = value; }
        public HardwareSpec SensorSpec { get => sensorSpec; set => sensorSpec = value; }
        public Antenna Antenna { get => antenna; set => antenna = value; }
        public Preselector Preselector { get => preselector; set => preselector = value; }
        public SignalAnalyzer SignalAnalyzer { get => signalAnalyzer; set => signalAnalyzer = value; }
        public HardwareSpec ComputerSpec { get => computerSpec; set => computerSpec = value; }
        public bool Mobile { get => mobile; set => mobile = value; }

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