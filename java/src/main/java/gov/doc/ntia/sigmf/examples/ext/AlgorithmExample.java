package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.algorithm.DFT;
import gov.doc.ntia.sigmf.ext.algorithm.FilterTypeEnum;
import gov.doc.ntia.sigmf.ext.algorithm.Graph;

public class AlgorithmExample implements Example {

  public static Extension getExtension() {
    Extension extension = new Extension();
    extension.setName("ntia-algorithm");
    extension.setVersion("v2.0.0");
    extension.setOptional(false);
    return extension;
  }

  /** Generates an example IIR filter object. */
  public static DigitalFilter getIIRFilter(String id) {
    DigitalFilter filter = new DigitalFilter();
    filter.setId(id);
    filter.setFilterType(FilterTypeEnum.IIR);
    Double[] feedforwardCoefficients = new Double[] {
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
    Double[] feedbackCoefficients = new Double[] {
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
    filter.setFeedforwardCoefficients(feedforwardCoefficients);
    filter.setFeedbackCoefficients(feedbackCoefficients);
    filter.setAttenuationCutoff(80.0);
    filter.setFrequencyCutoff(5008000.0);
    filter.setDescription("An example IIR 5 MHz lowpass filter");
    return filter;
  }

  /** Generates an example FIR filter object. */
  public static DigitalFilter getFIRFilter(String id) {
    DigitalFilter filter = new DigitalFilter();
    filter.setId(id);
    filter.setFilterType(FilterTypeEnum.FIR);
    Double[] feedforwardCoefficients = new Double[] {2.5, 4.5, 6.5, 8.5};
    filter.setFeedforwardCoefficients(feedforwardCoefficients);
    filter.setAttenuationCutoff(80.0);
    filter.setFrequencyCutoff(720000000d);
    filter.setDescription("An example FIR filter with nonsensical metadata");
    return filter;
  }

  /** Generates an example DFT object. */
  public static DFT getDFT(String id) {
    DFT dft = new DFT();
    dft.setId(id);
    dft.setEquivalentNoiseBandwidth(51546.33);
    dft.setSamples(875);
    dft.setBaseband(true);
    dft.setDfts(1000);
    dft.setWindow("flattop");
    dft.setDescription("An example DFT object for 1000x 875-sample DFTs, using the flat top window and providing amplitudes at baseband frequencies.");
    return dft;
  }

  public static Graph<Double, Double> getMeanMaxPowerSpectralDensityGraph() {
    Graph<Double, Double> psd = new Graph<>();
    psd.setName("power_spectral_density");
    psd.setDescription("Power spectral density with first and last 125 samples removed, computed from filtered data");
    DFT dft = getDFT("psd_fft");
    psd.addProcessing(dft.getId());
    psd.setLength(625);
    psd.addSeries("max");
    psd.addSeries("mean");
    psd.setXUnits("Hz");
    psd.addXStart(-4992000.0);
    psd.addXStop(4992000.0);
    psd.addXStep(16000.0);
    psd.setYUnits("dBm/Hz");
    psd.setReference("calibration terminal");
    return psd;
  }

  public static Graph<Double, Double> getM4SGraph() {
    Graph<Double, Double> m4s = new Graph<>();
    m4s.setName("m4s_result");
    m4s.setDescription("M4S detector computed from filtered data");
    DFT dft = getDFT("m4s_ffts");
    m4s.addProcessing(dft.getId());
    m4s.setLength(875);
    m4s.addSeries("max");
    m4s.addSeries("mean");
    m4s.addSeries("median");
    m4s.addSeries("min");
    m4s.addSeries("samples");
    m4s.setXUnits("Hz");
    m4s.addXStart(-6992000.0);
    m4s.addXStop(6992000.0);
    m4s.addXStep(16000.0);
    m4s.setYUnits("dBm");
    m4s.setReference("calibration terminal");
    return m4s;
  }

  public static Graph<Double, Double> getPowerVsTimeGraph() {
    Graph<Double, Double> pvt = new Graph<>();
    pvt.setName("power_vs_time");
    pvt.setDescription("Time series mean and max power computed from filtered data");
    pvt.addSeries("max");
    pvt.addSeries("mean");
    pvt.setLength(400);
    pvt.setXUnits("ms");
    pvt.addXStart(0.0);
    pvt.addXStop(4000.0);
    pvt.addXStep(10.0);
    pvt.setYUnits("dBm");
    pvt.setReference("calibration terminal");
    return pvt;
  }

  public static Graph<Double, Double> getPeriodicFramePowerGraph() {
    Graph<Double, Double> pfp = new Graph<>();
    pfp.setName("periodic_frame_power");
    pfp.setDescription("Periodic frame power with (min, max, mean) of mean and max detectors");
    pfp.addSeries("max-of-max");
    pfp.addSeries("mean-of-max");
    pfp.addSeries("min-of-max");
    pfp.addSeries("max-of-mean");
    pfp.addSeries("mean-of-mean");
    pfp.addSeries("min-of-mean");
    pfp.setLength(560);
    pfp.setXUnits("ms");
    pfp.setYUnits("dBm");
    pfp.addXStart(0.0);
    pfp.addXStop(10.0);
    pfp.addXStep(0.01785714285);
    pfp.setReference("calibration terminal");
    return pfp;
  }

  public static Graph<Double, Double> getAmplitudeProbabilityDistributionGraph() {
    Graph<Double, Double> apd = new Graph<>();
    apd.setName("amplitude_probability_distribution");
    apd.setDescription("Downsampled APD with 1 dBm bins");
    apd.setLength(151);
    apd.setXUnits("percent");
    apd.setYUnits("dBm");
    apd.addYStart(-180.0);
    apd.addYStop(-30.0);
    apd.addYStep(1.0);
    apd.setReference("calibration terminal");
    return apd;
  }

  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    global.addExtension(getExtension());

    DigitalFilter digitalFilter = getIIRFilter("iir_1");
    DFT fft = getDFT("psd_fft");
    Graph<Double, Double> psd = getMeanMaxPowerSpectralDensityGraph();
    Graph<Double, Double> pvt = getPowerVsTimeGraph();
    Graph<Double, Double> pfp = getPeriodicFramePowerGraph();
    Graph<Double, Double> apd = getAmplitudeProbabilityDistributionGraph();
    global.addDataProduct(psd);
    global.addDataProduct(pvt);
    global.addDataProduct(pfp);
    global.addDataProduct(apd);
    global.addProcessingInfo(fft);
    global.addProcessingInfo(digitalFilter);
    global.addProcessing(digitalFilter.getId());

    metaDoc.setGlobal(global);
    return metaDoc;
  }
}