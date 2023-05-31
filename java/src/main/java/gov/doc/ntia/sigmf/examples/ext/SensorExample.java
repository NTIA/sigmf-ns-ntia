package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.sensor.Amplifier;
import gov.doc.ntia.sigmf.ext.sensor.Calibration;
import gov.doc.ntia.sigmf.ext.sensor.CalSource;
import gov.doc.ntia.sigmf.ext.sensor.Filter;
import gov.doc.ntia.sigmf.ext.sensor.Preselector;
import gov.doc.ntia.sigmf.ext.sensor.RfPath;
import gov.doc.ntia.sigmf.ext.sensor.Sensor;
import gov.doc.ntia.sigmf.ext.sensor.SensorCalibration;
import gov.doc.ntia.sigmf.ext.sensor.SiganCalibration;
import gov.doc.ntia.sigmf.ext.sensor.SiganSettings;
import gov.doc.ntia.sigmf.ext.sensor.SignalAnalyzer;

public class SensorExample implements Example {

  public static Sensor getSensor() {
    Sensor sensor = new Sensor();
    sensor.setSensorSpec(CoreExample.getHardwareSpec("Greyhound_1"));
    sensor.setAntenna(CoreExample.getAntenna());
    sensor.setPreselector(getPreselector());
    sensor.setSignalAnalyzer(getSignalAnalyzer());
    sensor.setComputerSpec(CoreExample.getHardwareSpec("Example_PC"));
    sensor.setMobile(false);
    sensor.setEnvironment(EnvironmentExample.getEnvironment());
    sensor.setSensorSha512("657bd59b8e46609411b9ba53d77fbc1dee75885fc6f3e4a744c6cfd80e2d85279a940f3e749733e91a2289cf728b83e0d76befb44b356d7933dc236f8f742556");
    return sensor;
  }

  public static SignalAnalyzer getSignalAnalyzer() {
    SignalAnalyzer sigan = new SignalAnalyzer();
    sigan.setSiganSpec(CoreExample.getHardwareSpec("875649305NLDKDJN"));
    sigan.setA2dBits(16);
    sigan.setFrequencyHigh(700000000d);
    sigan.setFrequencyLow(100000000d);
    sigan.setNoiseFigure(20.0);
    sigan.setMaxPower(35.0);
    return sigan;
  }

  public static Preselector getPreselector() {
    Preselector preselector = new Preselector();
    preselector.setPreselectorSpec(CoreExample.getHardwareSpec("preselector_1"));

    String filterID = "filter_1";
    String amplifierID = "lna_1";
    String calSourceID = "noise_diode_1";

    CalSource calSource = getCalSource(calSourceID);
    preselector.addCalSource(calSource);

    Amplifier amplifier = getAmplifier(amplifierID);
    preselector.addAmplifier(amplifier);

    Filter filter = getFilter(filterID);
    preselector.addFilter(filter);

    RfPath rfPath = new RfPath();
    rfPath.setId("path_1");
    rfPath.setCalSourceId(calSourceID);
    rfPath.setAmplifierId(amplifierID);
    rfPath.setFilterId(filterID);
    preselector.addRfPath(rfPath);

    return preselector;
  }

  public static CalSource getCalSource(String id) {
    CalSource calSource = new CalSource();
    calSource.setCalSourceSpec(CoreExample.getHardwareSpec(id));
    calSource.setType("Calibrated noise diode");
    calSource.setEnr(15.0);
    return calSource;
  }

  public static Amplifier getAmplifier(String id) {
    Amplifier amplifier = new Amplifier();
    amplifier.setAmplifierSpec(CoreExample.getHardwareSpec(id));
    amplifier.setGain(30.0);
    amplifier.setNoiseFigure(2.5);
    amplifier.setMaxPower(35.0);
    return amplifier;
  }

  public static Filter getFilter(String id) {
    Filter filter = new Filter();
    filter.setFilterSpec(CoreExample.getHardwareSpec(id));
    filter.setFrequencyHighPassband(750000000d);
    filter.setFrequencyHighStopband(750000000d);
    filter.setFrequencyLowPassband(700000000d);
    filter.setFrequencyLowStopband(700000000d);
    return filter;
  }

  // RFPath example object omitted

  public static Calibration getCalibration() {
    Calibration cal = new Calibration();
    cal.setDatetime(ExampleUtils.getDatetimeNow());
    cal.setGain(30.0);
    cal.setNoiseFigure(4.9);
    cal.setCompressionPoint(33.0);
    cal.setEnbw(10000000.0);
    cal.setMeanNoisePower(-100.0);
    cal.setMeanNoisePowerUnits("dBm");
    cal.setReference("antenna terminal");
    cal.setTemperature(28.0);
    return cal;
  }

  public static SensorCalibration getSensorCalibration() {
    SensorCalibration cal = new SensorCalibration();
    cal.setDatetime(ExampleUtils.getDatetimeNow());
    cal.setGain(30.0);
    cal.setNoiseFigure(4.9);
    cal.setCompressionPoint(33.0);
    cal.setEnbw(10000000.0);
    cal.setMeanNoisePower(-100.0);
    cal.setMeanNoisePowerUnits("dBm");
    cal.setReference("antenna terminal");
    cal.setTemperature(28.0);
    return cal;
  }

  public static SiganCalibration getSiganCalibration() {
    SiganCalibration cal = new SiganCalibration();
    cal.setDatetime(ExampleUtils.getDatetimeNow());
    cal.setGain(30.0);
    cal.setNoiseFigure(4.9);
    cal.setCompressionPoint(33.0);
    cal.setEnbw(10000000.0);
    cal.setMeanNoisePower(-100.0);
    cal.setMeanNoisePowerUnits("dBm");
    cal.setReference("antenna terminal");
    cal.setTemperature(28.0);
    return cal;
  }

  public static SiganSettings getSiganSettings() {
    SiganSettings settings = new SiganSettings();
    settings.setGain(15.0);
    settings.setReferenceLevel(-33.0);
    settings.setAttenuation(10.0);
    settings.setPreampEnable(true);
    return settings;
  }

  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();

    Sensor sensor = getSensor();
    global.setSensor(sensor);

    Capture capture = new Capture();
    capture.setSampleStart(0);
    capture.setDuration(100);
    capture.setOverload(false);
    capture.setSensorCalibration(getSensorCalibration());
    capture.setSiganCalibration(getSiganCalibration());
    capture.setSiganSettings(getSiganSettings());
    metaDoc.addCapture(capture);
    
    return metaDoc;
  }

}
