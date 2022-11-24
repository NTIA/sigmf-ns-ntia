package gov.doc.ntia.sigmf.ext.annotation.sensor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "ntia-sensor:object_type")
@JsonSubTypes({
    @JsonSubTypes.Type(
      value = gov.doc.ntia.sigmf.ext.annotation.sensor.UsrpSettings.class,
      name = "UsrpSettings"),
    @JsonSubTypes.Type(
      value = gov.doc.ntia.sigmf.ext.annotation.sensor.TekrsaSettings.class,
      name = "TekrsaSettings"),
    @JsonSubTypes.Type(
      value = gov.doc.ntia.sigmf.ext.annotation.sensor.KeysightN6841aSettings.class,
      name = "KeysightN684141aSettings")
})
public class SiganSettings {}
