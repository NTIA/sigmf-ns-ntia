package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.location.Datum;
import gov.doc.ntia.sigmf.ext.global.location.GeographicCoordinateSystem;
import gov.doc.ntia.sigmf.ext.global.location.Spheroid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GcsWithSpheroidExample implements Example {
  @Override
  public MetaDoc getExample() {
    Date now = Calendar.getInstance().getTime();
    MetaDoc metadoc = new MetaDoc();

    Global global = ExampleUtils.getGlobal();
    List<Capture> captures = ExampleUtils.getCaptures(now);
    metadoc.setGlobal(global);
    metadoc.setCaptures(captures);
    GeographicCoordinateSystem gcs = new GeographicCoordinateSystem();
    gcs.setId("EPSG:4326");
    Spheroid spheroid = new Spheroid();
    spheroid.setSemimajor(6378137.0);
    spheroid.setSemiminor(6356752.3142);
    spheroid.setFlattening((1 / 298.257223563));
    spheroid.setPrimeMeridian("Greenwich");
    spheroid.setMeridianOffset(0.0);
    Datum datum = new Datum();
    datum.setSpheroid(spheroid);
    gcs.setDatum(datum);
    String description = "\"World Geodetic System 1984 - Horizontal component of 3D system.";
    description += " Used by the GPS and for NATO military geodetic surveying.";
    gcs.setDescription(description);
    global.setCoordinateSystem(gcs);

    return metadoc;
  }
}
