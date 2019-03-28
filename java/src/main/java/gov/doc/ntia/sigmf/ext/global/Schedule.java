package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-scos:id", required = true)
    protected String id;

    @JsonProperty(value="ntia-scos:action", required = true)
    protected String action;

    @JsonProperty(value="ntia-scos:relative_stop", required = false)
    protected Integer relativeStop;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
    @JsonProperty(value="ntia-scos:absolute_stop", required = false)
    protected Date absoluteStop;

    @JsonProperty(value="ntia-scos:interval", required=false)
    protected Integer interval;

    @JsonProperty(value="ntia-scos:priority", required = false)
    protected Integer priority;

    @JsonProperty(value="ntia-scos:callback_url", required = false)
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
