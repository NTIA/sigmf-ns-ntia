package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.GeoJsonPoint;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import gov.doc.ntia.sigmf.ext.waveform.Waveform;

public class EmitterExample implements Example {

  public static Extension getExtension() {
    Extension extension = new Extension();
    extension.setName("ntia-emitter");
    extension.setVersion("v2.0.0");
    extension.setOptional(false);
    return extension;
  }

  public static Emitter getEmitter() {
    Emitter emitter = new Emitter();
    emitter.setId("N5182B-1");
    emitter.setDescription("Example emitter");
    emitter.setPower(19d);
    emitter.setAntenna(CoreExample.getAntenna());
    emitter.setCenterFrequency(435000000d);
    GeoJsonPoint geolocation = new GeoJsonPoint(40.304983, -79.980916);
    emitter.setGeolocation(geolocation);
    return emitter;
  }

  @Override
  public MetaDoc getExample() {
    Emitter emitter = getEmitter();

    Waveform waveform = new Waveform();
    waveform.setDescription("continuous wave");
    emitter.setWaveform(waveform);

    HardwareSpec antennaSpec = new HardwareSpec();
    antennaSpec.setId("emitter-antenna");
    antennaSpec.setModel("Cobham_OA2-0.3-10.0V/1505");
    antennaSpec.setDescription("Ultra Wide Band Omni Antenna");
    antennaSpec.setSupplementalInformation(
        "https://www.european-antennas.co.uk/media/1638/ds1505-060510.pdf");
    Antenna antenna = new Antenna();
    antenna.setAntennaSpec(antennaSpec);
    antenna.setType("omni-directional");
    antenna.setFrequencyLow(3.0E8);
    antenna.setFrequencyHigh(1.0E10);
    antenna.setGain(2.0);
    antenna.setPolarization("horizontal");
    antenna.setCrossPolarDiscrimination(20.0);
    antenna.setHorizontalBeamwidth(360.0);
    antenna.setVerticalBeamwidth(65.0);
    antenna.setVoltageStandingWaveRatio(2.5);
    antenna.setCableLoss(.15);
    antenna.setSteerable(false);
    antenna.setAzimuthAngle(0.0);
    antenna.setElevationAngle(90.0);

    emitter.setAntenna(antenna);

    HardwareSpec transmitter = new HardwareSpec();
    transmitter.setId("tx_1");
    transmitter.setModel("N5182B");
    transmitter.setVersion("v1.0.0");
    transmitter.setDescription("Keysight MxG X-series RF Vector Signal Generator");
    transmitter.setSupplementalInformation(
        "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf");
    emitter.setTransmitter(transmitter);

    Environment environment = new Environment();
    environment.setCategory("Underground, coal mine");

    emitter.setEnvironment(environment);

    Global global = ExampleUtils.getGlobal();
    global.addExtension(getExtension());
    global.addEmitter(emitter);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
