# The `ntia-core` SigMF Extension Namespace v2.0.0

This document defines the `ntia-core` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace provides generally-useful metadata fields for NTIA's SigMF namespace extensions.

## 0 Datatypes

The `ntia-core` extension provides the following datatypes, which are referenced by this and other NTIA extensions:

| name           | long-form name         | description                                                                                                                                              |
|----------------|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Antenna`      | antenna specification  | JSON [Antenna](#01-the-antenna-object) object specifying an antenna                                                                                      |
| `enum`         | enumeration type       | Enumeration accepting a defined set of elements represented by a [core datatype](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#datatypes) |
| `HardwareSpec` | hardware specification | JSON [HardwareSpec](#02-the-hardwarespec-object) object, used to provide hardware details within other objects                                           |

## 0.1 The `Antenna` Object

`Antenna` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`antenna_spec`|true| [HardwareSpec](#02-the-hardwarespec-object) |N/A|Metadata to describe antenna.|
|`type`|false|string|N/A|Antenna type. E.g. `"dipole"`, `"biconical"`, `"monopole"`, `"conical monopole"`.|
|`frequency_low`|false|double|Hz|Low frequency of operational range.|
|`frequency_high`|false|double|Hz|High frequency of operational range.|
|`polarization`|false|double|string|Antenna polarization. E.g. `"vertical"`, `"horizontal"`, `"slant-45"`, `"left-hand circular"`, `"right-hand circular"`.|
|`cross_polar_discrimination`|false|double|N/A|Cross-polarization discrimination.|
|`gain`|false|double|dBi|Antenna gain in direction of maximum radiation or reception.|
|`horizontal_gain_pattern`|false|double[]|dBi|Antenna gain pattern in horizontal plane from 0 to 359 degrees in 1 degree steps.|
|`vertical_gain_pattern`|false|double[]|dBi|Antenna gain pattern in vertical plane from -90 to +90 degrees in 1 degree steps.|
|`horizontal_beamwidth`|false|double|degrees|Horizontal 3 dB beamwidth.|
|`vertical_beamwidth`|false|double|degrees|Vertical 3 dB beamwidth.|
|`voltage_standing_wave_ratio`|false|double|volts|Voltage standing wave ratio.|
|`cable_loss`|false|double|dB|Cable loss for cable connecting antenna and preselector.|
|`steerable`|false|boolean|N/A|Defines whether the antenna is steerable.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|

## 0.2 The `HardwareSpec` Object

`HardwareSpec` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique ID of hardware. E.g., serial number.|
|`model`|false|string|N/A|Hardware make and model.|
|`version`|false|string|N/A|Hardware version.|
|`description`|false|string|N/A|Description of the hardware.|
|`supplemental_information`|false|string|N/A|Information about hardware, e.g., url to on-line data sheets.|

## 1 Global

The `ntia-core` extension adds the following name/value pair to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`classification`|true|string|N/A|The classification markings for the acquisition, e.g., `UNCLASSIFIED`, `CONTROLLED//FEDCON`, `SECRET`|

## 2 Captures

The `ntia-core` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-core` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-core` extension does not extend the `collection` SigMF object.

## 5 Examples

### 5.1 Single-frequency Measurement Example

```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 2.8E7,
    "core:extensions": [
      {
        "name": "ntia-core",
        "version": "v2.0.0",
        "optional": false
      }
    ],
    "ntia-core:classification": "UNCLASSIFIED"
  },
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
  ```

### 5.2 Scan Measurement Example

```json  
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 2.8E7,
    "core:description": "Radar data captured off the coast of San Francisco",
    "core:extensions": [
      {
        "name": "ntia-core",
        "version": "v2.0.0",
        "optional": false
      },
      {
        "name": "ntia-sensor",
        "version": "v2.0.0",
        "optional": false
      }
    ],
    "core:geolocation": {
        "type": "Point",
        "coordinates": [-122.5309, 37.8204, 51.3522]
    },
    "ntia-sensor:sensor": {
      "id": "192.168.1.53",
      "sensor_spec": {
        "id": "bh-5",
        "model": "bassethound",
        "version": "v1.0.0"
      },
      "antenna": {
        "antenna_spec": {
          "id": "1000AAA",
          "model": "ARA BSB-26",
          "description": "RF antenna ideally suited for reception of signals on the horizon for nautical and broadband surveillance applications"
        },
        "type": "Omni-directional",
        "frequency_low": 2.0E9,
        "frequency_high": 6.0E9,
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
        "cal_sources": [ {
          "cal_source_spec": {
            "id": "37501",
            "model": "Mercury Systems NS36B-1",
            "supplemental_information": "https://www.everythingrf.com/products/noise-sources/mercury-systems/608-220-ns346b-1"
          },
          "type": "Calibrated noise source",
          "enr": "14.53 dB"
        } ],
        "filters": [ {
          "filter_spec": {
            "id": "13FV40-00014, SN 6",
            "model": "K&L 13FV40-3550/U200-o/o",
            "supplemental_information": "http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO"
          },
          "frequency_low_passband": 3.43E9,
          "frequency_high_passband": 3.67E9,
          "frequency_low_stopband": 3.39E9,
          "frequency_high_stopband": 3.71E9
        } ],
        "amplifiers": [ {
          "amplifier_spec": {
            "id": "1904044",
            "model": "MITEQ AFS3-02000400-30-25P-6",
            "supplemental_information": "https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf"
          },
          "gain": 32.85,
          "noise_figure": 2.59,
          "max_power": 13.0
        } ],
        "rf_paths": [ {
          "id": "Path 1",
          "cal_source_id": "37501",
          "filter_id": "13FV40-00014, SN 6",
          "amplifier_id": "1904044"
        } ]
      },
      "signal_analyzer": {
        "sigan_spec": {
          "id": "502725",
          "model": "Keysight N6841A",
          "supplemental_information": "https://www.keysight.com/us/en/assets/7018-02113/data-sheets/5990-3839.pdf"
        },
        "frequency_low": 2.0E7,
        "frequency_high": 6.0E9,
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
    "ntia-sensor:calibration_datetime": "2018-01-01T10:49:58.236Z",
    "ntia-core:classification":  "UNCLASSIFIED"
  },
  "captures": [ {
    "core:sample_start": 0,
    "core:frequency": 3.5501875E9,
    "core:datetime": "2018-01-01T07:59:42.792Z"
  } ],
  "annotations": []
}
```
