package gov.doc.ntia.sigmf.ext.global.sensor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.annotation.sensor.KeysightN6841aSettings;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.sensor.TekrsaSettings;
import gov.doc.ntia.sigmf.ext.annotation.sensor.UsrpSettings;
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
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(sensorId, readMetaDoc.getGlobal().getSensor().getId());
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
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    assertEquals(Boolean.TRUE, readMetaDoc.getGlobal().getSensor().getMobile());
  }

  @Test
  public void testTekrsaSettings() throws Exception {
    Global global = new Global();
    Sensor sensor = new Sensor();
    String sensorId = "TestSensor123";
    sensor.setId(sensorId);
    global.setSensor(sensor);
    SensorAnnotation sensorAnnotation = new SensorAnnotation();
    sensorAnnotation.setOverload(false);
    sensorAnnotation.setRfPathIndex(0);
    TekrsaSettings settings = new TekrsaSettings();
    settings.setAttenuation(0.0);
    settings.setAutoAttenuationEnable(false);
    settings.setIqBandwidth(100.0);
    settings.setPreampEnable(false);
    sensorAnnotation.setSiganSettings(settings);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.addAnnotation(sensorAnnotation);
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    SensorAnnotation readAnnotation = (SensorAnnotation) metaDoc.getAnnotations().get(0);
    TekrsaSettings readSettings = (TekrsaSettings) readAnnotation.getSiganSettings();
    assertEquals(Boolean.FALSE, readSettings.getPreampEnable());
    assertEquals(100.0, readSettings.getIqBandwidth().doubleValue());
    assertEquals(0.0, readSettings.getAttenuation().doubleValue());
  }

  @Test
  public void testUsrpSettings() throws Exception {
    Global global = new Global();
    Sensor sensor = new Sensor();
    String sensorId = "TestSensor123";
    sensor.setId(sensorId);
    global.setSensor(sensor);
    SensorAnnotation sensorAnnotation = new SensorAnnotation();
    sensorAnnotation.setOverload(false);
    sensorAnnotation.setRfPathIndex(0);
    UsrpSettings settings = new UsrpSettings();
    settings.setGain(40.0);
    settings.setClockRate(156789.00);
    sensorAnnotation.setSiganSettings(settings);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.addAnnotation(sensorAnnotation);
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    SensorAnnotation readAnnotation = (SensorAnnotation) metaDoc.getAnnotations().get(0);
    UsrpSettings readSettings = (UsrpSettings) readAnnotation.getSiganSettings();
    assertEquals(40.0, readSettings.getGain().doubleValue());
    assertEquals(156789.00, readSettings.getClockRate().doubleValue());
  }

  @Test
  public void testKeysightN6841aSettings() throws Exception {
    Global global = new Global();
    Sensor sensor = new Sensor();
    String sensorId = "TestSensor123";
    sensor.setId(sensorId);
    global.setSensor(sensor);
    SensorAnnotation sensorAnnotation = new SensorAnnotation();
    sensorAnnotation.setOverload(false);
    sensorAnnotation.setRfPathIndex(0);
    KeysightN6841aSettings settings = new KeysightN6841aSettings();
    settings.setAttenuation(20.00);
    sensorAnnotation.setSiganSettings(settings);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.addAnnotation(sensorAnnotation);
    metaDoc.setGlobal(global);
    ObjectMapper mapper = new ObjectMapper();
    File output = File.createTempFile("output", ".json");
    output.deleteOnExit();
    mapper.writeValue(output, metaDoc);
    MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);
    SensorAnnotation readAnnotation = (SensorAnnotation) metaDoc.getAnnotations().get(0);
    KeysightN6841aSettings readSettings = (KeysightN6841aSettings) readAnnotation.getSiganSettings();
    assertEquals(20.0, readSettings.getAttenuation().doubleValue());

  }

}
