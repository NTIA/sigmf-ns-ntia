# The `ntia-environment` SigMF Extension Namespace v1.0.0

This document defines the `ntia-environment` extension namespace for the Signal Metadata Format (SigMF) specification. This namespace extension helps to characterize the environment factors around a sensor and\or emitter.

## 0 Datatypes

The `ntia-environment` extension defines the following datatype, which is referenced by [ntia-sensor](/ntia-sensor.sigmf-ext.md) and [ntia-emitter](/ntia-emitter.sigmf-ext.md):

|name|long-form name| description                                                                                                                                      |
|----|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
|`Environment`|environment| JSON [Environment](#01-the-environment-object) object containing information describing the physical environment surrounding a sensor or emitter |

### 0.1 The `Environment` Object

An `Environment` object describes the physical environment surrounding an emitter or sensor, and has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|double|celsius|Environmental temperature.|
|`humidity`|false|double|%|Relative humidity.|
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
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:version" : "1.0.0",
    "core:num_channels" : 1,
    "core:extensions" : [ {
      "name" : "ntia-core",
      "version" : "v2.0.0",
      "optional" : false
    }, {
      "name" : "ntia-environment",
      "version" : "v1.0.0",
      "optional" : false
    }, {
      "name" : "ntia-sensor",
      "version" : "v2.0.0",
      "optional" : false
    } ],
    "ntia-sensor:sensor" : {
      "sensor_spec" : {
        "id" : "Greyhound_1",
        "model" : "Example model",
        "version" : "v1.0",
        "description" : "Example description",
        "supplemental_information" : "Example supplemental information"
      },
      "antenna" : [{
        "antenna_spec" : {
          "id" : "123-xyzpdq",
          "model" : "Example model",
          "version" : "v1.0",
          "description" : "Example description",
          "supplemental_information" : "Example supplemental information"
        },
        "type" : "omnidirectional",
        "frequency_low" : 3.0E8,
        "frequency_high" : 3.0E9,
        "gain" : 2.0,
        "polarization" : "vertical",
        "cross_polar_discrimination" : 9.1,
        "horizontal_gain_pattern" : [ 1.0, 2.0, 3.0 ],
        "vertical_gain_pattern" : [ 4.0, 5.0, 6.0 ],
        "horizontal_beamwidth" : 360.0,
        "vertical_beamwidth" : 10.0,
        "voltage_standing_wave_ratio" : 1.5,
        "cable_loss" : 1.0,
        "steerable" : false,
        "azimuth_angle" : 0.0,
        "elevation_angle" : 5.0
      }],
      "preselector" : {
        "preselector_spec" : {
          "id" : "preselector_1",
          "model" : "Example model",
          "version" : "v1.0",
          "description" : "Example description",
          "supplemental_information" : "Example supplemental information"
        },
        "cal_sources" : [ {
          "cal_source_spec" : {
            "id" : "noise_diode_1",
            "model" : "Example model",
            "version" : "v1.0",
            "description" : "Example description",
            "supplemental_information" : "Example supplemental information"
          },
          "type" : "Calibrated noise diode",
          "enr" : 15.0
        } ],
        "filters" : [ {
          "filter_spec" : {
            "id" : "filter_1",
            "model" : "Example model",
            "version" : "v1.0",
            "description" : "Example description",
            "supplemental_information" : "Example supplemental information"
          },
          "frequency_low_passband" : 7.0E8,
          "frequency_high_passband" : 7.5E8,
          "frequency_low_stopband" : 7.0E8,
          "frequency_high_stopband" : 7.5E8
        } ],
        "amplifiers" : [ {
          "amplifier_spec" : {
            "id" : "lna_1",
            "model" : "Example model",
            "version" : "v1.0",
            "description" : "Example description",
            "supplemental_information" : "Example supplemental information"
          },
          "gain" : 30.0,
          "noise_figure" : 2.5,
          "max_power" : 35.0
        } ],
        "rf_paths" : [ {
          "id" : "path_1",
          "cal_source_id" : "noise_diode_1",
          "filter_id" : "filter_1",
          "amplifier_id" : "lna_1"
        } ]
      },
      "signal_analyzer" : {
        "sigan_spec" : {
          "id" : "875649305NLDKDJN",
          "model" : "Example model",
          "version" : "v1.0",
          "description" : "Example description",
          "supplemental_information" : "Example supplemental information"
        },
        "frequency_low" : 1.0E8,
        "frequency_high" : 7.0E8,
        "noise_figure" : 20.0,
        "max_power" : 35.0,
        "a2d_bits" : 16
      },
      "computer_spec" : {
        "id" : "Example_PC",
        "model" : "Example model",
        "version" : "v1.0",
        "description" : "Example description",
        "supplemental_information" : "Example supplemental information"
      },
      "mobile" : false,
      "environment" : {
        "temperature" : 100.0,
        "humidity" : 50.0,
        "weather" : "overcast",
        "category" : "outdoor",
        "description" : "A fake example environment"
      },
      "sensor_sha512" : "657bd59b8e46609411b9ba53d77fbc1dee75885fc6f3e4a744c6cfd80e2d85279a940f3e749733e91a2289cf728b83e0d76befb44b356d7933dc236f8f742556"
    },
    "ntia-emitter:emitters" : [ {
      "id" : "EmitterXYZ",
      "description" : "A fictitious emitter to demonstrate the extensions format.",
      "power" : -60.0,
      "environment" : {
        "temperature" : 100.0,
        "humidity" : 50.0,
        "weather" : "overcast",
        "category" : "outdoor",
        "description" : "A fake example environment"
      }
    } ]
  },
  ...
  "captures" : [ ... ],
  "annotations" : [ ... ]
}
```
