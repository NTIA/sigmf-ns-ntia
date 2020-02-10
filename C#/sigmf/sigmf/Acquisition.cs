using AutoMapper;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
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

        //private void readObject(ObjectInputStream ois) {
        //    ois.defaultReadObject();
        //    metaDoc = (MetaDoc)ois.readObject();
        //    List<byte> bytes = (List<byte>)ois.readObject();
            
        //}

        public string toString()
        {
            var acq = JsonConvert.SerializeObject(this);
            return acq;
        }
    }
}
