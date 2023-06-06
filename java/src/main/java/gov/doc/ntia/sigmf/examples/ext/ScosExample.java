package gov.doc.ntia.sigmf.examples.ext;


import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.ext.scos.Action;
import gov.doc.ntia.sigmf.ext.scos.ScheduleEntry;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;

public class ScosExample implements Example {
    
    public static Extension getExtension() {
        Extension extension = new Extension();
        extension.setName("ntia-scos");
        extension.setVersion("v1.0.0");
        extension.setOptional(false);
        return extension;
    }

    public static ScheduleEntry getScheduleEntry() {
        ScheduleEntry sched = new ScheduleEntry();
        sched.setId("m4s_action_id");
        sched.setName("M4S_Every_Second");
        sched.setStart(ExampleUtils.getDatetimeNow());
        sched.setInterval(1);
        sched.setPriority(10);
        sched.addRole("admin");
        sched.addRole("user");
        sched.setStop(ExampleUtils.getDatetimeNow());
        return sched;
    }

    public static Action getAction() {
        Action action = new Action();
        action.setName("example_acquire_m4s");
        action.setDescription("Placeholder text for a high-detail action description");
        action.setSummary("Example description of an M4S detection action");
        return action;
    }

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = ExampleUtils.getGlobal();
        global.addExtension(getExtension());

        global.setSchedule(getScheduleEntry());
        global.setAction(getAction());
        global.setTask(1);
        global.setRecording(1);
        
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}