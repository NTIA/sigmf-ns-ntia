package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class TraceDataProduct extends DataProduct {

  @NotNull
  @JsonProperty(required = true)
  public List<Trace> traces;

  @NotNull
  @JsonProperty(required = true)
  protected Long samples;

  public void addTrace(Trace trace) {
    if (traces == null) {
      traces = new ArrayList<>();
    }
    traces.add(trace);
  }

  public void removeTrace(int i) {
    traces.remove(i);
  }

  public List<Trace> getTraces() {
    return traces;
  }

  public void setTraces(List<Trace> traces) {
    this.traces = traces;
  }

  public Long getSamples() {
    return samples;
  }

  public void setSamples(Long samples) {
    this.samples = samples;
  }
}
