package gov.doc.ntia.sigmf.examples.environment;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;
import java.util.Calendar;

public class SensorEnvironmentExample implements Example {
  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    metaDoc.setGlobal(global);
    Sensor sensor = new Sensor();
    Environment sensorEnvironment = new Environment();
    sensorEnvironment.setCategory("outdoor");
    sensor.setEnvironment(sensorEnvironment);
    global.setSensor(sensor);
    return metaDoc;
  }
}
