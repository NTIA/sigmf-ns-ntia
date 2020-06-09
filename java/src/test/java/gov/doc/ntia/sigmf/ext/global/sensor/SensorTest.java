package gov.doc.ntia.sigmf.ext.global.sensor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class SensorTest {

  @Test
  public void testId() throws IOException {
    MetaDoc metaDoc = new MetaDoc();
    Global global = new Global();
    Sensor sensor = new Sensor();
    String sensorId = "TestSensor123";
    sensor.setId(sensorId);
    global.setSensor(sensor);
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = (MetaDoc) mapper.readValue(output, MetaDoc.class);
    assertEquals(sensorId, metaDoc.getGlobal().getSensor().getId());
  }

  @Test
  public void testMobile() throws IOException {
    Global global = new Global();
    Sensor sensor = new Sensor();
    String sensorId = "TestSensor123";
    sensor.setId(sensorId);
    sensor.setMobile(Boolean.TRUE);
    global.setSensor(sensor);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = (MetaDoc) mapper.readValue(output, MetaDoc.class);
    assertEquals(Boolean.TRUE, metaDoc.getGlobal().getSensor().getMobile());
  }
}
