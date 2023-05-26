package gov.doc.ntia.sigmf.ext.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

public class Graph<T> extends AbstractDataProduct {


  @JsonProperty(required = false)
  protected List<String> series;

  @NotNull
  @JsonProperty(required = true)
  protected Integer length;

  @JsonProperty(value = "x_units")
  protected String xUnits;

  @JsonProperty(value = "x_axis")
  protected List<T> xAxis;

  @JsonProperty(value = "x_start")
  protected List<Double> xStart;

  @JsonProperty(value = "x_stop")
  protected List<Double> xStop;

  @JsonProperty(value = "x_step")
  protected List<Double> xStep;

  @JsonProperty(value = "y_units")
  protected String yUnits;

  @JsonProperty(value = "y_axis")
  protected List<T> yAxis;

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

  public List<Double> getXStop() {
    return xStop;
  }

  public void setXStop(List<Double> xStop) {
    this.xStop = xStop;
  }

  public List<Double> getXStep() {
    return xStep;
  }

  public void setXStep(List<Double> xStep) {
    this.xStep = xStep;
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

  public List<Double> getYStop() {
    return yStop;
  }

  public void setYStop(List<Double> yStop) {
    this.yStop = yStop;
  }

  public List<Double> getYStep() {
    return yStep;
  }

  public void setYStep(List<Double> yStep) {
    this.yStep = yStep;
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

  public List<T> getxAxis() {
    return xAxis;
  }

  public void setxAxis(List<T> xAxis) {
    this.xAxis = xAxis;
  }

  public List<T> getyAxis() {
    return yAxis;
  }

  public void setyAxis(List<T> yAxis) {
    this.yAxis = yAxis;
  }
}
