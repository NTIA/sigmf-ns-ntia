package gov.doc.ntia.sigmf.ext.global.sensor;


import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AntennaTests {

    private MetaDoc getMetaDocWithSensorAndAntenna(){
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        Sensor sensor = new Sensor();
        Antenna antenna = new Antenna();
        sensor.setAntenna(antenna);
        global.setSensor(sensor);
        metaDoc.setGlobal(global);
        return metaDoc;
    }

    @Test
    public void testAntennaSpec() throws IOException {

        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        HardwareSpec antennaSpec = new HardwareSpec();
        antennaSpec.setSupplementalInformation("supplemental info");
        antennaSpec.setModel("model");
        antennaSpec.setId("antenna123");
        antennaSpec.setDescription("description");
        metaDoc.getGlobal().getSensor().getAntenna().setAntennaSpec(antennaSpec);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getId(), readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getId());
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getDescription(), readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getDescription());
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getModel(), readMetaDoc.getGlobal().getSensor().getAntenna().getAntennaSpec().getModel());
    }


    @Test
    public void testType() throws IOException {
        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        metaDoc.getGlobal().getSensor().getAntenna().setType("antennaType");
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getType(), readMetaDoc.getGlobal().getSensor().getAntenna().getType());

    }

    @Test
    public void testLowFrequency() throws IOException {
        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        metaDoc.getGlobal().getSensor().getAntenna().setLowFrequency(100.0);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getLowFrequency(), readMetaDoc.getGlobal().getSensor().getAntenna().getLowFrequency());

    }


    @Test
    public void testHighFrequency() throws IOException {
        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        metaDoc.getGlobal().getSensor().getAntenna().setHighFrequency(100.0);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getHighFrequency(), readMetaDoc.getGlobal().getSensor().getAntenna().getHighFrequency());
    }


    @Test
    public void testGain() throws IOException {
        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        metaDoc.getGlobal().getSensor().getAntenna().setGain(100.0);
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getGain(), readMetaDoc.getGlobal().getSensor().getAntenna().getGain());

    }

    @Test
    public void testPolarization() throws IOException {
        MetaDoc metaDoc = getMetaDocWithSensorAndAntenna();
        metaDoc.getGlobal().getSensor().getAntenna().setPolarization("horizontal");
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(metaDoc.getGlobal().getSensor().getAntenna().getPolarization(), readMetaDoc.getGlobal().getSensor().getAntenna().getPolarization());

    }

    @Test
    public void testCrossPolarDiscrimination(){

    }


    @Test
    public void testHorizontalGainPattern(){

    }


    @Test
    public void testVerticalGainPattern(){

    }

    @Test
    public void testHorizontalBeamWidth(){

    }

    @Test
    public void testVerticalBeamWidth(){

    }

    @Test
    public void testVoltageStandingWaveRatio(){

    }

    @Test
    public void testCableLoss(){

    }

    @Test
    public void testSteerable(){

    }


    @Test
    public void testAzimuthAngle(){

    }

    @Test
    public void testElevationAngle(){

    }

    @Test
    public void testMobile(){

    }

}
