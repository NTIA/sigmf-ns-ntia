package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.callibration.CalibrationAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.callibration.SystemNoise;
import gov.doc.ntia.sigmf.ext.annotation.emitter.EmitterAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.global.scos.Action;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.sensor.Preselector;
import gov.doc.ntia.sigmf.ext.global.sensor.RFPath;
import gov.doc.ntia.sigmf.ext.global.sensor.Receiver;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;
import gov.doc.ntia.sigmf.ext.global.waveform.CodingRate;
import gov.doc.ntia.sigmf.ext.global.waveform.IEEE80211p;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;
import gov.doc.ntia.sigmf.util.AnnotationComparator;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args){

        MetaDoc metaDoc =  getMetaDoc();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("example.json"),metaDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(new File("example.json"), MetaDoc.class);
            System.out.println(readMetaDoc.getGlobal().getSensor().getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static MetaDoc getMetaDoc() {
        MetaDoc metaDoc = new MetaDoc();
        metaDoc.setGlobal(getGlobal());
        metaDoc.setCaptures(getCaptures());
        metaDoc.setAnnotations(getAnnotations());
        return metaDoc;
    }

    private static List<Capture> getCaptures() {
        ArrayList<Capture> captures = new ArrayList<>();
        int sampleStart=0;
        Capture capture = new Capture();
        /*
         "core:sample_start": 0,
            "core:time": "2018-04-10T14:55:37.118672Z",
            "core:frequency": 750999999.9999994
         */
        capture.setSampleStart(0);
        capture.setDateTime(Calendar.getInstance().getTime());
        capture.setFrequency(750999999.9999994);
        captures.add(capture);
        return captures;
    }

    private static Global getGlobal() {
        Global global = new Global();
        global.setSensor(getSensor());
        global.setAction(getAction());
        global.setTaskId((long)(Math.random() *1000000));
        global.setDatatype("rf32_le");
        global.setSampleRate(15360000.011967678);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis() - (int)( Math.random()* 1000000));
        c.setTimeInMillis(c.getTimeInMillis() + (int)(Math.random() * 10000000));
        global.setTaskId(1l);
        global.setAntiAliasingFilter(getDigitalFilter());
        global.setEmitters(getEmitters());
        global.add("SomeNamespace:SomeExtraField", 123.4);
        return global;
    }

    private static DigitalFilter getDigitalFilter() {
        DigitalFilter filter = new DigitalFilter();
        filter.setCutoffAttenuation(1d);
        filter.setRipplePassband(12d);
        filter.setAttenuationStopband(1d);
        filter.setFrequencyStopband(1d);
        filter.setCutoffFrequency(1d);
        filter.setFirCoefficients(new Double[]{12.0});
        filter.setIirDenominatorCoefficients(new Double[]{12.0});
        filter.setIirNumeratorCoefficients(new Double[]{12.0});
        filter.setFilterType("type");
        filter.setRipplePassband(12d);
        return filter;
    }

    private static Sensor getSensor() {
        Sensor sensor = new Sensor();
        sensor.setId("GH123");
        sensor.setSpeed(124.0);
        sensor.setAltitude(12d);
        sensor.setBearing(12d);
        sensor.setLatitude(12d);
        sensor.setLongitude(180d);
        sensor.setHostController("host controller");
        sensor.setAntenna(getAntenna());
        sensor.setReceiver(getReceiver());
        sensor.setGpsNmea("gps fix");
        sensor.setMobile(true);
        sensor.setPreselector(getPreselector());
        return sensor;
    }

    private static List<Emitter> getEmitters(){
        ArrayList<Emitter> emitters = new ArrayList<>();
        Emitter e1 = new Emitter();
        e1.setDescription("Description");
        e1.setAntenna(getAntenna());
        e1.setId("e1");
        e1.setPower(12.0);
        e1.setWaveform(getWaveform());
        emitters.add(e1);
        return emitters;
    }

    private static Waveform getWaveform() {
        IEEE80211p waveform = new IEEE80211p();
        CodingRate codingRate = new CodingRate();
        codingRate.setK(4l);
        codingRate.setN(3l);
        waveform.setCodingRate(codingRate);
        waveform.setCyclicPrefix(3l);
        waveform.setEncoder("encoder");
        waveform.setInfoBitGeneration("infoBitGeneration");
        waveform.setModulation("modulation");
        waveform.setNumberOfDataSubcarriers(4l);
        waveform.setPacketLength(4l);
        waveform.setNumberOfInfoBits(5l);
        waveform.setNumberOfSubcarriers(4l);
        waveform.setNumberOfPilots(4l);
        waveform.setShortInterFrameSpace(4d);
        waveform.setPreambleFrame(new Integer[]{0,1});
        waveform.setSignalToNoiseRation(4d);
        return waveform;
    }

    private static Preselector getPreselector() {
        Preselector preselector = new Preselector();
        RFPath[] rfPaths = new RFPath[1];
        RFPath rfPath = new RFPath();
        rfPath.setCalSourceType("calibrated noise source");
        rfPath.setHighFrequencyPassband(750000000d);
        rfPath.setHighFrequencyStopband(750000000d);
        rfPath.setLnaNoiseFigure(2.5);
        rfPath.setLowFrequencyPassband(700000000d);
        rfPath.setLowFrequencyStopband(700000000d);
        rfPaths[0] = rfPath;
        preselector.setRfPaths(rfPaths);
        return preselector;
    }
    private static Receiver getReceiver() {
        Receiver r = new Receiver();
        r.setModel("Model " + Math.random()*100);
        r.setLowFrequency(12d);
        r.setHighFrequency(1d);
        r.setNoiseFigure(12d);
        r.setMaxPower(12d);
        r.setA2dBits(123l);
        return r;
    }

    private static Antenna getAntenna() {
        Antenna antenna = new Antenna();
        antenna.setModel("Model " + Math.random()*100);
        antenna.setId("antenna123");
        antenna.setLowFrequency(123d);
        antenna.setHighFrequency(123d);
        antenna.setGain(12d);
        antenna.setElevationAngle(12d);
        antenna.setCrossPolarDiscrimination(123d);
        antenna.setCableLoss(12d);
        antenna.setAzimuthAngle(12d);
        antenna.setType("horizontal");
        antenna.setHorizontalBeamWidth(12d);
        antenna.setHorizontalGainPattern(new Double[]{12.0});
        antenna.setVerticalGainPattern(new Double[]{12.0});
        antenna.setMobile(true);
        antenna.setVerticalBeamWidth(12d);
        antenna.setPolarization("horizontal");
        antenna.setVoltageStandingWaveRatio(1d);
        antenna.setSteerable(true);


        return antenna;
    }


    private static Action getAction(){
        Action action = new Action();
        action.setName("Action" + (int)(Math.random()*10));
        return action;
    }

    private static List<Annotation> getAnnotations(){
        List<Annotation> annotations = new ArrayList<>();
        EmitterAnnotation emitterAnnotation = new EmitterAnnotation();
        emitterAnnotation.setLatitude(45.0);
        emitterAnnotation.setLongitude(-105.0);
        emitterAnnotation.setSampleStart(0l);
        emitterAnnotation.setSampleCount(1000l);
        annotations.add(emitterAnnotation);

        EmitterAnnotation emitterAnnotation2 = new EmitterAnnotation();
        emitterAnnotation2.setLatitude(44.0);
        emitterAnnotation2.setLongitude(-106.0);
        emitterAnnotation2.setSampleStart(1000l);
        emitterAnnotation2.setSampleCount(2000l);
        annotations.add(emitterAnnotation2);

        SensorAnnotation sensorAnnotation = new SensorAnnotation();
        sensorAnnotation.setGpsNmea("Poor GPS");
        sensorAnnotation.setSampleStart(1000l);
        sensorAnnotation.setSampleCount(2000l);

        Annotation calAnnotation = getCalibrationAnnotation();
        annotations.add(calAnnotation);
        annotations.add(sensorAnnotation);

        /*
        "single_frequency_fft_detection": {
                    "reference": "not referenced",
                    "equivalent_noise_bandwidth": 1.728445304482169,
                    "number_of_samples_in_fft": 1024,
                    "window": "blackman",
                    "units": "dBm",
                    "number_of_ffts": 300,
                    "detector": "min_power"
                }
         */
        FrequencyDomainDetection minPower = new FrequencyDomainDetection();
        minPower.setReference("not referenced");
        minPower.setNumberOfSamplesInFft(1024);
        minPower.setWindow("blackman");
        minPower.setUnits("dBm");
        minPower.setNumberOfFfts(300);
        minPower.setDetector("min_power");
        minPower.setSampleCount(1024l);
        minPower.setSampleStart(0l);

        FrequencyDomainDetection maxPower = new FrequencyDomainDetection();
        maxPower.setReference("not referenced");
        maxPower.setNumberOfSamplesInFft(1024);
        maxPower.setWindow("blackman");
        maxPower.setUnits("dBm");
        maxPower.setNumberOfFfts(300);
        maxPower.setDetector("max_power");
        maxPower.setSampleCount(1024l);
        maxPower.setSampleStart(1024l);

        FrequencyDomainDetection meanPower = new FrequencyDomainDetection();
        meanPower.setReference("not referenced");
        meanPower.setNumberOfSamplesInFft(1000);
        meanPower.setWindow("blackman");
        meanPower.setUnits("dBm");
        meanPower.setNumberOfFfts(300);
        meanPower.setDetector("mean_power");
        meanPower.setSampleCount(1024l);
        meanPower.setSampleStart(2048l);

        FrequencyDomainDetection median = new FrequencyDomainDetection();
        median.setReference("not referenced");
        median.setNumberOfSamplesInFft(1024);
        median.setWindow("blackman");
        median.setUnits("dBm");
        median.setNumberOfFfts(300);
        median.setDetector("median_power");
        median.setSampleCount(1024l);
        median.setSampleStart(3072l);

        FrequencyDomainDetection sample = new FrequencyDomainDetection();
        sample.setReference("not referenced");
        sample.setNumberOfSamplesInFft(1024);
        sample.setWindow("blackman");
        sample.setUnits("dBm");
        sample.setNumberOfFfts(300);
        sample.setDetector("sample_power");
        sample.setSampleCount(1024l);
        sample.setSampleStart(4096l);

        annotations.add(minPower);
        annotations.add(maxPower);
        annotations.add(meanPower);
        annotations.add(median);
        annotations.add(sample);

        annotations.sort(new AnnotationComparator<Annotation>());
        ArrayList<String> test = new ArrayList<>();
        System.out.println(((Object)test).getClass().getName());

        return annotations;



    }

    private static Annotation getCalibrationAnnotation() {
        CalibrationAnnotation cal = new CalibrationAnnotation();
        cal.setCalibrationDate(Calendar.getInstance().getTime());
        cal.setReceiverLdbCompressionPoint(12.0);
        cal.setReceiverScalingFactor(2.0);
        SystemNoise noise = new SystemNoise();
        noise.setUnits("dB");
        noise.setReference("reference");
        noise.setMeanPowerDensity(1.0);
        cal.setSampleCount(100l);
        cal.setSampleStart(0l);
        cal.setReceiverSystemNoisePower(noise);
        return cal;
    }

    public static void test(List<? extends List> param){
        System.out.println("WhooHoo");
    }
}
