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

        protected string id;

        protected Globals global;

        protected List<Capture> captures;

        protected List<Annotation> annotations;

        public MetaDoc() {
            global = new Globals();
            captures = new List<Capture>();
            annotations = new List<Annotation>();
        
        }

        public string getId() {
            return id;
        }
        public void setId(String id)
        {
            this.id = id;
        }
        public List<Capture> getCaptures()
        {
            return captures;
        }

        public void setCaptures(List<Capture> captures)
        {
            this.captures = captures;
        }

        public List<Annotation> getAnnotations()
        {
            return annotations;
        }

        public void setAnnotations(List<Annotation> annotations)
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
        public void addAnnotation(Annotation annotation) {
            annotations.Add(annotation);
        }
    }
}
