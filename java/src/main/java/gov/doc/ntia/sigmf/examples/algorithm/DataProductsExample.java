package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.global.algorithm.FFT;
import gov.doc.ntia.sigmf.ext.global.algorithm.Graph;import java.util.ArrayList;

public class DataProductsExample implements Example {
  @Override
  public MetaDoc getExample() {
    Global global = ExampleUtils.getGlobal();
    global.setVersion("0.0.2");

    DigitalFilter digitalFilter = new DigitalFilter();
    digitalFilter.setId("iir_1");
    digitalFilter.setFilterType("IIR");
    Double[] firNumeratorCoefficients =
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
    digitalFilter.setIirNumeratorCoefficients(firNumeratorCoefficients);
    Double[] iirDenomCoefficients =
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
    digitalFilter.setIirDenominatorCoefficients(iirDenomCoefficients);
    digitalFilter.setFrequencyCutoff(5000000.0);
    digitalFilter.setRipplePassband(0.1);
    digitalFilter.setAttenuationStopband(40.0);
    digitalFilter.setFrequencyStopband(5008000.0);

    Graph psd = new Graph();
    psd.addSeries("max");
    psd.addSeries("mean");
    psd.setLength(625L);
    FFT fft = new FFT();
    fft.setEquivalentNoiseBandwidth(60323.94);
    //psd.setSamples(875L);
    fft.setFfts(64000);
    fft.setUnits("dBm/Hz");
    fft.setWindow("flattop");
    MetaDoc metaDoc = new MetaDoc();
    global.addDataProduct(psd);

    Graph tsp = new Graph();
    tsp.setLength(400L);
    //tsp.setSamples(56000000L);
    tsp.setYLabel("dBm");
    tsp.addSeries("max");
    tsp.addSeries("mean");


    global.addDataProduct(tsp);

    Graph pfp = new Graph();
    pfp.addSeries("mean of min");
    pfp.addSeries("mean of max");
    pfp.addSeries("mean of mean");
    pfp.addSeries("max of min");
    pfp.addSeries("max of max");
    pfp.addSeries("max of mean");
    pfp.setLength(560L);
    pfp.setYLabel("dBm");
    global.addDataProduct(pfp);

    Graph apd = new Graph();
    apd.setLength(560L);
    apd.setYLabel("dBm");
    ArrayList<Double> yStep = new ArrayList();
    yStep.add(1.0);
    apd.setYStep(yStep);
    ArrayList<Double> yStop = new ArrayList<>();
    yStop.add(-85.0);
    apd.setYStop(yStop);
    ArrayList<Double> yStart = new ArrayList<>();
    yStart.add(-130.0);
    global.addDigitalFilter(digitalFilter);
    global.addDataProduct(apd);
    global.addDataProductProcessing("iir_1");
    global.setDataProductsReference("noise source output");
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
