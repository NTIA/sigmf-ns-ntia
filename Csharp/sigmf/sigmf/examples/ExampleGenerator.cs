using Boxed.Mapping;
using Newtonsoft.Json;
using sigmf.examples.algorithm;
using sigmf.examples.callibration;
using sigmf.examples.core;
using sigmf.examples.emitter;
using sigmf.examples.environment;
using sigmf.examples.location;
using sigmf.examples.waveform;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.Json;

namespace sigmf.examples
{
    public class ExampleGenerator
    {
        public static void Main(String[] args)
        {
            SensorExample sensorExample = new SensorExample();
            save("sensor.json", sensorExample.getExample());

            TimeDomainDetectionExample tddExample = new TimeDomainDetectionExample();
            save("tdd.json", tddExample.getExample());

            DigitalFilterExample digitalFilterExample = new DigitalFilterExample();
            save("digitalFilter.json", digitalFilterExample.getExample());

            FrequencyDomainDetectionExample frequencyDomainDetectionExample = new FrequencyDomainDetectionExample();
            save("frequencyDomainDetection.json", frequencyDomainDetectionExample.getExample());

            DigitalFilterAnnotationExample digitalFilterAnnotationExample = new DigitalFilterAnnotationExample();
            save("digitalFilterAnnotation.json", digitalFilterAnnotationExample.getExample());

            CallibrationAnnotationExample callibrationAnnotationExample = new CallibrationAnnotationExample();
            save("callibration.json", callibrationAnnotationExample.getExample());

            AntennaAnnotationExample cal = new AntennaAnnotationExample();
            save("antennaAnnotation.json", cal.getExample());

            EmitterExample emitterExample = new EmitterExample();
            save("emitterGlobal.json", emitterExample.getExample());

            EmitterAnnotationExample emitterAnnotationExample = new EmitterAnnotationExample();
            save("emitterAnnotation.json", emitterAnnotationExample.getExample());

            SensorEnvironmentExample sensorEnvironmentExample = new SensorEnvironmentExample();
            save("sensorEnviroment.json", sensorEnvironmentExample.getExample());

            EmitterEnvironmentExample emitterEnvironmentExample = new EmitterEnvironmentExample();
            save("emitterEnviroment.json", emitterEnvironmentExample.getExample());

            WaveformExample waveformExample = new WaveformExample();
            save("waveformExample.json", waveformExample.getExample());

            GcsWithSpheroidExample gcsExample = new GcsWithSpheroidExample();
            save("gcsExample.json", gcsExample.getExample());

            ProjectedExample projectedExample = new ProjectedExample();
            save("projectedSpatialRef.json", projectedExample.getExample());

            SpeedAndBearingExample speedAndBearingExample = new SpeedAndBearingExample();
            save("speedAndBearing.json", speedAndBearingExample.getExample());

            SimpleGCS simpleGCS = new SimpleGCS();
            save("simpleGCS.json", simpleGCS.getExample());

        }
        private static void save(string filename, MetaDoc example) {

            File.WriteAllText(filename, JsonConvert.SerializeObject(example));
        }
        public static void generateSensorExamples() {
        }

        public static List<Annotation> getAnnotation() {
            List<Annotation> annotations = new List<Annotation>();
            List<string> names = new List<string>{ "mean","median","min","max","sample"};
            for(long i = 0; i < names.Count; ++i)
            {
                FrequencyDomainDetection annotation = new FrequencyDomainDetection();
                annotation.SampleStart = i * 1024;
                annotation.SampleCount = (long)1024;
                annotation.NumberOfFfts = 300;
                annotation.NumberOfSamplesInFft = 1024;
                annotation.Detector = names.ElementAt((int)i);
                annotation.DetectionDomain = "m4";
                annotation.Units = "DB";
                annotation.Latitude = 40.5;
                annotation.Longitude = -105.2;
                annotations.Add(annotation);
            }
            return annotations;
        }
    }
}
