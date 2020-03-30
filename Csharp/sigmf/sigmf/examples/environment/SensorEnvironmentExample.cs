using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.environment
{
    public class SensorEnvironmentExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            metaDoc.setGlobal(globals);
            SensorEnvironment sensorEnvironment = new SensorEnvironment();
            sensorEnvironment.Category = "indoor";
            sensorEnvironment.SampleStart = 01;
            sensorEnvironment.SampleCount = 10241;

            SensorEnvironment sensorEnvironment2 = new SensorEnvironment();
            sensorEnvironment2.Category = "outdoor";
            sensorEnvironment2.SampleCount = 10241;
            sensorEnvironment2.SampleStart = 10241;

            List<Annotation> annotations = new List<Annotation>();
            annotations.Add(sensorEnvironment);
            annotations.Add(sensorEnvironment2);

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
