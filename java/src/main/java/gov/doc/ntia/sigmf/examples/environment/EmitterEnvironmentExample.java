package gov.doc.ntia.sigmf.examples.environment;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import java.util.ArrayList;
import java.util.Calendar;

public class EmitterEnvironmentExample implements Example {
  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    metaDoc.setGlobal(global);

    Emitter emitter = new Emitter();
    emitter.setId("EmitterXYZ");
    emitter.setDescription("A fictitious emitter to demonstrate the extensions format.");
    emitter.setPower(-60.0);
    Environment env = new Environment();
    env.setCategory("outdoor-urban");
    emitter.setEnvironment(env);
    ArrayList<Emitter> emitters = new ArrayList<>();
    emitters.add(emitter);
    global.setEmitters(emitters);

    return metaDoc;
  }
}
