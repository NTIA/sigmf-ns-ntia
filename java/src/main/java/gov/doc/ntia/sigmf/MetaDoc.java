package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Global global;

    protected List<Capture> captures;

    protected List<Annotation> annotations;

    public MetaDoc(){
        global = new Global();
        captures = new ArrayList<>();
        annotations = new ArrayList<>();
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    public void setCaptures(List<Capture> captures) {
        this.captures = captures;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
    

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }




}
