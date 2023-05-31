package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;

public class CoreExample implements Example {
    public static Antenna getAntenna() {
        Antenna antenna = new Antenna();
        HardwareSpec spec = getHardwareSpec("123-xyzpdq");
        antenna.setAntennaSpec(spec);
        antenna.setType("omnidirectional");
        antenna.setFrequencyLow(300000000d);
        antenna.setFrequencyHigh(3000000000d);
        antenna.setPolarization("vertical");
        antenna.setCrossPolarDiscrimination(9.1);
        antenna.setGain(2.0);
        Double[] horizontalPattern = new Double[] {1.0, 2.0, 3.0};
        Double[] verticalPattern = new Double[] {4.0, 5.0, 6.0};
        antenna.setHorizontalGainPattern(horizontalPattern);
        antenna.setVerticalGainPattern(verticalPattern);
        antenna.setHorizontalBeamwidth(360.0);
        antenna.setVerticalBeamwidth(10.0);
        antenna.setVoltageStandingWaveRatio(1.5);
        antenna.setCableLoss(1.0);
        antenna.setSteerable(false);
        antenna.setAzimuthAngle(0.0);
        antenna.setElevationAngle(5.0);
        return antenna;
      }

    /**
     * Generates an example HardwareSpec object with all fields filled.
     * 
     */
    public static HardwareSpec getHardwareSpec(String id) {
        HardwareSpec spec = new HardwareSpec();
        spec.setId(id);
        spec.setModel("Example model");
        spec.setVersion("v1.0");
        spec.setDescription("Example description");
        spec.setSupplementalInformation("Example supplemental information");
        return spec;
    }

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal();
        global.setClassification("UNCLASSIFIED");
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}
