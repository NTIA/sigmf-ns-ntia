using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.core
{
    public class AntennaAnnotationExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            List<Annotation> annotations = new List<Annotation>();
            AntennaAnnotation antennaAnnotation = new AntennaAnnotation();
            antennaAnnotation.Id = "antenna1";
            antennaAnnotation.AzimuthAngle = 15.0;
            antennaAnnotation.ElevationAngle = 20.0;
            antennaAnnotation.SampleCount = 10241;
            antennaAnnotation.SampleStart = 01;

            annotations.Add(antennaAnnotation);
            metaDoc.setAnnotations(annotations);
            return metaDoc;

        }
    }
}
