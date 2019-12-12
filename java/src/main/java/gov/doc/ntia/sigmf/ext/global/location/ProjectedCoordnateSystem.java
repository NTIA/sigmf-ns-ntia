package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectedCoordnateSystem {


    @JsonProperty(value="id", required = true)
    protected String id;

    @JsonProperty(value="description", required = false)
    protected String description;

    @JsonProperty(value="type", required = false)
    protected String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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






}
