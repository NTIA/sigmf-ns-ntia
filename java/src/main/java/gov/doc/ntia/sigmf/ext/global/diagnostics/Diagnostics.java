package gov.doc.ntia.sigmf.ext.global.diagnostics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diagnostics implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonProperty(value = "diagnostics_datetime", required = false)
    protected Date diagnosticsDatetime;

    @JsonProperty(value = "preselector", required = false)
    protected Preselector preselector;

    @JsonProperty(value = "spu_x410", required = false)
    protected SpuX410 spuX410;

    @JsonProperty(value = "spu_computer", required = false)
    protected SpuComputer spuComputer;

    public Date getDiagnosticsDatetime() {
        return diagnosticsDatetime;
    }

    public void setDiagnosticsDatetime(Date diagnosticsDatetime) {
        this.diagnosticsDatetime = diagnosticsDatetime;
    }

    public Preselector getPreselector(){return this.preselector;}
    public void setPreselector(Preselector preselector){this.preselector = preselector;}

    public SpuX410 getSpuX410(){return this.spuX410;}
    public void setSpuX410(SpuX410 spuX410){this.spuX410 = spuX410;}

    public SpuComputer getSpuComputer(){return this.spuComputer;}
    public void setSpuComputer(SpuComputer spuComputer){this.spuComputer = spuComputer;}
}
