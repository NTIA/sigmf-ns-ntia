package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;import gov.doc.ntia.sigmf.Global;import gov.doc.ntia.sigmf.MetaDoc;import gov.doc.ntia.sigmf.SigMfReader;import org.junit.jupiter.api.Test;import java.io.File;import java.io.IOException;import static org.junit.jupiter.api.Assertions.assertEquals;public class NasctnSensorTest {


    @Test
    public void testId() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String filename;
        // Survey 2 Times
        filename = "meta.sigmf-meta";
        File sigmfFile = new File(classLoader.getResource(filename).getFile());
        ObjectMapper mapper = new ObjectMapper();
        MetaDoc metaDoc = mapper.readValue(sigmfFile, MetaDoc.class);

    }
}
