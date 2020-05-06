package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.location.GeographicCoordinateSystem;
import gov.doc.ntia.sigmf.ext.global.location.ProjectedCoordnateSystem;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProjectedExample implements Example {
  @Override
  public MetaDoc getExample() {
    Date now = Calendar.getInstance().getTime();
    MetaDoc metadoc = new MetaDoc();

    Global global = ExampleUtils.getGlobal();
    List<Capture> captures = ExampleUtils.getCaptures(now);
    metadoc.setGlobal(global);
    metadoc.setCaptures(captures);
    GeographicCoordinateSystem gcs = new GeographicCoordinateSystem();
    gcs.setId("EPSG:4608");
    gcs.setDescription("NAD27(76)");
    ProjectedCoordnateSystem projectedCoordnateSystem = new ProjectedCoordnateSystem();
    projectedCoordnateSystem.setId("EPSG:2029");
    projectedCoordnateSystem.setDescription("NAD27(76) / UTM zone 17N");
    projectedCoordnateSystem.setGcs(gcs);
    global.setCoordinateSystem(projectedCoordnateSystem);
    return metadoc;
  }
}
