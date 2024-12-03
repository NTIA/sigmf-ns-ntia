package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Computer {

  @JsonProperty(value = "cpu_max_clock")
  protected Double cpuMaxClock;

  @JsonProperty(value = "cpu_min_clock")
  protected Double cpuMinClock;

  @JsonProperty(value = "cpu_mean_clock")
  protected Double cpuMeanClock;

  @JsonProperty(value = "action_cpu_usage")
  protected Double actionCpuUsage;

  @JsonProperty(value = "system_load_5m")
  protected Double systemLoad5m;

  @JsonProperty(value = "memory_usage")
  protected Double memoryUsage;

  @JsonProperty(value = "cpu_temp")
  protected Double cpuTemp;

  @JsonProperty(value = "cpu_overheating")
  protected Boolean cpuOverheating;

  @JsonProperty(value = "cpu_uptime")
  protected Double cpuUptime;

  @JsonProperty(value = "software_uptime")
  protected Double softwareUptime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "software_start")
  protected Date softwareStart;

  @JsonProperty(value = "ntp_active")
  protected Boolean ntpActive;

  @JsonProperty(value = "ntp_sync")
  protected Boolean ntpSync;

  @JsonProperty(value = "disk_usage")
  protected Double diskUsage;

  @Valid
  @JsonProperty(value = "ssd_smart_data")
  private SsdSmartData smartData;

  @JsonProperty(value = "action_runtime")
  private Double actionRuntime;

  public Double getCpuMaxClock() {
    return cpuMaxClock;
  }

  public void setCpuMaxClock(Double cpuMaxClock) {
    this.cpuMaxClock = cpuMaxClock;
  }

  public Double getCpuMinClock() {
    return cpuMinClock;
  }

  public void setCpuMinClock(Double cpuMinClock) {
    this.cpuMinClock = cpuMinClock;
  }

  public Double getCpuMeanClock() {
    return cpuMeanClock;
  }

  public void setCpuMeanClock(Double cpuMeanClock) {
    this.cpuMeanClock = cpuMeanClock;
  }

  public Double getActionCpuUsage() {
    return actionCpuUsage;
  }

  public void setActionCpuUsage(Double actionCpuUsage) {
    this.actionCpuUsage = actionCpuUsage;
  }

  public Double getSystemLoad5m() {
    return systemLoad5m;
  }

  public void setSystemLoad5m(Double systemLoad5m) {
    this.systemLoad5m = systemLoad5m;
  }

  public Double getMemoryUsage() {
    return memoryUsage;
  }

  public void setMemoryUsage(Double memory_usage) {
    this.memoryUsage = memory_usage;
  }

  public Double getCpuTemp() {
    return cpuTemp;
  }

  public void setCpuTemp(Double cpuTemp) {
    this.cpuTemp = cpuTemp;
  }

  public Boolean getCpuOverheating() {
    return cpuOverheating;
  }

  public void setCpuOverheating(Boolean cpuOverheating) {
    this.cpuOverheating = cpuOverheating;
  }

  public Double getCpuUptime() {
    return cpuUptime;
  }

  public void setCpuUptime(Double cpuUptime) {
    this.cpuUptime = cpuUptime;
  }

  public Date getSoftwareStart() {
    return softwareStart;
  }

  public void setSoftwareStart(Date softwareStart) {
    this.softwareStart = softwareStart;
  }

  public Double getSoftwareUptime() {
    return softwareUptime;
  }

  public void setSoftwareUptime(Double softwareUptime) {
    this.softwareUptime = softwareUptime;
  }

  public SsdSmartData getSmartData() {
    return smartData;
  }

  public void setSmartData(SsdSmartData smartData) {
    this.smartData = smartData;
  }

  public Boolean getNtpActive() {
    return ntpActive;
  }

  public void setNtpActive(Boolean ntpActive) {
    this.ntpActive = ntpActive;
  }

  public Boolean getNtpSync() {
    return ntpSync;
  }

  public void setNtpSync(Boolean ntpSync) {
    this.ntpSync = ntpSync;
  }

  public Double getDiskUsage() {
    return diskUsage;
  }

  public void setDiskUsage(Double diskUsage) {
    this.diskUsage = diskUsage;
  }

  public Double getActionRuntime() {
    return actionRuntime;
  }

  public void setActionRuntime(Double actionRuntime) {
    this.actionRuntime = actionRuntime;
  }
}
