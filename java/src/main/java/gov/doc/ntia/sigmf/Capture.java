package gov.doc.ntia.sigmf;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.ext.sensor.SensorCapture;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({@JsonSubTypes.Type(SensorCapture.class)})
public class Capture implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "core:sample_start", required = true)
  protected long sampleStart;

  @JsonProperty(value = "core:global_index", required = false)
  protected Long globalIndex;

  @JsonProperty(value = "core:header_bytes", required = false)
  protected Long headerBytes;

  @JsonProperty(value = "core:frequency", required = false)
  protected Double frequency;

  // 2019-04-30T15:24:24.153922Z
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "core:datetime", required = false)
  protected Date dateTime;

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

  public Long getHeaderBytes() {
    return headerBytes;
  }

  public void setHeaderBytes(Long headerBytes) {
    this.headerBytes = headerBytes;
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

}
