package gov.doc.ntia.sigmf.examples;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.algorithm.DataProductsExample;
import gov.doc.ntia.sigmf.examples.algorithm.DigitalFilterExample;
import gov.doc.ntia.sigmf.examples.capture.CaptureExample;
import gov.doc.ntia.sigmf.examples.diagnostics.DiagnosticsExample;
import gov.doc.ntia.sigmf.examples.emitter.EmitterExample;
import gov.doc.ntia.sigmf.examples.environment.EmitterEnvironmentExample;
import gov.doc.ntia.sigmf.examples.environment.SensorEnvironmentExample;
import gov.doc.ntia.sigmf.examples.scos.ScosExample;
import gov.doc.ntia.sigmf.examples.waveform.WaveformExample;
import java.io.File;
import java.io.IOException;

public class ExampleGenerator {

  /**
   * Generates a number of example JSON files to demonstrate the format of various objects specified
   * in the NTIA SigMF extensions. Note: currently the examples do not necessarily specify values
   * for all required parameters.
   *
   * @param args None.
   */
  public static void main(String[] args) {

    SensorExample sensorExample = new SensorExample();
    save("sensor.json", sensorExample.getExample());

    DigitalFilterExample digitalFilterExample = new DigitalFilterExample();
    save("digitalFilter.json", digitalFilterExample.getExample());

    DigitalFilterExample digitalFilterAnnotationExample = new DigitalFilterExample();
    save("digitalFilterAnnotation.json", digitalFilterAnnotationExample.getExample());

    EmitterExample emitterExample = new EmitterExample();
    save("emitterGlobal.json", emitterExample.getExample());

    SensorEnvironmentExample sensorEnvironmentExample = new SensorEnvironmentExample();
    save("sensorEnvironment.json", sensorEnvironmentExample.getExample());

    EmitterEnvironmentExample emitterEnvironmentExample = new EmitterEnvironmentExample();
    save("emitterEnvironment.json", emitterEnvironmentExample.getExample());

    WaveformExample waveformExample = new WaveformExample();
    save("waveformExample.json", waveformExample.getExample());

    RadarExample radarExample = new RadarExample();
    save("radarExample.json", radarExample.getExample());

    ScosExample scosExample = new ScosExample();
    save("scos.json", scosExample.getExample());

    DataProductsExample dataProductsExample = new DataProductsExample();
    save("data_products.json", dataProductsExample.getExample());

    CaptureExample captureExample = new CaptureExample();
    save("capture_example.json", captureExample.getExample());

    DiagnosticsExample diagnosticsExample = new DiagnosticsExample();
    save("diagnostics_example.json", diagnosticsExample.getExample());
  }

  private static void save(String filename, MetaDoc example) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    try {
      mapper.writeValue(new File(filename), example);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
