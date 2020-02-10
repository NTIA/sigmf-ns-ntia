using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples
{
    public class SensorExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            Sensor sensor = getSensor();
            metaDoc.setGlobal(globals);
            metaDoc.setAnnotations(GetAnnotations());
            return metaDoc;
        }
        private DateTime getCurrentTime()
        {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            return st;
        }
        private Sensor getSensor()
        {
            Sensor sensor = new Sensor();
            sensor.Id = "Greyhoud_1";
            sensor.Antenna = GetAntenna();
            sensor.SignalAnalyzer = GetSignalAnalyzer();
            sensor.Preselector = GetPreselector();
            return sensor;

        }
        private Preselector GetPreselector()
        {
            Preselector preselector = new Preselector();
            List<RFPath> rfPaths = new List<RFPath>(1);
            RFPath rfPath = new RFPath();
            rfPath.TypeCalSource = "calibrated noise source";
            rfPath.HighFrequencyPassbandFilter = 750000000d;
            rfPath.HighFrequencyStopbandFilter = 750000000d;
            rfPath.NoiseFigureLna = 2.5;
            rfPath.LowFrequencyPassbandFilter = 700000000d;
            rfPath.LowFrequencyStopbandFilter = 700000000d;
            rfPaths.Add(rfPath);
            preselector.RfPaths = rfPaths;
            return preselector;

        }
        private SignalAnalyzer GetSignalAnalyzer() {
            SignalAnalyzer sigan = new SignalAnalyzer();
            sigan.A2dBits = 16;
            sigan.HighFrequency = 700000000d;
            sigan.LowFrequency = 100000000d;
            sigan.NoiseFigure = 20.0;
            sigan.SiganSpec = getSiganSpec();
            return sigan;
        }
        private HardwareSpec getSiganSpec() {
            HardwareSpec siganSpec = new HardwareSpec();
            siganSpec.Id = "875649305NLDKDJN";
            siganSpec.Model = "Etus B210";
            return siganSpec;
        }
        private Antenna GetAntenna() {
            Antenna antenna = new Antenna();
            HardwareSpec spec = new HardwareSpec();
            spec.Model = "antenna123";
            spec.Id = "123-xyxpdq";
            antenna.AntennaSpec = spec;
            antenna.Type = "omnidirectional";
            antenna.AzimuthAngle = 45.0;
            antenna.CableLoss = 1.0;
            antenna.CrossPolarDiscrimination = 9.1;
            antenna.ElevationAngle = 10.3;
            antenna.Gain = 2.0;
            antenna.HighFrequency = 3000000000d;
            antenna.LowFrequency = 300000000d;
            return antenna;
        }
        private List<Annotation> GetAnnotations() {
            SensorAnnotation annotation = new SensorAnnotation();
            annotation.SampleStart = 01;
            annotation.SampleCount = 1001;
            annotation.Latitude = 40.5;
            annotation.Longitude = -105.0;
            SensorAnnotation annotation2 = new SensorAnnotation();
            annotation2.SampleStart = 1001;
            annotation2.SampleCount = 1001;
            annotation2.Latitude = 40.56;
            annotation2.Longitude = -105.03;
            List<Annotation> annotations = new List<Annotation>();
            annotations.Add(annotation);
            annotations.Add(annotation2);
            return annotations;
        }
    }
}
