package gov.doc.ntia.sigmf.examples.environment;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.environment.SensorEnvironment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SensorEnvironmentExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        metaDoc.setGlobal(global);
        SensorEnvironment sensorEnvironment = new SensorEnvironment();
        sensorEnvironment.setCategory("indoor");
        sensorEnvironment.setSampleStart(0l);
        sensorEnvironment.setSampleCount(1024l);

        SensorEnvironment sensorEnvironment2 = new SensorEnvironment();
        sensorEnvironment2.setCategory("outdoor");
        sensorEnvironment2.setSampleCount(1024l);
        sensorEnvironment2.setSampleStart(1024l);

        List<Annotation> annotations = new ArrayList();
        annotations.add(sensorEnvironment);
        annotations.add(sensorEnvironment2);

        metaDoc.setAnnotations(annotations);
        return metaDoc;

    }
}
