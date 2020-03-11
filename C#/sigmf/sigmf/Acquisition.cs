
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;

namespace sigmf
{
    class Acquisition
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty]
        protected MetaDoc metaDoc;

        [JsonProperty]
        [JsonIgnore]
        protected MemoryStream data;

        public MetaDoc getMetaDoc() {
            return metaDoc;
        }
        public void setMetaDoc(MetaDoc metaDoc)
        {
            this.metaDoc = metaDoc;
        }
        public MemoryStream getData()
        {
            return data;
        }
        public void setData(MemoryStream data)
        {
            this.data = data;
        }

        private MemoryStream writeObject(MetaDoc meta)
        {
            MemoryStream stream = new MemoryStream();
                
            IFormatter formatter = new BinaryFormatter();
            formatter.Serialize(stream, meta);
            return stream;
            
        }
        private MetaDoc readObject(MemoryStream stream)
        {
            IFormatter formatter = new BinaryFormatter();
            stream.Seek(0, SeekOrigin.Begin);
            MetaDoc meta = (MetaDoc)formatter.Deserialize(stream);
            return meta;
        }

        public string toString()
        {
            var acq = JsonConvert.SerializeObject(this);
            return acq;
        }
        public string GetName() {
            string name = getMetaDoc().getGlobal().Sensor.Id + "_" + getScheduleId() + "_" + getTaskId();
            return name;
        }
        public string getActionName()
        {
            Action action = metaDoc.getGlobal().Action;
            if(action == null || action.Name == null)
            {
                return "unknown";
            }
            else
            {
                return action.Name;
            }
        }
        public string getScheduleId()
        {
            ScheduleEntry scheduleEntry = metaDoc.getGlobal().Schedule;
            string missingScheduleInfo = "unknown";
            if(scheduleEntry == null)
            {
                return missingScheduleInfo;
            }
            else if(scheduleEntry.Id == null)
            {
                return missingScheduleInfo;
            }
            else
            {
                return scheduleEntry.Id;
            }
        }
        private string getTaskId()
        {
            string taskId = metaDoc.getGlobal().TaskId.ToString();
            if(taskId == null)
            {
                taskId = "unknown";
            }
            return taskId;
        }

    }
}
