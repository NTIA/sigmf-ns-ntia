package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.ExtensionsDeserializer;
import gov.doc.ntia.sigmf.serialization.ExtensionsSerializer;

import java.util.ArrayList;

@JsonSerialize(using = ExtensionsSerializer.class)
@JsonDeserialize(using = ExtensionsDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Extensions {
    protected ArrayList<Extension> extensions;

    public Extensions(){
        extensions = new ArrayList<>();
    }

    public ArrayList<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(ArrayList<Extension> extensions) {
        this.extensions = extensions;
    }


    public void addExtension(Extension extension) {
        extensions.add(extension);
    }
}
