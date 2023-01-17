package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preselector implements Serializable {
    @JsonProperty(value = "internal_temp_degC", required = false)
    protected Double internalTempDegC;

    @JsonProperty(value = "noise_diode_temp_degC", required = false)
    protected Double noiseDiodeTempDegC;

    @JsonProperty(value = "lna_temp_degC", required = false)
    protected Double lnaTempDegC;

    @JsonProperty(value = "internal_humidity_pct", required = false)
    protected Double internalHumidityPct;

    @JsonProperty(value = "door_closed", required = false)
    protected Boolean doorClosed;

    public Double getInternalTempDegC(){return this.internalTempDegC;}
    public void setInternalTempDegC(Double internalTempDegC){this.internalTempDegC = internalTempDegC;}

    public Double getNoiseDiodeTempDegC(){return this.noiseDiodeTempDegC;}
    public void setNoiseDiodeTempDegC(Double noiseDiodeTempDegC){this.noiseDiodeTempDegC = noiseDiodeTempDegC;}

    public Double getLnaTempDegC(){return this.lnaTempDegC;}
    public void setLnaTempDegC(Double lnaTempDegC){this.lnaTempDegC = lnaTempDegC;}

    public Double getInternalHumidityPct(){return this.internalHumidityPct;}
    public void setInternalHumidityPct(Double internalHumidityPct){this.internalHumidityPct = internalHumidityPct;}

    public Boolean getDoorClosed(){return this.doorClosed;}
    public void setDoorClosed(Boolean doorClosed){this.doorClosed = doorClosed;}
}
