package gov.doc.ntia.sigmf.examples.scos;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.scos.Action;
import gov.doc.ntia.sigmf.ext.global.scos.ScheduleEntry;
import gov.doc.ntia.sigmf.ext.global.sensor.Amplifier;
import gov.doc.ntia.sigmf.ext.global.sensor.CalSource;
import gov.doc.ntia.sigmf.ext.global.sensor.Filter;
import gov.doc.ntia.sigmf.ext.global.sensor.Preselector;
import gov.doc.ntia.sigmf.ext.global.sensor.RfPath;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;
import java.util.ArrayList;
import java.util.Calendar;

/** Generates and example metadata file based NTIA SCOS system. */
public class ScosExample implements Example {

  public static Action getAction() {
    Action action = new Action();
    action.setName("acquire_m4s_700MHz_Verizon_UL");
    action.setDescription("Typically, this would be a detailed description.");
    action.setSummary("Apply m4s detector over 300 1024-pt FFTs at 782 MHz.");
    return action;
  }

  public static ScheduleEntry getScheduleEntry() {
    ScheduleEntry scheduleEntry = new ScheduleEntry();
    scheduleEntry.setId("m4_123");
    scheduleEntry.setName("M4 every Second");
    Calendar calendar = Calendar.getInstance();
    scheduleEntry.setStart(calendar.getTime());
    calendar.add(Calendar.DAY_OF_WEEK, 7);
    scheduleEntry.setStop(calendar.getTime());
    scheduleEntry.setInterval(1);
    scheduleEntry.setPriority(10);
    return scheduleEntry;
  }

  public static ArrayList<Extension> getExtensions() {
    ArrayList<Extension> extensions = new ArrayList<>();
    Extension scos = new Extension();
    scos.setName("ntia-scos");
    scos.setVersion("v1.0.0");
    scos.setOptional(true);
    extensions.add(scos);
    return extensions;
  }

  public static Sensor getSensor() {
    Sensor sensor = new Sensor();
    sensor.setId("Radar_Sensor_1");
    sensor.setAntenna(getAntenna());
    sensor.setPreselector(getPreselector());
    return sensor;
  }

  private static Antenna getAntenna() {
    HardwareSpec antSpec = new HardwareSpec();
    antSpec.setModel("ARA BSB-26");
    String description = "RF antenna ideally suited for reception of signals";
    description += " on the horizon for nautical and broadband surveillance applications";
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

  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setExtensions(getExtensions());
    global.setSchedule(getScheduleEntry());
    global.setAction(getAction());
    global.setTask(1);
    global.setRecording(1);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
