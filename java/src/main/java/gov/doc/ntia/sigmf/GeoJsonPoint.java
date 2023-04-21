package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GeoJsonPoint {

  protected String type = "Point";

  protected Double[] coordinates;

  public GeoJsonPoint() {}

  public GeoJsonPoint(Double lat, Double longitude) {
    coordinates = new Double[2];
    coordinates[0] = longitude;
    coordinates[1] = lat;
  }

  @JsonIgnore
  public Double getLatitude() {
    if (coordinates == null) {
      return null;
    }
    return coordinates[1];
  }

  @JsonIgnore
  public void setLatitude(Double lat) {
    if (coordinates == null) {
      coordinates = new Double[2];
    }
    coordinates[1] = lat;
  }

  @JsonIgnore
  public Double getLongitude() {
    if (coordinates == null) {
      return null;
    }
    return coordinates[0];
  }

  @JsonIgnore
  public void setLongitude(Double l) {
    if (coordinates == null) {
      coordinates = new Double[2];
    }
    coordinates[0] = l;
  }

  public Double[] getCoordinates() {
    return coordinates;
  }

  public String getType() {
    return type;
  }
}
