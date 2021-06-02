using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace sigmf
{
    [Serializable]
    public class Capture
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("core:sample_start")]
        protected long? sampleStart;

        [JsonProperty("core:global_index")]
        protected long? globalIndex;

        [JsonProperty("core:frequency")]
        protected double? frequency;

        [JsonProperty("core:datetime",NullValueHandling = NullValueHandling.Ignore)]
        protected DateTime? dateTime;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();


        public void add(string key, object value) {
            otherfields.Add(key, value);
        }
    }
}
