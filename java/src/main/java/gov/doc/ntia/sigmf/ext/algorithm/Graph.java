package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Graph<X, Y> extends AbstractDataProduct {

  @JsonProperty(required = false)
  protected List<String> series;

  @NotNull
  @JsonProperty(required = true)
  protected Integer length;

  @JsonProperty(value = "x_units")
  protected String xUnits;

  @JsonProperty(value = "x_axis")
  protected List<X> xAxis;

  @JsonProperty(value = "x_start")
  protected List<Double> xStart;

  @JsonProperty(value = "x_stop")
  protected List<Double> xStop;

  @JsonProperty(value = "x_step")
  protected List<Double> xStep;

  @JsonProperty(value = "y_units")
  protected String yUnits;

  @JsonProperty(value = "y_axis")
  protected List<Y> yAxis;

  @JsonProperty(value = "y_start")
  protected List<Double> yStart;

  @JsonProperty(value = "y_stop")
  protected List<Double> yStop;

  @JsonProperty(value = "y_step")
  protected List<Double> yStep;

  @JsonProperty(required = false)
  protected String reference;

  public Graph() {}

  public List<String> getSeries() {
    return series;
  }

  public void setSeries(List<String> series) {
    this.series = series;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public String getXUnits() {
    return xUnits;
  }

  public void setXUnits(String xUnits) {
    this.xUnits = xUnits;
  }

  public List<Double> getXStart() {
    return xStart;
  }

  public void setXStart(List<Double> xStart) {
    this.xStart = xStart;
  }

  public void addXStart(Double xStartVal) {
    if (this.xStart == null) {
      xStart = new ArrayList<>();
    }
    xStart.add(xStartVal);
  }

  public void removeXStart(Double xStartVal) {
    if (this.xStart != null) {
      xStart.remove(xStartVal);
    }
  }

  public List<Double> getXStop() {
    return xStop;
  }

  public void setXStop(List<Double> xStop) {
    this.xStop = xStop;
  }

  public void addXStop(Double xStopVal) {
    if (this.xStop == null) {
      xStop = new ArrayList<>();
    }
    xStop.add(xStopVal);
  }

  public void removeXStop(Double xStopVal) {
    if (this.xStop != null) {
      xStop.remove(xStopVal);
    }
  }

  public List<Double> getXStep() {
    return xStep;
  }

  public void setXStep(List<Double> xStep) {
    this.xStep = xStep;
  }

  public void addXStep(Double xStepVal) {
    if (this.xStep == null) {
      xStep = new ArrayList<>();
    }
    xStep.add(xStepVal);
  }

  public void removeXStep(Double xStepVal) {
    if (this.xStep != null) {
      xStep.remove(xStepVal);
    }
  }

  public String getYUnits() {
    return yUnits;
  }

  public void setYUnits(String yUnits) {
    this.yUnits = yUnits;
  }

  public List<Double> getYStart() {
    return yStart;
  }

  public void setYStart(List<Double> yStart) {
    this.yStart = yStart;
  }

  public void addYStart(Double yStartVal) {
    if (this.yStart == null) {
      yStart = new ArrayList<>();
    }
    yStart.add(yStartVal);
  }

  public void removeYStart(Double yStartVal) {
    if (this.yStart != null) {
      yStart.remove(yStartVal);
    }
  }

  public List<Double> getYStop() {
    return yStop;
  }

  public void setYStop(List<Double> yStop) {
    this.yStop = yStop;
  }

  public void addYStop(Double yStopVal) {
    if (this.yStop == null) {
      yStop = new ArrayList<>();
    }
    yStop.add(yStopVal);
  }

  public void removeYStop(Double yStopVal) {
    if (this.yStop != null) {
      yStop.remove(yStopVal);
    }
  }

  public List<Double> getYStep() {
    return yStep;
  }

  public void setYStep(List<Double> yStep) {
    this.yStep = yStep;
  }

  public void addYStep(Double yStepVal) {
    if (this.yStep == null) {
      yStep = new ArrayList<>();
    }
    yStep.add(yStepVal);
  }

  public void removeYStep(Double yStepVal) {
    if (this.yStep != null) {
      yStep.remove(yStepVal);
    }
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void addSeries(String s) {
    if (this.series == null) {
      series = new ArrayList<>();
    }
    series.add(s);
  }

  public void removeSeries(String s) {
    if (series != null) {
      series.remove(s);
    }
  }

  public List<X> getxAxis() {
    return xAxis;
  }

  public void setxAxis(List<X> xAxis) {
    this.xAxis = xAxis;
  }

  public List<Y> getyAxis() {
    return yAxis;
  }

  public void setyAxis(List<Y> yAxis) {
    this.yAxis = yAxis;
  }
}
