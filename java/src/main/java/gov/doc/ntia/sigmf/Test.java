package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection;
import gov.doc.ntia.sigmf.ext.global.Antenna;
import gov.doc.ntia.sigmf.ext.global.Receiver;
import gov.doc.ntia.sigmf.ext.global.Sensor;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){

        MetaDoc metaDoc = new MetaDoc();
        Global global = new Global();
        Sensor sensor = new Sensor();
        sensor.setId("Sensor123");
        Antenna antenna = new Antenna();
        antenna.setType("Type123");

        Receiver receiver = new Receiver();
        receiver.setModel("Model123");
        List<Annotation> annotations = new ArrayList<>();
        FrequencyDomainDetection fdd = new FrequencyDomainDetection();
        fdd.setEquivalentNoiseBandwidth(2.0);
        fdd.setUnits("Units");
        fdd.setNumberOfFfts(1000);
        fdd.setWindow("window");
        fdd.setNumberOfSamplesInFft(1000);
        annotations.add(fdd);
        metaDoc.setAnnotations(annotations);

        sensor.setAntenna(antenna);
        sensor.setReceiver(receiver);

        global.setSensor(sensor);
        metaDoc.setGlobal(global);
        Extensions extensions = new Extensions();
        Extension ext = new Extension();
        ext.setName("ntia-scos");
        ext.setVersion("optional");
        extensions.addExtension(ext);
        Extension emitter = new Extension();
        emitter.setName("ntia-emitter");
        emitter.setVersion("optionsl");
        extensions.addExtension(emitter);
        global.setExtensions(extensions);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("C:\\Users\\dboulware\\Documents\\sigmf-ns-scos\\example.json"),metaDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MetaDoc readMetaDoc = (MetaDoc)mapper.readValue(new File("C:\\Users\\dboulware\\Documents\\sigmf-ns-scos\\example.json"), MetaDoc.class);
            System.out.println(readMetaDoc.getGlobal().getSensor().getId());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
