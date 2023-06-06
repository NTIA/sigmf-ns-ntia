package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.core.HardwareSpec;
import javax.validation.Valid;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @JsonProperty(value = "preselector_spec", required = false)
  protected HardwareSpec preselectorSpec;

  @Valid
  @JsonProperty(value = "cal_sources", required = false)
  protected List<CalSource> calSources;

  @Valid
  @JsonProperty(value = "filters", required = false)
  protected List<Filter> filters;

  @Valid
  @JsonProperty(value = "amplifiers", required = false)
  protected List<Amplifier> amplifiers;

  @Valid
  @JsonProperty(value = "rf_paths", required = false)
  protected List<RfPath> rfPaths;

  public HardwareSpec getPreselectorSpec() {
    return preselectorSpec;
  }

  public void setPreselectorSpec(HardwareSpec preselectorSpec) {
    this.preselectorSpec = preselectorSpec;
  }

  public List<CalSource> getCalSources() {
    return calSources;
  }

  public void setCalSources(List<CalSource> calSources) {
    this.calSources = calSources;
  }

  public void addCalSource(CalSource calSource) {
    if (this.calSources == null) {
      calSources = new ArrayList<>();
    }
    calSources.add(calSource);
  }

  public void removeCalSource(CalSource calSource) {
    if (this.calSources != null) {
      calSources.remove(calSource);
    }
  }

  public List<Filter> getFilters() {
    return filters;
  }

  public void setFilters(List<Filter> filters) {
    this.filters = filters;
  }

  public void addFilter(Filter filter) {
    if (this.filters == null) {
      filters = new ArrayList<>();
    }
    filters.add(filter);
  }

  public void removeFilter(Filter filter) {
    if (this.filters != null) {
      filters.remove(filter);
    }
  }

  public List<Amplifier> getAmplifiers() {
    return amplifiers;
  }

  public void setAmplifiers(List<Amplifier> amplifiers) {
    this.amplifiers = amplifiers;
  }

  public void addAmplifier(Amplifier amplifier) {
    if (this.amplifiers == null) {
      amplifiers = new ArrayList<>();
    }
    amplifiers.add(amplifier);
  }

  public void removeAmplifier(Amplifier amplifier) {
    if (this.amplifiers != null) {
      amplifiers.remove(amplifier);
    }
  }

  public List<RfPath> getRfPaths() {
    return rfPaths;
  }

  public void setRfPaths(List<RfPath> rfPaths) {
    this.rfPaths = rfPaths;
  }

  public void addRfPath(RfPath rfPath) {
    if (this.rfPaths == null) {
      rfPaths = new ArrayList<>();
    }
    rfPaths.add(rfPath);
  }

  public void removeRfPath(RfPath rfPath) {
    if (this.rfPaths != null) {
      rfPaths.remove(rfPath);
    }
  }

}
