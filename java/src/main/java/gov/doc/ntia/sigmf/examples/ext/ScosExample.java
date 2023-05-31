package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.scos.Action;
import gov.doc.ntia.sigmf.ext.scos.ScheduleEntry;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;

import java.util.ArrayList;

public class ScosExample implements Example {

    public static ScheduleEntry getScheduleEntry() {
        ScheduleEntry sched = new ScheduleEntry();
        sched.setId("example_entry");
        sched.setName("Example_Schedule_Entry");
        sched.setStart(ExampleUtils.getDatetimeNow());
        sched.setInterval(90);
        sched.setPriority(10);
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("user");
        sched.setRoles(roles);
        sched.setStop(ExampleUtils.getDatetimeNow());
        return sched;
    }

    public static Action getAction() {
        Action action = new Action();
        action.setName("example_action_name");
        action.setDescription("Placeholder text for a high-detail action description");
        action.setSummary("Some example metadata for a SCOS action");
        return action;
    }

    @Override
    public MetaDoc getExample() {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();

        global.setSchedule(getScheduleEntry());
        global.setAction(getAction());
        global.setTask(1);
        global.setRecording(1);
        
        metaDoc.setGlobal(global);
        return metaDoc;
    }
}