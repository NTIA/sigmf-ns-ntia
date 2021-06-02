using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.callibration
{
    public class CallibrationAnnotationExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = new Globals();
            List<Annotation> annotations = new List<Annotation>();
            CalibrationAnnotation cal = new CalibrationAnnotation();
            cal.GainSigan = 2.0;
            cal.NoiseFigureSigan = 1.0;
            cal.OneDbCompressionPointSigan = 12.0;
            cal.EnbwSigan = 2.0;
            cal.GainPreselector = 6.0;
            cal.NoiseFigureSensor = 5.0;
            cal.OneDbCompressionPointSensor = 20.0;
            cal.EnbwSensor = 3.0;
            cal.MeanNoisePowerSensor = 5.0;
            cal.SampleCount = 1001;
            cal.SampleStart = 01;
            annotations.Add(cal);
            metaDoc.setAnnotations(annotations);
            return metaDoc;
        }
    }
}
