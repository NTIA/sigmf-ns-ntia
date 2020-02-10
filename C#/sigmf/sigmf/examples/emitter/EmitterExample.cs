using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.emitter
{
    public class EmitterExample : Example
    {
       public override MetaDoc getExample()
        {
            MetaDoc metaDoc = new MetaDoc();
            Emitter emitter = new Emitter();
            emitter.Id = "EmitterXYZ";
            emitter.Description = "A fictitious emitter to demonstrate the extensions format.";
            emitter.Power = -60.0;
            Globals globals = ExampleUtils.getGlobals(getCurrentTime());
            List<Emitter> emitters = new List<Emitter>();
            emitters.Add(emitter);
            globals.Emitters = emitters;
            metaDoc.setGlobal(globals);
            return metaDoc;
        }
        private DateTime getCurrentTime()
        {
            DateTime st = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            TimeSpan t = (DateTime.Now.ToUniversalTime() - st);
            return st;
        }
    }
}
