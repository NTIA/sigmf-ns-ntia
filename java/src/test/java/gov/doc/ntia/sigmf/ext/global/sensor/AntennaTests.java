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
import org.junit.jupiter.api.Test;

public class AntennaTests {

  private MetaDoc getMetaDocWithSensorAndAntenna() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = new Global();
    Sensor sensor = new Sensor();
    sensor.setId("Sensor1");
    Antenna antenna = new Antenna();
    sensor.setAntenna(antenna);
    global.setSensor(sensor);
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
    metaDoc.getGlobal().getSensor().getAntenna().setAntennaSpec(antennaSpec);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getId(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getId());
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getDescription(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getDescription());
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getModel(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getModel());
  }

  @Test
  public void testType() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().setType("antennaType");
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getType(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getType());
  }

  @Test
  public void testLowFrequency() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().setFrequencyLow(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFrequencyLow(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFrequencyLow());
  }

  @Test
  public void testHighFrequency() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().setFrequencyHigh(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getFrequencyHigh(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getFrequencyHigh());
  }

  @Test
  public void testGain() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().setGain(100.0);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getGain(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getGain());
  }

  @Test
  public void testPolarization() throws IOException {
    MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
    metaDoc.getGlobal().getSensor().getAntenna().setPolarization("horizontal");
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(
        metaDoc.getGlobal().getSensor().getAntenna().getPolarization(),
        readMetaDoc.getGlobal().getSensor().getAntenna().getPolarization());
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
