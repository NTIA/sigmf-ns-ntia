package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class RfPath implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(required = true)
  protected String id;

  @JsonProperty(value = "cal_source_id", required = false)
  protected String calSourceId;

  @JsonProperty(value = "filter_id", required = false)
  protected String filterId;

  @JsonProperty(value = "amplifier_id", required = false)
  protected String amplifierId;

  @JsonProperty(value = "antenna_id", required = false)
  protected String antennaId;

  public String getCalSourceId() {
    return calSourceId;
  }

  public void setCalSourceId(String calSourceId) {
    this.calSourceId = calSourceId;
  }
  
  public String getFilterId() {
    return filterId;
  }

  public void setFilterId(String filterId) {
    this.filterId = filterId;
  }

  public String getAmplifierId() {
    return amplifierId;
  }

  public void setAmplifierId(String ampId) {
    this.amplifierId = ampId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAntennaId() {
    return antennaId;
  }

  public void setAntennaId(String antennaId) {
    this.antennaId = antennaId;
  }
}
