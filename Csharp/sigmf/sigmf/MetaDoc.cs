using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Newtonsoft.Json;

namespace sigmf
{
    [Serializable()]
    public class MetaDoc
    {
        private static readonly long serialVersionUID = 1L;

        [JsonProperty("id", Required = Required.Always)]
        protected string id;

        [JsonProperty("global", Required = Required.Always)]
        protected Globals global;

        [JsonProperty("captures", Required = Required.Always)]
        protected Capture[] captures;

        [JsonProperty("annotations", Required = Required.Always)]
        protected Annotation[] annotations;

        public MetaDoc() {
            global = new Globals();
            captures = new Capture[300];
            annotations = new Annotation[300];
        
        }

        public string getId() {
            return id;
        }
        public void setId(String id)
        {
            this.id = id;
        }
        public Capture[] getCaptures()
        {
            return captures;
        }

        public void setCaptures(Capture[] captures)
        {
            this.captures = captures;
        }

        public Annotation[] getAnnotations()
        {
            return annotations;
        }

        public void setAnnotations(Annotation[] annotations)
        {
            this.annotations = annotations;
        }


        public Globals getGlobal()
        {
            return global;
        }

        public void setGlobal(Globals global)
        {
            this.global = global;
        }
        public void saveToFile(string filename)
        {
            File.WriteAllText(filename,JsonConvert.SerializeObject(this));

        }
        public int addAnnotation(Annotation annotation , int index) {
            //annotations.Add(annotation);
            annotations[index] = annotation;
            return index + 1;
        }
    }
}
