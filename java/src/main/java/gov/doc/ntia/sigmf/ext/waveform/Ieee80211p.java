package gov.doc.ntia.sigmf.ext.waveform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.waveform.CodingRate;
import gov.doc.ntia.sigmf.ext.waveform.Waveform;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ieee80211p extends Waveform implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "info_bit_generation", required = false)
  protected String infoBitGeneration;

  @JsonProperty(value = "coding_rate", required = false)
  protected gov.doc.ntia.sigmf.ext.waveform.CodingRate codingRate;

  @JsonProperty(value = "packet_length", required = false)
  protected Long packetLength;

  @JsonProperty(value = "modulation", required = false)
  protected String modulation;

  @JsonProperty(value = "encoder", required = false)
  protected String encoder;

  @JsonProperty(value = "number_of_subcarriers", required = false)
  protected Long numberOfSubcarriers;

  @JsonProperty(value = "number_of_data_subcarriers", required = false)
  protected long numberOfDataSubcarriers;

  @JsonProperty(value = "number_of_pilots", required = false)
  protected long numberOfPilots;

  @JsonProperty(value = "cyclic_prefix", required = false)
  protected Long cyclicPrefix;

  @JsonProperty(value = "short_inter_frame_space", required = false)
  protected Double shortInterFrameSpace;

  @JsonProperty(value = "preamble_frame", required = false)
  protected Integer[] preambleFrame;

  @JsonProperty(value = "number_of_info_bits", required = false)
  protected Long numberOfInfoBits;

  @JsonProperty(value = "signal_to_noise_ratio", required = false)
  protected Double signalToNoiseRatio;

  public Ieee80211p() {}

  public String getInfoBitGeneration() {
    return infoBitGeneration;
  }

  public void setInfoBitGeneration(String infoBitGeneration) {
    this.infoBitGeneration = infoBitGeneration;
  }

  public gov.doc.ntia.sigmf.ext.waveform.CodingRate getCodingRate() {
    return codingRate;
  }

  public void setCodingRate(CodingRate codingRate) {
    this.codingRate = codingRate;
  }

  public Long getPacketLength() {
    return packetLength;
  }

  public void setPacketLength(Long packetLength) {
    this.packetLength = packetLength;
  }

  public String getModulation() {
    return modulation;
  }

  public void setModulation(String modulation) {
    this.modulation = modulation;
  }

  public String getEncoder() {
    return encoder;
  }

  public void setEncoder(String encoder) {
    this.encoder = encoder;
  }

  public Long getNumberOfSubcarriers() {
    return numberOfSubcarriers;
  }

  public void setNumberOfSubcarriers(Long numberOfSubcarriers) {
    this.numberOfSubcarriers = numberOfSubcarriers;
  }

  public long getNumberOfDataSubcarriers() {
    return numberOfDataSubcarriers;
  }

  public void setNumberOfDataSubcarriers(long numberOfDataSubcarriers) {
    this.numberOfDataSubcarriers = numberOfDataSubcarriers;
  }

  public long getNumberOfPilots() {
    return numberOfPilots;
  }

  public void setNumberOfPilots(long numberOfPilots) {
    this.numberOfPilots = numberOfPilots;
  }

  public Long getCyclicPrefix() {
    return cyclicPrefix;
  }

  public void setCyclicPrefix(Long cyclicPrefix) {
    this.cyclicPrefix = cyclicPrefix;
  }

  public Double getShortInterFrameSpace() {
    return shortInterFrameSpace;
  }

  public void setShortInterFrameSpace(Double shortInterFrameSpace) {
    this.shortInterFrameSpace = shortInterFrameSpace;
  }

  public Integer[] getPreambleFrame() {
    return preambleFrame;
  }

  public void setPreambleFrame(Integer[] preambleFrame) {
    this.preambleFrame = preambleFrame;
  }

  public Long getNumberOfInfoBits() {
    return numberOfInfoBits;
  }

  public void setNumberOfInfoBits(Long numberOfInfoBits) {
    this.numberOfInfoBits = numberOfInfoBits;
  }

  public Double getSignalToNoiseRatio() {
    return signalToNoiseRatio;
  }

  public void setSignalToNoiseRatio(Double signalToNoiseRatio) {
    this.signalToNoiseRatio = signalToNoiseRatio;
  }
}
