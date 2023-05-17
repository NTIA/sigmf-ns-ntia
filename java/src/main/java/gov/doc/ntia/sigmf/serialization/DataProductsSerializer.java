package gov.doc.ntia.sigmf.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import gov.doc.ntia.sigmf.ext.global.algorithm.DataProduct;
import gov.doc.ntia.sigmf.ext.global.algorithm.DataProducts;
import java.io.IOException;
import java.util.ArrayList;

public class DataProductsSerializer extends StdSerializer<DataProducts> {

  public DataProductsSerializer() {
    this(null);
  }

  public DataProductsSerializer(Class<DataProducts> t) {
    super(t);
  }

  @Override
  public void serialize(DataProducts value, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    gen.writeStartObject();
    ArrayList<DataProduct> dataProducts = value.getDataProducts();
    if (value.getDigitalFilter() != null) {
      gen.writeStringField("digital_filter", value.getDigitalFilter());
    }
    if(value.getReference() != null){
      gen.writeStringField("reference", value.getReference());
    }
    for (DataProduct dp : dataProducts) {
      gen.writeObjectField(dp.getFieldName(), dp);
    }

    gen.writeEndObject();
  }
}
