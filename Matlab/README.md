# SigMF-NS-NTIA in Matlab

Working with the SigMF-NS-NTIA SigMF extensions in Matlab can be made much easier by using the Java libraries within this repository.  The guide below provides useful tips to interact with the Java implemention of the SigMF-NS-NTIA extension within Matlab. 
## Tips for using the  SigMF-NS-NTIA Java implementation with Matlab. 

### 1.  Add the SigMF-NS_NTIA Jar file to Matlab

There are several alternative ways to add the jar file to Matlab. 

#### 1.1 Adding the jar file temporarily 

Adding the jar file to the dynamic path allows you to add the jar file to only you current session of Matlab. To add the jar file to the current session only, execute the following command in Matlab after replacing the path to the jar file with the path on you computer. 

`javaclasspath({'C:\Users\dboulware\Documents\sigmf-ns-ntia\sigmf-ns-ntia\java\build\libs\sigmf-ns-ntia-0.0.4-SNAPSHOT.jar'});`


#### 1.1 Adding the jar to the static path
Adding the jar file to Matlab's static path will allow the library to be used at anytime in Matlab. Add the jar to the Matlab's static path by: <br/>

1. Execute the `prefdir` command in Matlab to identify your preferences directory.
2. Close Matlab.
3. Go to your preferences directory identified by the above command and create an ASCII text file named `javaclasspath.txt`.
4. Add the full path to the `sigmf-ns-ntia` jar to the `javaclasspath.txt` file
5. Now you should be able to start and use the simf-ns-ntia java library from within Matlab as detailed below.

### Using the Java library from within Matlab

This section provides examples of the common ways to interact with the `sigmf-ns-ntia` java library within Matlab. 

#### Java library Overview

The `sigmf-ns-ntia` java library consists of a number classes that define an object oriented approach to modeling the `sigmf-ns-ntia` extensions to SigMF. As such, to get and set values  within the SigMF you will primarily be creating instances of the different objects defined within the library and calling various get and set methods on those objects to get and set the various values. In Java, classes can be organized into a set of packages and the `sigmf-ns-ntia` library is organized in packages that mimic the extensions defined in [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia).  The base package in the java library is `gov.doc.ntia.sigmf` so all objects you utilize will begin with `gov.doc.ntia.sigmf`. The `gov.doc.ntia.sigmf.ext.global` package includes subpackages to organize the global objects defined in  [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia) and `gov.doc.ntia.sigmf.ext.annotation` package includes subpackages to organize the annoation extensions defined in [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia).  The table below shows the mapping between Java packages and the extensions defined in  [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia) 

|Package|Extension|Description|
|----|--------|-----------|
|`gov.doc.ntia.sigmf`|NA|Contains the objects that are part of the core [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md) including MetaDoc to describe the entire metadata document, Global to represent the Global section within the MetaDoc, and Annotation and Capture to represent annotation and captures respectively |
|`gov.doc.ntia.sigmf.ext.global.core`|[ntia-core](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-core.sigmf-ext.md)|Contains objects to represent global objects defined in [ntia-core](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-core.sigmf-ext.md) including `Antenna` and `HardwareSpec`|
|`gov.doc.ntia.sigmf.ext.global.sensor`|[ntia-sensor](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-sensor.sigmf-ext.md)|Contains objects to represent the global objects defined in [ntia-sensor](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-sensor.sigmf-ext.md) including `Sensor`, `Preselector`, `SignalAnalyzer`, and `RFPath`|
|`gov.doc.ntia.sigmf.ext.global.algorithm`|[ntia-algorithm](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-algorithm.sigmf-ext.md)|Contains objects to represent the global objects defined in [ntia-algorithm](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-algorithm.sigmf-ext.md) including `DigitalFilter`|
|`gov.doc.ntia.sigmf.ext.global.emitter`|[ntia-emitter](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-emitter.sigmf-ext.md)|Contains objects to represent the global objects defined in [ntia-emitter](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-emitter.sigmf-ext.md) including `Emitter`, and `Transmitter`|
|`gov.doc.ntia.sigmf.ext.global.waveform`|[ntia-waveform](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-waveform.sigmf-ext.md)|Contains objects to represent the global objects defined in [ntia-waveform](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-waveform.sigmf-ext.md) including `Waveform` and `IEEE80211p`|
|`gov.doc.ntia.sigmf.ext.annotation.core`|[ntia-core](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-core.sigmf-ext.md)|Contains objects to represent annotation objects defined in [ntia-core](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-core.sigmf-ext.md) including `AntennaAnnotation`|
|`gov.doc.ntia.sigmf.ext.annotation.sensor`|[ntia-sensor](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-sensor.sigmf-ext.md)|Contains objects to represent the annotation objects defined in [ntia-sensor](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-sensor.sigmf-ext.md) including `SensorAnnotation` and `CalibrationAnnotation`|
|`gov.doc.ntia.sigmf.ext.annotation.algorithm`|[ntia-algorithm](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-algorithm.sigmf-ext.md)|Contains objects to represent the annotation objects defined in [ntia-algorithm](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-algorithm.sigmf-ext.md) including `TimeDomainDetection`, `FrequencyDomainDetection`, and `DigitalFilterAnnotation`|
|`gov.doc.ntia.sigmf.ext.annotation.emitter`|[ntia-emitter](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-emitter.sigmf-ext.md)|Contains objects to represent the annotation objects defined in [ntia-emitter](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-emitter.sigmf-ext.md) including `EmitterAnnotation`|
|`gov.doc.ntia.sigmf.ext.annotation.environment`|[ntia-environment](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-environment.sigmf-ext.md)|Contains objects to represent the annotation objects defined in [ntia-environment](https://github.com/NTIA/sigmf-ns-ntia/blob/master/ntia-environment.sigmf-ext.md) including `EmitterEnvironment` and `SensorEnvironment`|


#### Using the Java library

Utilizing the Java library from within Matlab mostly requires you to create instances of the objects and use the set and get methods on those objects to set or get the value of interest.  Creating an instance of a Java object is as simple as calling the constructor with the full name (including the package) of the class as shown in the example below. Note: as shown below, certain types like long and double require you specify them as their java type.

```
  metaDoc = gov.doc.ntia.sigmf.MetaDoc();
  globalExample = gov.doc.ntia.sigmf.Global();
  sensor = gov.doc.ntia.sigmf.ext.global.sensor.Sensor(); 
  antenna = gov.doc.ntia.sigmf.ext.global.core.Antenna(); 
  
  setType(antenna, "dipole"); 
  setGain(antenna, java.lang.Double(7)); 
  hardwareSpec = gov.doc.ntia.sigmf.ext.global.core.HardwareSpec();
  setModel(hardwareSpec, "ARA CSB-16");
  setId(hardwareSpec, "antenna_1");
  setAntennaSpec(antenna, hardwareSpec);

  setId(sensor, "greyhound-1");
  setAntenna(sensor, antenna);

  detection = gov.doc.ntia.sigmf.ext.annotation.algorithm.FrequencyDomainDetection();
  setDetector(detection, "fft_mean_power");
  setNumberOfFfts(detection, 1024);
  setDetectionDomain(detection, "frequency");
  setNumberOfSamplesInFft(detection, 1024);
  setWindow(detection, "blackman-harris");
  setSampleStart(detection, java.lang.Long(0));
  setSampleCount(detection, java.lang.Long(1024));

  setSensor(globalExample, sensor);
  setGlobal(metaDoc, globalExample);

  saveToFile(metaDoc, "C:\Users\dboulware\Documents\sigmf-ns-ntia\example.json");


```

Now, if we open the file we will see the following:
```
{
  "global": {
    "ntia-sensor:sensor": {
      "id": "greyhound-1",
      "antenna": {
        "antenna_spec": {
          "id": "antenna_1",
          "model": "ARA CSB-16"
        },
        "type": "dipole",
        "gain": 7,
      }
    }
  },
  "captures": [
    
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_mean_power",
      "ntia-algorithm:detection_domain": "frequency",
      "ntia-algorithm:number_of_ffts": 1024,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "blackman-harris"
    }
  ]
}

```

Finally, if we simply wanted to read the example.json in Matlab we would use the static read method provided by the SifMFReader class. Because it is a static method you must call it slightly differently, as shown below:

`readMetaDoc = javaMethod('read', 'gov.doc.ntia.sigmf.SigMFReader',' 'C:\Users\dboulware\Documents\sigmf-ns-ntia\example.json');`













