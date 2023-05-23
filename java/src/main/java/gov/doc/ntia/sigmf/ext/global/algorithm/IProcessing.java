package gov.doc.ntia.sigmf.ext.global.algorithm;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FFT.class),
  @JsonSubTypes.Type(value = DigitalFilter.class)
})
public interface IProcessing {

  String getId();

  String getDescription();
}
