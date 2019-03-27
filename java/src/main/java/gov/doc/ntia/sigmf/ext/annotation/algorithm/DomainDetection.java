package gov.doc.ntia.sigmf.ext.annotation.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

public class DomainDetection extends Annotation {
    @JsonProperty(value="ntia-algorithm:detector", required =  true)
    protected String detector;

    @JsonProperty(value ="ntia-algorithm:detection_domain", required = true)
    protected String detectionDomain;

    @JsonProperty(value="ntia-algorithm:units", required = true)
    protected String units;

    @JsonProperty(value="ntia-algorithm:reference", required = false)
    protected String reference;

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


}
