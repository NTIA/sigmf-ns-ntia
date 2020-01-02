package gov.doc.ntia.sigmf.examples.emitter;

import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmitterExample implements Example {
    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Emitter emitter = new Emitter();
        emitter.setId("EmitterXYZ");
        emitter.setDescription("A fictitious emitter to demonstrate the extensions format.");
        emitter.setPower(-60.0);
        Global global = ExampleUtils.getGlobal(Calendar.getInstance().getTime());
        List<Emitter> emitters = new ArrayList<>();
        emitters.add(emitter);
        global.setEmitters(emitters);
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}
