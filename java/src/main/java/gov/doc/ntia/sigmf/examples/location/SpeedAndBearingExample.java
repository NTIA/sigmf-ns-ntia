package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.location.CoordinateSystem;
import gov.doc.ntia.sigmf.ext.global.location.Location;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;

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


        Sensor sensor = new Sensor();
        sensor.setId("Greyhound 10");
        Location location = new Location();
        location.setSpeed(35.0);
        location.setBearing(90.0);
        location.setX(0d);
        location.setY(0d);
        location.setZ(0d);

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
        global.setSensor(sensor);


        return metadoc;
    }
}
