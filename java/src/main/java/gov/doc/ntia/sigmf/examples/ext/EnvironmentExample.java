package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.environment.Environment;
import gov.doc.ntia.sigmf.ext.sensor.Sensor;

public class EnvironmentExample implements Example {

  public static Environment getEnvironment() {
    Environment env = new Environment();
    env.setCategory("outdoor");
    env.setTemperature(100.0);
    env.setHumidity(50.0);
    env.setWeather("overcast");
    env.setDescription("A fake example environment");
    return env;
  }

  /**
   * Generate an example metadoc with a sensor and emitter, each with an environment object.
   */
  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    metaDoc.setGlobal(global);

    Emitter emitter = new Emitter();
    emitter.setId("EmitterXYZ");
    emitter.setDescription("A fictitious emitter to demonstrate the extensions format.");
    emitter.setPower(-60.0);
    Environment env = getEnvironment();
    emitter.setEnvironment(env);
    global.addEmitter(emitter);

    // getSensor uses getEnvironment from above
    Sensor sensor = SensorExample.getSensor();
    global.setSensor(sensor);

    return metaDoc;
  }
}
