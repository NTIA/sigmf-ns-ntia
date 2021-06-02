using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.location
{
    public class SimpleGCS : Example
    {
        public override MetaDoc getExample()
        {
            DateTime now = getCurrentTime();
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(now);
            List<Capture> captures = ExampleUtils.getCaptures(now);
            metaDoc.setGlobal(globals);
            metaDoc.setCaptures(captures);
            GeographicCoordinateSystem gcs = new GeographicCoordinateSystem();
            gcs.Id = "EPSG:4326";
            globals.CoordinateSystem = gcs;
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
