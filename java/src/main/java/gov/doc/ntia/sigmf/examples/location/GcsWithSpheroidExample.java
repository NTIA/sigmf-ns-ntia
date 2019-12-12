package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.location.Datum;
import gov.doc.ntia.sigmf.ext.global.location.GeographicCoordinateSystem;
import gov.doc.ntia.sigmf.ext.global.location.SpatialReference;
import gov.doc.ntia.sigmf.ext.global.location.Spheroid;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GcsWithSpheroidExample implements Example {
    @Override
    public MetaDoc getExample() {
        Date now = Calendar.getInstance().getTime();
        MetaDoc metadoc = new MetaDoc();

        Global global = ExampleUtils.getGlobal(now);
        List<Capture> captures = ExampleUtils.getCaptures(now);
        metadoc.setGlobal(global);
        metadoc.setCaptures(captures);
        GeographicCoordinateSystem gcs = new GeographicCoordinateSystem();
        gcs.setId("EPSG:4326");
        Datum datum = new Datum();


        gcs.setPrimeMeridian("Greenwich");

        Spheroid spheroid = new Spheroid();
        spheroid.setSemimajor(6378137.0);
        spheroid.setSemiminor(6356752.3142);
        spheroid.setFlattening((1/298.257223563));
        datum.setSpheroid(spheroid);
        gcs.setDatum(datum);

        gcs.setDescription("World Geodetic System 1984 - Horizontal component of 3D system. Used by the GPS satellite navigation system and for NATO military geodetic surveying.");
        SpatialReference spatialReference = new SpatialReference();
        spatialReference.setGcs(gcs);
        spatialReference.setId("EPSG:4326");
        spatialReference.setSystemType("Geographic");

        global.setSpatialReference(spatialReference);

        return metadoc;
    }
}
