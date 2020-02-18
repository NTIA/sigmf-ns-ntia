package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    @Test
    public void testId() throws IOException {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        Sensor sensor = new Sensor();
        String sensorId = "TestSensor123";
        sensor.setId(sensorId);
        global.setSensor(sensor);
        metaDoc.setGlobal(global);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(sensorId, metaDoc.getGlobal().getSensor().getId());
    }

    @Test
    public void testMobile() throws IOException {
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        Sensor sensor = new Sensor();
        String sensorId = "TestSensor123";
        sensor.setId(sensorId);
        sensor.setMobile(Boolean.TRUE);
        global.setSensor(sensor);
        metaDoc.setGlobal(global);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(Boolean.TRUE, metaDoc.getGlobal().getSensor().getMobile());
    }






}