package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "x", required = false)
  protected Double x;

  @JsonProperty(value = "y", required = false)
  protected Double y;

  @JsonProperty(value = "z", required = false)
  protected Double z;

  @JsonProperty(value = "speed", required = false)
  protected Double speed;

  @JsonProperty(value = "bearing", required = false)
  protected Double bearing;

  @JsonProperty(value = "description", required = false)
  protected String description;

  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public Double getZ() {
    return z;
  }

  public void setZ(Double z) {
    this.z = z;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Double getBearing() {
    return bearing;
  }

  public void setBearing(Double bearing) {
    this.bearing = bearing;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
