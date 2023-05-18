package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.doc.ntia.sigmf.Annotation;

@Deprecated
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "ntia-core:annotation_type")
public class SensorAnnotation extends Annotation {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "ntia-sensor:rf_path_index", required = false)
  protected Integer rfPathIndex;

  @JsonProperty(value = "ntia-sensor:overload", required = false)
  protected Boolean overload;

  @JsonProperty(value = "ntia-sensor:attenuation_setting_sigan", required = false)
  protected Double attenuationSettingSigan;

  @JsonProperty(value = "ntia-sensor:gain_setting_sigan", required = false)
  protected Double gainSettingSigan;

  @JsonProperty(value = "ntia-sensor:gps_nmea", required = false)
  protected String gpsNmea;

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

  public Double getAttenuationSettingSigan() {
    return attenuationSettingSigan;
  }

  public void setAttenuationSettingSigan(Double attenuationSettingSigan) {
    this.attenuationSettingSigan = attenuationSettingSigan;
  }

  public Double getGainSettingSigan() {
    return gainSettingSigan;
  }

  public void setGainSettingSigan(Double gainSettingSigan) {
    this.gainSettingSigan = gainSettingSigan;
  }

  public String getGpsNmea() {
    return gpsNmea;
  }

  public void setGpsNmea(String gpsNmea) {
    this.gpsNmea = gpsNmea;
  }
}
