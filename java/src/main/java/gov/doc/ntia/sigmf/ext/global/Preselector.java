package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-sensor:rf_paths", required = false)
    protected RFPath[] rfPaths;

    public RFPath[] getRfPaths() {
        return rfPaths;
    }

    public void setRfPaths(RFPath[] rfPaths) {
        this.rfPaths = rfPaths;
    }







}
