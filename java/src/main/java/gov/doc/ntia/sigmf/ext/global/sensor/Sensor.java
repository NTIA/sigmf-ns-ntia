package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.global.environment.Environment;
import gov.doc.ntia.sigmf.ext.global.location.Location;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sensor  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id", required = true)
    protected String id;

    @JsonProperty(value = "sensor_spec", required = false)
    protected HardwareSpec sensorSpec;

    @JsonProperty(value="ntia-core:antenna", required = false)
    protected Antenna antenna;

    @JsonProperty(value="preselector", required = false)
    protected Preselector preselector;

    @JsonProperty(value="signal_analyzer", required = false)
    protected SignalAnalyzer signalAnalyzer;

    @JsonProperty(value="computer_spec", required = false)
    protected HardwareSpec computerSpec;

    @JsonProperty(value="mobile", required=false)
    protected Boolean mobile;

    @JsonProperty(value="location", required = false)
    protected Location location;

    @JsonProperty(value="environment", required = false)
    protected Environment environment;

    public HardwareSpec getSensorSpec() {
        return sensorSpec;
    }

    public void setSensorSpec(HardwareSpec sensorSpec) {
        this.sensorSpec = sensorSpec;
    }

    public void setSignalAnalyzer(SignalAnalyzer signalAnalyzer) {
        this.signalAnalyzer = signalAnalyzer;
    }

    public HardwareSpec getComputerSpec() {
        return computerSpec;
    }

    public void setComputerSpec(HardwareSpec computerSpec) {
        this.computerSpec = computerSpec;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setOtherFields(Map<String, Object> otherFields) {
        this.otherFields = otherFields;
    }

    public Boolean isMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

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


    public SignalAnalyzer getSignalAnalyzer() {
        return signalAnalyzer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
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
