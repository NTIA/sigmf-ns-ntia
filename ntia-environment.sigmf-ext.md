# The `ntia-environment` SigMF Extension Namespace v1.0.0

This document defines the `ntia-environment` extension namespace for the Signal Metadata Format (SigMF) specification. This namespace extension helps to characterize the environment factors around a sensor and\or emitter.

## 0 Datatypes

The `ntia-environment` extension defines the following datatype, which is referenced by [`ntia-sensor`](/ntia-sensor.sigmf-ext.md) and [`ntia-emitter`](/ntia-emitter.sigmf-ext.md):

|name|long-form name|description|
|----|--------------|-----------|
|`Environment`|environment|JSON [`Environment`](#01-the-environment-object) object containing information describing the physical environment surrounding a sensor or emitter|

### 0.1 The `Environment` Object

An `Environment` object describes the physical environment surrounding an emitter or sensor, and has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temperature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the sensor, e.g., `"rain"`, `"snow"`|
|`description`|false|string|N/A|A description of the environment.|

## 1 Global

The `ntia-environment` extension does not extend the `global` SigMF object.

## 2 Captures

The `ntia-environment` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-environment` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-environment` extension does not extend the `collection` SigMF object.

## 5 Example

```json
{
  "global": {
    "core:datatype": "cf32_le",
    "core:sample_rate": 1.5360000011967678E7,
    "core:version": "0.0.2",
    "core:sha512": "5b522660c1406db41a7c05c564b902fa658de8755eaf77a35fea635ff97fd1293fe9e8b799c7ffca70d22cff8fa97cef0633ef29a08bdbc1b629165db72f81e3",
     "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor": {
      "id": "greyhound8.sms.internal",
      "sensor_spec": {
        "model": "greyhound"
      },
      "antenna": {
        "antenna_spec": {
          "model": "L-com HG3512UP-NF"
        }
      },
      "signal_analyzer": {
        "sigan_spec": {
          "model": "Ettus USRP B210"
        },
        "a2d_bits": 0
      },
      "computer_spec": {
        "model": "Intel NUC"
      },
      "location": {
        "x": -105.2715,
        "y": 40.0067
      },
      "environment":{
        "category": "outside",
        "description": "Mounted on a pole on top of the Fleming building at CU Boulder."
      }
    }
  },
  "captures": [
    ...
  ],
  "annotations": [
    ...
  ]
}
```
