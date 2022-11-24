package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.DigitalFilterAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.TimeDomainDetection;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.DigitalFilterAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.core.AnnotationSegment;
import gov.doc.ntia.sigmf.ext.annotation.sensor.CalibrationAnnotation;
import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "ntia-core:annotation_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FrequencyDomainDetection.class, name = "FrequencyDomainDetection"),
        @JsonSubTypes.Type(value = TimeDomainDetection.class, name = "TimeDomainDetection"),
        @JsonSubTypes.Type(value = DigitalFilterAnnotation.class, name = "DigitalFilterAnnotation"),
        @JsonSubTypes.Type(value = CalibrationAnnotation.class, name = "CalibrationAnnotation"),
        @JsonSubTypes.Type(value = SensorAnnotation.class, name = "SensorAnnotation"),
        @JsonSubTypes.Type(value = AnnotationSegment.class, name = "AnnotationSegment")

})
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

  @JsonProperty(value = "core:latitude", required = false)
  protected Double latitude;

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

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

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
