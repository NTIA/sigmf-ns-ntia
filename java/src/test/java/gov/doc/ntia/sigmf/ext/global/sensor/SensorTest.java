package gov.doc.ntia.sigmf.ext.global.sensor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.SigMfReader;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.sensor.Sensor;
import java.io.File;
import java.io.IOException;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SensorTest {

  @Test
  public void testId() throws IOException {
    String sensorId = "TestSensor123";
    Sensor sensor = new Sensor();
    HardwareSpec sensorSpec = new HardwareSpec();
    sensorSpec.setId(sensorId);
    sensor.setSensorSpec(sensorSpec);
    Global global = new Global();
    global.setSensor(sensor);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(sensorId, readMetaDoc.getGlobal().getSensor().getSensorSpec().getId());
  }

  @Test
  public void testMobile() throws IOException {
    String sensorId = "TestSensor123";
    Sensor sensor = new Sensor();
    HardwareSpec sensorSpec = new HardwareSpec();
    sensorSpec.setId(sensorId);
    sensor.setSensorSpec(sensorSpec);
    sensor.setMobile(Boolean.TRUE);
    Global global = new Global();
    global.setSensor(sensor);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(Boolean.TRUE, readMetaDoc.getGlobal().getSensor().getMobile());
  }

  @Test
  public void testIdRequired() {
    Sensor sensor = new Sensor();
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.getGlobal().setSensor(sensor);
    ObjectMapper mapper = new ObjectMapper();
    String metaString = null;
    try {
      metaString = mapper.writeValueAsString(metaDoc);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    String finalMetaString = metaString;
    Assertions.assertThrows(
        ValidationException.class, () -> SigMfReader.fromString(finalMetaString));
  }
}
