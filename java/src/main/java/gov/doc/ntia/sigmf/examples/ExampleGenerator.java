package gov.doc.ntia.sigmf.examples;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.algorithm.DigitalFilterAnnotationExample;
import gov.doc.ntia.sigmf.examples.algorithm.DigitalFilterExample;
import gov.doc.ntia.sigmf.examples.algorithm.FrequencyDomainDetectionExample;
import gov.doc.ntia.sigmf.examples.algorithm.TimeDomainDetectionExample;
import gov.doc.ntia.sigmf.examples.callibration.CallibrationAnnotationExample;
import gov.doc.ntia.sigmf.examples.core.AntennaAnnotationExample;
import gov.doc.ntia.sigmf.examples.emitter.EmitterAnnotationExample;
import gov.doc.ntia.sigmf.examples.emitter.EmitterExample;
import gov.doc.ntia.sigmf.examples.environment.EmitterEnvironmentExample;
import gov.doc.ntia.sigmf.examples.environment.SensorEnvironmentExample;
import gov.doc.ntia.sigmf.examples.location.GcsWithSpheroidExample;
import gov.doc.ntia.sigmf.examples.location.ProjectedExample;
import gov.doc.ntia.sigmf.examples.location.SimpleGCS;
import gov.doc.ntia.sigmf.examples.location.SpeedAndBearingExample;
import gov.doc.ntia.sigmf.examples.waveform.WaveformExample;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExampleGenerator {

    public static void main(String[] args){

        SensorExample sensorExample = new SensorExample();
        save("sensor.json", sensorExample.getExample());

        TimeDomainDetectionExample tddExample = new TimeDomainDetectionExample();
        save("tdd.json", tddExample.getExample());

        DigitalFilterExample digitalFilterExample = new DigitalFilterExample();
        save("digitalFilter.json", digitalFilterExample.getExample());

        FrequencyDomainDetectionExample frequencyDomainDetection = new FrequencyDomainDetectionExample();
        save("frequencyDomainDetection.json", frequencyDomainDetection.getExample());

        DigitalFilterAnnotationExample digitalFilterAnnotationExample = new DigitalFilterAnnotationExample();
        save("digitalFilterAnnotation.json", digitalFilterAnnotationExample.getExample());

        CallibrationAnnotationExample cal = new CallibrationAnnotationExample();
        save("callibration.json", cal.getExample());

        AntennaAnnotationExample antennaAnnotationExample = new AntennaAnnotationExample();
        save("antennaAnnotation.json", antennaAnnotationExample.getExample());

        EmitterExample emitterExample = new EmitterExample();
        save("emitterGlobal.json", emitterExample.getExample());

        EmitterAnnotationExample emitterAnnotationExample = new EmitterAnnotationExample();
        save("emitterAnnotation.json", emitterAnnotationExample.getExample());

        SensorEnvironmentExample sensorEnvironmentExample = new SensorEnvironmentExample();
        save("sensorEnvironment.json", sensorEnvironmentExample.getExample());

        EmitterEnvironmentExample emitterEnvironmentExample = new EmitterEnvironmentExample();
        save("emitterEnvironment.json", emitterEnvironmentExample.getExample());

        WaveformExample waveformExample = new WaveformExample();
        save("waveformExample.json", waveformExample.getExample());

        RadarExample radarExample = new RadarExample();
        save("radarExample.json", radarExample.getExample());

        GcsWithSpheroidExample gcsExample = new GcsWithSpheroidExample();
        save("gcsExample.json", gcsExample.getExample());

        ProjectedExample projectedExample = new ProjectedExample();
        save("projectedSpatialRef.json", projectedExample.getExample());

        SpeedAndBearingExample speedAndBearingExample = new SpeedAndBearingExample();
        save("speedAndBearing.json", speedAndBearingExample.getExample());

        SimpleGCS simpleGCS = new SimpleGCS();
        save("simpleGCS.json", simpleGCS.getExample());

    }

    private static void save(String filename, MetaDoc example) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(filename),example);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void generateSensorExamples(){

    }
    public static List<Annotation> getAnnotations() {
        ArrayList<Annotation> annotations = new ArrayList<>();
        List<String> names = Arrays.asList("mean","median","min","max","sample");
        for(long i = 0; i < names.size(); i++){
            FrequencyDomainDetection annotation = new FrequencyDomainDetection();
            annotation.setSampleStart(i * 1024);
            annotation.setSampleCount((long) 1024);
            annotation.setNumberOfFfts(300);
            annotation.setNumberOfSamplesInFft(1024);
            annotation.setDetector(names.get((int) i));
            annotation.setDetectionDomain("m4");
            annotation.setReference("um, very");
            annotation.setUnits("DB");
            annotation.setLatitude( 40.5);
            annotation.setLongitude(-105.2);
            annotations.add(annotation);
        }
        return annotations;
    }
}
