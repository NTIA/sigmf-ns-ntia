package gov.doc.ntia.sigmf.ext.global.scos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required = true)
    protected String id;

    @JsonProperty(value="action", required = true)
    protected String action;

    @JsonProperty(value="relative_stop", required = false)
    protected Integer relativeStop;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getRelativeStop() {
        return relativeStop;
    }

    public void setRelativeStop(Integer relativeStop) {
        this.relativeStop = relativeStop;
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




}
