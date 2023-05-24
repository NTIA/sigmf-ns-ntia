package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Annotation implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "core:sample_start", required = true)
  protected Long sampleStart;

  @JsonProperty(value = "core:sample_count", required = true)
  protected Long sampleCount;

  @JsonProperty(value = "core:generator", required = false)
  protected String generator;

  @JsonProperty(value = "core:comment", required = false)
  protected String comment;

  @JsonProperty(value = "core:freq_lower_edge", required = false)
  protected Double freqLowerEdge;

  @JsonProperty(value = "core:freq_upper_edge", required = false)
  protected Double freqUpperEdge;

  @JsonProperty(value = "uuid", required = false)
  protected String uuid;

  @Deprecated
  @JsonProperty(value = "core:latitude", required = false)
  protected Double latitude;

  @Deprecated
  @JsonProperty(value = "core:longitude", required = false)
  protected Double longitude;

  protected Map<String, Object> otherFields = new HashMap<>();

  public Long getSampleStart() {
    return sampleStart;
  }

  public void setSampleStart(Long sampleStart) {
    this.sampleStart = sampleStart;
  }

  public Long getSampleCount() {
    return sampleCount;
  }

  public void setSampleCount(Long sampleCount) {
    this.sampleCount = sampleCount;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Double getFreqLowerEdge() {
    return freqLowerEdge;
  }

  public void setFreqLowerEdge(Double freqLowerEdge) {
    this.freqLowerEdge = freqLowerEdge;
  }

  public Double getFreqUpperEdge() {
    return freqUpperEdge;
  }

  public void setFreqUpperEdge(Double freqUpperEdge) {
    this.freqUpperEdge = freqUpperEdge;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Deprecated
  public Double getLatitude() {
    return latitude;
  }

  @Deprecated
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  @Deprecated
  public Double getLongitude() {
    return longitude;
  }

  @Deprecated
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
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
