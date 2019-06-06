package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.Mover;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor extends Mover implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="id", required=true)
    protected String id;

    @JsonProperty(value="ntia-core:antenna", required = true)
    protected Antenna antenna;

    @JsonProperty(value="preselector", required = false)
    protected Preselector preselector;

    @JsonProperty(value="receiver", required = true)
    protected Receiver receiver;

    @JsonProperty(value="host_controller", required = false)
    protected String hostController;

    public Boolean isMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    @JsonProperty(value="mobile", required=false)
    protected Boolean mobile;

    public String getGpsNmea() {
        return gpsNmea;
    }

    public void setGpsNmea(String gpsNmea) {
        this.gpsNmea = gpsNmea;
    }

    @JsonProperty(value="gps_nmea", required = false)
    protected String gpsNmea;

    protected Map<String, Object> otherFields = new HashMap<>();

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

    @JsonAnyGetter
    public Map<String, Object> getOtherFields(){
        return otherFields;
    }

    @JsonAnySetter
    public void add(String key, Object value){
        otherFields.put(key, value);
    }

}
