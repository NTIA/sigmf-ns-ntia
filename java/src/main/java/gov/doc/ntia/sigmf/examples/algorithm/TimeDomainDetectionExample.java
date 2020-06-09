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

    TimeDomainDetection tdd = new TimeDomainDetection();
    tdd.setNumberOfSamples(1024L);
    tdd.setSampleStart(0L);
    tdd.setDetector("mean");
    tdd.setSampleCount(1024L);
    tdd.setUnits("dBm");
    tdd.setReference("antenna output");
    List<Annotation> annotations = new ArrayList();
    annotations.add(tdd);
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    metaDoc.setGlobal(global);
    metaDoc.setAnnotations(annotations);
    return metaDoc;
  }
}
