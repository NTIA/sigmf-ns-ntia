package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.algorithm.DFT;
import gov.doc.ntia.sigmf.ext.algorithm.FilterTypeEnum;
import gov.doc.ntia.sigmf.ext.algorithm.Graph;
import java.util.ArrayList;

public class DataProductsExample implements Example {
  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setVersion("1.0.0");

    DigitalFilter digitalFilter = new DigitalFilter();
    digitalFilter.setId("iir_1");
    digitalFilter.setFilterType(FilterTypeEnum.IIR);
    Double[] firCoefficients =
        new Double[] {
          0.22001755985277486,
          1.8950858799155859,
          8.083698129129007,
          22.28438408611688,
          43.93585109754826,
          65.02462875088665,
          73.93117717291233,
          65.02462875088665,
          43.93585109754826,
          22.284384086116878,
          8.083698129129007,
          1.8950858799155853,
          0.22001755985277483
        };
    digitalFilter.setFeedforwardCoefficients(firCoefficients);
    Double[] iirFeedbackCoefficients =
        new Double[] {
          1.0,
          5.984606843057637,
          19.199454663117217,
          40.791247158352408,
          63.2429677473874,
          74.33110989910304,
          67.69826765401139,
          47.873252810169407,
          26.149624421307168,
          10.75285488653393,
          3.2164061393115994,
          0.6363986832562693,
          0.07408086875619748
        };
    digitalFilter.setfeedbackCoefficients(iirFeedbackCoefficients);
    digitalFilter.setFrequencyCutoff(5000000.0);

    Graph psd = new Graph();
    psd.addSeries("max");
    psd.addSeries("mean");
    psd.setLength(625);
    psd.setYUnits("dBm/Hz");
    psd.setReference("noise source output");
    DFT fft = new DFT();
    fft.setEquivalentNoiseBandwidth(60323.94);
    // psd.setSamples(875L);
    fft.setDfts(64000);
    fft.setWindow("flattop");
    MetaDoc metaDoc = new MetaDoc();
    global.addDataProduct(psd);

    Graph tsp = new Graph();
    tsp.setLength(400);
    // tsp.setSamples(56000000L);
    tsp.setYUnits("dBm");
    tsp.addSeries("max");
    tsp.addSeries("mean");
    tsp.setReference("noise source output");
    global.addDataProduct(tsp);

    Graph pfp = new Graph();
    pfp.addSeries("mean of min");
    pfp.addSeries("mean of max");
    pfp.addSeries("mean of mean");
    pfp.addSeries("max of min");
    pfp.addSeries("max of max");
    pfp.addSeries("max of mean");
    pfp.setLength(560);
    pfp.setYUnits("dBm");
    pfp.setReference("noise source output");
    global.addDataProduct(pfp);

    Graph apd = new Graph();
    apd.setLength(560);
    apd.setYUnits("dBm");
    ArrayList<Double> yStep = new ArrayList();
    yStep.add(1.0);
    apd.setYStep(yStep);
    apd.setReference("noise source output");
    ArrayList<Double> yStop = new ArrayList<>();
    yStop.add(-85.0);
    apd.setYStop(yStop);
    ArrayList<Double> yStart = new ArrayList<>();
    yStart.add(-130.0);
    global.addProcessingInfo(digitalFilter);
    global.addDataProduct(apd);
    global.addProcessing(digitalFilter.getId());
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
