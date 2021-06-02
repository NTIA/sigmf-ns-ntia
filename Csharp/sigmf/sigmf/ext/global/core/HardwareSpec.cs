using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    
    [Serializable()]
    public class HardwareSpec
    {
        [JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
        protected string id;

        [JsonProperty("model", NullValueHandling = NullValueHandling.Ignore)]
        protected string model;

        [JsonProperty("version", NullValueHandling = NullValueHandling.Ignore)]
        protected string version;

        [JsonProperty("description", NullValueHandling = NullValueHandling.Ignore)]
        protected string description;

        [JsonProperty("supplemental_information", NullValueHandling = NullValueHandling.Ignore)]
        protected string supplemental_information;

        public string Id { get => id; set => id = value; }
        public string Model { get => model; set => model = value; }
        public string Version { get => version; set => version = value; }
        public string Description { get => description; set => description = value; }
        public string Supplemental_information { get => supplemental_information; set => supplemental_information = value; }
    }
}
