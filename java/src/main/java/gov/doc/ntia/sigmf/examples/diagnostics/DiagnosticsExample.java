package gov.doc.ntia.sigmf.examples.diagnostics;

import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.Example;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Computer;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Diagnostics;
import gov.doc.ntia.sigmf.ext.global.diagnostics.Preselector;
import gov.doc.ntia.sigmf.ext.global.diagnostics.SPU;
import gov.doc.ntia.sigmf.ext.global.diagnostics.SsdSmartData;
import java.util.Calendar;
import java.util.Date;

public class DiagnosticsExample implements Example {

  @Override
  public MetaDoc getExample() {
    Diagnostics diagnostics = new Diagnostics();
    Date now = Calendar.getInstance().getTime();
    diagnostics.setDatetime(now);
    Preselector preselector = new Preselector();
    preselector.setTemp(21.6);
    preselector.setNoiseDiodeTemp(21.8);
    preselector.setLnaTemp(21.8);
    preselector.setHumidity(65.0);
    preselector.setDoorClosed(true);
    diagnostics.setPreselector(preselector);

    SPU spu = new SPU();
    spu.setRfTrayPowered(true);
    spu.setPreselectorPowered(true);
    spu.setAux28vPowered(true);
    spu.setPwrBoxTemp(28.8);
    spu.setRfBoxTemp(31.4);
    spu.setPwrBoxHumidity(11.2);
    spu.setSiganInternalTemp(50.0);
    diagnostics.setSpu(spu);

    SsdSmartData ssdSmartData = new SsdSmartData();
    ssdSmartData.setTestPassed(true);
    ssdSmartData.setCriticalWarning("0x00");
    ssdSmartData.setTemp(41.0);
    ssdSmartData.setAvailableSpare(100.0);
    ssdSmartData.setAvailableSpareThreshold(10.0);
    ssdSmartData.setPercentageUsed(1.0);
    ssdSmartData.setUnsafeShutdowns(18);
    ssdSmartData.setIntegrityErrors(0);

    Computer computer = new Computer();
    computer.setSmartData(ssdSmartData);
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
    computer.setScosStartTime(now);
    diagnostics.setCpu(computer);

    MetaDoc metaDoc = new MetaDoc();
    metaDoc.getGlobal().setDiagnostics(diagnostics);
    return metaDoc;
  }
}
