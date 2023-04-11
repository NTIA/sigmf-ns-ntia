package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonFormat;import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Diagnostics {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private Date datetime;

  private Preselector preselector;

  private Spu spu;

  protected Computer computer;

  @JsonProperty(value = "action_runtime")
  private Double actionRuntime;

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

  public Preselector getPreselector() {
    return preselector;
  }

  public void setPreselector(Preselector preselector) {
    this.preselector = preselector;
  }

  public Spu getSpu() {
    return spu;
  }

  public void setSpu(Spu spu) {
    this.spu = spu;
  }

  public Computer getCpu() {
    return computer;
  }

  public void setCpu(Computer computer) {
    this.computer = computer;
  }

  public Double getActionRuntime() {
    return actionRuntime;
  }

  public void setActionRuntime(Double actionRuntime) {
    this.actionRuntime = actionRuntime;
  }

  public Computer getComputer() {
    return computer;
  }

  public void setComputer(Computer computer) {
    this.computer = computer;
  }
}