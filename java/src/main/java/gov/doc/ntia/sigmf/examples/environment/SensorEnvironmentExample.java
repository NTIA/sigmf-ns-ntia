package gov.doc.ntia.sigmf.examples.environment;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import gov.doc.ntia.sigmf.ext.sensor.Sensor;

public class SensorEnvironmentExample implements Example {
  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    metaDoc.setGlobal(global);
    Sensor sensor = new Sensor();
    sensor.setId("ExampleSensor");
    Environment sensorEnvironment = new Environment();
    sensorEnvironment.setCategory("outdoor");
    sensor.setEnvironment(sensorEnvironment);
    global.setSensor(sensor);
    return metaDoc;
  }
}
