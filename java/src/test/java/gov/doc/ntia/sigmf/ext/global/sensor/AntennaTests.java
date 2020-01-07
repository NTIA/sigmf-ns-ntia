package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.global.core.Antenna;
import gov.doc.ntia.sigmf.ext.global.core.HardwareSpec;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AntennaTests {
/*
    @Test
    public void testAntennaSpec(){
        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        Sensor sensor = new Sensor();
        String sensorId = "TestSensor123";
        sensor.setId(sensorId);
        global.setSensor(sensor);
        metaDoc.setGlobal(global);
        Antenna antenna = new Antenna();
        HardwareSpec antennaSpec = new HardwareSpec();
        antennaSpec.setSupplementalInformation("supplemental info");
        antennaSpec.setModel("model");
        antennaSpec.setId("antenna123");
        antennaSpec.setDescription("description");
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile ("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output,metaDoc);
        MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(output, MetaDoc.class);
        assertEquals(sensorId, metaDoc.getGlobal().getSensor().getId());

    }

    @JsonProperty(value="type", required=false)
    protected  String type;


    @JsonProperty(value="low_frequency", required = false)
    protected Double lowFrequency;


    @JsonProperty(value="high_frequency", required = false)
    protected Double highFrequency;


    @JsonProperty(value="gain", required=false)
    protected Double gain;

    @JsonProperty(value="polarization", required = false)
    protected String polarization;


    @JsonProperty(value="cross_polar_discrimination", required = false)
    protected Double crossPolarDiscrimination;

    @JsonProperty(value="horizontal_gain_pattern", required = false)
    protected Double[] horizontalGainPattern;

    @JsonProperty(value="vertical_gain_pattern", required = false)
    protected  Double[] verticalGainPattern;


    @JsonProperty(value="horizontal_beam_width", required = false)
    protected Double horizontalBeamWidth;


    @JsonProperty(value="vertical_beam_width", required = false)
    protected Double verticalBeamWidth;


    @JsonProperty(value="voltage_standing_wave_ratio", required = false)
    protected Double voltageStandingWaveRatio;


    @JsonProperty(value="cable_loss", required = false)
    protected Double cableLoss;

    @JsonProperty(value="steerable", required = false)
    protected Boolean steerable;


    @JsonProperty(value="azimuth_angle", required = false)
    protected Double azimuthAngle;


    @JsonProperty(value="elevation_angle", required = false)
    protected Double elevationAngle;

    @JsonProperty(value="mobile", required = false)
    protected Boolean mobile;
    */
}
