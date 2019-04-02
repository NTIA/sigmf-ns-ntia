package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capture implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("core:sample-start")
    protected long sampleStart;

    @JsonProperty(value = "core:sample_count", required =  true)
    protected long sampleCount;

    @JsonProperty(value = "core:global_index", required= false)
    protected Long globalIndex;

    @JsonProperty(value="core:frequency", required= false)
    protected Double frequency;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
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

    public long getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(long sampleCount) {
        this.sampleCount = sampleCount;
    }

}
