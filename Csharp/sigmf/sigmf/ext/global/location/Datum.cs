using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class Datum
    {
        [JsonProperty("id")]
        protected string id;

        [JsonProperty("description")]
        protected string description;

        [JsonProperty("spheroid")]
        protected Spheroid spheroid;

        public string Id { get => id; set => id = value; }
        public string Description { get => description; set => description = value; }
        public Spheroid Spheroid { get => spheroid; set => spheroid = value; }
    }
}
