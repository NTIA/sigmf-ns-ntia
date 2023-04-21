package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class TraceDataProduct extends DataProduct {
  public List<Trace> traces;

  @JsonProperty(required = false)
  protected String reference;

  @JsonProperty(value = "units", required = false)
  protected String units;

  @JsonProperty(required = true)
  protected Long samples;

  public void addTrace(Trace trace) {
    if (traces == null) {
      traces = new ArrayList<>();
    }
    traces.add(trace);
  }

  public void removeDetector(int i) {
    traces.remove(i);
  }

  public List<Trace> getTraces() {
    return traces;
  }

  public void setTraces(List<Trace> traces) {
    this.traces = traces;
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

  public Long getSamples() {
    return samples;
  }

  public void setSamples(Long samples) {
    this.samples = samples;
  }
}
