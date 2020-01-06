package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.sensor.*;

import java.util.Calendar;

public class RadarExample  implements Example {


    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        Sensor sensor = getSensor();
        global.setSensor(getSensor());
        metaDoc.setGlobal(global);
        return metaDoc;
    }

    public static Sensor getSensor(){
        Sensor sensor = new Sensor();
        sensor.setId("Radar_Sensor_1");
        sensor.setAntenna(getAntenna());
        sensor.setPreselector(getPreselector());
        return sensor;
    }

    private static Antenna getAntenna(){
        Antenna antenna = new Antenna();
        HardwareSpec antSpec = new HardwareSpec();
        antSpec.setModel("ARA BSB-26");
        antSpec.setDescription("RF antenna ideally suited for reception of signals on the horizon for nautical and broadband surveillance applications");
        antenna.setAntennaSpec(antSpec);
        antenna.setType("omni-directional");
        antenna.setLowFrequency(2000000000d);
        antenna.setHighFrequency(6000000000d);
        antenna.setGain(0d);
        antenna.setPolarization("slant");
        antenna.setCrossPolarDiscrimination(13d);
        antenna.setHorizontalBeamWidth(360d);
        antenna.setVerticalBeamWidth(68.38);
        antenna.setVoltageStandingWaveRatio(2d);
        antenna.setCableLoss(.62);
        antenna.setSteerable(Boolean.FALSE);
        antenna.setAzimuthAngle(90d);
        antenna.setElevationAngle(0d);
        antenna.setMobile(Boolean.FALSE);
        return antenna;

    }

    private static Preselector getPreselector(){
        Preselector preselector = new Preselector();
        HardwareSpec calSourceSpec = new HardwareSpec();
        calSourceSpec.setId("MY53400510");
        calSourceSpec.setModel("Keysight 346B");
        calSourceSpec.setSupplementalInformation("https://www.keysight.com/en/pd-1000001299%3Aepsg%3Apro-pn-346B/noise-source-10-mhz-to-18-ghz-nominal-enr-15-db?cc=US&lc=eng");

        CalSource calSource = new CalSource();
        calSource.setCalSourceSpec(calSourceSpec);

        preselector.setCalSource(calSource);
        Amplifier amplifier = new Amplifier();
        HardwareSpec lnaSpec = new HardwareSpec();
        lnaSpec.setId("1904043");
        lnaSpec.setModel("MITEQ AFS3-02000400-30-25P-6");
        lnaSpec.setSupplementalInformation("https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf");
        amplifier.setAmplifierSpec(lnaSpec);
        amplifier.setNoiseFigure(2.76);
        amplifier.setGain(30.61);
        amplifier.setMaxPower(13d);

        Filter filter  = new Filter();
        HardwareSpec filterSpec = new HardwareSpec();
        filterSpec.setId("13FV40-00014");
        filterSpec.setModel("K&L 13FV40-3550/U200-o/o");
        filterSpec.setSupplementalInformation("http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO");
        filter.setFilterSpec(filterSpec);

        filter.setHighFrequencyPassband(3670000000d);
        filter.setLowFrequencyPassband(3430000000d);
        filter.setHighFrequencyStopband(3710000000d);
        filter.setLowFrequencyStopband(3390000000d);

        Filter[] filters = new Filter[1];
        filters[0] = filter;
        preselector.setFilters(filters);

        Amplifier[] amplifiers = new Amplifier[1];
        amplifiers[0] = amplifier;
        preselector.setAmplifiers(amplifiers);

        RFPath path1 = new RFPath();
        path1.setFilterId("13FV40-00014");
        path1.setAmplifierId("1904043");
        path1.setCalSourceId("Calibrated noise source");

        RFPath[] paths = new RFPath[1];
        paths[0] = path1;

        preselector.setRfPaths(paths);
        return preselector;

    }

}
