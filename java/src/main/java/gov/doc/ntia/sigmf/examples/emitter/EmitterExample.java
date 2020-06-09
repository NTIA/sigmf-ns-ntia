package gov.doc.ntia.sigmf.examples.emitter;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import gov.doc.ntia.sigmf.ext.global.location.Location;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmitterExample implements Example {
  @Override
  public MetaDoc getExample() {
    Emitter emitter = new Emitter();
    emitter.setId("N5182B-1");
    emitter.setPower(19d);
    emitter.setCenterFrequency(435000000d);
    Waveform waveform = new Waveform();
    waveform.setDescription("continuous wave");
    emitter.setWaveform(waveform);

    HardwareSpec antennaSpec = new HardwareSpec();
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
    antenna.setHorizontalBeamWidth(360.0);
    antenna.setVerticalBeamWidth(65.0);
    antenna.setVoltageStandingWaveRatio(2.5);
    antenna.setCableLoss(.15);
    antenna.setSteerable(false);
    antenna.setAzimuthAngle(0.0);
    antenna.setElevationAngle(90.0);

    emitter.setAntenna(antenna);

    HardwareSpec transmitter = new HardwareSpec();
    transmitter.setModel("N5182B");
    transmitter.setVersion("v1.0.0");
    transmitter.setDescription("Keysight MxG X-series RF Vector Signal Generator");
    transmitter.setSupplementalInformation(
        "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf");
    emitter.setTransmitter(transmitter);

    Location location = new Location();
    location.setX(-79.980916);
    location.setY(40.304983);
    location.setSpeed(0.0);
    location.setDescription("NIOSH mine, Pittsburgh PA");

    Environment environment = new Environment();
    environment.setCategory("Underground, coal mine");

    emitter.setEnvironment(environment);

    Global global = ExampleUtils.getGlobal();
    List<Emitter> emitters = new ArrayList<>();
    emitters.add(emitter);
    global.setEmitters(emitters);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
