using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Globalization;

namespace sigmf
{
    public class Test
    {
        public static void Main(string[] args)
        {
            MetaDoc metaDoc = getMetaDoc();
            GeographicCoordinateSystem gcs = new GeographicCoordinateSystem();
            gcs.Id = "WGS84";
            metaDoc.getGlobal().CoordinateSystem = gcs;
            using (StreamWriter file = File.CreateText("example.json"))
            {
                JsonSerializer serial = new JsonSerializer();
                serial.Serialize(file, metaDoc);

            }
        }
        private static MetaDoc getMetaDoc()
        {
            MetaDoc metaDoc = new MetaDoc();
            metaDoc.setGlobal(getGlobal());
            metaDoc.setCaptures(getCaptures());
            metaDoc.setAnnotations(GetAnnotations());
            return metaDoc;
        }
        private static List<Capture> getCaptures()
        {
            List<Capture> captures = new List<Capture>();
            Capture capture = new Capture();
            capture.SampleStart = 0;
            capture.DateTime = GetCurrentTime();
            capture.Frequency = 750999999.9999994;
            captures.Add(capture);
            return captures;
        }
        private static Globals getGlobal()
        {
            Globals global = new Globals();
            global.Sensor = GetSensor();
            global.Action = GetAction();
            Random rand = new Random();
            global.TaskId = (long)(rand.Next()*1000000);
            global.Datatype = "rf32_le";
            global.SampleRate = 15360000.011967678;
            long ms = DateTime.Now.Ticks / TimeSpan.TicksPerMillisecond;
            //Do date stuff
            global.TaskId = 11;
            global.AntiAliasingFilter = GetDigitalFilter();
            global.Emitters = GetEmitters();
            global.otherFields.Add("SomeNamespace:SomeExtraField",123.4);
            return global;
        }
        private static DigitalFilter GetDigitalFilter()
        {
            DigitalFilter filter = new DigitalFilter();
            filter.CutoffAttenuation = 1d;
            filter.RipplePassband = 12d;
            filter.AttenuationStopband = 1d;
            filter.FrequencyStopband = 1d;
            filter.CutoffFrequency = 1d;
            filter.FirCoefficients = new List<double> { 12.0 };
            filter.IirDenominatorCoefficients = new List<double> { 12.0 };
            filter.IirNumeratorCoefficients = new List<double> { 12.0 };
            filter.FilterType = "type";
            filter.RipplePassband = 12d;
            return filter;
        }
        private static SignalAnalyzer GetSignalAnalyzer()
        {
            SignalAnalyzer sigan = new SignalAnalyzer();
            sigan.A2dBits = 16;
            sigan.HighFrequency = 700000000d;
            sigan.LowFrequency = 100000000d;
            sigan.NoiseFigure = 20.0;
            sigan.SiganSpec = GetSiganSpec();
            return sigan;
        }
        private static HardwareSpec GetSiganSpec() {
            HardwareSpec siganSpec = new HardwareSpec();
            siganSpec.Id = "875649305NLDKDJN";
            siganSpec.Model = "Etus B210";
            return siganSpec;
        }
        private static Sensor GetSensor()
        {
            Sensor sensor = new Sensor();
            sensor.Id = "GH123";
            sensor.SignalAnalyzer = GetSignalAnalyzer();
            sensor.Antenna = GetAntenna();
            sensor.Mobile = true;
            sensor.Preselector = GetPreselector();
            return sensor;
        }
        private static List<Emitter> GetEmitters()
        {
            List<Emitter> emitters = new List<Emitter>();
            Emitter e1 = new Emitter();
            e1.Description = "Description";
            e1.Antenna = GetAntenna();
            e1.Id = "e1";
            e1.Power = 12.0;
            emitters.Add(e1);
            return emitters;
        }
        private static IEEE80211p GetWaveform()
        {
            IEEE80211p waveform = new IEEE80211p();
            CodingRate codingRate = new CodingRate();
            codingRate.setK(41);
            codingRate.setN(31);
            waveform.CodingRate = codingRate;
            waveform.CyclicPrefix = 31;
            waveform.Encoder = "encoder";
            waveform.InfoBitGeneration = "infoBitGeneration";
            waveform.Modulation = "modulation";
            waveform.NumberOfDataSubcarriers = 41;
            waveform.PacketLength = 41;
            waveform.NumberOfInfoBits = 51;
            waveform.NumberOfPilots = 41;
            waveform.NumberOfSubcarriers = 41;
            waveform.NumberOfPilots = 41;
            waveform.ShortInterFrameSpace = 4d;
            waveform.PreambleFrame = new List<int> { 0, 1 };
            waveform.SignalToNoiseRation = 4d;
            return waveform;
        }
        private static Preselector GetPreselector()
        {
            Preselector preselector = new Preselector();
            List<RFPath> rfPaths = new List<RFPath>();
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
        private static Antenna GetAntenna()
        {
            Antenna antenna = new Antenna();
            HardwareSpec spec = new HardwareSpec();
            spec.Model = "antenna123";
            antenna.AntennaSpec = spec;
            antenna.LowFrequency = 123d;
            antenna.HighFrequency = 123d;
            antenna.Gain = 12d;
            antenna.ElevationAngle = 12d;
            antenna.CrossPolarDiscrimination = 123d;
            antenna.CableLoss = 12d;
            antenna.AzimuthAngle = 12d;
            antenna.Type = "horizontal";
            antenna.HorizontalBeamWidth = 12d;
            antenna.HorizontalGainPattern = new List<double> { 12.0 };
            antenna.VerticalGainPattern = new List<double> { 12.0 };
            antenna.Mobile = true;
            antenna.VerticalBeamWidth = 12d;
            antenna.Polarization = "horizontal";
            antenna.VoltageStandingWaveRatio = 1d;
            antenna.Steerable = true;

            return antenna;
        }
        private static Action GetAction() {
            Action action = new Action();
            Random rand = new Random();
            action.Name = "Action" + (int)(rand.Next() * 10);
            return action;
        }
        private static List<Annotation> GetAnnotations()
        {
            List<Annotation> annotations = new List<Annotation>();
            EmitterAnnotation emitterAnnotation = new EmitterAnnotation();
            emitterAnnotation.Latitude = 45.0;
            emitterAnnotation.Longitude = -105.0;
            emitterAnnotation.SampleStart = 01;
            emitterAnnotation.SampleCount = 20001;
            annotations.Add(emitterAnnotation);

            EmitterAnnotation emitterAnnotation2 = new EmitterAnnotation();
            emitterAnnotation2.Latitude = 44.0;
            emitterAnnotation2.Longitude =  106.0;
            emitterAnnotation2.SampleStart = 10001;
            emitterAnnotation2.SampleCount = 20001;
            annotations.Add(emitterAnnotation2);

            SensorAnnotation sensorAnnotation = new SensorAnnotation();
            sensorAnnotation.GpsNmea = "Poor GPS";
            sensorAnnotation.SampleStart = 10001;
            sensorAnnotation.SampleCount = 20001;

            Annotation calAnnotation = GetCalibrationAnnotation();
            annotations.Add(calAnnotation);
            annotations.Add(sensorAnnotation);


            FrequencyDomainDetection minPower = new FrequencyDomainDetection();
            minPower.Reference = "not referenced";
            minPower.NumberOfSamplesInFft = 1024;
            minPower.Window = "blackman";
            minPower.Units = "dBm";
            minPower.NumberOfFfts = 300;
            minPower.Detector = "max_power";
            minPower.SampleCount = 10241;
            minPower.SampleStart = 10241;

            FrequencyDomainDetection maxPower = new FrequencyDomainDetection();
            maxPower.Reference = "not referenced";
            maxPower.NumberOfSamplesInFft = 1024;
            maxPower.Window = "blackman";
            maxPower.Units = "dBm";
            maxPower.NumberOfFfts = 300;
            maxPower.Detector = "max_power";
            maxPower.SampleCount = 10241;
            maxPower.SampleStart = 10241;

            FrequencyDomainDetection meanPower = new FrequencyDomainDetection();
            meanPower.Reference = "not referenced";
            meanPower.NumberOfSamplesInFft = 1000;
            meanPower.Window = "blackman";
            meanPower.Units = "dBm";
            meanPower.NumberOfFfts = 300;
            meanPower.Detector = "mean_power";
            meanPower.SampleCount = 1024l;
            meanPower.SampleStart = 2048l;

            FrequencyDomainDetection median = new FrequencyDomainDetection();
            median.Reference = "not referenced";
            median.NumberOfSamplesInFft = 1024;
            median.Window = "blackman";
            median.Units = "dBm";
            median.NumberOfFfts = 300;
            median.Detector = "median_power";
            median.SampleCount = 1024l;
            median.SampleStart = 3072l;

            FrequencyDomainDetection sample = new FrequencyDomainDetection();
            sample.Reference = "not referenced";
            sample.NumberOfSamplesInFft = 1024;
            sample.Window = "blackman";
            sample.Units = "dBm";
            sample.NumberOfFfts = 300;
            sample.Detector = "sample_power";
            sample.SampleCount = 10241;
            sample.SampleStart = 4096l;

            annotations.Add(minPower);
            annotations.Add(maxPower);
            annotations.Add(meanPower);
            annotations.Add(median);
            annotations.Add(sample);

            annotations.Sort(new AnnotationComparator<Annotation>());
            List<string> test = new List<string>();

            Console.WriteLine("End of annotations");

            return annotations;


        }
        private static Annotation GetCalibrationAnnotation()
        {
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
            return cal;
        }
        private static DateTime GetCurrentTime()
        {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            var xt = DateTime.Now.ToLocalTime();
            return xt;
        }
        private static void test()
        {
            Console.WriteLine("WhooHoo");
            Console.WriteLine("Insode test");
        }
    }
}
