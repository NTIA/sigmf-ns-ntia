package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SigMFReader {
    public static MetaDoc read(String fileName){
        ObjectMapper mapper = new ObjectMapper();
        try {
            MetaDoc metaDoc = (MetaDoc)mapper.readValue(new File(fileName), MetaDoc.class);
            return metaDoc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
