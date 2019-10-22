package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.sensor.*;

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
        sensor.setSignalAnalyzer(getSignalAnalyzer());
        sensor.setPreselector(getPreselector());
        return sensor;
    }

    private Preselector getPreselector() {
        Preselector preselector = new Preselector();
        RFPath[] rfPaths = new RFPath[1];
        RFPath rfPath = new RFPath();
        rfPath.setTypeCalSource("calibrated noise source");
        rfPath.setHighFrequencyPassbandFilter(750000000d);
        rfPath.setHighFrequencyStopbandFilter(750000000d);
        rfPath.setNoiseFigureLna(2.5);
        rfPath.setLowFrequencyPassbandFilter(700000000d);
        rfPath.setLowFrequencyStopbandFilter(700000000d);
        rfPaths[0] = rfPath;
        preselector.setRfPaths(rfPaths);
        return preselector;
    }

    private SignalAnalyzer getSignalAnalyzer(){
        SignalAnalyzer sigan = new SignalAnalyzer();
        sigan.setA2dBits(16);
        sigan.setHighFrequency(700000000d);
        sigan.setLowFrequency(100000000d);
        sigan.setNoiseFigure(20.0);
        sigan.setSiganSpec(getSiganSpec());
        return sigan;
    }

    private HardwareSpec getSiganSpec(){
        HardwareSpec siganSpec = new HardwareSpec();
        siganSpec.setId("875649305NLDKDJN");
        siganSpec.setModel("Etus B210");
        return siganSpec;
    }

    private Antenna getAntenna() {
        Antenna antenna = new Antenna();
        HardwareSpec spec = new HardwareSpec();
        spec.setModel("antenna123");
        antenna.setAntennaSpec(spec);
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
