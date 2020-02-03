package gov.doc.ntia.sigmf.ext.global.scos;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = true)
    protected String id;

    @JsonProperty(value="name", required = true)
    protected String name;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
    @JsonProperty(value="stop", required = false)
    protected Date stop;

    @JsonProperty(value="interval", required=false)
    protected Integer interval;

    @JsonProperty(value="priority", required = false)
    protected Integer priority;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonProperty(value="start", required = false)
    protected Date start;

    protected Map<String, Object> otherFields = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherFields(){
        return otherFields;
    }

    @JsonAnySetter
    public void add(String key, Object value){
        otherFields.put(key, value);
    }

    @JsonIgnore
    public String getScheduleNameFromUrl(){
        String scheduleName = "";
        if(id != null){
            if(id.endsWith("/")) {
                scheduleName = id.substring(0, id.length() - 1);
            }
            int index = scheduleName.lastIndexOf("/");
            scheduleName = scheduleName.substring(index+1);
        }
        return scheduleName;
    }



}
