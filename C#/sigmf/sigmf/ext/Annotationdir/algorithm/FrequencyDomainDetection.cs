using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class FrequencyDomainDetection : DomainDetection
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-algorithm:number_of_ffts")]
        protected int numberOfFfts;

        [JsonProperty("ntia-algorithm:number_of_samples_in_fft")]
        protected int numberOfSamplesInFft;

        [JsonProperty("ntia-algorithm:window")]
        protected string window;

        [JsonProperty("ntia-algorithm:equivalent_noise_bandwidth")]
        protected double equivalentNoiseBandwidth;

        public int NumberOfFfts { get => numberOfFfts; set => numberOfFfts = value; }
        public int NumberOfSamplesInFft { get => numberOfSamplesInFft; set => numberOfSamplesInFft = value; }
        public string Window { get => window; set => window = value; }
        public double EquivalentNoiseBandwidth { get => equivalentNoiseBandwidth; set => equivalentNoiseBandwidth = value; }

        public FrequencyDomainDetection()
        {
            this.detectionDomain = "frequency";
        }
    }
}
