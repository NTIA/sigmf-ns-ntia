using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class ProjectedCoordnateSystem : CoordinateSystem
    {
        [JsonProperty("false_easting")]
        protected double falseEasting;

        [JsonProperty("false_northing")]
        protected double falseNorthing;

        [JsonProperty("central_meridian")]
        protected double centralMeridian;

        [JsonProperty("scale_factor")]
        protected double scaleFactor;

        [JsonProperty("origin_latitude")]
        protected double originLatitude;

        [JsonProperty("gcs")]
        protected GeographicCoordinateSystem gcs;

        [JsonProperty("projection")]
        protected string projection;

        public double FalseEasting { get => falseEasting; set => falseEasting = value; }
        public double FalseNorthing { get => falseNorthing; set => falseNorthing = value; }
        public double CentralMeridian { get => centralMeridian; set => centralMeridian = value; }
        public double ScaleFactor { get => scaleFactor; set => scaleFactor = value; }
        public double OriginLatitude { get => originLatitude; set => originLatitude = value; }
        public GeographicCoordinateSystem Gcs { get => gcs; set => gcs = value; }
        public string Projection { get => projection; set => projection = value; }
    }
}
