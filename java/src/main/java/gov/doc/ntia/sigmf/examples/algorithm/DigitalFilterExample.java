package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DigitalFilterExample implements Example {

  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setVersion("0.0.2");
    DigitalFilter digitalFilter = new DigitalFilter();
    Double[] firCoefficients = new Double[] {1.0, 4.0, 5.0, 3.2};

    digitalFilter.setFilterType("FIR");
    digitalFilter.setFirCoefficients(firCoefficients);
    digitalFilter.setFrequencyCutoff(7500000d);
    digitalFilter.setFrequencyStopband(7000000d);
    digitalFilter.setAttenuationStopband(-10d);
    digitalFilter.setRipplePassband(-5d);
    digitalFilter.setAttenuationCutoff(-6d);
    List<Annotation> annotations = new ArrayList();
    global.setAntiAliasingFilter(digitalFilter);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    metaDoc.setAnnotations(annotations);
    return metaDoc;
  }
}
