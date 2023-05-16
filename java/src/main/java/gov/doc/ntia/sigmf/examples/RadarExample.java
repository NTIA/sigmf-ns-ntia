package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.algorithm.PowerSpectralDensity;
import gov.doc.ntia.sigmf.ext.global.algorithm.Trace;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.core.Measurement;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import gov.doc.ntia.sigmf.ext.global.sensor.Amplifier;
import gov.doc.ntia.sigmf.ext.global.sensor.CalSource;
import gov.doc.ntia.sigmf.ext.global.sensor.Filter;
import gov.doc.ntia.sigmf.ext.global.sensor.Preselector;
import gov.doc.ntia.sigmf.ext.global.sensor.RfPath;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;
import java.util.ArrayList;
import java.util.Calendar;import java.util.List;

/** Generates an example based on coastal monitoring of the CBRS band. */
public class RadarExample implements Example {

  public static Measurement getMeasurement() {
    Measurement measurement = new Measurement();
    measurement.setFrequencyTunedLow(3.45021875E9);
    measurement.setFrequencyTunedHigh(3.65015625E9);
    measurement.setDomain("frequency");
    measurement.setMeasurementType("scan");
    Calendar calendar = Calendar.getInstance();
    calendar.set(2018, 02, 01, 07, 01, 00);
    measurement.setTimeStart(calendar.getTime());
    calendar.add(Calendar.MILLISECOND, 30);
    measurement.setTimeStop(calendar.getTime());
    measurement.setFrequencyTunedStep(437500.0);
    measurement.setClassification("UNCLASSIFIED");
    return measurement;
  }

  public static List<Extension> getExtensions() {

    Extension sensorExtension = new Extension();
    sensorExtension.setName("ntia-sensor");
    sensorExtension.setVersion("v1.0.0");

    Extension algorithmExtension = new Extension();
    algorithmExtension.setName("ntia-algorithm");
    algorithmExtension.setVersion("v1.0.0");

    Extension envExtension = new Extension();
    envExtension.setName("ntia-environment");
    envExtension.setVersion("v1.0.0");

    ArrayList<Extension> extensions = new ArrayList<>();
    extensions.add(sensorExtension);
    extensions.add(algorithmExtension);
    extensions.add(envExtension);
    return extensions;
  }

  public static Sensor getSensor() {
    Sensor sensor = new Sensor();
    sensor.setId("Radar_Sensor_1");
    sensor.setAntenna(getAntenna());
    sensor.setPreselector(getPreselector());
    Environment environment = new Environment();
    environment.setCategory("Outside. Coastal");
    sensor.setEnvironment(environment);

    return sensor;
  }

  private static Antenna getAntenna() {
    HardwareSpec antSpec = new HardwareSpec();
    antSpec.setModel("ARA BSB-26");
    String description = "\"RF antenna ideally suited for reception of signals on the horizon";
    description += " for nautical and broadband surveillance applications";
    antSpec.setDescription(description);
    Antenna antenna = new Antenna();
    antenna.setAntennaSpec(antSpec);
    antenna.setType("omni-directional");
    antenna.setFrequencyLow(2.0E9);
    antenna.setFrequencyHigh(6.0E9);
    antenna.setGain(0d);
    antenna.setPolarization("slant");
    antenna.setCrossPolarDiscrimination(13d);
    antenna.setHorizontalBeamwidth(360d);
    antenna.setVerticalBeamwidth(68.38);
    antenna.setVoltageStandingWaveRatio(2d);
    antenna.setCableLoss(.62);
    antenna.setSteerable(Boolean.FALSE);
    antenna.setAzimuthAngle(90d);
    antenna.setElevationAngle(0d);
    return antenna;
  }

  private static Preselector getPreselector() {

    HardwareSpec calSourceSpec = new HardwareSpec();
    calSourceSpec.setId("MY53400510");
    calSourceSpec.setModel("Keysight 346B");
    calSourceSpec.setSupplementalInformation(
        "https://www.keysight.com/en/pd-1000001299%3Aepsg%3Apro-pn-346B/noise-source-10-mhz-to-18-ghz-nominal-enr-15-db?cc=US&lc=eng");

    CalSource calSource = new CalSource();
    calSource.setCalSourceSpec(calSourceSpec);
    CalSource[] calSources = new CalSource[1];
    calSources[0] = calSource;
    Preselector preselector = new Preselector();
    preselector.setCalSources(calSources);
    HardwareSpec lnaSpec = new HardwareSpec();
    lnaSpec.setId("1904043");
    lnaSpec.setModel("MITEQ AFS3-02000400-30-25P-6");
    lnaSpec.setSupplementalInformation(
        "https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf");
    Amplifier amplifier = new Amplifier();
    amplifier.setAmplifierSpec(lnaSpec);
    amplifier.setNoiseFigure(2.76);
    amplifier.setGain(30.61);
    amplifier.setMaxPower(13d);

    HardwareSpec filterSpec = new HardwareSpec();
    filterSpec.setId("13FV40-00014");
    filterSpec.setModel("K&L 13FV40-3550/U200-o/o");
    filterSpec.setSupplementalInformation(
        "http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO");
    Filter filter = new Filter();
    filter.setFilterSpec(filterSpec);

    filter.setFrequencyHighPassband(3670000000d);
    filter.setFrequencyLowPassband(3430000000d);
    filter.setFrequencyHighStopband(3710000000d);
    filter.setFrequencyLowStopband(3390000000d);

    Filter[] filters = new Filter[1];
    filters[0] = filter;
    preselector.setFilters(filters);

    Amplifier[] amplifiers = new Amplifier[1];
    amplifiers[0] = amplifier;
    preselector.setAmplifiers(amplifiers);

    RfPath path1 = new RfPath();
    path1.setFilterId("13FV40-00014");
    path1.setAmplifierId("1904043");
    path1.setCalSourceId("Calibrated noise source");

    RfPath[] paths = new RfPath[1];
    paths[0] = path1;

    preselector.setRfPaths(paths);
    return preselector;
  }

  private static ArrayList<Capture> getCaptures() {
    Capture capture = new Capture();
    capture.setFrequency(3.5501875E9);
    Calendar calendar = Calendar.getInstance();
    // "2018-02-01T07:01:00.000001Z"
    calendar.set(2018, 02, 01, 07, 01, 00);
    capture.setDateTime(calendar.getTime());
    capture.setSampleStart(0);
    ArrayList<Capture> captures = new ArrayList<>();
    captures.add(capture);

    return captures;
  }

  private static ArrayList<Annotation> getAnnotations() {
    /*
    CalibrationAnnotation calibrationAnnotation = new CalibrationAnnotation();
    calibrationAnnotation.setSampleStart(0L);
    calibrationAnnotation.setComment("Calibration is done every 6 hours.");
    calibrationAnnotation.setNoiseFigureSensor(9.892);
    calibrationAnnotation.setMeanNoisePowerSensor(-92.21948908296943);
    calibrationAnnotation.setTemperature(18.556);
    calibrationAnnotation.setGainPreselector(25.931);
    calibrationAnnotation.setSampleCount(458L);
    ArrayList<Annotation> annotations = new ArrayList<>();
    annotations.add(calibrationAnnotation);

     */
    /*
        SensorAnnotation sensorAnnotation = new SensorAnnotation();
        sensorAnnotation.setAttenuationSettingSigan(6.0);
        sensorAnnotation.setOverload(false);
        sensorAnnotation.setRfPathIndex(0);
        sensorAnnotation.setSampleStart(0L);
        sensorAnnotation.setSampleCount(458L);
        annotations.add(sensorAnnotation);
    */

    return new ArrayList<>();
    // return annotations;
  }

  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setExtensions(getExtensions());
    Sensor sensor = getSensor();
    global.setSensor(getSensor());
    global.setMeasurement(getMeasurement());

    PowerSpectralDensity psd = new PowerSpectralDensity();
    Trace max = new Trace();
    max.setStatistic("max");
    psd.addTrace(max);
    psd.setFfts(458);
    psd.setSamples(64L);
    psd.setWindow("Gauss-top");
    psd.setEquivalentNoiseBandwidth(962500.0);
    psd.setLength(458L);

    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    metaDoc.setAnnotations(getAnnotations());
    metaDoc.setCaptures(getCaptures());
    return metaDoc;
  }
}
