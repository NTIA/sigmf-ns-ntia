package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capture implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "core:sample_start", required = true)
  protected long sampleStart;

  @JsonProperty(value = "core:global_index", required = false)
  protected Long globalIndex;

  @JsonProperty(value = "core:frequency", required = false)
  protected Double frequency;

  // 2019-04-30T15:24:24.153922Z
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "core:datetime", required = false)
  protected Date dateTime;

  @JsonProperty(value = "max_channel_power_dBm", required = false)
  protected Double maxChannelPowerdBm;

  @JsonProperty(value = "mean_channel_power_dBm", required = false)
  protected Double meanChannelPowerdBm;

  @JsonProperty(value = "overload", required = false)
  protected Boolean overload;

  @JsonProperty(value = "cal_noise_figure_dB", required = false)
  protected Double calNoiseFiguredB;

  @JsonProperty(value = "cal_gain_dB", required = false)
  protected Double calGaindB;

  @JsonProperty(value = "iq_capture_duration_msec", required = false)
  protected Integer iqCaptureDurationMsec;

  @JsonProperty(value = "sigan_attenuation_dB", required = false)
  protected Integer siganAttenuationdB;

  @JsonProperty(value = "sigan_preamp_enable", required = false)
  protected Boolean siganPreampEnable;

  @JsonProperty(value = "sigan_reference_level_dBm", required = false)
  protected Integer siganReferenceLeveldBm;

  @JsonProperty(value = "fft_sample_count", required = false)
  protected Integer fftSampleCount;

  @JsonProperty(value = "td_pwr_sample_count", required = false)
  protected Integer tdPowerSampleCount;

  @JsonProperty(value = "pfp_sample_count", required = false)
  protected Integer pfpSampleCount;

  @JsonProperty(value = "apd_sample_count", required = false)
  protected Integer apdSampleCount;

  @JsonProperty(value = "max_fft_sample_start", required = false)
  protected Integer maxFftSampleStart;

  @JsonProperty(value = "mean_fft_sample_start", required = false)
  protected Integer meanFftSampleStart;

  @JsonProperty(value = "max_td_pwr_series_sample_start", required = false)
  protected Integer maxTdPowerSeriesSampleStart;

  @JsonProperty(value = "mean_td_pwr_series_sample_start", required = false)
  protected Integer meanTdPowerSeriesSampleStart;

  @JsonProperty(value = "min_rms_pfp_sample_start", required = false)
  protected Integer minRmsPfpSampleStart;

  @JsonProperty(value = "max_rms_pfp_sample_start", required = false)
  protected Integer maxRmsPfpSampleStart;

  @JsonProperty(value = "mean_rms_pfp_sample_start", required = false)
  protected Integer meanRmsPfpSampleStart;

  @JsonProperty(value = "min_peak_pfp_sample_start", required = false)
  protected Integer minPeakPfpSampleStart;

  @JsonProperty(value = "max_peak_pfp_sample_start", required = false)
  protected Integer maxPeakPfpSampleStart;

  @JsonProperty(value = "mean_peak_pfp_sample_start", required = false)
  protected Integer meanPeakPfpSampleStart;

  @JsonProperty(value = "apd_p_sample_start", required = false)
  protected Integer apdPSampleStart;

  @JsonProperty(value = "apd_a_sample_start", required = false)
  protected Integer apdASampleStart;

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
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

  public Double getMaxChannelPowerdBm() {return this.maxChannelPowerdBm;}
  public void setMaxChannelPowerdBm(Double maxChannelPowerdBm){this.maxChannelPowerdBm = maxChannelPowerdBm;}

  public Double getMeanChannelPowerdBm(){return this.meanChannelPowerdBm;}

  public void setMeanChannelPowerdBm(Double meanChannelPowerdBm){this.meanChannelPowerdBm = meanChannelPowerdBm;}

  public Boolean getOverload(){return this.overload;}
  public void setOverload(Boolean overload){this.overload = overload;}

  public Double getCalNoiseFiguredB(){return this.calNoiseFiguredB;}
  public void setCalNoiseFiguredB(Double calNoiseFiguredB){this.calNoiseFiguredB = calNoiseFiguredB;}

  public Double getCalGaindB(){return this.calGaindB;}
  public void setCalGaindB(Double calGaindB){this.calGaindB = calGaindB;}

  public Integer getIqCaptureDurationMsec(){return this.iqCaptureDurationMsec;}
  public void setIqCaptureDurationMsec(Integer iqCaptureDurationMsec){this.iqCaptureDurationMsec = iqCaptureDurationMsec;}

  public Integer getSiganAttenuationdB(){return this.siganAttenuationdB;}
  public void setSiganAttenuationdB(Integer siganAttenuationdB){this.siganAttenuationdB = siganAttenuationdB;}

  public Boolean getSiganPreampEnable(){return this.siganPreampEnable;}
  public void setSiganPreampEnable(Boolean siganPreampEnable){this.siganPreampEnable = siganPreampEnable;}

  public Integer getSiganReferenceLeveldBm(){return this.siganReferenceLeveldBm;}
  public void setSiganReferenceLeveldBm(Integer siganReferenceLeveldBm){this.siganReferenceLeveldBm = siganReferenceLeveldBm;}

  public Integer getFftSampleCount(){return this.fftSampleCount;}
  public void setFftSampleCount(Integer fftSampleCount){this.fftSampleCount = fftSampleCount;}

  public Integer getTdPowerSampleCount(){return this.tdPowerSampleCount;}
  public void setTdPowerSampleCount(Integer tdPowerSampleCount){this.tdPowerSampleCount = tdPowerSampleCount;}

  public Integer getPfpSampleCount(){return this.pfpSampleCount;}
  public void setPfpSampleCount(Integer pfpSampleCount){this.pfpSampleCount = pfpSampleCount;}

  public Integer getApdSampleCount(){return this.apdSampleCount;}
  public void setApdSampleCount(Integer apdSampleCount){this.apdSampleCount = apdSampleCount;}

  public Integer getMaxFftSampleStart(){return this.maxFftSampleStart;}
  public void setMaxFftSampleStart(Integer maxFftSampleStart){this.maxFftSampleStart = maxFftSampleStart;}

  public Integer getMeanFftSampleStart(){return this.meanFftSampleStart;}
  public void setMeanFftSampleStart(Integer meanFftSampleStart){this.meanFftSampleStart = meanFftSampleStart;}

  public Integer getMaxTdPowerSeriesSampleStart(){return maxTdPowerSeriesSampleStart;}
  public void setMaxTdPowerSeriesSampleStart(Integer maxTdPowerSeriesSampleStart){this.maxTdPowerSeriesSampleStart = maxTdPowerSeriesSampleStart;}

  public Integer getMeanTdPowerSeriesSampleStart(){return meanTdPowerSeriesSampleStart;}
  public void setMeanTdPowerSeriesSampleStart(Integer meanTdPowerSeriesSampleStart){this.meanTdPowerSeriesSampleStart = meanTdPowerSeriesSampleStart;}

  public Integer getMinRmsPfpSampleStart(){return this.minRmsPfpSampleStart;}
  public void setMinRmsPfpSampleStart(Integer minRmsPfpSampleStart){this.minRmsPfpSampleStart = minRmsPfpSampleStart;}

  public Integer getMaxRmsPfpSampleStart(){return this.maxRmsPfpSampleStart;}
  public void setMaxRmsPfpSampleStart(Integer maxRmsPfpSampleStart){this.maxRmsPfpSampleStart = maxRmsPfpSampleStart;}

  public Integer getMeanRmsPfpSampleStart(){return this.meanRmsPfpSampleStart;}
  public void setMeanRmsPfpSampleStart(Integer meanRmsPfpSampleStart){this.meanRmsPfpSampleStart = meanRmsPfpSampleStart;}

  public Integer getMinPeakPfpSampleStart(){return this.minPeakPfpSampleStart;}
  public void setMinPeakPfpSampleStart(Integer minPeakPfpSampleStart){this.minPeakPfpSampleStart = minPeakPfpSampleStart;}

  public Integer getMaxPeakPfpSampleStart(){return this.maxPeakPfpSampleStart;}
  public void setMaxPeakPfpSampleStart(Integer maxPeakPfpSampleStart){this.maxPeakPfpSampleStart = maxPeakPfpSampleStart;}

  public Integer getMeanPeakPfpSampleStart(){return this.meanPeakPfpSampleStart;}
  public void setMeanPeakPfpSampleStart(Integer meanPeakPfpSampleStart){this.meanPeakPfpSampleStart = meanPeakPfpSampleStart;}

  public Integer getApdPSampleStart(){return this.apdPSampleStart;}
  public void setApdPSampleStart(Integer apdPSampleStart){this.apdPSampleStart = apdPSampleStart;}

  public Integer getApdASampleStart(){return this.apdASampleStart;}
  public void setApdASampleStart(Integer apdASampleStart){this.apdASampleStart = apdASampleStart;}

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }

  protected Map<String, Object> otherFields = new HashMap<>();
}
