package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectedCoordnateSystem extends CoordinateSystem {

    @JsonProperty(value="false_easting", required = false)
    protected Double falseEasting;

    @JsonProperty(value="false_northing", required = false)
    protected Double falseNorthing;

    @JsonProperty(value="central_meridian", required = false)
    protected Double centralMeridian;

    @JsonProperty(value="scale_factor", required = false)
    protected Double scaleFactor;

    @JsonProperty(value="origin_latitude", required = false)
    protected Double originLatitude;


    @JsonProperty(value="gcs", required = false)
    protected GeographicCoordinateSystem gcs;


    @JsonProperty(value="projection", required = false)
    protected String projection;

    public GeographicCoordinateSystem getGcs() {
        return gcs;
    }

    public void setGcs(GeographicCoordinateSystem gcs) {
        this.gcs = gcs;
    }

    public Double getFalseEasting() {
        return falseEasting;
    }

    public void setFalseEasting(double falseEasting) {
        this.falseEasting = falseEasting;
    }

    public Double getFalseNorthing() {
        return falseNorthing;
    }

    public void setFalseNorthing(double falseNorthing) {
        this.falseNorthing = falseNorthing;
    }

    public Double getCentralMeridian() {
        return centralMeridian;
    }

    public void setCentralMeridian(double centralMeridian) {
        this.centralMeridian = centralMeridian;
    }

    public Double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public Double getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(double originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }




}
