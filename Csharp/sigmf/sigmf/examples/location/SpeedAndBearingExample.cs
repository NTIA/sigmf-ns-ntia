using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.examples.location
{
    public class SpeedAndBearingExample : Example
    {
        public override MetaDoc getExample()
        {
            DateTime now = getCurrentTime();
            MetaDoc metaDoc = new MetaDoc();
            Globals globals = ExampleUtils.getGlobals(now);
            List<Capture> captures = ExampleUtils.getCaptures(now);
            metaDoc.setGlobal(globals);
            metaDoc.setCaptures(captures);

            CoordinateSystem coordinateSystem = new CoordinateSystem();
            coordinateSystem.Id = "SpeedAndBearing_1";
            coordinateSystem.Description = "System used for relative positioning in tunnels.";
            coordinateSystem.DistanceUnit = "miles";
            coordinateSystem.TimeUnit = "hours";
            coordinateSystem.Origin = "Tunnel Entrance";
            coordinateSystem.OrientationRef = "Magnetic north";
            coordinateSystem.ElevationUnit = "feet";
            coordinateSystem.ElevationRef = "Tunnel Entrance";

            (metaDoc.getGlobal()).CoordinateSystem = coordinateSystem;

            LocationAnnotation a1 = new LocationAnnotation();
            a1.SampleStart = 01;
            a1.SampleCount = 1001;
            a1.Speed = 3.0;
            a1.Bearing = 89.7;
            a1.Z = -3.23;

            metaDoc.addAnnotation(a1);

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
