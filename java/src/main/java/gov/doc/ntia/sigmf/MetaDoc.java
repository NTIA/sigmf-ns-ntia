package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    protected String id;

    protected Global global;

    protected List<Capture> captures;

    protected List<Annotation> annotations;

    public MetaDoc(){
        global = new Global();
        captures = new ArrayList<>();
        annotations = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void saveToFile(String filename){

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
         try {
             mapper.writeValue(new File(filename),this);
         } catch (IOException e) {
            e.printStackTrace();
         }


    }

    public void addAnnotation(Annotation annotation){
        annotations.add(annotation);
    }



}
