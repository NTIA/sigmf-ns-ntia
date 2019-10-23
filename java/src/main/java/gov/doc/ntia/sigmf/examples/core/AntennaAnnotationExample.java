package gov.doc.ntia.sigmf.examples.core;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.ext.annotation.core.AntennaAnnotation;

import java.util.ArrayList;
import java.util.List;

public class AntennaAnnotationExample implements Example {
    @Override
    public MetaDoc getExample() {
       MetaDoc metaDoc = new MetaDoc();
        List<Annotation> annotations = new ArrayList<>();
        AntennaAnnotation antennaAnnotation = new AntennaAnnotation();
        antennaAnnotation.setId("antenna1");
        antennaAnnotation.setAzimuthAngle(15.0);
        antennaAnnotation.setElevationAngle(20.0);
        antennaAnnotation.setSampleCount(1024l);
        antennaAnnotation.setSampleStart(0l);
        annotations.add(antennaAnnotation);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
