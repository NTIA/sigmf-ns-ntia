package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Capture {


    @JsonProperty("core:sample-start")
    protected long sampleStart;

    @JsonProperty(value = "core:global_index", required= false)
    protected Long globalIndex;

    @JsonProperty(value="core:frequency", required= false)
    protected Double frequency;

    @JsonProperty(value ="core:datetime",required=false )
    protected String dateTime;


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getGlobalIndex() {
        return globalIndex;
    }

    public void setGlobalIndex(Long globalIndex) {
        this.globalIndex = globalIndex;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Long getSampleStart() {
        return sampleStart;
    }

    public void setSampleStart(int sampleStart) {
        this.sampleStart = sampleStart;
    }


}
