using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable]
    public class Capture
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("core:sample_start")]
        protected long sampleStart;

        [JsonProperty("core:global_index")]
        protected long globalIndex;

        [JsonProperty("core:frequency")]
        protected double frequency;

        [JsonProperty("core:datetime")]
        protected DateTime dateTime;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();

        public long SampleStart { get => sampleStart; set => sampleStart = value; }
        public long GlobalIndex { get => globalIndex; set => globalIndex = value; }
        public double Frequency { get => frequency; set => frequency = value; }
        public DateTime DateTime { get => dateTime; set => dateTime = value; }
        public Dictionary<string, object> Otherfields { get => otherfields; }

        public void add(string key, object value) {
            otherfields.Add(key, value);
        }
    }
}