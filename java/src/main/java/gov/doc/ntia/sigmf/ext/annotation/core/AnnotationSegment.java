package gov.doc.ntia.sigmf.ext.annotation.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.doc.ntia.sigmf.Annotation;

public class AnnotationSegment extends Annotation {

  @JsonProperty(value = "ntia-core:label", required = false)
  protected String label;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
