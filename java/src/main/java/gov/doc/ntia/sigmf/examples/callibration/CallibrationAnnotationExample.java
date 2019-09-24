package gov.doc.ntia.sigmf.examples.callibration;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.ext.annotation.sensor.CalibrationAnnotation;

import java.util.ArrayList;
import java.util.List;

public class CallibrationAnnotationExample implements Example {

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        List<Annotation> annotations = new ArrayList<>();
        CalibrationAnnotation cal = new CalibrationAnnotation();
        cal.setGainSigan(2.0);
        cal.setNoiseFigureSigan(1.0);
        cal.setOneDbCompressionPointSigan(12.0);
        cal.setEnbwSigan(2.0);
        cal.setGainPreselector(6.0);
        cal.setNoiseFigureSensor(5.0);
        cal.setOneDbCompressionPointSensor(20.0);
        cal.setEnbwSensor(3.0);
        cal.setMeanNoisePowerSensor(5.0);
        cal.setSampleCount(100l);
        cal.setSampleStart(0l);
        annotations.add(cal);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
