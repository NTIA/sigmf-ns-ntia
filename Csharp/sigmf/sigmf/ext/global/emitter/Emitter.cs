using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable()]
    public class Emitter
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
        protected string id;

        [JsonProperty("description", NullValueHandling = NullValueHandling.Ignore)]
        protected string description;

        [JsonProperty("power", NullValueHandling = NullValueHandling.Ignore)]
        protected double power;

        [JsonProperty("antenna", NullValueHandling = NullValueHandling.Ignore)]
        protected Antenna antenna;

        [JsonProperty("transmitter", NullValueHandling = NullValueHandling.Ignore)]
        protected Transmitter transmitter;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();

        public string Id { get => id; set => id = value; }
        public string Description { get => description; set => description = value; }
        public double Power { get => power; set => power = value; }
        public Antenna Antenna { get => antenna; set => antenna = value; }
        public Transmitter Transmitter { get => transmitter; set => transmitter = value; }

        public Dictionary<string, object> getOtherFields() {
            return otherfields;
        }
        public void add(string key, object value) {
            otherfields.Add(key, value);
        }


    }
}