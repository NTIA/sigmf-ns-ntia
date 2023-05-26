package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import gov.doc.ntia.sigmf.ext.sensor.Amplifier;
import gov.doc.ntia.sigmf.ext.sensor.CalSource;
import gov.doc.ntia.sigmf.ext.sensor.Filter;
import gov.doc.ntia.sigmf.ext.sensor.RfPath;
import javax.validation.Valid;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @JsonProperty(value = "preselector_spec", required = false)
  protected HardwareSpec preselectorSpec;

  @Valid
  @JsonProperty(value = "cal_sources", required = false)
  protected gov.doc.ntia.sigmf.ext.sensor.CalSource[] calSources;

  @Valid
  @JsonProperty(value = "filters", required = false)
  protected Filter[] filters;

  @Valid
  @JsonProperty(value = "amplifiers", required = false)
  protected gov.doc.ntia.sigmf.ext.sensor.Amplifier[] amplifiers;

  @Valid
  @JsonProperty(value = "rf_paths", required = false)
  protected RfPath[] rfPaths;

  public HardwareSpec getPreselectorSpec() {
    return preselectorSpec;
  }

  public void setPreselectorSpec(HardwareSpec preselectorSpec) {
    this.preselectorSpec = preselectorSpec;
  }

  public gov.doc.ntia.sigmf.ext.sensor.CalSource[] getCalSources() {
    return calSources;
  }

  public void setCalSources(CalSource[] calSources) {
    this.calSources = calSources;
  }

  public Filter[] getFilters() {
    return filters;
  }

  public void setFilters(Filter[] filters) {
    this.filters = filters;
  }

  public gov.doc.ntia.sigmf.ext.sensor.Amplifier[] getAmplifiers() {
    return amplifiers;
  }

  public void setAmplifiers(Amplifier[] amplifiers) {
    this.amplifiers = amplifiers;
  }

  public RfPath[] getRfPaths() {
    return rfPaths;
  }

  public void setRfPaths(RfPath[] rfPaths) {
    this.rfPaths = rfPaths;
  }

}
