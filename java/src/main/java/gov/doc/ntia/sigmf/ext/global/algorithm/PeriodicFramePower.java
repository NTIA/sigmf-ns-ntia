package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.beans.Transient;

public class PeriodicFramePower extends AbstractUnitRequiredTraceDataProduct {

  @JsonIgnore
  @Transient
  @Override
  public String getFieldName() {
    return "periodic_frame_power";
  }
}
