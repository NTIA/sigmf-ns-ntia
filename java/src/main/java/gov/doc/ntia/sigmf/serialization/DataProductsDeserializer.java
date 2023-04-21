package gov.doc.ntia.sigmf.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import gov.doc.ntia.sigmf.ext.global.algorithm.AmplitudeProbabilityDistribution;
import gov.doc.ntia.sigmf.ext.global.algorithm.DataProducts;
import gov.doc.ntia.sigmf.ext.global.algorithm.PeriodicFramePower;
import gov.doc.ntia.sigmf.ext.global.algorithm.PowerSpectralDensity;
import gov.doc.ntia.sigmf.ext.global.algorithm.TimeSeriesPower;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class DataProductsDeserializer extends StdDeserializer<DataProducts> {

  public DataProductsDeserializer() {
    this(null);
  }

  public DataProductsDeserializer(Class<?> extensions) {
    super(extensions);
  }

  @Override
  public DataProducts deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
    ObjectMapper mapper = new ObjectMapper();
    DataProducts dataProducts = new DataProducts();
    while (fields.hasNext()) {
      Map.Entry<String, JsonNode> field = fields.next();
      String dataProductType = field.getKey();
      switch (dataProductType) {
        case "reference":
          dataProducts.setReference(field.getValue().asText());
          break;
        case "digital_filter":
          dataProducts.setDigitalFilter(field.getValue().asText());
          break;
        case "periodic_frame_power":
          PeriodicFramePower pfp = mapper.convertValue(field.getValue(), PeriodicFramePower.class);
          dataProducts.add(pfp);
          break;
        case "time_series_power":
          TimeSeriesPower tsp = mapper.convertValue(field.getValue(), TimeSeriesPower.class);
          dataProducts.add(tsp);
          break;
        case "power_spectral_density":
          PowerSpectralDensity psd =
              mapper.convertValue(field.getValue(), PowerSpectralDensity.class);
          dataProducts.add(psd);
          break;
        case "amplitude_probability_distribution":
          AmplitudeProbabilityDistribution apd =
              mapper.convertValue(field.getValue(), AmplitudeProbabilityDistribution.class);
          dataProducts.add(apd);
          break;
      }
    }
    return dataProducts;
  }
}
