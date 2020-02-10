using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class SensorEnvironment : Environment
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-environment:category")]
        protected string category1;

        public string Category1 { get => category1; set => category1 = value; }
    }
}
