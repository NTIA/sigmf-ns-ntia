package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoordinateSystem {

    @JsonProperty(value="id", required = false)
    private String id;

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty(value = "system_type", required = false)
    private String systemType;

    @JsonProperty(value = "distance_unit", required = false)
    private String distanceUnit;

    @JsonProperty(value = "time_unit", required = false)
    private String timeUnit;

    @JsonProperty(value = "origin", required = false)
    private String origin;

    @JsonProperty(value = "orientation_ref", required = false)
    private String orientationRef;

    @JsonProperty(value = "orientation", required = false)
    private String orientation;

    @JsonProperty(value = "elevation_ref", required = false)
    private String elevationRef;

    @JsonProperty(value = "elevation_unit", required = false)
    private String elevationUnit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrientationRef() {
        return orientationRef;
    }

    public void setOrientationRef(String orientationRef) {
        this.orientationRef = orientationRef;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getElevationRef() {
        return elevationRef;
    }

    public void setElevationRef(String elevationRef) {
        this.elevationRef = elevationRef;
    }

    public String getElevationUnit() {
        return elevationUnit;
    }

    public void setElevationUnit(String elevationUnit) {
        this.elevationUnit = elevationUnit;
    }






}
