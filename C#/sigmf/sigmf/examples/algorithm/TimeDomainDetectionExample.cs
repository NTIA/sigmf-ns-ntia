using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.algorithm
{
    public class TimeDomainDetectionExample : Example
    {
        public override MetaDoc getExample() {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            List<Annotation> annotations = new List<Annotation>();

            TimeDomainDetection tdd = new TimeDomainDetection();
            tdd.NumberOfSamples = 10241;
            tdd.SampleStart = 01;
            tdd.Detector = "mean";
            tdd.DetectionDomain = "time";
            tdd.SampleCount = 10241;
            tdd.Units = "dBm";
            tdd.Reference = "antenna output";
            annotations.Add(tdd);
            metaDoc.setGlobal(globals);
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
