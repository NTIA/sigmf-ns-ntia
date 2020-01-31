package gov.doc.ntia.sigmf.ext.global.environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value="temperature", required = false)
    protected Double temperature;

    @JsonProperty(value="humidity", required = false)
    protected Double humidity;

    @JsonProperty(value="weather", required = false)
    protected String weather;

    @JsonProperty(value="category", required =true)
    protected String category;

    @JsonProperty(value="description", required =false)
    protected String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
