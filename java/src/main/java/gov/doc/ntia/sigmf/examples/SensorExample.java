package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.sensor.Preselector;
import gov.doc.ntia.sigmf.ext.global.sensor.RFPath;
import gov.doc.ntia.sigmf.ext.global.sensor.Receiver;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SensorExample implements Example {


    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        Sensor sensor = getSensor();
        global.setSensor(getSensor());
        metaDoc.setGlobal(global);
        metaDoc.setAnnotations(getAnnotations());
        return metaDoc;
    }

    private Sensor getSensor(){
        Sensor sensor = new Sensor();
        sensor.setId("Greyhound_1");
        sensor.setAntenna(getAntenna());
        sensor.setHostController("Host Controller 123");
        sensor.setPreselector(getPreselector());
        sensor.setReceiver(getReceiver());
        return sensor;
    }

    private Receiver getReceiver() {
        Receiver receiver = new Receiver();
        receiver.setA2dBits(256l);
        receiver.setHighFrequency(3000000000d);
        receiver.setLowFrequency(300000000d);
        receiver.setModel("Receiver 123xyz");
        receiver.setMaxPower(-5d);
        receiver.setNoiseFigure(2.0);
        return receiver;
    }

    private Preselector getPreselector() {
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

    private Antenna getAntenna() {
        Antenna antenna = new Antenna();
        antenna.setId("antenna1");
        antenna.setModel("model_X");
        antenna.setType("omnidirectional");
        antenna.setAzimuthAngle(45.0);
        antenna.setCableLoss(1.0);
        antenna.setCrossPolarDiscrimination(9.1);
        antenna.setElevationAngle(10.3);
        antenna.setGain(2.0);
        antenna.setHighFrequency(3000000000d);
        antenna.setLowFrequency(300000000d);
        return antenna;
    }

    private List<Annotation> getAnnotations(){
        SensorAnnotation annotation= new SensorAnnotation();
        annotation.setSampleStart(0l);
        annotation.setSampleCount(100l);
        annotation.setLatitude(40.5);
        annotation.setLongitude(-105.0);
        SensorAnnotation annotation2= new SensorAnnotation();
        annotation2.setSampleStart(100l);
        annotation2.setSampleCount(100l);
        annotation2.setLatitude(40.56);
        annotation2.setLongitude(-105.03);
        List<Annotation> annotations = new ArrayList<>();
        annotations.add(annotation);
        annotations.add(annotation2);
        return annotations;


    }
}
