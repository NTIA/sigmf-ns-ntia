package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Software {

    @JsonProperty(value = "system_platform")
    protected String systemPlatform;

    @JsonProperty(value = "python_version")
    protected String pythonVersion;

    @JsonProperty(value = "scos_sensor_version")
    protected String scosSensorVersion;

    @JsonProperty(value = "scos_actions_version")
    protected String scosActionsVersion;

    @JsonProperty(value = "scos_sigan_plugin")
    protected ScosPlugin scosSiganPlugin;

    @JsonProperty(value = "preselector_api_version")
    protected String preselectorApiVersion;

    public String getSystemPlatform() {
        return systemPlatform;
    }

    public void setSystemPlatform(String systemPlatform) {
        this.systemPlatform = systemPlatform;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }

    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }

    public String getScosSensorVersion() {
        return scosSensorVersion;
    }

    public void setScosSensorVersion(String scosSensorVersion) {
        this.scosSensorVersion = scosSensorVersion;
    }

    public String getScosActionsVersion() {
        return scosActionsVersion;
    }

    public void setScosActionsVersion(String scosActionsVersion) {
        this.scosActionsVersion = scosActionsVersion;
    }

    public ScosPlugin getScosSiganPlugin() { return scosSiganPlugin; }

    public void setScosSiganPlugin(ScosPlugin scosSiganPlugin) { this.scosSiganPlugin = scosSiganPlugin; }

    public String getPreselectorApiVersion() {
        return preselectorApiVersion;
    }

    public void setPreselectorApiVersion(String preselectorApiVersion) {
        this.preselectorApiVersion = preselectorApiVersion;
    }
}
