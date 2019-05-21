package gov.doc.ntia.sigmf.ext.annotation.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntennaAnnotation extends Annotation {

    @JsonProperty(value="ntia-core:antenna_id", required = true)
    protected String id;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-core:azimuth_angle", required = false)
    protected Double azimuthAngle;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-core:elevation_angle", required = false)
    protected Double elevationAngle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAzimuthAngle() {
        return azimuthAngle;
    }

    public void setAzimuthAngle(Double azimuthAngle) {
        this.azimuthAngle = azimuthAngle;
    }

    public Double getElevationAngle() {
        return elevationAngle;
    }

    public void setElevationAngle(Double elevationAngle) {
        this.elevationAngle = elevationAngle;
    }

}
