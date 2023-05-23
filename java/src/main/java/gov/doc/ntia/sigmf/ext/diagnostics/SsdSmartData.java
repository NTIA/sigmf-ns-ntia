package gov.doc.ntia.sigmf.ext.diagnostics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SsdSmartData {

  @JsonProperty(value = "test_passed")
  protected Boolean testPassed;

  @JsonProperty(value = "critical_warning")
  protected String criticalWarning;

  protected Double temp;

  @JsonProperty(value = "available_spare")
  protected Double availableSpare;

  @JsonProperty(value = "available_spare_threshold")
  protected Double availableSpareThreshold;

  @JsonProperty(value = "percentage_used")
  protected Double percentageUsed;

  @JsonProperty(value = "unsafe_shutdowns")
  protected Integer unsafeShutdowns;

  @JsonProperty(value = "integrity_errors")
  protected Integer integrityErrors;

  public Boolean getTestPassed() {
    return testPassed;
  }

  public void setTestPassed(Boolean testPassed) {
    this.testPassed = testPassed;
  }

  public String getCriticalWarning() {
    return criticalWarning;
  }

  public void setCriticalWarning(String criticalWarning) {
    this.criticalWarning = criticalWarning;
  }

  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Double getAvailableSpare() {
    return availableSpare;
  }

  public void setAvailableSpare(Double availableSpare) {
    this.availableSpare = availableSpare;
  }

  public Double getAvailableSpareThreshold() {
    return availableSpareThreshold;
  }

  public void setAvailableSpareThreshold(Double availableSpareThreshold) {
    this.availableSpareThreshold = availableSpareThreshold;
  }

  public Double getPercentageUsed() {
    return percentageUsed;
  }

  public void setPercentageUsed(Double percentageUsed) {
    this.percentageUsed = percentageUsed;
  }

  public Integer getUnsafeShutdowns() {
    return unsafeShutdowns;
  }

  public void setUnsafeShutdowns(Integer unsafeShutdowns) {
    this.unsafeShutdowns = unsafeShutdowns;
  }

  public Integer getIntegrityErrors() {
    return integrityErrors;
  }

  public void setIntegrityErrors(Integer integrityErrors) {
    this.integrityErrors = integrityErrors;
  }
}
