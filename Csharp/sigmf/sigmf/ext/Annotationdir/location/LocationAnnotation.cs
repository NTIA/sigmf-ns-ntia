using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class LocationAnnotation : Annotation
    {
        [JsonProperty("x")]
        protected double x;

        [JsonProperty("y")]
        protected double y;

        [JsonProperty("z")]
        protected double z;

        [JsonProperty("speed")]
        protected double speed;

        [JsonProperty("bearing")]
        protected double bearing;

        public double X { get => x; set => x = value; }
        public double Y { get => y; set => y = value; }
        public double Z { get => z; set => z = value; }
        public double Speed { get => speed; set => speed = value; }
        public double Bearing { get => bearing; set => bearing = value; }
    }
}
