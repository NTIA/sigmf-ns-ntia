package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpuX410 implements Serializable {

    @JsonProperty(value = "rf_tray_powered", required = false)
    protected Boolean rfTrayPowered;

    @JsonProperty(value = "preselector_powered", required = false)
    protected Boolean preselectorPowered;

    @JsonProperty(value = "28v_aux_powered", required = false)
    protected Boolean aux28vPowered;

    @JsonProperty(value = "pwr_box_temp_degC", required = false)
    protected Double powerBoxTempDegC;

    @JsonProperty(value = "rf_box_temp_degC", required = false)
    protected Double rfBoxTempDegC;

    @JsonProperty(value = "pwr_box_humidity_pct", required = false)
    protected Double powerBoxHumidityPct;

    public Boolean getRfTrayPowered(){return this.rfTrayPowered;}
    public void setRfTrayPowered(Boolean rfTrayPowered){this.rfTrayPowered = rfTrayPowered;}

    public Boolean getPreselectorPowered(){return this.preselectorPowered;}
    public void setPreselectorPowered(Boolean preselectorPowered){this.preselectorPowered = preselectorPowered;}

    public Boolean getAux28vPowered(){return this.aux28vPowered;}
    public void setAux28vPowered(Boolean aux28vPowered){this.aux28vPowered = aux28vPowered;}

    public Double getPowerBoxTempDegC(){return this.powerBoxTempDegC;}
    public void setPowerBoxTempDegC(Double powerBoxTempDegC){this.powerBoxTempDegC = powerBoxTempDegC;}

    public Double getRfBoxTempDegC(){return this.rfBoxTempDegC;}
    public void setRfBoxTempDegC(Double rfBoxTempDegC){this.rfBoxTempDegC = rfBoxTempDegC;}

    public Double getPowerBoxHumidityPct(){return this.powerBoxHumidityPct;}
    public void setPowerBoxHumidityPct(Double powerBoxHumidityPct){this.powerBoxHumidityPct = powerBoxHumidityPct;}

}
