package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="filter_type", required = false)
    protected String filterType;

    @JsonProperty(value="length", required = false)
    protected Long length;

    @JsonProperty(value="frequency_cutoff", required = false)
    protected Double frequencyCutoff;


}
