package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import java.util.ArrayList;

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
    ArrayList<DigitalFilter> filters = new ArrayList<DigitalFilter>();
    filters.add(digitalFilter);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
