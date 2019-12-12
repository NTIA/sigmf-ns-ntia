package gov.doc.ntia.sigmf.ext.global.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicCoordinateSystem {

    @JsonProperty(value = "id", required = false)
    protected String id;

    @JsonProperty(value="description", required = false)
    protected String description;

    @JsonProperty(value="prime_meridian", required = false)
    protected String primeMeridian;

    @JsonProperty(value = "datum", required = false)
    protected Datum datum;

    @JsonProperty(value = "angular_unit", required = false)
    protected String angularUnit;

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

    public String getPrimeMeridian() {
        return primeMeridian;
    }

    public void setPrimeMeridian(String primeMeridian) {
        this.primeMeridian = primeMeridian;
    }

    public Datum getDatum() {
        return datum;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public String getAngularUnit() {
        return angularUnit;
    }

    public void setAngularUnit(String angularUnit) {
        this.angularUnit = angularUnit;
    }





}
