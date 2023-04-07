package gov.doc.ntia.sigmf.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Extensions;
import java.io.IOException;
import java.util.ArrayList;

public class ExtensionsSerializer extends StdSerializer<Extensions> {

  public ExtensionsSerializer() {
    this(null);
  }

  public ExtensionsSerializer(Class<Extensions> t) {
    super(t);
  }

  @Override
  public void serialize(Extensions value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    jgen.writeStartObject();
    ArrayList<Extension> extensions = value.getExtensions();
    for (Extension ext : extensions) {
      jgen.writeStringField(ext.getName(), ext.getVersion());
    }
    jgen.writeEndObject();
  }
}
