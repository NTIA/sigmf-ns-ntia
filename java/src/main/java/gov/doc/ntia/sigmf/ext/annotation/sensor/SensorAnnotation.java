package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

@Deprecated
public class SensorAnnotation extends Annotation {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "ntia-sensor:rf_path_index", required = false)
  protected Integer rfPathIndex;

  @JsonProperty(value = "ntia-sensor:overload", required = false)
  protected Boolean overload;


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



}
