package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.TimeDomainDetection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FrequencyDomainDetectionExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        List<Annotation> annotations = new ArrayList();
        FrequencyDomainDetection fdd = new FrequencyDomainDetection();
        fdd.setNumberOfSamplesInFft(1024);
        fdd.setSampleStart(0l);
        fdd.setDetector("fft_mean_power");
        fdd.setDetectionDomain("frequency");
        fdd.setSampleCount(1024l);
        fdd.setReference("antenna output");
        annotations.add(fdd);

        FrequencyDomainDetection fdd2 = new FrequencyDomainDetection();
        fdd2.setNumberOfSamplesInFft(1024);
        fdd2.setSampleStart(1024l);
        fdd2.setDetector("fft_max_power");
        fdd2.setDetectionDomain("frequency");
        fdd2.setSampleCount(1024l);
        fdd2.setReference("antenna output");
        annotations.add(fdd2);
        metaDoc.setGlobal(global);
        metaDoc.setAnnotations(annotations);
        return metaDoc;
    }
}

