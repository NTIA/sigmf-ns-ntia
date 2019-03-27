package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor {

    @JsonProperty(value="ntia-sensor:id", required=true)
    protected String id;

    @JsonProperty(value="ntia-antenna:antenna", required = true)
    protected Antenna antenna;

    @JsonProperty(value="ntia-sensor:preselector", required = false)
    protected Preselector preselector;

    @JsonProperty(value="ntia-sensor:receiveer", required = true)
    protected Receiver receiver;

    @JsonProperty(value="ntia-sensor:host_controller", required = false)
    protected String hostController;

    @JsonProperty(value ="ntia-sensor:anti_aliasing_filter", required = false)
    protected DigitalFilter antiAliasingFilter;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Antenna getAntenna() {
        return antenna;
    }

    public void setAntenna(Antenna antenna) {
        this.antenna = antenna;
    }

    public Preselector getPreselector() {
        return preselector;
    }

    public void setPreselector(Preselector preselector) {
        this.preselector = preselector;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public String getHostController() {
        return hostController;
    }

    public void setHostController(String hostController) {
        this.hostController = hostController;
    }

    public DigitalFilter getAntiAliasingFilter() {
        return antiAliasingFilter;
    }

    public void setAntiAliasingFilter(DigitalFilter antiAliasingFilter) {
        this.antiAliasingFilter = antiAliasingFilter;
    }

}
