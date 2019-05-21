package gov.doc.ntia.sigmf.examples.callibration;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.ext.annotation.callibration.CalibrationAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.callibration.SystemNoise;

import java.util.ArrayList;
import java.util.List;

public class CallibrationAnnotationExample implements Example {

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        List<Annotation> annotations = new ArrayList<>();
        CalibrationAnnotation calibrationAnnotation = new CalibrationAnnotation();
        calibrationAnnotation.setSampleCount(1024l);
        calibrationAnnotation.setSampleStart(0l);
        calibrationAnnotation.setReceiverLdbCompressionPoint(2.0);
        calibrationAnnotation.setReceiverScalingFactor(10.0);
        SystemNoise systemNoise = new SystemNoise();
        systemNoise.setMeanPowerDensity(2.0);
        systemNoise.setReference("antenna output");
        systemNoise.setUnits("dBm/Hz");
        calibrationAnnotation.setReceiverSystemNoisePower(systemNoise);
        annotations.add(calibrationAnnotation);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
