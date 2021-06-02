using Newtonsoft.Json;
using System.Collections.Generic;

namespace sigmf
{
    public class Transmitter
    {
        [JsonProperty("model")]
        protected string model;

        protected Dictionary<string, object> otherfields = new Dictionary<string, object>();

        public string Model { get => model; set => model = value; }

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