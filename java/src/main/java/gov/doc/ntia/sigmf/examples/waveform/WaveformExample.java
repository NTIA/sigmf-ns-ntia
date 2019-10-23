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
        emitter.setId("EmitterXYZ");
        emitter.setDescription("A fictitious emitter to demonstrate the extensions format.");
        emitter.setPower(-60.0);
        Waveform waveform = getWaveform();
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
        codingRate.setK(4l);
        codingRate.setN(3l);
        waveform.setCodingRate(codingRate);
        waveform.setCyclicPrefix(3l);
        waveform.setEncoder("encoder");
        waveform.setInfoBitGeneration("infoBitGeneration");
        waveform.setModulation("modulation");
        waveform.setNumberOfDataSubcarriers(4l);
        waveform.setPacketLength(4l);
        waveform.setNumberOfInfoBits(5l);
        waveform.setNumberOfSubcarriers(4l);
        waveform.setNumberOfPilots(4l);
        waveform.setShortInterFrameSpace(4d);
        waveform.setPreambleFrame(new Integer[]{0,1});
        waveform.setSignalToNoiseRation(4d);
        return waveform;
    }
}
