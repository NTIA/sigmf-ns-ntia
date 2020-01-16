package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensorEnvironment extends Environment  {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="ntia-environment:category", required = false)
    protected String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




}
