package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.scos.Action;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;

import java.text.SimpleDateFormat;
import java.util.*;

public class ExampleUtils {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public  static List<Capture> getCaptures(Date dateTime) {
        ArrayList<Capture> captures = new ArrayList<>();
        int sampleStart=0;
        Capture capture = new Capture();
        capture.setSampleStart(0);
        capture.setDateTime(dateTime);
        capture.setFrequency(700000000.);
        captures.add(capture);
        return captures;
    }



    public static Global getGlobal(Date date) {
        Global global = new Global();
        global.setDatatype("rf32_le");
        global.setSampleRate(2.8E7);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        c.setTimeInMillis(c.getTimeInMillis() + 30000);
        return global;

    }

    private Sensor getSensor(String id) {
        Sensor sensor = new Sensor();
        sensor.setId(id);
        sensor.setAntenna(getAntenna());
        return sensor;
    }


    public static Antenna getAntenna() {
        Antenna antenna = new Antenna();
        HardwareSpec spec = new HardwareSpec();
        spec.setModel("model xyz");
        antenna.setAntennaSpec(spec);
        return antenna;
    }
    private Action getAction(){
        Action action = new Action();
        action.setName("M4");
        return action;
    }

}
