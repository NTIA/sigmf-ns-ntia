package gov.doc.ntia.sigmf.examples.emitter;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.emitter.EmitterAnnotation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmitterAnnotationExample implements Example {

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        metaDoc.setGlobal(global);
        List<Annotation> annotations = new ArrayList<>();
        EmitterAnnotation emitterAnnotation = new EmitterAnnotation();
        emitterAnnotation.setId("emiter_1");
        emitterAnnotation.setSampleStart(0l);
        emitterAnnotation.setSampleCount(1024l);
        emitterAnnotation.setLatitude(40.5);
        emitterAnnotation.setLongitude(-105.7);

        EmitterAnnotation emitterAnnotation2 = new EmitterAnnotation();
        emitterAnnotation2.setId("emiter_1");
        emitterAnnotation2.setSampleStart(1024l);
        emitterAnnotation2.setSampleCount(1024l);
        emitterAnnotation2.setLatitude(41.5);
        emitterAnnotation2.setLongitude(-105.3);
        annotations.add(emitterAnnotation);
        annotations.add(emitterAnnotation2);

        metaDoc.setAnnotations(annotations);
        return metaDoc;

    }
}
