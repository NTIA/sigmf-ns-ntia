using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class AntennaAnnotation : Annotation
    {
        [JsonProperty("ntia-core:antenna_id")]
        protected string id;

        [JsonProperty("ntia-core:azimuth_angle")]
        protected double azimuthAngle;

        [JsonProperty("ntia-core:elevation_angle")]
        protected double elevationAngle;

        public string Id { get => id; set => id = value; }
        public double AzimuthAngle { get => azimuthAngle; set => azimuthAngle = value; }
        public double ElevationAngle { get => elevationAngle; set => elevationAngle = value; }
    }
}
