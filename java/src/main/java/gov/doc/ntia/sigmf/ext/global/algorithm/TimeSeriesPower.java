package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.beans.Transient;

public class TimeSeriesPower extends AbstractUnitRequiredTraceDataProduct {

  @JsonIgnore
  @Transient
  @Override
  public String getFieldName() {
    return "time_series_power";
  }
}
