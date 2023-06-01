package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoJsonPoint {

  protected String type = "Point";

  protected Double[] coordinates;

  public GeoJsonPoint() {}

  public GeoJsonPoint(Double lat, Double longitude) {
    coordinates = new Double[2];
    coordinates[0] = longitude;
    coordinates[1] = lat;
  }

  public GeoJsonPoint(Double lat, Double longitude, Double altitude) {
    coordinates = new Double[3];
    coordinates[0] = longitude;
    coordinates[1] = lat;
    coordinates[2] = altitude;
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

  @JsonIgnore
  public Double getAltitude() {
    if (coordinates != null && coordinates.length == 3) {
      return coordinates[2];
    } else {
      return null;
    }
  }

  @JsonIgnore
  public void setAltitude(Double a) {
    if (coordinates == null) {
      coordinates = new Double[3];
    } else if (coordinates.length == 2) {
      Double[] oldCoords = coordinates;
      coordinates = new Double[3];
      coordinates[0] = oldCoords[0];
      coordinates[1] = oldCoords[1];
    }
    coordinates[2] = a;
  }

  public Double[] getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Double[] coordinates){
    this.coordinates = coordinates;
  }

  public String getType() {
    return type;
  }
}
