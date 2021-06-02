using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class Action
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("name")]
        protected string name;

        [JsonProperty("description")]
        protected string description;

        [JsonProperty("type")]
        protected string[] type;

        [JsonProperty("type")]
        protected DateTime endTime;

        [JsonProperty("type")]
        protected DateTime startTime;

        [JsonProperty("type")]
        protected string model;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public string Name { get => name; set => name = value; }
        public string Description { get => description; set => description = value; }
        public string[] Type { get => type; set => type = value; }
        public DateTime EndTime { get => endTime; set => endTime = value; }
        public DateTime StartTime { get => startTime; set => startTime = value; }
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
