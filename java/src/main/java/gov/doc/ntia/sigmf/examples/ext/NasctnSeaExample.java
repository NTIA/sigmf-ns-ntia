package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;

import java.util.ArrayList;

public class NasctnSeaExample implements Example {

    public static Extension getExtension() {
        Extension extension = new Extension();
        extension.setName("ntia-nasctn-sea");
        extension.setVersion("v0.6.0");
        extension.setOptional(false);
        return extension;
    }
    
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal();
        global.addExtension(getExtension());
        global.setNumChannels(4L);

        ArrayList<Double> maxOfMax = new ArrayList<>();
        maxOfMax.add(-89.0);
        maxOfMax.add(-93.0);
        maxOfMax.add(-95.0);
        global.setMaxOfMaxChannelPowers(maxOfMax);

        ArrayList<Double> mean = new ArrayList<>();
        mean.add(-98.0);
        mean.add(-102.0);
        mean.add(-104.0);
        global.setMeanChannelPowers(mean);

        ArrayList<Double> median = new ArrayList<>();
        median.add(-98.5);
        median.add(-102.5);
        median.add(-104.5);
        global.setMedianChannelPowers(median);

        ArrayList<Double> medianOfMean = new ArrayList<>();
        medianOfMean.add(-99.0);
        medianOfMean.add(-103.0);
        medianOfMean.add(-105.0);
        global.setMedianOfMeanChannelPowers(medianOfMean);
        
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}
