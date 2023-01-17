package gov.doc.ntia.sigmf.ext.global.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.*;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Diagnostics;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Preselector;
import gov.doc.ntia.sigmf.ext.global.diagnostics.SpuComputer;
import gov.doc.ntia.sigmf.ext.global.diagnostics.SpuX410;
import gov.doc.ntia.sigmf.ext.global.scos.ScheduleEntry;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NasctnSeaTest {

    @Test
    public void testNasctnSeaSigmf() throws IOException {
        MetaDoc sigmf = getSigmf();
        ObjectMapper mapper = new ObjectMapper();
        File output = File.createTempFile("output", ".json");
        output.deleteOnExit();
        mapper.writeValue(output, sigmf);
        MetaDoc readMetaDoc = mapper.readValue(output, MetaDoc.class);

        Diagnostics diagnostics = readMetaDoc.getGlobal().getDiagnostics();
        Preselector preselector = diagnostics.getPreselector();
        assertEquals(preselector.getInternalTempDegC().doubleValue(), 6.2);
        assertEquals(preselector.getNoiseDiodeTempDegC().doubleValue(), 7.9);
        assertEquals(preselector.getLnaTempDegC().doubleValue(), 7.5);
        assertEquals(preselector.getInternalHumidityPct().doubleValue(), 37.3);
        assertEquals(preselector.getDoorClosed().booleanValue(), true);

        SpuX410 spuX410 = diagnostics.getSpuX410();
        assertEquals(spuX410.getRfTrayPowered().booleanValue(), true);
        assertEquals(spuX410.getPreselectorPowered().booleanValue(), true);
        assertEquals(spuX410.getAux28vPowered().booleanValue(), true);
        assertEquals(spuX410.getPowerBoxTempDegC().doubleValue(), 81.3);
        assertEquals(spuX410.getRfBoxTempDegC().doubleValue(), 84.8);
        assertEquals(spuX410.getPowerBoxHumidityPct().doubleValue(), 14.4);

    }

    public MetaDoc getSigmf(){
        MetaDoc sigmf = new MetaDoc();
        writeGlobal(sigmf);
        writeCaptures(sigmf);
        return sigmf;
    }

    public void writeGlobal(MetaDoc metaDoc)
    {
        Global global = new Global();
        global.setVersion("v0.0.2");
        writeExtensions(global);
        global.setDatatype("rf16");
        global.setSampleRate(14000000.0);
        global.setNumChannels(15);
        global.setTask(1);
        writeSchedule(global);
        global.setCalibrationDate(new Date());
        global.setCalibrationTemp(8.0);
        writeDiagnostics(global);
        global.setSha512("42710845c92696d24db14e0e58742e7db2600590bb5835ec5769359e55b7614697d12159f01c3a08feade4bc436daca939459458460e3c720b428727ca2a501b");
        metaDoc.setGlobal(global);
    }

    public void writeExtensions(Global global){
        Extensions extensions = new Extensions();
        Extension ntiaAlg = new Extension();
        ntiaAlg.setName("ntia-algorithm");
        ntiaAlg.setVersion("v1.0.0");
        extensions.addExtension(ntiaAlg);

        Extension ntiaCore = new Extension();
        ntiaCore.setName("ntia-core");
        ntiaCore.setVersion("v1.0.0");
        extensions.addExtension(ntiaCore);

        Extension ntiaEnv = new Extension();
        ntiaEnv.setName("ntia-environment");
        ntiaEnv.setVersion("v1.0.0");
        extensions.addExtension(ntiaEnv);

        Extension ntiaLocation = new Extension();
        ntiaLocation.setName("ntia-location");
        ntiaLocation.setVersion("v1.0.0");
        extensions.addExtension(ntiaLocation);

        Extension ntiaScos = new Extension();
        ntiaScos.setName("ntia-scos");
        ntiaScos.setVersion("v1.0.0");
        extensions.addExtension(ntiaScos);

        Extension ntiaSensor = new Extension();
        ntiaSensor.setName("ntia-sensor");
        ntiaSensor.setVersion("v1.0.0");
        extensions.addExtension(ntiaSensor);

        Extension ntiaNasctnSea = new Extension();
        ntiaNasctnSea.setName("ntia-nasctn-sea");
        ntiaNasctnSea.setVersion("v0.2");
        extensions.addExtension(ntiaNasctnSea);
        global.setExtensions(extensions);
    }

    public void writeSchedule(Global global){
        ScheduleEntry scheduleEntry = new ScheduleEntry();
        scheduleEntry.setName("data_product_revised");
        scheduleEntry.setStart(new Date());
        scheduleEntry.setPriority(10);
        scheduleEntry.setId("data_product_revised");
        global.setSchedule(scheduleEntry);
    }

    public void writeDiagnostics(Global global){
        Diagnostics diagnostics = new Diagnostics();
        diagnostics.setDiagnosticsDatetime(new Date());
        writeDiagnosticsPreselector(diagnostics);
        writeSpuX410(diagnostics);
        writeSpuComputer(diagnostics);
        global.setDiagnostics(diagnostics);
    }

    public void writeDiagnosticsPreselector(Diagnostics diagnostics){
        Preselector preselector = new Preselector();
        preselector.setInternalTempDegC(6.2);
        preselector.setNoiseDiodeTempDegC(7.9);
        preselector.setLnaTempDegC(7.5);
        preselector.setInternalHumidityPct(37.3);
        preselector.setDoorClosed(true);
        diagnostics.setPreselector(preselector);
    }

    public void writeSpuX410(Diagnostics diagnostics)
    {
        SpuX410 spuX410 = new SpuX410();
        spuX410.setRfTrayPowered(true);
        spuX410.setPreselectorPowered(true);
        spuX410.setAux28vPowered(true);
        spuX410.setPowerBoxTempDegC(81.3);
        spuX410.setRfBoxTempDegC(84.8);
        spuX410.setPowerBoxHumidityPct(14.4);
        diagnostics.setSpuX410(spuX410);
    }

    public void writeSpuComputer(Diagnostics diagnostics)
    {
        SpuComputer spuComputer = new SpuComputer();
        spuComputer.setActionCpuUsagePct(46.4);
        spuComputer.setSystemLoad5mPct(24.0);
        spuComputer.setMemoryUsagePct(24.0);
        spuComputer.setDiskUsagePct(7.6);
        spuComputer.setCpuTemperatureDegC(66.0);
        spuComputer.setCpuOverheating(false);
        spuComputer.setUptimeHours(651.16);
        diagnostics.setSpuComputer(spuComputer);
    }

    public void writeCaptures(MetaDoc metaDoc){
        for(int i=0; i<15; i++){
            Capture capture = new Capture();
            capture.setFrequency((i*10e6)*3555.0e6);
            capture.setDateTime(new Date());
            capture.setMaxChannelPowerdBm(-66.0);
            capture.setMeanChannelPowerdBm(-83.25);
            capture.setOverload(false);
            capture.setCalNoiseFiguredB(4.322);
            capture.setCalGaindB(30.707);
            capture.setIqCaptureDurationMsec(4000);
            capture.setSiganAttenuationdB(0);
            capture.setSiganPreampEnable(true);
            capture.setSiganReferenceLeveldBm(-25);
            capture.setFftSampleCount(625);
            capture.setTdPowerSampleCount(400);
            capture.setPfpSampleCount(560);
            capture.setApdSampleCount(180);
            capture.setMaxFftSampleStart(5760*i + i*10);
            capture.setMeanFftSampleStart(625+(i*5770));
            capture.setMaxTdPowerSeriesSampleStart(1250 + (i*5770));
            capture.setMeanTdPowerSeriesSampleStart(1650+(i*5770));
            capture.setMinRmsPfpSampleStart(2050 + (i*5770));
            capture.setMaxRmsPfpSampleStart(2610 + (i*5770));
            capture.setMeanRmsPfpSampleStart(3170 + (i*5770));
            capture.setMinPeakPfpSampleStart(3730 + (i*5770));
            capture.setMaxPeakPfpSampleStart(4290 + (i*5770));
            capture.setMeanPeakPfpSampleStart(4850 + (i*5770));
            capture.setApdPSampleStart(5410 + (i*5770));
            capture.setApdASampleStart(5590 + (i*5775));
            capture.setSampleStart(5760*i + i*10);
            metaDoc.addCapture(capture);
        }
    }
}
