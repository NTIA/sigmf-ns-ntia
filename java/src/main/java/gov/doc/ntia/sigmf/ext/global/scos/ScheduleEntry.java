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

    @JsonProperty(value="name", required = false)
    protected String name;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
    @JsonProperty(value="absolute_stop", required = false)
    protected Date absoluteStop;

    @JsonProperty(value="interval", required=false)
    protected Integer interval;

    @JsonProperty(value="priority", required = false)
    protected Integer priority;

    @JsonProperty(value="callback_url", required = false)
    protected String callbackURL;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    @JsonProperty(value="start_time", required = false)
    protected Date startTime;

    protected Map<String, Object> otherFields = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAbsoluteStop() {
        return absoluteStop;
    }

    public void setAbsoluteStop(Date absoluteStop) {
        this.absoluteStop = absoluteStop;
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

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
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
