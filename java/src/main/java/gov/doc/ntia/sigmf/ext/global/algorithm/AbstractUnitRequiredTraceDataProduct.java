package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public abstract class AbstractUnitRequiredTraceDataProduct extends TraceDataProduct {

  @NotNull
  @JsonProperty(value = "units", required = true)
  protected String units;

  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }
}
