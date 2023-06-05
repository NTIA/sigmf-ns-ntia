package gov.doc.ntia.sigmf.examples.ext;

import gov.doc.ntia.sigmf.Extension;
import gov.doc.ntia.sigmf.Global;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.examples.ExampleUtils;
import gov.doc.ntia.sigmf.ext.diagnostics.Computer;
import gov.doc.ntia.sigmf.ext.diagnostics.Diagnostics;
import gov.doc.ntia.sigmf.ext.diagnostics.Preselector;
import gov.doc.ntia.sigmf.ext.diagnostics.SPU;
import gov.doc.ntia.sigmf.ext.diagnostics.SsdSmartData;

public class DiagnosticsExample implements Example {

  public static Extension getExtension() {
    Extension extension = new Extension();
    extension.setName("ntia-diagnostics");
    extension.setVersion("v1.0.0");
    extension.setOptional(false);
    return extension;
  }

  public static Diagnostics getDiagnostics() {
    Diagnostics diagnostics = new Diagnostics(); 
    diagnostics.setDatetime(ExampleUtils.getDatetimeNow());

    Preselector preselector = getPreselectorDiagnostics();
    diagnostics.setPreselector(preselector);

    SPU spu = getSPUDiagnostics();
    diagnostics.setSpu(spu);

    Computer computer = getComputerDiagnostics();
    diagnostics.setComputer(computer);

    diagnostics.setActionRuntime(100.0);

    return diagnostics;
  }

  public static Preselector getPreselectorDiagnostics() {
    Preselector preselector = new Preselector();
    preselector.setTemp(21.6);
    preselector.setNoiseDiodeTemp(21.8);
    preselector.setLnaTemp(21.8);
    preselector.setHumidity(65.0);
    preselector.setDoorClosed(true);
    return preselector;
  }

  public static SPU getSPUDiagnostics() {
    SPU spu = new SPU();
    spu.setRfTrayPowered(true);
    spu.setPreselectorPowered(true);
    spu.setAux28vPowered(true);
    spu.setPwrBoxTemp(28.8);
    spu.setRfBoxTemp(31.4);
    spu.setPwrBoxHumidity(11.2);
    spu.setSiganInternalTemp(50.0);
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
    computer.setScosUptime(1.0);
    computer.setScosStart(ExampleUtils.getDatetimeNow());
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
