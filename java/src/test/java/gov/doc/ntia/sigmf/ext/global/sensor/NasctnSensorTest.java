package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.capture.sensor.*;
import gov.doc.ntia.sigmf.ext.capture.sensor.SensorCapture;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Computer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NasctnSensorTest {

  public static boolean setupComplete = false;
  private File metaFile;
  private String metaString;
  private MetaDoc metaDoc;
  private MetaDoc metaDocFromString;
  private File schemaFile;

  @BeforeAll
  public void setup() throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    String filename;
    // Survey 2 Times
    filename = "meta.sigmf-meta";
    URL meta_url = classLoader.getResource(filename);
    metaFile = new File(meta_url.getFile());
    ObjectMapper mapper = new ObjectMapper();
    metaDoc = mapper.readValue(metaFile, MetaDoc.class);
    metaString = mapper.writeValueAsString(metaDoc);
    metaDocFromString = mapper.readValue(metaString, MetaDoc.class);
    String schema = "sigmf-ns-ntia.schema";
    URL schemaUrl = classLoader.getResource(schema);
    schemaFile = new File(schemaUrl.getFile());
  }

  @Test
  public void testSerializeDeserializeDatetime() {
    ZonedDateTime zdt =
        metaDocFromString
            .getGlobal()
            .getDiagnostics()
            .getDatetime()
            .toInstant()
            .atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-04-06T21:31:39.356Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
  }

  @Test
  public void testDeserializeDatetime() {
    ZonedDateTime zdt =
        metaDoc.getGlobal().getDiagnostics().getDatetime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-04-06T21:31:39.356Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
  }

  @Test
  public void testDeserializeActionRuntime() {
    Assertions.assertEquals(
        81.8970819178503, metaDoc.getGlobal().getDiagnostics().getActionRuntime().doubleValue());
  }

  @Test
  public void testSerializeDeserializeActionRuntime() {
    Assertions.assertEquals(
        81.8970819178503,
        metaDocFromString.getGlobal().getDiagnostics().getActionRuntime().doubleValue());
  }

  @Test
  public void testDeserializePreselector() {
    Assertions.assertEquals(
        22.7,
        metaDoc.getGlobal().getDiagnostics().getPreselector().getNoiseDiodeTemp().doubleValue());
    Assertions.assertFalse(metaDoc.getGlobal().getDiagnostics().getPreselector().getDoorClosed());
    Assertions.assertEquals(
        null, metaDoc.getGlobal().getDiagnostics().getPreselector().getHumidity());
  }

  @Test
  public void testSerializeDeserializePreselector() {
    Assertions.assertEquals(
        22.7,
        metaDocFromString
            .getGlobal()
            .getDiagnostics()
            .getPreselector()
            .getNoiseDiodeTemp()
            .doubleValue());
    Assertions.assertFalse(
        metaDocFromString.getGlobal().getDiagnostics().getPreselector().getDoorClosed());
    Assertions.assertEquals(
        null, metaDocFromString.getGlobal().getDiagnostics().getPreselector().getHumidity());
  }

  @Test
  public void testDeserializeSpu() {
    Assertions.assertEquals(true, metaDoc.getGlobal().getDiagnostics().getSpu().getRfTrayPowered());
    Assertions.assertEquals(
        true, metaDoc.getGlobal().getDiagnostics().getSpu().getPreselectorPowered());
    Assertions.assertEquals(true, metaDoc.getGlobal().getDiagnostics().getSpu().getAux28vPowered());
    Assertions.assertEquals(
        26.0, metaDoc.getGlobal().getDiagnostics().getSpu().getPwrBoxTemp().doubleValue());
    Assertions.assertEquals(
        26.1, metaDoc.getGlobal().getDiagnostics().getSpu().getRfBoxTemp().doubleValue());
    Assertions.assertEquals(
        11.2, metaDoc.getGlobal().getDiagnostics().getSpu().getPwrBoxHumidity().doubleValue());
    Assertions.assertEquals(
        54.44, metaDoc.getGlobal().getDiagnostics().getSpu().getSiganInternalTemp().doubleValue());
  }

  @Test
  public void testSerializeDeserializeSpu() {
    Assertions.assertEquals(
        true, metaDocFromString.getGlobal().getDiagnostics().getSpu().getRfTrayPowered());
    Assertions.assertEquals(
        true, metaDocFromString.getGlobal().getDiagnostics().getSpu().getPreselectorPowered());
    Assertions.assertEquals(
        true, metaDocFromString.getGlobal().getDiagnostics().getSpu().getAux28vPowered());
    Assertions.assertEquals(
        26.0,
        metaDocFromString.getGlobal().getDiagnostics().getSpu().getPwrBoxTemp().doubleValue());
    Assertions.assertEquals(
        26.1, metaDocFromString.getGlobal().getDiagnostics().getSpu().getRfBoxTemp().doubleValue());
    Assertions.assertEquals(
        11.2,
        metaDocFromString.getGlobal().getDiagnostics().getSpu().getPwrBoxHumidity().doubleValue());
    Assertions.assertEquals(
        54.44,
        metaDocFromString
            .getGlobal()
            .getDiagnostics()
            .getSpu()
            .getSiganInternalTemp()
            .doubleValue());
  }

  @Test
  public void testDeserializeComputer() {
    Computer computer = metaDoc.getGlobal().getDiagnostics().getComputer();
    Assertions.assertEquals(59.0, computer.getCpuTemp().doubleValue());
    Assertions.assertEquals(false, computer.getCpuOverheating());
    Assertions.assertEquals(21.04, computer.getCpuUptime().doubleValue());
    Assertions.assertEquals(4533.5, computer.getCpuMaxClock().doubleValue());
    Assertions.assertEquals(1240.5, computer.getCpuMinClock().doubleValue());
    Assertions.assertEquals(3222.1, computer.getCpuMeanClock().doubleValue());
    Assertions.assertEquals(42.1, computer.getActionCpuUsage().doubleValue());
    Assertions.assertEquals(18.1, computer.getSystemLoad5m().doubleValue());
    Assertions.assertEquals(14.9, computer.getMemoryUsage().doubleValue());
    ZonedDateTime zdt = computer.getScosStartTime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-04-06T21:28:45.532Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
    Assertions.assertEquals(0.002, computer.getScosUptime().doubleValue());
    Assertions.assertEquals(true, computer.getSmartData().getTestPassed());
    Assertions.assertEquals("0x00", computer.getSmartData().getCriticalWarning());
    Assertions.assertEquals(35.0, computer.getSmartData().getTemp().doubleValue());
    Assertions.assertEquals(100.0, computer.getSmartData().getAvailableSpare().doubleValue());
    Assertions.assertEquals(
        10.0, computer.getSmartData().getAvailableSpareThreshold().doubleValue());
    Assertions.assertEquals(1.0, computer.getSmartData().getPercentageUsed().doubleValue());
    Assertions.assertEquals(18, computer.getSmartData().getUnsafeShutdowns().intValue());
    Assertions.assertEquals(0, computer.getSmartData().getIntegrityErrors().intValue());
  }

  @Test
  public void testSerializeDeserializeComputer() {
    Computer computer = metaDocFromString.getGlobal().getDiagnostics().getComputer();
    Assertions.assertEquals(59.0, computer.getCpuTemp().doubleValue());
    Assertions.assertEquals(false, computer.getCpuOverheating());
    Assertions.assertEquals(21.04, computer.getCpuUptime().doubleValue());
    Assertions.assertEquals(4533.5, computer.getCpuMaxClock().doubleValue());
    Assertions.assertEquals(1240.5, computer.getCpuMinClock().doubleValue());
    Assertions.assertEquals(3222.1, computer.getCpuMeanClock().doubleValue());
    Assertions.assertEquals(42.1, computer.getActionCpuUsage().doubleValue());
    Assertions.assertEquals(18.1, computer.getSystemLoad5m().doubleValue());
    Assertions.assertEquals(14.9, computer.getMemoryUsage().doubleValue());
    ZonedDateTime zdt = computer.getScosStartTime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-04-06T21:28:45.532Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
    Assertions.assertEquals(0.002, computer.getScosUptime().doubleValue());
    Assertions.assertEquals(true, computer.getSmartData().getTestPassed());
    Assertions.assertEquals("0x00", computer.getSmartData().getCriticalWarning());
    Assertions.assertEquals(35.0, computer.getSmartData().getTemp().doubleValue());
    Assertions.assertEquals(100.0, computer.getSmartData().getAvailableSpare().doubleValue());
    Assertions.assertEquals(
        10.0, computer.getSmartData().getAvailableSpareThreshold().doubleValue());
    Assertions.assertEquals(1.0, computer.getSmartData().getPercentageUsed().doubleValue());
    Assertions.assertEquals(18, computer.getSmartData().getUnsafeShutdowns().intValue());
    Assertions.assertEquals(0, computer.getSmartData().getIntegrityErrors().intValue());
  }

  @Test
  public void testDeserializeMaxOfMaxChannelPowers() {
    ArrayList<Double> maxPowers = metaDoc.getGlobal().getMaxOfMaxChannelPowers();
    Assertions.assertEquals(15, maxPowers.size());
    Assertions.assertEquals(-65.3125, maxPowers.get(0).doubleValue());
    Assertions.assertEquals(-42.8125, maxPowers.get(14).doubleValue());
  }

  @Test
  public void testDeserializeMedianOfMean() {
    ArrayList<Double> medianOfMeanPowers = metaDoc.getGlobal().getMedianOfMeanChannelPowers();
    Assertions.assertEquals(15, medianOfMeanPowers.size());
    Assertions.assertEquals(-83.875, medianOfMeanPowers.get(0).doubleValue());
    Assertions.assertEquals(-85.8125, medianOfMeanPowers.get(14).doubleValue());
  }

  @Test
  public void testCaptures() {
    List<Capture> captureList = metaDoc.getCaptures();
    Assertions.assertEquals(15, captureList.size());
    Capture capture = captureList.get(0);
    Assertions.assertEquals(3555000000.0, capture.getFrequency().doubleValue());
    SensorCapture sensorCapture = (SensorCapture) capture;
    Assertions.assertEquals(false, sensorCapture.getOverload());
    Assertions.assertEquals(4000, sensorCapture.getDuration().intValue());
    Calibration calibration = sensorCapture.getSensorCalibration();
    Assertions.assertEquals(6.159, calibration.getNoiseFigure().doubleValue());
    Assertions.assertEquals(23.008, calibration.getGain().doubleValue());
    Assertions.assertEquals(22.6, calibration.getTemperature().doubleValue());
    ZonedDateTime zdt = calibration.getDatetime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-04-06T21:29:17.134Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
  }
}
