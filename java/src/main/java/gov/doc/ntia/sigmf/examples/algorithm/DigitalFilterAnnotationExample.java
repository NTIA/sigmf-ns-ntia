package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.DigitalFilterAnnotation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DigitalFilterAnnotationExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        global.setVersion("0.0.2");
        DigitalFilterAnnotation digitalFilter = new DigitalFilterAnnotation();
        Double[] FIRcoefficients = new Double[]{1.0, 4.0,5.0,3.2};
        digitalFilter.setSampleCount(1000l);
        digitalFilter.setSampleStart(0l);
        digitalFilter.setFilterType("FIR");
        digitalFilter.setFirCoefficients(FIRcoefficients);
        digitalFilter.setFrequencyCutoff(7500000d);
        digitalFilter.setFrequencyStopband(7000000d);
        digitalFilter.setAttenuationStopband(-10d);
        digitalFilter.setRipplePassband(-5d);
        digitalFilter.setAttenuationCutoff(-6d);
        List<Annotation> annotations = new ArrayList();
        annotations.add(digitalFilter);
        metaDoc.setGlobal(global);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
