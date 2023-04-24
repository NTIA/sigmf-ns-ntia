package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.ext.global.algorithm.DataProduct;
import gov.doc.ntia.sigmf.ext.global.algorithm.DataProducts;
import gov.doc.ntia.sigmf.ext.global.algorithm.DigitalFilter;
import gov.doc.ntia.sigmf.ext.global.core.Measurement;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Diagnostics;
import gov.doc.ntia.sigmf.ext.global.emitter.Emitter;
import gov.doc.ntia.sigmf.ext.global.scos.Action;
import gov.doc.ntia.sigmf.ext.global.scos.ScheduleEntry;
import gov.doc.ntia.sigmf.ext.global.sensor.Sensor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class Global implements Serializable {

  private static final long serialVersionUID = 1L;

  // The format of the stored samples in the dataset file.
  // Its value must be a valid SigMF dataset format type string.
  @JsonProperty(value = "core:datatype", required = true)
  protected String datatype;

  // The sample rate of the signal in samples per second.
  @JsonProperty(value = "core:sample_rate", required = false)
  protected Double sampleRate;

  // The version of the SigMF specification used to create the metadata file.
  @JsonProperty(value = "core:version", required = true)
  protected String version;

  // Total number of interleaved channels in the dataset file.
  // If omitted, this defaults to one.
  @JsonProperty(value = "core:num_channels", required = false)
  protected Long numChannels = 1L;

  // The SHA512 hash of the dataset file associated with the SigMF file.
  @JsonProperty(value = "core:sha512", required = false)
  protected String sha512;

  // The index number of the first sample in the dataset.
  // This value defaults to zero. Typically used when a recording is split over multiple files.
  @JsonProperty(value = "core:offset", required = false)
  protected Long offset;

  // A text description of the SigMF recording.
  @JsonProperty(value = "core:description", required = false)
  protected String description;

  // The author's name (and optionally e-mail address).
  @JsonProperty(value = "core:author", required = false)

  protected String author;

  // The registered DOI (ISO 26324) for a recording's metadata file.
  @JsonProperty(value = "core:meta_doi", required = false)
  protected String metaDoi;

  // The registered DOI (ISO 26324) for a recording's dataset file.
  @JsonProperty(value = "core:data_doi", required = false)
  protected String dataDoi;

  // The name of the software used to make this SigMF recording.
  @JsonProperty(value = "core:recorder", required = false)
  protected String recorder;

  // A URL for the license document under which the recording is offered;
  // when possible, use the canonical document provided by the license author,
  // or, failing that, a well-known one.
  @JsonProperty(value = "core:license", required = false)
  protected String license;

  // A text description of the hardware used to make the recording.
  @JsonProperty(value = "core:hw", required = false)
  protected String hw;

  // The full filename of the dataset this metadata describes
  @JsonProperty(value = "core:dataset", required = false)
  protected String dataset;

  // The number of bytes to ignore at the end of a Non-Conforming dataset file
  @JsonProperty(value = "core:trailing_bytes", required = false)
  protected Long trailingBytes;

  // Indicates the metadata is intentionally distributed without the dataset
  @JsonProperty(value = "core:metadata_only", required = false)
  protected Boolean metadataOnly;

  // the location of the recording system
  @JsonProperty(value = "core:geolocation", required = false)
  protected GeoJsonPoint geolocation;

  // A list of JSON objects describing extensions used by this recording
  // TODO: Update the extensions object
  @JsonProperty(value = "core:extensions", required = false)
  protected Extensions extensions;

  // The base filename of a SigMF collection with which this recording is associated
  @JsonProperty(value = "core:collection", required = false)
  protected String collection;

  @JsonProperty(value = "ntia-sensor:sensor", required = false)
  protected Sensor sensor;

  @JsonProperty(value = "ntia-emitter:emitters", required = false)
  protected List<Emitter> emitters;

  @JsonProperty(value = "ntia-scos:action", required = true)
  protected Action action;

  @JsonProperty(value = "ntia-scos:schedule", required = true)
  protected ScheduleEntry schedule;

  protected Map<String, Object> otherFields = new HashMap<>();

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "ntia-sensor:calibration_datetime", required = false)
  protected Date calibrationDate;

  @JsonProperty(value = "ntia-scos:data_file_path", required = false)
  protected String filePath;

  @JsonProperty(value = "ntia-scos:task", required = false)
  protected Integer task;

  @JsonProperty(value = "ntia-scos:recording", required = false)
  protected Integer recording;

  @JsonProperty(value = "ntia-core:classification", required = true)
  protected String classification;

  @JsonProperty(value = "ntia-algorithm:data_products", required = false)
  protected DataProducts dataProducts;

  @JsonProperty(value = "ntia-algorithm:digital_filters")
  protected ArrayList<DigitalFilter> digitalFilters;

  @JsonProperty(value = "ntia-diagnostics:diagnostics")
  protected Diagnostics diagnostics;

  @JsonProperty(value = "ntia-nasctn-sea:max_of_max_channel_poowers")
  protected ArrayList<Double> maxOfMaxChannelPowers;

  @JsonProperty(value = "ntia-nasctn-sea:median_of_mean_channel_powers")
  protected ArrayList<Double> medianOfMeanChannelPowers;

  public Integer getRecording() {
    return recording;
  }

  public void setRecording(Integer recording) {
    this.recording = recording;
  }

  public String getSha512() {
    return sha512;
  }

  public void setSha512(String sha512) {
    this.sha512 = sha512;
  }

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getMetaDoi() {
    return metaDoi;
  }

  public void setMetaDoi(String metaDoi) {
    this.metaDoi = metaDoi;
  }

  public String getDataDoi() {
    return dataDoi;
  }

  public void setDataDoi(String dataDoi) {
    this.dataDoi = dataDoi;
  }

  public String getRecorder() {
    return recorder;
  }

  public void setRecorder(String recorder) {
    this.recorder = recorder;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getHw() {
    return hw;
  }

  public void setHw(String hw) {
    this.hw = hw;
  }

  public Extensions getExtensions() {
    return extensions;
  }

  public void setExtensions(Extensions extensions) {
    this.extensions = extensions;
  }

  public String getDatatype() {
    return datatype;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }

  public Double getSampleRate() {
    return sampleRate;
  }

  public void setSampleRate(Double sampleRate) {
    this.sampleRate = sampleRate;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public List<Emitter> getEmitters() {
    return emitters;
  }

  public void setEmitters(List<Emitter> emitters) {
    this.emitters = emitters;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public ScheduleEntry getSchedule() {
    return schedule;
  }

  public void setSchedule(ScheduleEntry schedule) {
    this.schedule = schedule;
  }

  public Integer getTask() {
    return task;
  }

  public void setTask(Integer task) {
    this.task = task;
  }

  public Sensor getSensor() {
    return sensor;
  }

  public void setSensor(Sensor sensor) {
    this.sensor = sensor;
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }

  public Date getCalibrationDate() {
    return calibrationDate;
  }

  public void setCalibrationDate(Date calibrationDate) {
    this.calibrationDate = calibrationDate;
  }

  public String getFilepath() {
    return filePath;
  }

  public void setFilepath(String filePath) {
    this.filePath = filePath;
  }

  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public Long getNumChannels() {
    return numChannels;
  }

  public void setNumChannels(Long numChannels) {
    this.numChannels = numChannels;
  }

  public String getDataset() {
    return dataset;
  }

  public void setDataset(String dataset) {
    this.dataset = dataset;
  }

  public Long getTrailingBytes() {
    return trailingBytes;
  }

  public void setTrailingBytes(Long trailingBytes) {
    this.trailingBytes = trailingBytes;
  }

  public Boolean getMetadataOnly() {
    return metadataOnly;
  }

  public void setMetadataOnly(Boolean metadataOnly) {
    this.metadataOnly = metadataOnly;
  }

  public GeoJsonPoint getGeolocation() {
    return this.geolocation;
  }

  public void setGeolocation(GeoJsonPoint location) {
    this.geolocation = location;
  }

  public String getCollection() {
    return collection;
  }

  public void setCollection(String collection) {
    this.collection = collection;
  }

  public void addDataProduct(DataProduct dataProduct) {
    if (this.dataProducts == null) {
      dataProducts = new DataProducts();
    }
    dataProducts.add(dataProduct);
  }

  public void removeDataProduct(DataProduct dataProduct) {
    if (dataProducts != null) {
      dataProducts.remove(dataProduct);
    }
  }

  public DataProducts getDataProducts() {
    return dataProducts;
  }

  public void addDigitalFilter(DigitalFilter df) {
    if (this.digitalFilters == null) {
      digitalFilters = new ArrayList<DigitalFilter>();
    }
    digitalFilters.add(df);
  }

  public ArrayList<DigitalFilter> getDigitalFilters() {
    return digitalFilters;
  }

  public Diagnostics getDiagnostics() {
    return diagnostics;
  }

  public void setDiagnostics(Diagnostics diagnostics) {
    this.diagnostics = diagnostics;
  }

  public ArrayList<Double> getMaxOfMaxChannelPowers() {
    return maxOfMaxChannelPowers;
  }

  public void setMaxOfMaxChannelPowers(ArrayList<Double> maxOfMaxChannelPowers) {
    this.maxOfMaxChannelPowers = maxOfMaxChannelPowers;
  }

  public ArrayList<Double> getMedianOfMeanChannelPowers() {
    return medianOfMeanChannelPowers;
  }

  public void setMedianOfMeanChannelPowers(ArrayList<Double> medianOfMeanChannelPowers) {
    this.medianOfMeanChannelPowers = medianOfMeanChannelPowers;
  }
}
