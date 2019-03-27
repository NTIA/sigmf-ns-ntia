package gov.doc.ntia.sigmf.ext.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalFilter {

    @JsonProperty(value="ntia-sensor:filter_type", required = false)
    protected String filterType;

    @JsonProperty(value="ntia-sensor:length", required = false)
    protected Long length;

    @JsonProperty(value="ntia-sensor:frequency_cutoff", required = false)
    protected Double frequencyCutoff;


}
