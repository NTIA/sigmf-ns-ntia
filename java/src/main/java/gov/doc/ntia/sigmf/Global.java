package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.Action;
import gov.doc.ntia.sigmf.ext.global.Emitter;
import gov.doc.ntia.sigmf.ext.global.Schedule;
import gov.doc.ntia.sigmf.ext.global.Sensor;

public class Global {
    @JsonProperty(value="core:datatype", required = true)
    protected String datatype;

    @JsonProperty(value="core:sample_rate", required = false)
    protected Double sampleRate;

    @JsonProperty(value="core:version", required = true)
    protected String version;

    @JsonProperty(value="ntia-sensor:sensor", required = false)
    protected Sensor sensor;

    @JsonProperty(value="ntia-emitter:emitter", required = false)
    protected Emitter emitter;

    @JsonProperty(value="ntia-scos:action", required = false)
    protected Action action;

    @JsonProperty(value="ntia-scos:schedule", required = false)
    protected Schedule schedule;

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Double getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Emitter getEmitter() {
        return emitter;
    }

    public void setEmitter(Emitter emitter) {
        this.emitter = emitter;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }


}
