using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.algorithm
{
    public class DigitalFilterExample : Example
    {
        public override MetaDoc getExample() {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            DigitalFilter digFilter = new DigitalFilter();
            List<double> FIRcoefficients = new List<double> { 1.0, 4.0, 5.0, 3.2 };
            digFilter.FilterType = "FIR";
            digFilter.FirCoefficients = FIRcoefficients;
            digFilter.CutoffFrequency = 7500000d;
            digFilter.FrequencyStopband = 7000000d;
            digFilter.AttenuationStopband = -10d;
            digFilter.RipplePassband = -5d;
            digFilter.CutoffAttenuation = -6d;
            List<Annotation> annotations = new List<Annotation>();
            globals.AntiAliasingFilter = digFilter;
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
