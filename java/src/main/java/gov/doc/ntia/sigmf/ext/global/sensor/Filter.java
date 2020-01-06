package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;

public class Filter {


    @JsonProperty(value="filter_spec", required = false)
    protected HardwareSpec filterSpec;

    @JsonProperty(value="low_frequency_passband", required = false)
    protected Double lowFrequencyPassband;


    @JsonProperty(value="high_frequency_passband", required = false)
    protected Double highFrequencyPassband;


    @JsonProperty(value="low_frequency_stopband", required = false)
    protected Double lowFrequencyStopband;


    @JsonProperty(value ="high_frequency_stopband", required = false)
    protected Double highFrequencyStopband;


    public HardwareSpec getFilterSpec() {
        return filterSpec;
    }

    public void setFilterSpec(HardwareSpec filterSpec) {
        this.filterSpec = filterSpec;
    }

    public Double getLowFrequencyPassband() {
        return lowFrequencyPassband;
    }

    public void setLowFrequencyPassband(Double lowFrequencyPassband) {
        this.lowFrequencyPassband = lowFrequencyPassband;
    }

    public Double getHighFrequencyPassband() {
        return highFrequencyPassband;
    }

    public void setHighFrequencyPassband(Double highFrequencyPassband) {
        this.highFrequencyPassband = highFrequencyPassband;
    }

    public Double getLowFrequencyStopband() {
        return lowFrequencyStopband;
    }

    public void setLowFrequencyStopband(Double getLowFrequencyStopband) {
        this.lowFrequencyStopband = getLowFrequencyStopband;
    }

    public Double getHighFrequencyStopband() {
        return highFrequencyStopband;
    }

    public void setHighFrequencyStopband(Double getHighFrequencyStopband) {
        this.highFrequencyStopband = getHighFrequencyStopband;
    }




}