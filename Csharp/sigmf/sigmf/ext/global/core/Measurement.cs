using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.ext.global.core
{
    [Serializable()]
    class Measurement
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("domain", Required = Required.Always)]
        protected string domain;

        [JsonProperty("domain", Required = Required.Always)]
        protected string measuremntType;

        [JsonProperty("domain", Required = Required.Always)]
        protected DateTime timeStart;

        [JsonProperty("domain", Required = Required.Always)]
        protected DateTime timeStop;

        [JsonProperty("frequencyTunedLow", NullValueHandling = NullValueHandling.Ignore)]
        protected double frequencyTunedLow;

        [JsonProperty("frequencyTunedHigh", NullValueHandling = NullValueHandling.Ignore)]
        protected double frequencyTunedHigh;

        [JsonProperty("frequencyTunedStep", NullValueHandling = NullValueHandling.Ignore)]
        protected double frequencyTunedStep;

        [JsonProperty("frequencies_tuned", NullValueHandling = NullValueHandling.Ignore)]
        protected double[] frequencies_tuned;

        public string Domain { get => domain; set => domain = value; }
        public string MeasuremntType { get => measuremntType; set => measuremntType = value; }
        public DateTime TimeStart { get => timeStart; set => timeStart = value; }
        public DateTime TimeStop { get => timeStop; set => timeStop = value; }
        public double FrequencyTunedLow { get => frequencyTunedLow; set => frequencyTunedLow = value; }
        public double FrequencyTunedHigh { get => frequencyTunedHigh; set => frequencyTunedHigh = value; }
        public double FrequencyTunedStep { get => frequencyTunedStep; set => frequencyTunedStep = value; }
        public double[] Frequencies_tuned { get => frequencies_tuned; set => frequencies_tuned = value; }
    }
}
