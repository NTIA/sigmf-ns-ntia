# SigMF-NS-NTIA in Matlab

Working with the SigMF-NS-NTIA SigMF extensions in Matlab can be made much easier by using the Java libraries within this repository.  The guide below provides useful tips to interact with the Java implementation of the SigMF-NS-NTIA extension within Matlab.

## Tips for using the  SigMF-NS-NTIA Java implementation with Matlab

The jar file is available for download in the GitHub [packages page](https://github.com/orgs/NTIA/packages?repo_name=sigmf-ns-ntia) of this repository.

### 1.  Add the SigMF-NS_NTIA Jar file to Matlab

There are several alternative ways to add the jar file to Matlab.

#### 1.1 Adding the jar file temporarily

Adding the jar file to the dynamic path allows you to add the jar file to only your current session of Matlab. To add the jar file only to the current session, execute the following command in Matlab after replacing the path to the jar file with the path to the jar file on your computer.

```matlab
javaclasspath({'C:\path\to\sigmf-ns-ntia-2.0.1.jar'});
```

#### 1.2 Adding the jar to the static path

Adding the jar file to Matlab's static path will allow the library to be used at anytime in Matlab. Add the jar to the Matlab's static path by:

1. Execute the `prefdir` command in Matlab to identify your preferences directory.
2. Close Matlab.
3. Go to your preferences directory identified by the above command and create an ASCII text file named `javaclasspath.txt`.
4. Add the full path to the `sigmf-ns-ntia` jar to the `javaclasspath.txt` file
5. Now you should be able to start and use the simf-ns-ntia java library from within Matlab as detailed below.

### 2. Using the Java library from within Matlab

This section provides examples of the common ways to interact with the `sigmf-ns-ntia` java library within Matlab.

#### 2.1 Java library Overview

The `sigmf-ns-ntia` Java library consists of a number classes that define an object oriented approach to modeling the `sigmf-ns-ntia`
extensions to SigMF. As such, to get and set values  within the SigMF you will primarily be creating instances of the 
different objects defined within the library and calling various get and set methods on those objects to get and set
the various values. In Java, classes can be organized into a set of packages and the `sigmf-ns-ntia` library is
organized in packages that mimic the extensions defined in [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia).  The
base package in the Java library is `gov.doc.ntia.sigmf` so all objects you utilize will begin with `gov.doc.ntia.sigmf`. 
The `gov.doc.ntia.sigmf.ext` package includes subpackages for each extension in 
[sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia).  The table below shows the mapping between Java packages and 
the extensions defined in [sigmf-ns-ntia](https://github.com/NTIA/sigmf-ns-ntia). Extensions to the global object are 
provided directly in the `gov.doc.ntia.sigmf.Global` class. 

| Package                                  |Extension|
|------------------------------------------|--------|
| `gov.doc.ntia.sigmf`                     |Base [SigMF](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md)|
| `gov.doc.ntia.sigmf.ext.algorithm`       |[`ntia-algorithm`](../ntia-algorithm.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.core`     |[`ntia-core`](../ntia-core.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.diagnostics` |[`ntia-diagnostics`](../ntia-diagnostics.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.emitter`  |[`ntia-emitter`](../ntia-emitter.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.environment` |[`ntia-environment`](../ntia-environment.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.scos`     |[`ntia-scos`](../ntia-scos.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.sensor`   |[`ntia-sensor`](../ntia-sensor.sigmf-ext.md)|
| `gov.doc.ntia.sigmf.ext.waveform` |[`ntia-waveform`](../ntia-waveform.sigmf-ext.md)|

#### 2.2 Using the Java library

Utilizing the Java library from within Matlab mostly requires you to create instances of the objects and use the set and get methods on those objects to set or get the value of interest.  Creating an instance of a Java object is as simple as calling the constructor with the full name (including the package) of the class as shown in the example below. Note: as shown below, certain types like long and double require you specify them as their java type.

```matlab
  metaDoc = gov.doc.ntia.sigmf.MetaDoc();
  globalExample = gov.doc.ntia.sigmf.Global();
  sensor = gov.doc.ntia.sigmf.ext.sensor.Sensor(); 
  antenna = gov.doc.ntia.sigmf.ext.core.Antenna(); 
  
  setType(antenna, "dipole"); 
  setGain(antenna, java.lang.Double(7)); 
  hardwareSpec = gov.doc.ntia.sigmf.ext.core.HardwareSpec();
  setModel(hardwareSpec, "ARA CSB-16");
  setId(hardwareSpec, "antenna_1");
  setAntennaSpec(antenna, hardwareSpec);

  setId(sensor, "greyhound-1");
  setAntenna(sensor, antenna);

  setSensor(globalExample, sensor);
  setGlobal(metaDoc, globalExample);

  saveToFile(metaDoc, "C:\path\to\example.json");
```

Now, if we open the file we will see the following:

```json
{
  "global": {
    "ntia-sensor:sensor": {
      "id": "greyhound-1",
      "antenna": [{
        "antenna_spec": {
          "id": "antenna_1",
          "model": "ARA CSB-16"
        },
        "type": "dipole",
        "gain": 7,
      }]
    }
  },
  "captures": [],
  "annotations": []
}

```

Finally, if we simply wanted to read the `example.json` in Matlab we would use the static read method provided by the `SigMfReader` class. Because it is a static method you must call it slightly differently, as shown below:

```matlab
readMetaDoc = javaMethod('read', 'gov.doc.ntia.sigmf.SigMfReader', 'C:\path\to\example.json');
```
