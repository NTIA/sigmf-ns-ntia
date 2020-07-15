package gov.doc.ntia.sigmf.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Extensions;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ExtensionsDeserializer extends StdDeserializer<Extensions> {

  public ExtensionsDeserializer() {
    this(null);
  }

  public ExtensionsDeserializer(Class<?> extensions) {
    super(extensions);
  }

  @Override
  public Extensions deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    Extensions extensions = new Extensions();
    JsonNode node = jp.getCodec().readTree(jp);
    Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
    while (fields.hasNext()) {
      Map.Entry<String, JsonNode> field = fields.next();
      Extension extension = new Extension();
      extension.setName(field.getKey());
      extension.setVersion(field.getValue().asText());
      extensions.addExtension(extension);
    }
    return extensions;
  }
}
