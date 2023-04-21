package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capture implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "core:sample_start", required = true)
  protected long sampleStart;

  @JsonProperty(value = "core:global_index", required = false)
  protected Long globalIndex;

  @JsonProperty(value = "core:frequency", required = false)
  protected Double frequency;

  // 2019-04-30T15:24:24.153922Z
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "core:datetime", required = false)
  protected Date dateTime;

  protected Map<String, Object> otherFields = new HashMap<>();

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public Long getGlobalIndex() {
    return globalIndex;
  }

  public void setGlobalIndex(Long globalIndex) {
    this.globalIndex = globalIndex;
  }

  public Double getFrequency() {
    return frequency;
  }

  public void setFrequency(Double frequency) {
    this.frequency = frequency;
  }

  public Long getSampleStart() {
    return sampleStart;
  }

  public void setSampleStart(int sampleStart) {
    this.sampleStart = sampleStart;
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }
}
