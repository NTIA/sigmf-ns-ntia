package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.algorithm.FilterTypeEnum;

import java.util.ArrayList;

public class DigitalFilterExample implements Example {
  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setVersion("1.0.0");
    DigitalFilter digitalFilter = new DigitalFilter();
    Double[] firCoefficients = new Double[] {1.0, 4.0, 5.0, 3.2};
    digitalFilter.setFilterType(FilterTypeEnum.FIR);
    digitalFilter.setFeedforwardCoefficients(firCoefficients);
    digitalFilter.setFrequencyCutoff(7500000d);
    digitalFilter.setAttenuationCutoff(-6d);
    ArrayList<DigitalFilter> filters = new ArrayList<DigitalFilter>();
    filters.add(digitalFilter);
    MetaDoc metaDoc = new MetaDoc();
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
