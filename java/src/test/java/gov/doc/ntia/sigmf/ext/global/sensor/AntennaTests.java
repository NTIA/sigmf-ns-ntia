package gov.doc.ntia.sigmf.ext.global.sensor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.sensor.Sensor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AntennaTests {

  private MetaDoc getMetaDocWithSensorAndAntenna() {
    HardwareSpec sensorSpec = new HardwareSpec();
    sensorSpec.setId("Sensor1");
    Sensor sensor = new Sensor();
    sensor.setSensorSpec(sensorSpec);
    Antenna antenna = new Antenna();
    sensor.addAntenna(antenna);
    Global global = new Global();
    global.setSensor(sensor);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }

  @Test
  public void testAntennaSpec() throws IOException {

    HardwareSpec antennaSpec = new HardwareSpec();
    antennaSpec.setSupplementalInformation("supplemental info");
    antennaSpec.setModel("model");
    antennaSpec.setId("antenna123");
    antennaSpec.setDescription("description");
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setAntennaSpec(antennaSpec);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getId(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getId());
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getDescription(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getDescription());
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getModel(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getAntennaSpec().getModel());
  }

  @Test
  public void testType() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setType("antennaType");
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getType(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getType());
  }

  @Test
  public void testLowFrequency() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setFrequencyLow(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getFrequencyLow(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getFrequencyLow());
  }

  @Test
  public void testHighFrequency() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setFrequencyHigh(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getFrequencyHigh(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getFrequencyHigh());
  }

  @Test
  public void testGain() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setGain(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getGain(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getGain());
  }

  @Test
  public void testPolarization() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().getFirst().setPolarization("horizontal");
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFirst().getPolarization(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFirst().getPolarization());
  }

  @Test
  public void testCrossPolarDiscrimination() {}

  @Test
  public void testHorizontalGainPattern() {}

  @Test
  public void testVerticalGainPattern() {}

  @Test
  public void testHorizontalBeamwidth() {}

  @Test
  public void testVerticalBeamwidth() {}

  @Test
  public void testVoltageStandingWaveRatio() {}

  @Test
  public void testCableLoss() {}

  @Test
  public void testSteerable() {}

  @Test
  public void testAzimuthAngle() {}

  @Test
  public void testElevationAngle() {}

  @Test
  public void testMobile() {}
}
