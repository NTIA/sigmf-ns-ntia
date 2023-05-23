package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import gov.doc.ntia.sigmf.ext.annotation.sensor.SensorAnnotation;import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

@JsonTypeInfo(use=DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Graph.class)

})
public interface IDataProduct {

    public String getName();

    public String getDescription();

}
