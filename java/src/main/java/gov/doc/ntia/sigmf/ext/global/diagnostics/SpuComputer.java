package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpuComputer implements Serializable {
    @JsonProperty(value = "action_cpu_usage_pct", required = false)
    protected Double actionCpuUsagePct;

    @JsonProperty(value = "system_load_5m_pct", required = false)
    protected Double systemLoad5mPct;

    @JsonProperty(value = "memory_usage_pct", required = false)
    protected Double memoryUsagePct;

    @JsonProperty(value = "disk_usage_pct", required = false)
    protected Double diskUsagePct;

    @JsonProperty(value = "cpu_temperature_degC", required = false)
    protected Double cpuTemperatureDegC;

    @JsonProperty(value = "cpu_overheating", required = false)
    protected Boolean cpuOverheating;

    @JsonProperty(value = "uptime_hours", required = false)
    protected Double uptimeHours;

    public Double getActionCpuUsagePct(){return this.actionCpuUsagePct;}
    public void setActionCpuUsagePct(Double actionCpuUsagePct){this.actionCpuUsagePct = actionCpuUsagePct;}

    public Double getSystemLoad5mPct(){return this.systemLoad5mPct;}
    public void setSystemLoad5mPct(Double systemLoad5mPct){this.systemLoad5mPct = systemLoad5mPct;}

    public Double getMemoryUsagePct(){return this.memoryUsagePct;}
    public void setMemoryUsagePct(Double memoryUsagePct){this.memoryUsagePct = memoryUsagePct;}

    public Double getDiskUsagePct(){return this.diskUsagePct;}
    public void setDiskUsagePct(Double diskUsagePct){this.diskUsagePct = diskUsagePct;}

    public Double getCpuTemperatureDegC(){return this.cpuTemperatureDegC;}
    public void setCpuTemperatureDegC(Double cpuTemperatureDegC){this.cpuTemperatureDegC = cpuTemperatureDegC;}

    public Boolean getCpuOverheating(){return this.cpuOverheating;}
    public void setCpuOverheating(Boolean cpuOverheating){this.cpuOverheating = cpuOverheating;}

    public Double getUptimeHours(){return this.uptimeHours;}
    public void setUptimeHours(Double uptimeHours){this.uptimeHours = uptimeHours;}
}
