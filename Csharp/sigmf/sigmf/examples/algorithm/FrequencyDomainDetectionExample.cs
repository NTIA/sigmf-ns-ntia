using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.algorithm
{
    public class FrequencyDomainDetectionExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            List<Annotation> annotations = new List<Annotation>();
            FrequencyDomainDetection fdd = new FrequencyDomainDetection();
            fdd.NumberOfSamplesInFft = 1024;
            fdd.SampleStart = 01;
            fdd.Detector = "fft_mean_power";
            fdd.DetectionDomain = "frequency";
            fdd.SampleCount = 10241;
            fdd.Reference = "antenna output";
            annotations.Add(fdd);

            FrequencyDomainDetection fdd2 = new FrequencyDomainDetection();
            fdd2.NumberOfSamplesInFft = 1024;
            fdd2.SampleStart = 10241;
            fdd2.Detector = "fft_max_power";
            fdd2.DetectionDomain = "frequency";
            fdd2.SampleCount = 10241;
            fdd2.Reference = "antenna output";
            annotations.Add(fdd2);
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
