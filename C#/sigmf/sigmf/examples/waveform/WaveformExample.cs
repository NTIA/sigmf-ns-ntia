using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.waveform
{
    public class WaveformExample : Example
    {
        public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Emitter emitter = new Emitter();
            emitter.Id = "EmitterXYZ";
            emitter.Description = "A fictitious emitter to demonstrate the extensions format.";
            emitter.Power = -60.0;
            IEEE80211p waveform = getWaveform();
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            List<Emitter> emitters = new List<Emitter>();
            emitters.Add(emitter);
            globals.Emitters = emitters;
            metaDoc.setGlobal(globals);
            return metaDoc;
        }
        private static IEEE80211p getWaveform()
        {
            IEEE80211p waveform = new IEEE80211p();
            CodingRate codingRate = new CodingRate();
            codingRate.setK(4l);
            codingRate.setN(3l);
            waveform.CodingRate = codingRate;
            waveform.CyclicPrefix = 3l;
            waveform.Encoder = "encoder";
            waveform.InfoBitGeneration = "infoBitGeneration";
            waveform.Modulation = "modulation";
            waveform.NumberOfSubcarriers = 4l;
            waveform.PacketLength = 4l;
            waveform.NumberOfInfoBits = 5l;
            waveform.NumberOfDataSubcarriers = 4l;
            waveform.NumberOfPilots = 4l;
            waveform.ShortInterFrameSpace = 4d;
            waveform.PreambleFrame = new List<int> { 0, 1 };
            waveform.SignalToNoiseRation = 4d;

            return waveform;
        }
        private DateTime getCurrentTime()
        {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            return st;
        }
    }
}
