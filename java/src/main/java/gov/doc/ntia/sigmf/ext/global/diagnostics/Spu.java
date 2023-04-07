package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Spu {

    @JsonProperty(value = "rf_tray_powered")
    protected Boolean rfTrayPowered;
    
    @JsonProperty(value = "preselector_powered")
    protected Boolean preselectorPowered;
    
    @JsonProperty(value = "28v_aux_powered")
    protected Boolean aux28vPowered;
    
    @JsonProperty(value = "pow_box_temp")
    protected Double pwrBoxTemp;
    
    @JsonProperty(value = "rf_box_temp")
    protected Double rfBoxTemp;
    
    @JsonProperty(value = "pwr_box_humidity")
    protected Double pwrBoxHumidity;
    
    @JsonProperty(value = "sigan_internal_temp")
    protected Double siganInternalTemp;

  public Boolean getRfTrayPowered() {
    return rfTrayPowered;
  }

  public void setRfTrayPowered(Boolean rfTrayPowered) {
    this.rfTrayPowered = rfTrayPowered;
  }

  public Boolean getPreselectorPowered() {
    return preselectorPowered;
  }

  public void setPreselectorPowered(Boolean preselectorPowered) {
    this.preselectorPowered = preselectorPowered;
  }

  public Boolean getAux28vPowered() {
    return aux28vPowered;
  }

  public void setAux28vPowered(Boolean aux28vPowered) {
    this.aux28vPowered = aux28vPowered;
  }

  public Double getPwrBoxTemp() {
    return pwrBoxTemp;
  }

  public void setPwrBoxTemp(Double pwrBoxTemp) {
    this.pwrBoxTemp = pwrBoxTemp;
  }

  public Double getRfBoxTemp() {
    return rfBoxTemp;
  }

  public void setRfBoxTemp(Double rfBoxTemp) {
    this.rfBoxTemp = rfBoxTemp;
  }

  public Double getPwrBoxHumidity() {
    return pwrBoxHumidity;
  }

  public void setPwrBoxHumidity(Double pwrBoxHumidity) {
    this.pwrBoxHumidity = pwrBoxHumidity;
  }

  public Double getSiganInternalTemp() {
    return siganInternalTemp;
  }

  public void setSiganInternalTemp(Double siganInternalTemp) {
    this.siganInternalTemp = siganInternalTemp;
  }
}
