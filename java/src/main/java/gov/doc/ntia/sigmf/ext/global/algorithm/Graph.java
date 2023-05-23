package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;import java.util.List;
import javax.validation.constraints.NotNull;

public class Graph implements IDataProduct {

  @NotNull @JsonProperty protected String name;

  @JsonProperty protected List<String> series;

  @NotNull
  @JsonProperty(required = true)
  protected Integer length;

  @JsonProperty(value = "x_label")
  protected String xLabel;

  @JsonProperty(value = "x_start")
  protected List<Double> xStart;

  @JsonProperty(value = "x_stop")
  protected List<Double> xStop;

  @JsonProperty(value = "x_step")
  protected List<Double> xStep;

  @JsonProperty(value = "y_label")
  protected String yLabel;

  @JsonProperty(value = "y_start")
  protected List<Double> yStart;

  @JsonProperty(value = "y_stop")
  protected List<Double> yStop;

  @JsonProperty(value = "y_step")
  protected List<Double> yStep;

  @JsonProperty protected List<String> processing;

  @JsonProperty protected String reference;

  @JsonProperty
  protected String description;

  public Graph(){

  }

  @Override
  public String getName() {
    return name;
  }

  public void setDescription(String description){
    this.description = description;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

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

  public String getXLabel() {
    return xLabel;
  }

  public void setXLabel(String xLabel) {
    this.xLabel = xLabel;
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

  public String getYLabel() {
    return yLabel;
  }

  public void setYLabel(String label){
      yLabel = label;
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

  public List<String> getProcessing() {
    return processing;
  }

  public void setProcessing(List<String> processing) {
    this.processing = processing;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public void addSeries(String s){
    if(this.series == null){
      series = new ArrayList<>();
    }
    series.add(s);
  }

  public void removeSeries(String s){
    if(series != null){
      series.remove(s);
    }
  }

}
