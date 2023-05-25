# The `ntia-emitter` SigMF Extension Namespace v2.0.0

This document defines the `ntia-emitter` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace provides emitter defintion and properties.

## 0 Datatypes

The `ntia-emitter` extension defines the following datatype:

|name|long-form name|description|
|----|--------------|-----------|
|`Emitter`|signal emitter|JSON [Emitter](#01-the-emitter-object) object containing information describing a signal emitter, including its physical properties, emitted waveform, and environment|

### 0.1 The `Emitter` Object

An `Emitter` object describes the physical and environmental characteristics of a signal emitter, and has the following properties:

| name               |required|type|unit| description                                          |
|--------------------|--------------|-------|-------|------------------------------------------------------|
| `id`               |true|string|N/A| Unique ID of the emitter                            |
| `description`      |false|string|N/A| Description of the emitter                          |
| `power`            |false|double|dBm| Power referenced to antenna input                   |
| `antenna`          |false|[Antenna](ntia-core.sigmf-ext.md#02-the-antenna-object)|N/A| Metadata that describes the antenna                 |
| `transmitter`      |false|[HardwareSpec](ntia-core.sigmf-ext.md#03-the-hardwarespec-object)|N/A| Metadata that describes the transmitter             |
| `center_frequency` |false|double|Hz| Center frequency                                    |
| `waveform`         |false| [Waveform](ntia-waveform.sigmf-ext.md)|N/A| Metadata that describes transmitted waveform        |
| `geolocation`      |false|GeoJSON point Object|N/A| The location of the emitter                       |
| `environment`      |false|[Environment](ntia-environment.sigmf-ext.md#01-the-environment-object)|N/A| Specifies the environment surrounding the emitter |

## 1 Global

The `ntia-emitter` extension adds the following field to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitters`|false|[Emitter](#01-the-emitter-object)[]|N/A|Metadata that describe signal emitters|

## 2 Captures

The `ntia-emitter` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-emitter` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-emitter` extension does not extend the `collection` SigMF object.

## 5 Example

```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 2.8E7,
    "core:extensions": [
      {
        "name": "ntia-emitter",
        "version": "v2.0.0",
        "required": true
      }
    ],
    "ntia-emitter:emitters": [ {
      "id": "N5182B-1",
      "power": 19.0,
      "antenna": {
        "antenna_spec": {
          "model": "Cobham_OA2-0.3-10.0V/1505",
          "description": "Ultra Wide Band Omni Antenna",
          "supplemental_information": "https://www.european-antennas.co.uk/media/1638/ds1505-060510.pdf"
        },
        "type": "omni-directional",
        "frequency_low": 3.0E8,
        "frequency_high": 1.0E10,
        "gain": 2.0,
        "polarization": "horizontal",
        "cross_polar_discrimination": 20.0,
        "horizontal_beamwidth": 360.0,
        "vertical_beamwidth": 65.0,
        "voltage_standing_wave_ratio": 2.5,
        "cable_loss": 0.15,
        "steerable": false,
        "elevation_angle": 90.0
      },
      "transmitter": {
        "model": "N5182B",
        "version": "v1.0.0",
        "description": "Keysight MxG X-series RF Vector Signal Generator",
        "supplemental_information": "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf"
      },
      "center_frequency": 4.35E8,
      "waveform": {
        "model": "Waveform",
        "description": "continuous wave"
      },
      "environment": {
        "category": "Underground, coal mine"
      }
    } ]
  },
  "captures": [ ],
  "annotations": [ ]
}
```
