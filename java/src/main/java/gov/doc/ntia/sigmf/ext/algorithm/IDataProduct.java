package gov.doc.ntia.sigmf.ext.algorithm;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({@JsonSubTypes.Type(value = Graph.class)})
public interface IDataProduct {

  String getName();

  String getDescription();
}
