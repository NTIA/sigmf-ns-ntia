using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class TimeDomainDetection : DomainDetection
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-algorithm:number_of_samples")]
        protected long numberOfSamples;

        public long NumberOfSamples { get => numberOfSamples; set => numberOfSamples = value; }

        public TimeDomainDetection() {
            this.detectionDomain = "time";
        }
    }
}
