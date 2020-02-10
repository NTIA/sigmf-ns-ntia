using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text.Json;
namespace sigmf

{
    [Serializable]
    public class Globals
    {
        private static readonly long serialVersionUID = 1L;
        [JsonProperty("core:datatype")]
        protected String datatype;

        [JsonProperty("core:sample_rate")]
        protected Double sampleRate;

        [JsonProperty("core:version")]
        protected string version;

        [JsonProperty("core:sha512")]
        protected string sha512;

        [JsonProperty("core:offset")]
        protected long offset;

        [JsonProperty("core:description")]
        protected string description;

        [JsonProperty("core:author")]
        protected string author;

        [JsonProperty("core:meta_doi")]
        protected string metaDoi;

        [JsonProperty("core:data_doi")]
        protected string dataDoi;

        [JsonProperty("core:recorder")]
        protected string recorder;

        [JsonProperty("core:license")]
        protected string license;

        [JsonProperty("core:hw")]
        protected string hw;

        [JsonProperty("core:extensions")]
        protected Extensions extensions;

        [JsonProperty("ntia-sensor:sensor")]
        protected Sensor sensor;

        [JsonProperty("ntia-emitter:emitters")]
        protected List<Emitter> emitters;

        [JsonProperty("ntia-scos:action")]
        protected Action action;

        [JsonProperty("ntia-scos:schedule")]
        protected ScheduleEntry schedule;

        [JsonProperty("ntia-scos:task_id")]
        protected long taskId;

        [JsonProperty("ntia-location:coordinate_system")]
        protected CoordinateSystem coordinateSystem;

        public Dictionary<String, Object> otherFields = new Dictionary<String, Object>();

        [JsonProperty("ntia-algorithm:anti_aliasing_filter")]
        protected DigitalFilter antiAliasingFilter;

        [JsonProperty("ntia-sensor:calibration_datetime")]
        protected DateTime calibrationDate;

        public string Datatype { get => datatype; set => datatype = value; }
        public double SampleRate { get => sampleRate; set => sampleRate = value; }
        public string Version { get => version; set => version = value; }
        public string Sha512 { get => sha512; set => sha512 = value; }
        public long Offset { get => offset; set => offset = value; }
        public string Description { get => description; set => description = value; }
        public string MetaDoi { get => metaDoi; set => metaDoi = value; }
        public string DataDoi { get => dataDoi; set => dataDoi = value; }
        public string Recorder { get => recorder; set => recorder = value; }
        public string License { get => license; set => license = value; }
        public string Hw { get => hw; set => hw = value; }
        public Extensions Extensions { get => extensions; set => extensions = value; }
        public Sensor Sensor { get => sensor; set => sensor = value; }
        public List<Emitter> Emitters { get => emitters; set => emitters = value; }
        public Action Action { get => action; set => action = value; }
        public ScheduleEntry Schedule { get => schedule; set => schedule = value; }
        public long TaskId { get => taskId; set => taskId = value; }
        public CoordinateSystem CoordinateSystem { get => coordinateSystem; set => coordinateSystem = value; }
        public DigitalFilter AntiAliasingFilter { get => antiAliasingFilter; set => antiAliasingFilter = value; }
        public DateTime CalibrationDate { get => calibrationDate; set => calibrationDate = value; }
    }

}
