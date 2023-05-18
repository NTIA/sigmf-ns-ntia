package gov.doc.ntia.sigmf.examples.algorithm;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.algorithm.AmplitudeProbabilityDistribution;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.global.algorithm.PeriodicFramePower;
import gov.doc.ntia.sigmf.ext.global.algorithm.PowerSpectralDensity;
import gov.doc.ntia.sigmf.ext.global.algorithm.TimeSeriesPower;
import gov.doc.ntia.sigmf.ext.global.algorithm.Trace;

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

    PowerSpectralDensity psd = new PowerSpectralDensity();
    Trace max = new Trace();
    max.setStatistic("max");
    psd.addTrace(max);
    Trace mean = new Trace();
    mean.setStatistic("mean");
    psd.addTrace(mean);
    psd.setLength(625L);
    psd.setEquivalentNoiseBandwidth(60323.94);
    psd.setSamples(875L);
    psd.setFfts(64000);
    psd.setUnits("dBm/Hz");
    psd.setWindow("flattop");
    MetaDoc metaDoc = new MetaDoc();
    global.addDataProduct(psd);

    TimeSeriesPower tsp = new TimeSeriesPower();
    tsp.setLength(400L);
    tsp.setSamples(56000000L);
    tsp.setUnits("dBm");
    Trace maxTsp = new Trace();
    maxTsp.setDetector("max");
    Trace meanTsp = new Trace();
    meanTsp.setDetector("mean");
    tsp.addTrace(maxTsp);
    tsp.addTrace(meanTsp);

    global.addDataProduct(tsp);

    PeriodicFramePower pfp = new PeriodicFramePower();
    Trace rmsMin = new Trace("mean", "min");
    pfp.addTrace(rmsMin);
    Trace rmsMax = new Trace("mean", "max");
    pfp.addTrace(rmsMax);
    Trace rmsMean = new Trace("mean", "mean");
    pfp.addTrace(rmsMean);
    Trace peakMin = new Trace("max", "min");
    pfp.addTrace(peakMin);
    Trace peakMax = new Trace("max", "max");
    pfp.addTrace(peakMax);
    Trace peakMean = new Trace("max", "mean");
    pfp.addTrace(peakMean);
    pfp.setLength(560L);
    pfp.setUnits("dBm");
    global.addDataProduct(pfp);

    AmplitudeProbabilityDistribution apd = new AmplitudeProbabilityDistribution();
    apd.setLength(560L);
    apd.setSamples(56000000L);
    apd.setUnits("dBm");
    apd.setAmplitudeBinSize(1.0);
    apd.setMaxAmplitude(-85.0);
    apd.setMinAmplitude(-130.0);
    global.addDigitalFilter(digitalFilter);
    global.addDataProduct(apd);
    global.setDataProductsFilter("iir_1");
    global.setDataProductsReference("noise source output");
    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
