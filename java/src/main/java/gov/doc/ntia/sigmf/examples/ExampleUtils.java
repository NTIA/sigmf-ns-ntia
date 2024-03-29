package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.examples.ext.CoreExample;
import gov.doc.ntia.sigmf.ext.core.Antenna;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExampleUtils {

  public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

  /**
   * Generates an example Capture.
   *
   * @param dateTime The Date of the Capture.
   * @return A List containing one Capture at dateTime.
   */
  public static List<Capture> getCaptures(Date dateTime) {
    int sampleStart = 0;
    Capture capture = new Capture();
    capture.setSampleStart(sampleStart);
    capture.setDateTime(dateTime);
    capture.setFrequency(700000000.);
    ArrayList<Capture> captures = new ArrayList<>();
    captures.add(capture);
    return captures;
  }

  /**
   * Generates a bare bones Global object with data type rf32_le, sample_rate = 2.8E7, and version 1.0.0.
   *
   * @return Global object.
   */
  public static Global getGlobal() {
    Global global = new Global();
    global.setDatatype("rf32_le");
    global.setSampleRate(2.8E7);
    global.setVersion("1.0.0");
    global.addExtension(CoreExample.getExtension());
    global.setClassification("UNCLASSIFIED");
    return global;
  }

  /**
   * Generates a bare bones Antenna object with an AntennaSpec with model = 'model xyz'.
   *
   * @return Antenna object.
   */
  public static Antenna getAntenna() {
    Antenna antenna = new Antenna();
    HardwareSpec spec = new HardwareSpec();
    spec.setModel("model xyz");
    antenna.setAntennaSpec(spec);
    return antenna;
  }

  /**
   * Generates a Date object with the current datetime.
   */
  public static Date getDatetimeNow() {
    Date now = Calendar.getInstance().getTime();
    return now;
  }
}
