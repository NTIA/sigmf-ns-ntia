package gov.doc.ntia.sigmf.examples.location;

import gov.doc.ntia.sigmf.Capture;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.location.GeographicCoordinateSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SimpleGCS implements Example {
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
        global.setCoordinateSystem(gcs);
        return metadoc;
    }
}
