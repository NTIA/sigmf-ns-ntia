using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    public class GeographicCoordinateSystem : CoordinateSystem
    {
        [JsonProperty("datum")]
        protected Datum datum;

        public Datum Datum { get => datum; set => datum = value; }
    }
}
