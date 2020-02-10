using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable]
    public class Annotation
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("core:sample_start")]
        protected long sampleStart;

        [JsonProperty("core:sample_count")]
        protected long sampleCount;

        [JsonProperty("core:generator")]
        protected String generator;

        [JsonProperty("core:comment")]
        protected String comment;

        [JsonProperty("core:freq_lower_edge")]
        protected Double freqLowerEdge;

        [JsonProperty("core:freq_upper_edge")]
        protected Double freqUpperEdge;

        [JsonProperty("core:latitude")]
        protected Double latitude;

        [JsonProperty("core:longitude")]
        protected Double longitude;

        protected Dictionary<string, object> otherfields = new Dictionary<string,object>();

        public long SampleStart { get => sampleStart; set => sampleStart = value; }
        public long SampleCount { get => sampleCount; set => sampleCount = value; }
        public string Generator { get => generator; set => generator = value; }
        public string Comment { get => comment; set => comment = value; }
        public double FreqLowerEdge { get => freqLowerEdge; set => freqLowerEdge = value; }
        public double FreqUpperEdge { get => freqUpperEdge; set => freqUpperEdge = value; }
        public double Latitude { get => latitude; set => latitude = value; }
        public double Longitude { get => longitude; set => longitude = value; }

        public Dictionary<string, object> getOtherFields() {
            return otherfields;
        }
        public void add(string key, object value) {
            otherfields.Add(key, value);
        }
    }
}