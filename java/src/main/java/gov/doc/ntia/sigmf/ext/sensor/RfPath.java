package gov.doc.ntia.sigmf.ext.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RfPath implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "name", required = false)
  protected String name;

  @JsonProperty(value = "cal_source_id", required = false)
  protected String calSourceId;

  @JsonProperty(value = "filter_id", required = false)
  protected String filterId;

  @JsonProperty(value = "amplifier_id", required = false)
  protected String amplifierId;

  protected Map<String, Object> otherFields = new HashMap<>();

  public String getCalSourceId() {
    return calSourceId;
  }

  public void setCalSourceId(String calSourceId) {
    this.calSourceId = calSourceId;
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  public void setOtherFields(Map<String, Object> otherFields) {
    this.otherFields = otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
