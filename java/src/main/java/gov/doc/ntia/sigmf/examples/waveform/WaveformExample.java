package gov.doc.ntia.sigmf.examples.waveform;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.global.waveform.CodingRate;
import gov.doc.ntia.sigmf.ext.global.waveform.IEEE80211p;
import gov.doc.ntia.sigmf.ext.global.waveform.Waveform;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WaveformExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Emitter emitter = new Emitter();
        emitter.setId("test80211pEmitter");
        emitter.setDescription("Test 80211p emitter");
        Waveform waveform = getWaveform();
        emitter.setWaveform(waveform);
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        List<Emitter> emitters = new ArrayList<>();
        emitters.add(emitter);
        global.setEmitters(emitters);
        metaDoc.setGlobal(global);
        return metaDoc;
    }

    private static Waveform getWaveform() {
        IEEE80211p waveform = new IEEE80211p();
        CodingRate codingRate = new CodingRate();
        codingRate.setK(1l);
        codingRate.setN(2l);
        waveform.setCodingRate(codingRate);
        waveform.setEncoder("convolutional");
        waveform.setInfoBitGeneration("infoBitGeneration");
        waveform.setModulation("16QAM");
        waveform.setNumberOfDataSubcarriers(48);
        waveform.setNumberOfSubcarriers(64l);
        waveform.setPacketLength(3200l);
        waveform.setNumberOfPilots(4);
        waveform.setShortInterFrameSpace(80000.0);
        waveform.setInfoBitGeneration("random");
        return waveform;
    }
}
