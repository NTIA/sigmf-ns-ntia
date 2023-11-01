package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diagnostics {

  @Valid protected Computer computer;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  private Date datetime;

  @Valid
  private Preselector preselector;

  @Valid
  private Software software;

  @Valid
  private SPU spu;

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

  public Software getSoftware() { return software; }

  public void setSoftware(Software software) { this.software = software; }

  public SPU getSpu() {
    return spu;
  }

  public void setSpu(SPU spu) {
    this.spu = spu;
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
