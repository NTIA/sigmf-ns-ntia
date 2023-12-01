package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.diagnostics.Computer;
import gov.doc.ntia.sigmf.ext.diagnostics.DiagnosticSensor;import gov.doc.ntia.sigmf.ext.diagnostics.Diagnostics;
import gov.doc.ntia.sigmf.ext.diagnostics.Preselector;
import gov.doc.ntia.sigmf.ext.diagnostics.ScosPlugin;
import gov.doc.ntia.sigmf.ext.diagnostics.Software;
import gov.doc.ntia.sigmf.ext.diagnostics.SPU;
import gov.doc.ntia.sigmf.ext.diagnostics.SsdSmartData;import java.util.ArrayList;

public class DiagnosticsExample implements Example {

  public static Extension getExtension() {
    Extension extension = new Extension();
    extension.setName("ntia-diagnostics");
    extension.setVersion("v1.1.2");
    extension.setOptional(false);
    return extension;
  }

  public static Diagnostics getDiagnostics() {
    Diagnostics diagnostics = new Diagnostics(); 
    diagnostics.setDatetime(ExampleUtils.getDatetimeNow());

    Preselector preselector = getPreselectorDiagnostics();
    diagnostics.setPreselector(preselector);

    Software software = getSoftwareDiagnostics();
    diagnostics.setSoftware(software);

    SPU spu = getSPUDiagnostics();
    diagnostics.setSpu(spu);

    Computer computer = getComputerDiagnostics();
    diagnostics.setComputer(computer);


    return diagnostics;
  }

  public static Preselector getPreselectorDiagnostics() {
    Preselector preselector = new Preselector();
    preselector.setTemp(21.6);
    preselector.setNoiseDiodeTemp(21.8);
    preselector.setLnaTemp(21.8);
    preselector.setHumidity(65.0);
    preselector.setDoorClosed(true);
    preselector.setAntennaPathEnabled(true);
    preselector.setNoiseDiodePathEnabled(false);
    preselector.setNoiseDiodePowered(false);
    return preselector;
  }

  public static Software getSoftwareDiagnostics() {
    Software software = new Software();
    software.setSystemPlatform("Linux-9.9.9-example-platform");
    software.setPythonVersion("3.11.5");
    software.setScosSensorVersion("1.0.0-gcbb75ad");
    software.setScosActionsVersion("2.0.0");
    ScosPlugin scosSiganPlugin = new ScosPlugin();
    scosSiganPlugin.setName("scos_tekrsa");
    scosSiganPlugin.setVersion("3.1.4");
    software.setScosSiganPlugin(scosSiganPlugin);
    software.setPreselectorApiVersion("1.0.0");
    return software;
  }

  public static SPU getSPUDiagnostics() {
    SPU spu = new SPU();
    spu.setPreselectorPowered(true);
    DiagnosticSensor internalTemp = new DiagnosticSensor();
    internalTemp.setName("internal_temp");
    internalTemp.setValue(32.0);
    ArrayList<DiagnosticSensor> tempSensors = new ArrayList<>();
    tempSensors.add(internalTemp);
    spu.setTemperatureSensors(tempSensors);
    spu.setCooling(false);
    spu.setHeating(false);
    spu.setDoorClosed(true);
    DiagnosticSensor internalHumidity = new DiagnosticSensor();
    internalHumidity.setName("internal_humidity");
    internalHumidity.setValue(17.0);
    ArrayList<DiagnosticSensor> humiditySensors = new ArrayList<>();
    humiditySensors.add(internalHumidity);
    spu.setHumiditySensors(humiditySensors);
    DiagnosticSensor powerMonitor5V = new DiagnosticSensor();
    powerMonitor5V.setName("5V_power_monitor");
    powerMonitor5V.setValue(5.0);
    powerMonitor5V.setExpectedValue(5.0);
    ArrayList<DiagnosticSensor> powerSensors = new ArrayList<>();
    powerSensors.add(powerMonitor5V);
    spu.setPowerSensors(powerSensors);
    return spu;
  }

  public static Computer getComputerDiagnostics() {
    Computer computer = new Computer();
    SsdSmartData smartData = getSsdSmartData();
    computer.setSmartData(smartData);
    computer.setCpuMaxClock(4800.00);
    computer.setCpuMinClock(1120.00);
    computer.setCpuMeanClock(3100.00);
    computer.setActionCpuUsage(44.3);
    computer.setSystemLoad5m(24.62);
    computer.setMemoryUsage(23.8);
    computer.setCpuTemp(67.0);
    computer.setCpuOverheating(false);
    computer.setCpuUptime(10.0);
    computer.setSoftwareUptime(1.0);
    computer.setSoftwareStart(ExampleUtils.getDatetimeNow());
    computer.setNtpActive(true);
    computer.setNtpSync(true);
    computer.setActionRuntime(100.0);
    return computer;
  }

  public static SsdSmartData getSsdSmartData() {
    SsdSmartData smartData = new SsdSmartData();
    smartData.setTestPassed(true);
    smartData.setCriticalWarning("0x00");
    smartData.setTemp(41.0);
    smartData.setAvailableSpare(100.0);
    smartData.setAvailableSpareThreshold(10.0);
    smartData.setPercentageUsed(1.0);
    smartData.setUnsafeShutdowns(18);
    smartData.setIntegrityErrors(0);
    return smartData;
  }

  @Override
  public MetaDoc getExample() {
    MetaDoc metaDoc = new MetaDoc();
    Global global = ExampleUtils.getGlobal();
    global.addExtension(getExtension());

    Diagnostics diagnostics = getDiagnostics();
    global.setDiagnostics(diagnostics);

    metaDoc.setGlobal(global);
    return metaDoc;
  }
}
