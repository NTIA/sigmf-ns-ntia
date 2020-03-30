using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class EmitterEnvironment : Environment
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-environment:emitter_id")]
        protected string emitter_id;

        public string Emitter_id { get => emitter_id; set => emitter_id = value; }
    }
}
