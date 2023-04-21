package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Trace {

  protected String detector;

  protected String statistic;

  public Trace() {}

  public Trace(String detector, String statistic) {
    this.detector = detector;
    this.statistic = statistic;
  }

  public String getDetector() {
    return detector;
  }

  public void setDetector(String detector) {
    this.detector = detector;
  }

  public String getStatistic() {
    return statistic;
  }

  public void setStatistic(String statistic) {
    this.statistic = statistic;
  }
}
