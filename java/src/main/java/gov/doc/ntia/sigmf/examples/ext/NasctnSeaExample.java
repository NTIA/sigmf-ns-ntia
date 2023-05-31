package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;

import java.util.ArrayList;

public class NasctnSeaExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();

        ArrayList<Double> maxOfMax = new ArrayList<>();
        maxOfMax.add(-89.0);
        maxOfMax.add(-93.0);
        maxOfMax.add(-95.0);
        maxOfMax.add(-87.0);
        global.setMaxOfMaxChannelPowers(maxOfMax);

        ArrayList<Double> medianOfMean = new ArrayList<>();
        medianOfMean.add(-99.0);
        medianOfMean.add(-103.0);
        medianOfMean.add(-105.0);
        medianOfMean.add(-97.0);
        global.setMedianOfMeanChannelPowers(medianOfMean);
        
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}
