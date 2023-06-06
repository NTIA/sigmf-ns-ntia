package gov.doc.ntia.sigmf.examples;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import gov.doc.ntia.sigmf.MetaDoc;
import gov.doc.ntia.sigmf.examples.ext.AlgorithmExample;
import gov.doc.ntia.sigmf.examples.ext.CoreExample;
import gov.doc.ntia.sigmf.examples.ext.DiagnosticsExample;
import gov.doc.ntia.sigmf.examples.ext.EmitterExample;
import gov.doc.ntia.sigmf.examples.ext.EnvironmentExample;
import gov.doc.ntia.sigmf.examples.ext.NasctnSeaExample;
import gov.doc.ntia.sigmf.examples.ext.ScosExample;
import gov.doc.ntia.sigmf.examples.ext.SensorExample;
import gov.doc.ntia.sigmf.examples.ext.WaveformExample;

import java.io.File;
import java.io.IOException;

public class ExampleGenerator {

  /**
   * Generates a number of example JSON files to demonstrate the format of various objects specified
   * in the NTIA SigMF extensions.
   *
   * @param args None.
   */
  public static void main(String[] args) {

    // First, generate example JSON for all pieces of each extension

    AlgorithmExample algorithmExample = new AlgorithmExample();
    save("ntia-algorithm.json", algorithmExample.getExample());

    CoreExample coreExample = new CoreExample();
    save("ntia-core.json", coreExample.getExample());

    DiagnosticsExample diagnosticsExample = new DiagnosticsExample();
    save("ntia-diagnostics.json", diagnosticsExample.getExample());

    EmitterExample emitterExample = new EmitterExample();
    save("ntia-emitter.json", emitterExample.getExample());

    EnvironmentExample environmentExample = new EnvironmentExample();
    save("ntia-environment.json", environmentExample.getExample());

    NasctnSeaExample nasctnSeaExample = new NasctnSeaExample();
    save("ntia-nasctn-sea.json", nasctnSeaExample.getExample());

    ScosExample scosExample = new ScosExample();
    save("ntia-scos.json", scosExample.getExample());

    SensorExample sensorExample = new SensorExample();
    save("ntia-sensor.json", sensorExample.getExample());

    WaveformExample waveformExample = new WaveformExample();
    save("ntia-waveform.json", waveformExample.getExample());

    // Now, generate any other examples

    CaptureExample captureExample = new CaptureExample();
    save("capture_example.json", captureExample.getExample());
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
