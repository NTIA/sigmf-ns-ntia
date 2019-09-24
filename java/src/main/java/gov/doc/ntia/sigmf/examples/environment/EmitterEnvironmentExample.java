package gov.doc.ntia.sigmf.examples.environment;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.environment.EmitterEnvironment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmitterEnvironmentExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        metaDoc.setGlobal(global);

        EmitterEnvironment emitterEnvironment = new EmitterEnvironment();
        emitterEnvironment.setEmitter_id("emitter_123");
        emitterEnvironment.setSampleCount(1024l);
        emitterEnvironment.setSampleCount(0l);
        emitterEnvironment.setCategory("outdoor-urban");

        EmitterEnvironment emitterEnvironment2 = new EmitterEnvironment();
        emitterEnvironment2.setEmitter_id("emitter_123");
        emitterEnvironment2.setSampleStart(1024l);
        emitterEnvironment2.setSampleCount(1024l);
        emitterEnvironment2.setCategory("indoor");

        List<Annotation> annotations = new ArrayList();
        annotations.add(emitterEnvironment);
        annotations.add(emitterEnvironment2);

        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
