using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.environment
{
    public class EmitterEnvironmentExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            metaDoc.setGlobal(globals);
            EmitterEnvironment emitterEnvironment = new EmitterEnvironment();
            emitterEnvironment.Emitter_id = "emitter_123";
            emitterEnvironment.SampleCount = 10241;
            emitterEnvironment.SampleStart = 01;
            emitterEnvironment.Category = "outdoor_urban";

            EmitterEnvironment emitterEnvironment2 = new EmitterEnvironment();
            emitterEnvironment2.Emitter_id = "emitter_123";
            emitterEnvironment2.SampleCount = 10241;
            emitterEnvironment2.SampleStart = 10241;
            emitterEnvironment2.Category = "indoor";

            List<Annotation> annotations = new List<Annotation>();
            annotations.Add(emitterEnvironment);
            annotations.Add(emitterEnvironment2);

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
