using Newtonsoft.Json;

namespace sigmf
{
    public class Spheroid
    {
        [JsonProperty("id")]
        protected string id;

        [JsonProperty("description")]
        protected string description;

        [JsonProperty("semiminor")]
        protected double semiminor;

        [JsonProperty("semimajor")]
        protected double semimajor;

        [JsonProperty("flattening")]
        protected double flattening;

        [JsonProperty("angular_unit")]
        protected string angularUnit;

        [JsonProperty("prime_meridian")]
        protected string primeMeridian;

        [JsonProperty("meridian_offset")]
        protected double meridianOffset;

        public string Id { get => id; set => id = value; }
        public string Description { get => description; set => description = value; }
        public double Semiminor { get => semiminor; set => semiminor = value; }
        public double Semimajor { get => semimajor; set => semimajor = value; }
        public double Flattening { get => flattening; set => flattening = value; }
        public string AngularUnit { get => angularUnit; set => angularUnit = value; }
        public string PrimeMeridian { get => primeMeridian; set => primeMeridian = value; }
        public double MeridianOffset { get => meridianOffset; set => meridianOffset = value; }
    }
}