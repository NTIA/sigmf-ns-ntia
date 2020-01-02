package gov.doc.ntia.sigmf.ext.annotation.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Environment extends Annotation implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty(value="ntia-environment:temperature", required = false)
    protected Double temperature;


    @JsonProperty(value="ntia-environment:humidity", required = false)
    protected Double humidity;

    @JsonProperty(value="ntia-environment:weather", required = false)
    protected String weather;

    @JsonProperty(value="ntia-environment:category", required =true)
    protected String category;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String environment) {
        this.category = environment;
    }



}
