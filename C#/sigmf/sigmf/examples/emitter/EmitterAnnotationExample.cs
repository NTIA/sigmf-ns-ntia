using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.emitter
{
    public class EmitterAnnotationExample : Example
    {
        public override MetaDoc getExample() {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            metaDoc.setGlobal(globals);
            List<Annotation> annotations = new List<Annotation>();
            EmitterAnnotation emitterAnnotation = new EmitterAnnotation();
            emitterAnnotation.Id = "emitter_1";
            emitterAnnotation.SampleStart = 01;
            emitterAnnotation.SampleCount = 10241;
            emitterAnnotation.Latitude = 40.5;
            emitterAnnotation.Longitude = -105.7;

            EmitterAnnotation emitterAnnotation2 = new EmitterAnnotation();
            emitterAnnotation2.Id = "emitter_1";
            emitterAnnotation2.SampleStart = 10241;
            emitterAnnotation2.SampleCount = 10241;
            emitterAnnotation2.Latitude = 41.5;
            emitterAnnotation2.Longitude = -105.3;
            annotations.Add(emitterAnnotation);
            annotations.Add(emitterAnnotation2);

            metaDoc.setAnnotations(annotations);
            return metaDoc;
        }
        private DateTime getCurrentTime()
        {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            return st;
        }
    }
}
