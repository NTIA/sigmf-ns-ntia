using Newtonsoft.Json;

namespace sigmf
{
    public class CoordinateSystem
    {
        [JsonProperty("id")]
        protected string id;

        [JsonProperty("description")]
        protected string description;

        [JsonProperty("distance_unit")]
        protected string distanceUnit;

        [JsonProperty("time_unit")]
        protected string timeUnit;

        [JsonProperty("origin")]
        protected string origin;

        [JsonProperty("orientation_ref")]
        protected string orientationRef;

        [JsonProperty("orientation")]
        protected string orientation;

        [JsonProperty("elevation_ref")]
        protected string elevationRef;

        [JsonProperty("elevation_unit")]
        protected string elevationUnit;

        public string Id { get => id; set => id = value; }
        public string Description { get => description; set => description = value; }
        public string DistanceUnit { get => distanceUnit; set => distanceUnit = value; }
        public string TimeUnit { get => timeUnit; set => timeUnit = value; }
        public string Origin { get => origin; set => origin = value; }
        public string OrientationRef { get => orientationRef; set => orientationRef = value; }
        public string Orientation { get => orientation; set => orientation = value; }
        public string ElevationRef { get => elevationRef; set => elevationRef = value; }
        public string ElevationUnit { get => elevationUnit; set => elevationUnit = value; }
    }
}