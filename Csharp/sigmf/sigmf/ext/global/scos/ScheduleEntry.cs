using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace sigmf
{
    [Serializable()]
    public class ScheduleEntry
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("id")]
        protected string id;

        [JsonProperty("action")]
        protected string action;

        [JsonProperty("relative_stop")]
        protected int relativeStop;

        [JsonProperty("absolute_stop")]
        protected DateTime absoluteStop;

        [JsonProperty("interval")]
        protected int interval;

        [JsonProperty("priority")]
        protected int priority;

        [JsonProperty("callback_url")]
        protected string callbackURL;

        [JsonProperty("start_time")]
        protected DateTime startTime;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public string Id { get => id; set => id = value; }
        public string Action { get => action; set => action = value; }
        public int RelativeStop { get => relativeStop; set => relativeStop = value; }
        public DateTime AbsoluteStop { get => absoluteStop; set => absoluteStop = value; }
        public int Interval { get => interval; set => interval = value; }
        public int Priority { get => priority; set => priority = value; }
        public string CallbackURL { get => callbackURL; set => callbackURL = value; }
        public DateTime StartTime { get => startTime; set => startTime = value; }

        public Dictionary<string, object> getOtherFields()
        {
            return otherfields;
        }
        public void add(string key, object value)
        {
            otherfields.Add(key, value);
        }

        public string getScheduleName() {
            string scheduleName = "";
            if (id != null) {
                if (id.EndsWith("/")) {
                    scheduleName = id.Substring(0, id.Length - 1);
                }
                int index = scheduleName.LastIndexOf("/");
                scheduleName = scheduleName.Substring(index + 1);
            }
            return scheduleName;
        }



    }
}