package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomainDetection extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-algorithm:detector", required =  true)
    protected String detector;

    @JsonProperty(value ="ntia-algorithm:detection_domain", required = true)
    protected String detectionDomain;

    @JsonProperty(value="ntia-algorithm:units", required = true)
    protected String units;

    @JsonProperty(value="ntia-algorithm:reference", required = false)
    protected String reference;

    @JsonProperty(value="ntia-algorithm:measurement_type", required = false)
    protected String measurementType;

    public String getDetector() {
        return detector;
    }

    public void setDetector(String detector) {
        this.detector = detector;
    }

    public String getDetectionDomain() {
        return detectionDomain;
    }

    public void setDetectionDomain(String detectionDomain) {
        this.detectionDomain = detectionDomain;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}
