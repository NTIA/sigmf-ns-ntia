# The `ntia-sensor` SigMF Extension Namespace v2.0.0

This document defines the `ntia-sensor` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace helps to describe RF sensors.

## 0 Datatypes

The `ntia-sensor` extension defines the following datatypes:

| name             | long-form name                   | description                                                                                                                       |
|------------------|----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| `Sensor`         | RF sensor                        | JSON [Sensor](#01-the-sensor-object) object specifying the physical and environmental properties of an RF sensor                  |
| `SignalAnalyzer` | signal analyzer specification    | JSON [SignalAnalyzer](#02-the-signalanalyzer-object) object specifying a signal analyzer                                          |
| `Preselector`    | preselector specification        | JSON [Preselector](#03-the-preselector-object) object specifying a preselector                                                    |
| `CalSource`      | calibration source specification | JSON [CalSource](#04-the-calsource-object) object specifying a calibration source                                                 |
| `Amplifier`      | amplifier specification          | JSON [Amplifier](#05-the-amplifier-object) object specifying an amplifier in the RF path                                          |
| `Filter`         | filter specification             | JSON [Filter](#06-the-filter-object) object specifying a filter in the RF path                                                    |
| `RFPath`         | RF path specification            | JSON [RFPath](#07-the-rfpath-object) object specifying an RF path as a combination of a filter, amplifier, and calibration source |
| `Calibration`    | calibration result               | JSON [Calibration](#08-the-calibration-object) object specifying the results of a calibration                                     |
| `SiganSettings`  | signal analyzer settings         | JSON [SiganSettings](#09-the-sigansettings-object) object specifying signal analyzer settings                                     |

### 0.1 The `Sensor` Object

Sensor definition follows a simplified hardware model composed of the following elements: antenna, preselector, signal analyzer, and computer. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The signal analyzer (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

`Sensor` has the following properties:

| name              | required | type                                                                   | unit | description                                        |
|-------------------|----------|------------------------------------------------------------------------|------|----------------------------------------------------|
| `sensor_spec`     | true     | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object)      | N/A  | Specifies the sensor                               |
| `antenna`         | false    | [Antenna[]](ntia-core.sigmf-ext.md#01-the-antenna-object)              | N/A  | Specifies the antenna                              |
| `preselector`     | false    | [Preselector](#03-the-preselector-object)                              | N/A  | Specifies the preselector                          |
| `signal_analyzer` | false    | [SignalAnalyzer](#02-the-signalanalyzer-object)                        | N/A  | Specifies the signal analyzer                      |
| `computer_spec`   | false    | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object)      | N/A  | Specifies the onboard computer                     |
| `mobile`          | false    | boolean                                                                | N/A  | Whether the sensor is mobile                       |
| `environment`     | false    | [Environment](ntia-environment.sigmf-ext.md#01-the-environment-object) | N/A  | Specifies the environment surrounding the `Sensor` |
| `sensor_sha512`   | false    | string                                                                 | N/A  | SHA-512 hash of the sensor definition              |

### 0.2 The `SignalAnalyzer` Object

`SignalAnalyzer` the following properties:

| name             | required | type                                                              | unit | description                                                |
|------------------|----------|-------------------------------------------------------------------|------|------------------------------------------------------------|
| `sigan_spec`     | false    | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object) | N/A  | Metadata to describe/specify the signal analyzer           |
| `frequency_low`  | false    | double                                                            | Hz   | Low frequency of operational range of the signal analyzer  |
| `frequency_high` | false    | double                                                            | Hz   | High frequency of operational range of the signal analyzer |
| `noise_figure`   | false    | double                                                            | dB   | Noise figure of the signal analyzer                        |
| `max_power`      | false    | double                                                            | dBm  | Maximum input power of the signal analyzer                 |
| `a2d_bits`       | false    | integer                                                           | N/A  | Number of bits in A/D converter                            |

### 0.3 The `Preselector` Object

`Preselector` has the following properties:

| name               | required | type                                                              | unit | description                                                         |
|--------------------|----------|-------------------------------------------------------------------|------|---------------------------------------------------------------------|
| `preselector_spec` | false    | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object) | N/A  | Metadata to describe/specify the preselector                        |
| `cal_sources`      | false    | [CalSource[]](#04-the-calsource-object)                           | N/A  | Metadata to describe/specify the preselector calibration source(s)  |
| `amplifiers`       | false    | [Amplifier[]](#05-the-amplifier-object)                           | N/A  | Metadata to describe/specify the preselector low noise amplifier(s) |
| `filters`          | false    | [Filter[]](#06-the-filter-object)                                 | N/A  | Metadata to describe/specify the preselector RF filter(s)           |
| `rf_paths`         | false    | [RFPath[]](#07-the-rfpath-object)                                 | N/A  | Metadata to specify the preselector RF path(s)                      |

### 0.4 The `CalSource` Object

`CalSource` has the following properties:

| name              | required | type                                                              | unit | description                                 |
|-------------------|----------|-------------------------------------------------------------------|------|---------------------------------------------|
| `cal_source_spec` | false    | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object) | N/A  | Metadata to describe the calibration source |
| `type`            | false    | string                                                            | N/A  | Type of the calibration source              |
| `enr`             | false    | double                                                            | dB   | Excess noise ratio                          |

### 0.5 The `Amplifier` Object

`Amplifier` has the following properties:

| name             | required | type                                                              | unit | description                                |
|------------------|----------|-------------------------------------------------------------------|------|--------------------------------------------|
| `amplifier_spec` | false    | [HardwareSpec](ntia-core.sigmf-ext.md#02-the-hardwarespec-object) | N/A  | Metadata to describe/specify the amplifier |
| `gain`           | false    | double                                                            | dB   | Gain of the low noise amplifier            |
| `noise_figure`   | false    | double                                                            | dB   | Noise figure of the low noise amplifier    |
| `max_power`      | false    | double                                                            | dBm  | Maximum power of the low noise amplifier   |

### 0.6 The `Filter` Object

`Filter` has the following properties:

| name                      | required | type                                                               | unit | description                             |
|---------------------------|----------|--------------------------------------------------------------------|------|-----------------------------------------|
| `filter_spec`             | false    | [HardwareSpec](/ntia-core.sigmf-ext.md#02-the-hardwarespec-object) | N/A  | Metadata to describe/specify the filter |
| `frequency_low_passband`  | false    | double                                                             | Hz   | Low frequency of filter 1 dB passband   |
| `frequency_high_passband` | false    | double                                                             | Hz   | High frequency of filter 1 dB passband  |
| `frequency_low_stopband`  | false    | double                                                             | Hz   | Low frequency of filter 60 dB stopband  |
| `frequency_high_stopband` | false    | double                                                             | Hz   | High frequency of filter 60 dB stopband |

### 0.7 The `RFPath` Object

`RFPath` has the following properties:

| name            | required | type   | unit | description                       |
|-----------------|----------|--------|------|-----------------------------------|
| `id`            | true     | string | N/A  | Unique name or ID for the RF path |
| `cal_source_id` | false     | string | N/A  | ID of the calibration source      |
| `filter_id`     | false     | string | N/A  | ID of the filter                  |
| `amplifier_id`  | false     | string | N/A  | ID of the amplifier               |
| `antenna_id`    | false     | string | N/A  | ID of the antenna                 |

The `cal_source_id`, `filter_id`, and `amplifier_id` values SHOULD match the `id` field in corresponding `cal_source_spec`, `filter_spec`, or `amplifier_spec` objects. These fields are left optional since a given sensor may not make use of all three components. If a calibration source, filter, and amplifier exist for a given physical RF path, they SHOULD be recorded here.

### 0.8 The `Calibration` Object

| name                     | required | type   | unit                     | description                                                                                                  |
|--------------------------|----------|--------|--------------------------|--------------------------------------------------------------------------------------------------------------|
| `datetime`               | false    | string | ISO-8601 (see below)     | Timestamp for the calibration data in this object. RECOMMENDED                                               |
| `gain`                   | false    | double | dB                       | Calibrated gain of signal analyzer or sensor (may differ with signal analyzer gain setting)                  |
| `noise_figure`           | false    | double | dB                       | Calibrated noise figure of signal analyzer or sensor                                                         |
| `1db_compression_point`  | false    | double | dBm                      | Level of input to signal analyzer or sensor at which the received power level is compressed by 1 dB, in dBm. |
| `enbw`                   | false    | double | Hz                       | Equivalent noise bandwidth of signal analyzer or sensor                                                      |
| `mean_noise_power`       | false    | double | `mean_noise_power_units` | Mean sensor noise floor power                                                                                |
| `mean_noise_power_units` | false    | string | N/A                      | The units of the `mean_noise_power`                                                                          |
| `reference`              | false    | string | N/A                      | Reference point for the calibration data, e.g., `"signal analyzer input"`, `"preselector input"`            |
| `temperature`            | false    | double | degrees Celsius          | Temperature during calibration                                                                               |

The `datetime` MUST be an ISO-8601 string, as defined by [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt), where the only allowed `time-offset` is `z`, indicating the UTC/Zulu timezone. Thus, timestamps take the form of `YYYY-MM-DDTHH:MM:SS.SSSZ`, where any number of digits for fractional seconds is permitted.

### 0.9 The `SiganSettings` Object

| name              | required | type    | unit | description                                    |
|-------------------|----------|---------|------|------------------------------------------------|
| `gain`            | false    | double  | dB   | Gain setting of signal analyzer                |
| `reference_level` | false    | double  | dBm  | Reference level setting of the signal analyzer |
| `attenuation`     | false    | double  | dB   | Attenuation setting of the signal analyzer     |
| `preamp_enable`   | false    | boolean | N/A  | True if signal analyzer preamp is enabled      |

## 1 Global

The `ntia-sensor` extension adds the following field to the `global` SigMF object:

| name     | required | type                            | unit | description                                                        |
|----------|----------|---------------------------------|------|--------------------------------------------------------------------|
| `sensor` | false    | [Sensor](#01-the-sensor-object) | N/A  | Describes the sensor model components. This object is RECOMMENDED. |

## 2 Captures

`ntia-sensor` extends [Capture Segment Objects](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#capture-segment-objects) with the following keys:

| name                 | required | type                                          | unit | description                                        |
|----------------------|----------|-----------------------------------------------|------|----------------------------------------------------|
| `duration`           | false    | int                                           | ms   | Duration of IQ signal capture                      |
| `overload`           | false    | boolean                                       | N/A  | Whether signal analyzer overload occurred          |
| `rf_path`            | false    | string                                        | N/A  | The id of the `RFPath` used to produce the capture |
| `sensor_calibration` | false    | [Calibration](#08-the-calibration-object)     | N/A  | Sensor calibration metadata                        |
| `sigan_calibration`  | false    | [Calibration](#08-the-calibration-object)     | N/A  | Signal analyzer calibration metadata               |
| `sigan_settings`     | false    | [SiganSettings](#09-the-sigansettings-object) | N/A  | Signal analyzer settings used during capture       |

## 3 Annotations

The `ntia-sensor` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-sensor` extension does not extend the `collection` SigMF object.

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
          "amplifier_id" : "lna_1", 
          "antenna_id" : "123-xyzpdq"
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
    "ntia-core:classification" : "UNCLASSIFIED"
  },
  ...
  "captures" : [ {
    "core:sample_start" : 0,
    "ntia-sensor:overload" : false,
    "ntia-sensor:rf_path": "path_1",
    "ntia-sensor:sigan_calibration" : {
      "gain" : 30.0,
      "temperature" : 28.0,
      "datetime" : "2023-05-31T19:59:19.651Z",
      "enbw" : 1.0E7,
      "reference" : "antenna terminal",
      "noise_figure" : 4.9,
      "1db_compression_point" : 33.0,
      "mean_noise_power" : -100.0,
      "mean_noise_power_units" : "dBm"
    },
    "ntia-sensor:sensor_calibration" : {
      "gain" : 30.0,
      "temperature" : 28.0,
      "datetime" : "2023-05-31T19:59:19.651Z",
      "enbw" : 1.0E7,
      "reference" : "antenna terminal",
      "noise_figure" : 4.9,
      "1db_compression_point" : 33.0,
      "mean_noise_power" : -100.0,
      "mean_noise_power_units" : "dBm"
    },
    "ntia-sensor:duration" : 100,
    "ntia-sensor:sigan_settings" : {
      "attenuation" : 10.0,
      "gain" : 15.0,
      "reference_level" : -33.0,
      "preamp_enable" : true
    }
  } ],
  "annotations" : [ ... ]
}
```
