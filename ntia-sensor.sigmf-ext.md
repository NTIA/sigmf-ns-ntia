# The `ntia-sensor` SigMF Extension Namespace v2.0.0

This document defines the `ntia-sensor` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace helps to describe RF sensors.

## 0 Datatypes

The `ntia-sensor` extension defines the following datatypes:

|name|long-form name|description|
|----|--------------|-----------|
|`Sensor`|RF sensor|JSON [`Sensor`](#01-the-sensor-object) object specifying the physical and environmental properties of an RF sensor|
|`SignalAnalyzer`|signal analyzer specification|JSON [`SignalAnalyzer`](#02-the-signalanalyzer-object) object specifying a signal analyzer|
|`Preselector`|preselector specification|JSON [`Preselector`](#03-the-preselector-object) object specifying a preselector|
|`CalSource`|calibration source specification|JSON [`CalSource`](#04-the-calsource-object) object specifying a calibration source|
|`Amplifier`|amplifier specification|JSON [`Amplifier`](#05-the-amplifier-object) object specifying an amplifier in the RF path|
|`Filter`|filter specification|JSON [`Filter`](#06-the-filter-object) object specifying a filter in the RF path|
|`RFPath`|RF path specification|JSON [`RFPath`](#07-the-rfpath-object) object specifying an RF path as a combination of a filter, amplifier, and calibration source|

### 0.1 The `Sensor` Object

Sensor definition follows a simplified hardware model composed of the following elements: antenna, preselector, signal analyzer, and computer. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The signal analyzer (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

`Sensor` has the following properties:

| name              |required| type                                                               |unit| description                                         |
|-------------------|--------------|--------------------------------------------------------------------|-------|-----------------------------------------------------|
| `id`              |true| string                                                             |N/A| Unique logical ID for the sensor.                   |
| `sensor_spec`     |false| [HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)      |N/A| Metadata to describe/specify the sensor.            |
| `antenna`         |false| [Antenna](ntia-core.sigmf-ext.md#02-the-antenna-object)                |N/A| Metadata to describe/specify the antenna.           |
| `preselector`     |false| [Preselector](#03-the-preselector-object)                              |N/A| Metadata to describe/specify the preselector.       |
| `signal_analyzer` |false| [SignalAnalyzer](#02-the-signalanalyzer-object)                        |N/A| Metadata to describe/specify the signal analyzer.   |
| `computer_spec`   |false| [HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)      |N/A| Metadata to describe/specify the onboard computer.  |
| `mobile`          |false| boolean                                                            |N/A| Defines whether the sensor is mobile.               |
| `environment`     |false| [Environment](ntia-environment.sigmf-ext.md#01-the-environment-object) |N/A| Specifies the environment surrounding the `Sensor`. |
| `sensor_sha512`   |false| string        |N/A| Sha512 hash of the sensor definition.               |

### 0.2 The `SignalAnalyzer` Object

`SignalAnalyzer` the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sigan_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)|N/A|Metadata to describe/specify the signal analyzer.|
|`frequency_low`|false|double|Hz|Low frequency of operational range of the signal analyzer.|
|`frequency_high`|false|double|Hz|High frequency of operational range of the signal analyzer.|
|`noise_figure`|false|double|dB|Noise figure of the signal analyzer.|
|`max_power`|false|double|dBm|Maximum input power of the signal analyzer.|
|`a2d_bits`|false|integer|bits|Number of bits in A/D converter.|

### 0.3 The `Preselector` Object

`Preselector` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`preselector_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)|N/A|Metadata to describe/specify the preselector.|
|`cal_sources`|false|[CalSource[]](#04-the-calsource-object)|N/A|Metadata to describe/specify the preselector calibration source.|
|`amplifiers`|false|[Amplifier[]](#05-the-amplifier-object)|N/A|Metadata to describe/specify the preselector low noise amplifiers.|
|`filters`|false|[Filter[]](#06-the-filter-object)|N/A|Metadata to describe the preselector RF filters.|
|`rf_paths`|false|[RFPath[]](#07-the-rfpath-object)|N/A|Metadata that describes preselector RF paths.|

### 0.4 The `CalSource` Object

`CalSource` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`cal_source_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)|N/A|Metadata to describe the calibration source specification.|
|`type`|false|string|N/A|Type of the calibration source.|
|`enr`|false|double|dB|Excess noise ratio.|

### 0.5 The `Amplifier` Object

`Amplifier` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`amplifier_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)|N/A|Metadata to describe the amplifier specification.|
|`gain`|false|double|dB|Gain of the low noise amplifier.|
|`noise_figure`|false|double|dB|Noise figure of the low noise amplifier.|
|`max_power`|false|double|dB|Maximum power of the low noise amplifier.|

### 0.6 The `Filter` Object

`Filter` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_spec`|false|[HardwareSpec](/ntia-core.sigmf-ext.md#03)|N/A|Metadata to describe/specify the filter specification.|
|`frequency_low_passband`|false|double|Hz|Low frequency of filter 1 dB passband.|
|`frequency_high_passband`|false|double|Hz|High frequency of filter 1 dB passband.|
|`frequency_low_stopband`|false|double|Hz|Low frequency of filter 60 dB stopband.|
|`frequency_high_stopband`|false|double|Hz|High frequency of filter 60 dB stopband.|

### 0.7 The `RFPath` Object

`RFPath` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|false|string|N/A|Descriptive name for the RFPath.|
|`cal_source_id`|true|string|N/A|ID of the calibration source.|
|`filter_id`|true|string|N/A|ID of the filter.|
|`amplifier_id`|true|string|N/A|ID of the amplifier.|

### 0.8 The `Calibration` Object

| name          |required| type                                  | unit    | description                                 |
|---------------|--------------|---------------------------------------|---------|---------------------------------------------|
|`gain`|false|double|N/A|Gain of signal analyzer or sensor (may differ with signal analyzer gain setting).|
|`noise_figure`|false|double|dB|Noise figure of signal analyzer or sensor.|
|`1db_compression_point`|false|double|dBm|Maximum input of signal analyzer or sensor.|
|`enbw`|false|double|Hz|Equivalent noise bandwidth of signal analyzer or sensor.|
|`gain_preselector`|false|double|dB|Gain of sensor preselector.|
|`mean_noise_power`|false|double|Defined in `mean_noise_power_units`|Mean noise power density of sensor.|
|`mean_noise_power_units`|false|string|N/A|The units of the mean_noise_power|
|`mean_noise_power_reference`|false|string|N/A| Reference source for the mean_noise_power, e.g., `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`|
| `temperature` |false|double| celsius | The temperature during calibration.         |

### 0.9 The `SiganSettings` Object

| name                         |required| type    | unit | description                                |
|------------------------------|--------------|---------|------|--------------------------------------------|
| `gain`                       |false| double  | dB   | Gain of signal analyzer.                   |
| `reference_level`            |false| double  | dBm  | Reference level of the signal analyzer.    |
| `attenuation`                |false| double  | dB   | Attenuation of the signal analyzer.        |
| `preamp_enable`              |false| boolean | N/A  | True if signal analyzer preamp is enabled. |

## 1 Global

The `ntia-sensor` extension adds the following fields to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#01-the-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|
|`calibration_datetime`|false|string|ISO-8601 (see below)|Time of last calibration. RECOMMENDED.|

The `calibration_datetime` MUST be an ISO-8601 string, as defined by [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt), where the only allowed `time-offset` is `z`, indicating the UTC/Zulu timezone. Thus, timestamps take the form of `YYYY-MM-DDTHH:MM:SS.SSSZ`, where any number of digits for fractional seconds is permitted.

## 2 Captures

`ntia-sensor` extends [Capture Segment Objects](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#capture-segment-objects) with the following keys:

| name                 |required| type                                      | unit    | description                                    |
|----------------------|--------------|-------------------------------------------|---------|------------------------------------------------|
| `duration`           |false| int                                       |milliseconds| Duration of IQ signal capture.                 |
| `overload`           |false| boolean                                   |N/A| Indicates if signal analyzer overload occurred |
| `sensor_calibration` |false| [Calibration](#08-the-calibration-object)     |N/A| Sensor calibration metadata.                   |
| `sigan_calibration`  |false| [Calibration](#08-the-calibration-object)     |N/A| Signal analyzer calibration metadata.          |
| `sigan_settings`     |false| [SiganSettings](#09-the-sigansettings-object) |N/A| Signal analyzer settings used during capture.  |

## 3 Annotations

The `ntia-sensor` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-sensor` extension does not extend the `collection` SigMF object.

## 5 Example

```json
{
  "global": {
    "core:extensions" : {
      "ntia-sensor" : "v2.0.0",
      "ntia-environment" : "v1.0.0"
    },
    "ntia-sensor:sensor": {
      "id": "192.168.1.53",
      "sensor_spec": {
        "id": "bh-5",
        "model": "bassethound",
        "version": "v1.0.0",
        "description": ""
      },
      "antenna": {
        "antenna_spec": {
          "model": "ARA BSB-26",
          "description": "RF antenna ideally suited for reception of signals on the horizon for nautical and broadband surveillance applications"
        },
        "type": "Omni-directional",
        "frequency_low": 2000000000.0,
        "frequency_high": 6000000000.0,
        "gain": 0.0,
        "polarization": "Slant",
        "cross_polar_discrimination": 13.0,
        "horizontal_beamwidth": 360.0,
        "vertical_beamwidth": 68.38,
        "voltage_standing_wave_ratio": 2.0,
        "cable_loss": 0.79,
        "steerable": false
      },
      "preselector": {
        "cal_sources": [
          {
            "cal_source_spec": {
              "id": "37501",
              "model": "Mercury Systems NS36B-1",
              "supplemental_information": "https://www.everythingrf.com/products/noise-sources/mercury-systems/608-220-ns346b-1"
            },
            "type": "Calibrated noise source",
            "enr": "14.53 dB"
          }
        ],
        "filters": [
          {
            "filter_spec": {
              "id": "13FV40-00014, SN 6",
              "model": "K&L 13FV40-3550/U200-o/o",
              "supplemental_information": "http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO"
            },
            "frequency_low_passband": 3430000000.0,
            "frequency_high_passband": 3670000000.0,
            "frequency_low_stopband": 3390000000.0,
            "frequency_high_stopband": 3710000000.0
          },
          {}
        ],
        "amplifiers": [
          {
            "amplifier_spec": {
              "id": "1904044",
              "model": "MITEQ AFS3-02000400-30-25P-6",
              "supplemental_information": "https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf"
            },
            "gain": 32.85,
            "noise_figure": 2.59,
            "max_power": 13.0
          }
        ],
        "rf_paths": [
          {
            "name": "Path 1",
            "cal_source_id": "37501",
            "filter_id": "13FV40-00014, SN 6",
            "amplifier_id": "1904044"
          },
          {
            "name": "Bypass",
            "cal_source_id": "37501"
          }
        ]
      },
      "signal_analyzer": {
        "sigan_spec": {
          "id": "502725",
          "model": "Keysight N6841A",
          "supplemental_information": "https://www.keysight.com/us/en/assets/7018-02113/data-sheets/5990-3839.pdf"
        },
        "frequency_low": 20000000.0,
        "frequency_high": 6000000000.0,
        "noise_figure": 20.0,
        "max_power": 20.0,
        "a2d_bits": 14
      },
      "computer_spec": {
        "id": "MC 9",
        "description": "Custom computer with Intel i7 processor, MSI motherboard, 16 GB of Ram and running Windows 7"
      },
      "environment": {
        "category": "Outside. Coastal."
      }
    },
    "ntia-sensor:calibration_datetime": "2018-01-01T10:49:58.236Z"
  },
  "captures": [
    {
      "core:frequency": 3545000000.0,
      "core:datetime": "2023-04-14T17:04:20.118Z",
      "ntia-sensor:overload": true,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 4.649,
        "gain": 30.708,
        "temperature": 24.2,
        "datetime": "2023-04-14T17:01:03.679Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 0
    }
    ...
  ],
  "annotations": []
}
```
