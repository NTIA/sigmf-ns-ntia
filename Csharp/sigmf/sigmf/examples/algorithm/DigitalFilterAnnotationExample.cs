using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.algorithm
{
    public class DigitalFilterAnnotationExample : Example
    {
        override public MetaDoc getExample() {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            DigitalFilterAnnotation digFilter = new DigitalFilterAnnotation();
            List<double> FIRcoefficients = new List<double> { 1.0, 4.0, 5.0, 3.2 };
            digFilter.SampleCount = 10001;
            digFilter.SampleStart = 01;
            digFilter.FilterType = "FIR";
            digFilter.FirCoefficients = FIRcoefficients;
            digFilter.FrequencyCutoff = 7500000d;
            digFilter.FrequencyStopband = 7000000d;
            digFilter.AttenuationStopband = -10d;
            digFilter.RipplePassband = -5d;
            digFilter.AttenuationCutoff = -6d;
            List<Annotation> annotations = new List<Annotation>();
            annotations.Add(digFilter);
            metaDoc.setGlobal(globals);
            metaDoc.setAnnotations(annotations);
            return metaDoc;

        }
        private DateTime getCurrentTime() {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            return st;
        }
    }
}
