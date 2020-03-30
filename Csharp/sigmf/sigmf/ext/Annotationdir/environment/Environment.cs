using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class Environment : Annotation
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-environment:temperature")]
        protected double temperature;

        [JsonProperty("ntia-environment:humidity")]
        protected double humidity;

        [JsonProperty("ntia-environment:weather")]
        protected string weather;

        [JsonProperty("ntia-environment:category")]
        protected string category;

        public double Temperature { get => temperature; set => temperature = value; }
        public double Humidity { get => humidity; set => humidity = value; }
        public string Weather { get => weather; set => weather = value; }
        public string Category { get => category; set => category = value; }
    }
}
