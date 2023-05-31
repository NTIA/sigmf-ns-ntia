package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.waveform.CodingRate;
import gov.doc.ntia.sigmf.ext.waveform.Ieee80211p;
import gov.doc.ntia.sigmf.ext.waveform.Waveform;

public class WaveformExample implements Example {
  
  public static Extension getExtension() {
    Extension extension = new Extension();
    extension.setName("ntia-waveform");
    extension.setVersion("v1.0.0");
    extension.setOptional(false);
    return extension;
  }

  public static Waveform getWaveform() {
    Waveform waveform = new Waveform();
    waveform.setModel("Example waveform type");
    waveform.setDescription("This is just an example description");
    return waveform;
  }
  
  public static Waveform getIeee80211pWaveform() {
    Ieee80211p waveform = new Ieee80211p();
    CodingRate codingRate = new CodingRate();
    codingRate.setK(1L);
    codingRate.setN(2L);
    waveform.setCodingRate(codingRate);
    waveform.setEncoder("convolutional");
    waveform.setInfoBitGeneration("infoBitGeneration");
    waveform.setModulation("16QAM");
    waveform.setNumberOfDataSubcarriers(48);
    waveform.setNumberOfSubcarriers(64L);
    waveform.setPacketLength(3200L);
    waveform.setNumberOfPilots(4);
    waveform.setShortInterFrameSpace(80000.0);
    waveform.setInfoBitGeneration("random");
    return waveform;
  }

  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    global.addExtension(getExtension());
    global.addExtension(WaveformExample.getExtension());

    Waveform waveform = getIeee80211pWaveform();

    Emitter emitter = new Emitter();
    emitter.setId("test80211pEmitter");
    emitter.setDescription("Test 80211p emitter");
    emitter.setWaveform(waveform);
    global.addEmitter(emitter);

    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
