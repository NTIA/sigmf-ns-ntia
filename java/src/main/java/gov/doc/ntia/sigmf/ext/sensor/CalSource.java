package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import jakarta.validation.Valid;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalSource implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @JsonProperty(value = "cal_source_spec", required = false)
  protected HardwareSpec calSourceSpec;

  @JsonProperty(value = "type", required = false)
  protected String type;

  @JsonProperty(value = "enr", required = false)
  protected Double enr;

  public HardwareSpec getCalSourceSpec() {
    return calSourceSpec;
  }

  public void setCalSourceSpec(HardwareSpec calSourceSpec) {
    this.calSourceSpec = calSourceSpec;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double getEnr() {
    return enr;
  }

  public void setEnr(Double enr) {
    this.enr = enr;
  }
}
