package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.Annotation;


public class SensorAnnotation extends Annotation {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "ntia-sensor:rf_path_index", required = false)
  protected Integer rfPathIndex;

  @JsonProperty(value = "ntia-sensor:overload", required = false)
  protected Boolean overload;

  @JsonProperty(value = "ntia-sensor:sigan_settings", required = false)
  protected SiganSettings siganSettings;

  public Integer getRfPathIndex() {
    return rfPathIndex;
  }

  public void setRfPathIndex(Integer rfPathIndex) {
    this.rfPathIndex = rfPathIndex;
  }

  public Boolean getOverload() {
    return overload;
  }

  public void setOverload(Boolean overload) {
    this.overload = overload;
  }

  public SiganSettings getSiganSettings() {
    return siganSettings;
  }

  public void setSiganSettings(SiganSettings siganSettings) {
    this.siganSettings = siganSettings;
  }

}
