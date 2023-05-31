package gov.doc.ntia.sigmf.examples;

import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.ext.sensor.Calibration;
import gov.doc.ntia.sigmf.ext.sensor.SensorCapture;
import gov.doc.ntia.sigmf.ext.sensor.SiganSettings;
import java.util.Calendar;

public class CaptureExample implements Example {

  @Override
  public MetaDoc getExample() {

    MetaDoc metaDoc = new MetaDoc();
    SensorCapture sensorCapture = new SensorCapture();
    sensorCapture.setFrequency(3615000000.0);
    sensorCapture.setDateTime(Calendar.getInstance().getTime());
    sensorCapture.setSampleStart(0);
    sensorCapture.setGlobalIndex(0L);
    sensorCapture.setHeaderBytes(0L);
    sensorCapture.setOverload(false);
    Calibration sensorCalibration = new Calibration();
    sensorCalibration.setGain(31.003);
    sensorCalibration.setNoiseFigure(4.069);
    sensorCapture.setDuration(4000);
    sensorCapture.setSensorCalibration(sensorCalibration);
    SiganSettings settings = new SiganSettings();
    settings.setAttenuation(0.0);
    settings.setReferenceLevel(-25.0);
    settings.setPreampEnable(true);
    sensorCapture.setSiganSettings(settings);
    metaDoc.addCapture(sensorCapture);
    return metaDoc;
  }
}
