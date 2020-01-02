package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.annotation.location.LocationAnnotation;
import gov.doc.ntia.sigmf.ext.global.location.CoordinateSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SpeedAndBearingExample implements Example {
    @Override
    public MetaDoc getExample() {
        Date now = Calendar.getInstance().getTime();
        MetaDoc metadoc = new MetaDoc();

        Global global = ExampleUtils.getGlobal(now);
        List<Capture> captures = ExampleUtils.getCaptures(now);
        metadoc.setGlobal(global);
        metadoc.setCaptures(captures);

        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.setId("SpeedAndBearing_1");
        coordinateSystem.setDescription("System used for relative positioning in tunnels.");
        coordinateSystem.setDistanceUnit("miles");
        coordinateSystem.setTimeUnit("hours");
        coordinateSystem.setOrigin("Tunnel Entrance");
        coordinateSystem.setOrientationRef("Magnetic north");
        coordinateSystem.setElevationUnit("feet");
        coordinateSystem.setElevationRef("Tunnel Entrance");

        metadoc.getGlobal().setCoordinateSystem(coordinateSystem);

        LocationAnnotation a1 = new LocationAnnotation();
        a1.setSampleStart(0l);
        a1.setSampleCount(100l);
        a1.setSpeed(3.0);
        a1.setBearing(89.7);
        a1.setZ(-3.23);

        metadoc.addAnnotation(a1);

        return metadoc;
    }
}
