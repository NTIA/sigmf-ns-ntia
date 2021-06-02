using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.location
{
    class GcsWithSpheroidExample : Example
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
            Datum datum = new Datum();
            Spheroid spheroid = new Spheroid();
            spheroid.Semimajor = 6378137.0;
            spheroid.Semiminor = 6356752.3142;
            spheroid.Flattening = 1 / (298.257223563);
            spheroid.PrimeMeridian = "Greenwich";
            spheroid.MeridianOffset = 0.0;
            datum.Spheroid = spheroid;
            gcs.Datum = datum;
            gcs.Description = "World Geodetic System 1984 - Horizontal component of 3D system. Used by the GPS satellite navigation system and for NATO military geodetic surveying.";

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
