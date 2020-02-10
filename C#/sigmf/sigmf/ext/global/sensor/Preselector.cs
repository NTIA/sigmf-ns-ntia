using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class Preselector
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("preselector_spec")]
        protected HardwareSpec preselectorSpec;

        [JsonProperty("cal_source_spec")]
        protected HardwareSpec calSourceSpec;

        [JsonProperty("lna_spec")]
        protected HardwareSpec lnaSpec;

        [JsonProperty("filter_spec")]
        protected List<HardwareSpec> filterSpec;

        [JsonProperty("rf_paths")]
        protected List<RFPath> rfPaths;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public HardwareSpec PreselectorSpec { get => preselectorSpec; set => preselectorSpec = value; }
        public HardwareSpec CalSourceSpec { get => calSourceSpec; set => calSourceSpec = value; }
        public HardwareSpec LnaSpec { get => lnaSpec; set => lnaSpec = value; }
        public List<HardwareSpec> FilterSpec { get => filterSpec; set => filterSpec = value; }
        public List<RFPath> RfPaths { get => rfPaths; set => rfPaths = value; }

        public Dictionary<string, object> getOtherFields()
        {
            return otherfields;
        }
        public void add(string key, object value)
        {
            otherfields.Add(key, value);
        }
    }
}
