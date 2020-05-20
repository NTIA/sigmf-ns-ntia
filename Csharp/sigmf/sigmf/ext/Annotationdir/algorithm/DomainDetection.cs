using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class DomainDetection : Annotation
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-algorithm:detector", Required = Required.Always)]
        protected string detector;

        [JsonProperty("ntia-algorithm:detection_domain", Required = Required.Always)]
        protected string detectionDomain;

        [JsonProperty("ntia-algorithm:units", Required = Required.Always)]
        protected string units;

        [JsonProperty("ntia-algorithm:reference", Required = Required.Always)]
        protected string reference;

        public string Detector { get => detector; set => detector = value; }
        public string DetectionDomain { get => detectionDomain; set => detectionDomain = value; }
        public string Units { get => units; set => units = value; }
        public string Reference { get => reference; set => reference = value; }
    }
}
