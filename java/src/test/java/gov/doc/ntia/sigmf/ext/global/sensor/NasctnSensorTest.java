package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.algorithm.AbstractDataProduct;
import gov.doc.ntia.sigmf.ext.algorithm.AbstractProcessing;
import gov.doc.ntia.sigmf.ext.algorithm.DFT;
import gov.doc.ntia.sigmf.ext.algorithm.Graph;
import gov.doc.ntia.sigmf.ext.diagnostics.Computer;
import gov.doc.ntia.sigmf.ext.diagnostics.Software;
import gov.doc.ntia.sigmf.ext.sensor.Calibration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
    Assertions.assertEquals("2023-12-01T16:15:06.908Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
  }

  @Test
  public void testDeserializeDatetime() {
    ZonedDateTime zdt =
        metaDoc.getGlobal().getDiagnostics().getDatetime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-12-01T16:15:06.908Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
  }

  @Test
  public void testDeserializeDataProducts() {
    List<AbstractDataProduct> dataProducts = metaDoc.getGlobal().getDataProducts();
    Assertions.assertEquals(4, dataProducts.size());
    Graph psd = (Graph)dataProducts.get(0);
    Assertions.assertEquals("Power Spectral Density", psd.getName());
    List<String> series = psd.getSeries();
    Assertions.assertEquals("maximum", series.get(0));
    Assertions.assertEquals("mean", series.get(1));
    Assertions.assertEquals(625L, psd.getLength().longValue());
    Assertions.assertEquals("dBm/Hz", psd.getYUnits());
    Assertions.assertEquals(-4992000, ((Double)psd.getXStart().get(0)).intValue());
    Assertions.assertEquals(16000, ((Double)psd.getXStep().get(0)).intValue());
    Assertions.assertEquals(4992000, ((Double)psd.getXStop().get(0)).intValue());
    Assertions.assertEquals("psd_fft", psd.getProcessing().get(0));
  }

  @Test
  public void testDeserializeFft() {
    List<AbstractProcessing> dataProcessing = metaDoc.getGlobal().getProcessingInfo();
    boolean foundFft = false;
    for (AbstractProcessing processing : dataProcessing) {
      if (processing instanceof DFT) {
        DFT fft = (DFT)processing;
        foundFft = true;
        Assertions.assertEquals("psd_fft", fft.getId());
        Assertions.assertEquals(60323.94, fft.getEquivalentNoiseBandwidth().doubleValue());
        Assertions.assertEquals(875, fft.getSamples().intValue());
        Assertions.assertEquals(64000, fft.getDfts().intValue());
        Assertions.assertEquals("flattop", fft.getWindow());
        Assertions.assertTrue(fft.isBaseband());
      }

    }
    Assertions.assertTrue(foundFft);
  }

  @Test
  public void testDeserializePreselector() {
    Assertions.assertEquals(
        22.7,
        metaDoc.getGlobal().getDiagnostics().getPreselector().getNoiseDiodeTemp().doubleValue());
    Assertions.assertTrue(metaDoc.getGlobal().getDiagnostics().getPreselector().getDoorClosed());
    Assertions.assertEquals(
        17.0, metaDoc.getGlobal().getDiagnostics().getPreselector().getHumidity().doubleValue());
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
    Assertions.assertTrue(
        metaDocFromString.getGlobal().getDiagnostics().getPreselector().getDoorClosed());
    Assertions.assertEquals(
        17.0, metaDocFromString.getGlobal().getDiagnostics().getPreselector().getHumidity().doubleValue());
  }

  @Test
  public void testDeserializeSpu() {
    Assertions.assertEquals(
        true, metaDoc.getGlobal().getDiagnostics().getSpu().getPreselectorPowered());
  }

  @Test
  public void testSerializeDeserializeSpu() {
    Assertions.assertEquals(
        true, metaDocFromString.getGlobal().getDiagnostics().getSpu().getPreselectorPowered());


  }

  @Test
  public void testDeserializeComputer() {
    Computer computer = metaDoc.getGlobal().getDiagnostics().getComputer();
    Assertions.assertEquals(55.0, computer.getCpuTemp().doubleValue());
    Assertions.assertEquals(false, computer.getCpuOverheating());
    Assertions.assertEquals(6.99, computer.getCpuUptime().doubleValue());
    Assertions.assertEquals(4295.5, computer.getCpuMaxClock().doubleValue());
    Assertions.assertEquals(1457.0, computer.getCpuMinClock().doubleValue());
    Assertions.assertEquals(3000.1, computer.getCpuMeanClock().doubleValue());
    Assertions.assertEquals(42.8, computer.getActionCpuUsage().doubleValue());
    Assertions.assertEquals(19.9, computer.getSystemLoad5m().doubleValue());
    Assertions.assertEquals(11.2, computer.getMemoryUsage().doubleValue());
    ZonedDateTime zdt = computer.getSoftwareStart().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-12-01T16:11:06.092Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
    Assertions.assertEquals(0.0028, computer.getSoftwareUptime().doubleValue());
    Assertions.assertEquals(true, computer.getSmartData().getTestPassed());
    Assertions.assertEquals("0x00", computer.getSmartData().getCriticalWarning());
    Assertions.assertEquals(36.0, computer.getSmartData().getTemp().doubleValue());
    Assertions.assertEquals(100.0, computer.getSmartData().getAvailableSpare().doubleValue());
    Assertions.assertEquals(
        10.0, computer.getSmartData().getAvailableSpareThreshold().doubleValue());
    Assertions.assertEquals(1.0, computer.getSmartData().getPercentageUsed().doubleValue());
    Assertions.assertEquals(70, computer.getSmartData().getUnsafeShutdowns().intValue());
    Assertions.assertEquals(0, computer.getSmartData().getIntegrityErrors().intValue());
    Assertions.assertEquals(5.0, computer.getDiskUsage().doubleValue());
    Assertions.assertEquals(94.88, computer.getActionRuntime().doubleValue());
    Assertions.assertEquals(true, computer.getNtpSync());
    Assertions.assertEquals(true, computer.getNtpActive());
  }

  @Test
  public void testSerializeDeserializeComputer() {
    Computer computer = metaDocFromString.getGlobal().getDiagnostics().getComputer();
    Assertions.assertEquals(55.0, computer.getCpuTemp().doubleValue());
    Assertions.assertEquals(false, computer.getCpuOverheating());
    Assertions.assertEquals(6.99, computer.getCpuUptime().doubleValue());
    Assertions.assertEquals(4295.5, computer.getCpuMaxClock().doubleValue());
    Assertions.assertEquals(1457.0, computer.getCpuMinClock().doubleValue());
    Assertions.assertEquals(3000.1, computer.getCpuMeanClock().doubleValue());
    Assertions.assertEquals(42.8, computer.getActionCpuUsage().doubleValue());
    Assertions.assertEquals(19.9, computer.getSystemLoad5m().doubleValue());
    Assertions.assertEquals(11.2, computer.getMemoryUsage().doubleValue());
    ZonedDateTime zdt = computer.getSoftwareStart().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-12-01T16:11:06.092Z", zdt.format(DateTimeFormatter.ISO_INSTANT));
    Assertions.assertEquals(0.0028, computer.getSoftwareUptime().doubleValue());
    Assertions.assertEquals(true, computer.getSmartData().getTestPassed());
    Assertions.assertEquals("0x00", computer.getSmartData().getCriticalWarning());
    Assertions.assertEquals(36.0, computer.getSmartData().getTemp().doubleValue());
    Assertions.assertEquals(100.0, computer.getSmartData().getAvailableSpare().doubleValue());
    Assertions.assertEquals(
        10.0, computer.getSmartData().getAvailableSpareThreshold().doubleValue());
    Assertions.assertEquals(1.0, computer.getSmartData().getPercentageUsed().doubleValue());
    Assertions.assertEquals(70, computer.getSmartData().getUnsafeShutdowns().intValue());
    Assertions.assertEquals(0, computer.getSmartData().getIntegrityErrors().intValue());
    Assertions.assertEquals(5.0, computer.getDiskUsage().doubleValue());
    Assertions.assertEquals(94.88, computer.getActionRuntime().doubleValue());
    Assertions.assertEquals(true, computer.getNtpSync());
    Assertions.assertEquals(true, computer.getNtpActive());
  }

  @Test
  public void testDeserializeDiagnosticsSoftware(){
    Software software = metaDoc.getGlobal().getDiagnostics().getSoftware();
    Assertions.assertEquals("Linux-5.4.0-167-generic-x86_64-with-glibc2.29", software.getSystemPlatform());
    Assertions.assertEquals("3.8.10", software.getPythonVersion());
    Assertions.assertEquals("6.4.2", software.getScosActionsVersion());
    Assertions.assertEquals("scos_tekrsa", software.getScosSiganPlugin().getName());
    Assertions.assertEquals("3.1.5", software.getScosSiganPlugin().getVersion());
    Assertions.assertEquals( "3.1.0", software.getPreselectorApiVersion());
    Assertions.assertEquals("sea-prototype-v0.4.2-4-gbc10e57", software.getScosSensorVersion());
    Assertions.assertEquals("1.2.3", software.getSiganFirmwareVersion());
    Assertions.assertEquals("V1.0.0", software.getSiganApiVersion());
  }

  @Test
  public void testDeserializeMaxOfMaxChannelPowers() {
    List<Double> maxPowers = metaDoc.getGlobal().getMaxOfMaxChannelPowers();
    Assertions.assertEquals(17, maxPowers.size());
    Assertions.assertEquals(-86.8125, maxPowers.get(0).doubleValue());
    Assertions.assertEquals(-87.375, maxPowers.get(14).doubleValue());
  }

  @Test
  public void testDeserializeMedianOfMean() {
    List<Double> medianOfMeanPowers = metaDoc.getGlobal().getMedianOfMeanChannelPowers();
    Assertions.assertEquals(17, medianOfMeanPowers.size());
    Assertions.assertEquals(-99.5625, medianOfMeanPowers.get(0).doubleValue());
    Assertions.assertEquals(-99.625, medianOfMeanPowers.get(14).doubleValue());
  }

  @Test
  public void testDeserializeMeanChannelPowers() {
    List<Double> meanChannelPowers = metaDoc.getGlobal().getMeanChannelPowers();
    Assertions.assertEquals(17, meanChannelPowers.size());
    Assertions.assertEquals( -99.625, meanChannelPowers.get(0).doubleValue());
    Assertions.assertEquals(-99.6875, meanChannelPowers.get(14).doubleValue());
  }

  @Test
  public void testDeserializeMedianChannelPowers() {
    List<Double> medianChannelPowers = metaDoc.getGlobal().getMedianChannelPowers();
    Assertions.assertEquals(17, medianChannelPowers.size());
    Assertions.assertEquals( -101.1875, medianChannelPowers.get(0).doubleValue());
    Assertions.assertEquals(-101.25, medianChannelPowers.get(14).doubleValue());
  }

  @Test
  public void testCaptures() {
    List<Capture> captureList = metaDoc.getCaptures();
    Assertions.assertEquals(17, captureList.size());
    Capture capture = captureList.get(0);
    Assertions.assertEquals(3.545E9, capture.getFrequency().doubleValue());
    Capture sensorCapture = (Capture) capture;
    Assertions.assertEquals(false, sensorCapture.getOverload());
    Assertions.assertEquals(4000, sensorCapture.getDuration().intValue());
    Calibration calibration = sensorCapture.getSensorCalibration();
    Assertions.assertEquals(4.173, calibration.getNoiseFigure().doubleValue());
    Assertions.assertEquals(39.079, calibration.getGain().doubleValue());
    Assertions.assertEquals(25.7, calibration.getTemperature().doubleValue());
    ZonedDateTime zdt = calibration.getDatetime().toInstant().atZone(ZoneId.of("UTC"));
    Assertions.assertEquals("2023-11-30T22:04:58.961Z", zdt.format(DateTimeFormatter.ISO_INSTANT));

  }
}
