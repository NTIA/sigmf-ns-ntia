using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class EmitterAnnotation : Annotation
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("ntia-emitter:id")]
        protected string id;

        [JsonProperty("ntia-emitter:waveform")]
        protected Waveform waveform;

        [JsonProperty("ntia-emitter:altitude")]
        protected double altitude;

        [JsonProperty("ntia-emitter:speed")]
        protected double speed;

        [JsonProperty("ntia-emitter:bearing")]
        protected double bearing;

        public string Id { get => id; set => id = value; }
        public Waveform Waveform { get => waveform; set => waveform = value; }
        public double Altitude { get => altitude; set => altitude = value; }
        public double Speed { get => speed; set => speed = value; }
        public double Bearing { get => bearing; set => bearing = value; }
    }
}
