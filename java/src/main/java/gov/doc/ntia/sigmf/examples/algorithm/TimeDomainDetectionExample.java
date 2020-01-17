package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.TimeDomainDetection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeDomainDetectionExample implements Example {

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        List<Annotation> annotations = new ArrayList();

        TimeDomainDetection tdd = new TimeDomainDetection();
        tdd.setNumberOfSamples(1024l);
        tdd.setSampleStart(0l);
        tdd.setDetector("mean");
        tdd.setSampleCount(1024l);
        tdd.setUnits("dBm");
        tdd.setReference("antenna output");
        annotations.add(tdd);
        metaDoc.setGlobal(global);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}
