package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;
import java.io.File;
import java.io.IOException;


public class SchemaGenerator {
    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonSchemaGenerator schemaGenerator = new JsonSchemaGenerator(mapper);
        try {
            JsonNode schema = schemaGenerator.generateJsonSchema(MetaDoc.class);
            String jsonSchemaAsString = mapper.writeValueAsString(schema);
            mapper.writeValue(new File("sigmf-ns-ntia.schematest"), schema);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
