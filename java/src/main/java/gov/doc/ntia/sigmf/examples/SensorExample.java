package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.core.Measurement;
import gov.doc.ntia.sigmf.ext.global.sensor.*;

import java.util.Calendar;

public class SensorExample implements Example {


    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        Sensor sensor = getSensor();
        global.setSensor(getSensor());
        metaDoc.setGlobal(global);
      //  metaDoc.setCaptures(getCaptures());
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
        Filter filter = new Filter();
        HardwareSpec filterSpec = new HardwareSpec();
        filterSpec.setId("filter_1");
        filter.setFilterSpec(filterSpec);
        Amplifier amplifier = new Amplifier();
        HardwareSpec lnaSpec = new HardwareSpec();
        lnaSpec.setId("lna_1");
        amplifier.setAmplifierSpec(lnaSpec);
        rfPath.setCalSourceId("calibrated noise source");
        filter.setFrequencyHighPassband(750000000d);
        filter.setFrequencyHighStopband(750000000d);
        amplifier.setNoiseFigure(2.5);
        filter.setFrequencyLowPassband(700000000d);
        filter.setFrequencyLowStopband(700000000d);
        rfPath.setAmplifierId("lna_1");
        rfPath.setFilterId("filter_1");
        rfPaths[0] = rfPath;
        preselector.setRfPaths(rfPaths);
        return preselector;
    }

    private SignalAnalyzer getSignalAnalyzer(){
        SignalAnalyzer sigan = new SignalAnalyzer();
        sigan.setA2dBits(16);
        sigan.setFrequencyHigh(700000000d);
        sigan.setFrequencyLow(100000000d);
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
        spec.setId("123-xyxpdq");
        antenna.setAntennaSpec(spec);
        antenna.setType("omnidirectional");
        antenna.setCableLoss(1.0);
        antenna.setCrossPolarDiscrimination(9.1);
        antenna.setGain(2.0);
        antenna.setFrequencyHigh(3000000000d);
        antenna.setFrequencyLow(300000000d);
        return antenna;
    }

    private Measurement getMeasurement(){
        Measurement measurement = new Measurement();
        return measurement;
    }


}
