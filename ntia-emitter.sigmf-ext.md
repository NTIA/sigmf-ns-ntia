# The `ntia-emitter` SigMF Extension Namespace v2.0.0

This document defines the `ntia-emitter` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace defines how to describe the attributes of a radio frequency signal emitter.

## 0 Datatypes

This extension defines the following datatype:

|name|long-form name|description|
|----|--------------|-----------|
|`Emitter`|radio frequency signal emitter| JSON [`Emitter`](#01-the-emitter-object) object containing metadata describing the radio frequency signal emitter|

### 0.1 The `Emitter` Object

An `Emitter` object is used to describe the properties of a radio signal emitter. This may include descriptions of the hardware, location, and emitted waveform.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique ID of the emitter|
|`description`|false|string|N/A|A brief textual description of the emitter|
|`power`|false|double|dBm|Power referenced to antenna input|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#12-antenna-object)|N/A|Metadata that describes the antenna|
|`transmitter`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata that describes the transmitter|
|`center_frequency`|false|double|Hz|Center frequency of the emitted signal|
|`waveform`|false| [Waveform](ntia-waveform.sigmf-ext.md)|N/A|Metadata that describes the transmitted waveform|
|`geolocation`|false|GeoJSON|N/A|The location of the emitter|
|`environment`|false|[Environment](ntia-environment.sigmf-ext.md#01-the-environment-object)|N/A|Metadata that describes the environment surrounding the `Emitter`|

An example of an `Emitter` object is shown below:

```json
"emitter" : {
  "id" : "N5182B-1",
  "power" : 19.0,
  "antenna" : {
    "antenna_spec" : {
      "model" : "Cobham_OA2-0.3-10.0V/1505",
      "description" : "Ultra Wide Band Omni Antenna",
      "supplemental_information" : "https://www.european-antennas.co.uk/media/1638/ds1505-060510.pdf"
    },
    "type" : "omni-directional",
    "frequency_low" : 3.0E8,
    "frequency_high" : 1.0E10,
    "gain" : 2.0,
    "polarization" : "horizontal",
    "cross_polar_discrimination" : 20.0,
    "horizontal_beamwidth" : 360.0,
    "vertical_beamwidth" : 65.0,
    "voltage_standing_wave_ratio" : 2.5,
    "cable_loss" : 0.15,
    "steerable" : false,
    "elevation_angle" : 90.0
  },
  "transmitter" : {
    "model" : "N5182B",
    "version" : "v1.0.0",
    "description" : "Keysight MxG X-series RF Vector Signal Generator",
    "supplemental_information" : "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf"
  },
  "center_frequency" : 4.35E8,
  "waveform" : {
    "model" : "CW",
    "description": "continuous wave"
  },
  "geolocation" : {
    "type": "Point",
    "coordinates": [-107.6183682, 34.0787916, 2120.0]
  },
  "environment" : {
    "description" : "Center of the NRAO Very Large Array"
  }
}
```

## 1 Global

The `ntia-emitter` extension adds the following field to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitters`|false|[Emitter](#01-the-emitter-object)[]|N/A|Metadata that describe emitters|

## 2 Captures

The `ntia-emitter` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-emitter` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-emitter` extension does not extend the `collection` SigMF object.

## 5 Examples

Here is an example showing the use of `ntia-emitter` to document a (fictitious) signal emitter:

```json
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "ntia-emitter:emitters" : [ {
      "id" : "N5182B-1",
      "power" : 19.0,
      "antenna" : {
        "antenna_spec" : {
          "model" : "Cobham_OA2-0.3-10.0V/1505",
          "description" : "Ultra Wide Band Omni Antenna",
          "supplemental_information" : "https://www.european-antennas.co.uk/media/1638/ds1505-060510.pdf"
        },
        "type" : "omni-directional",
        "frequency_low" : 3.0E8,
        "frequency_high" : 1.0E10,
        "gain" : 2.0,
        "polarization" : "horizontal",
        "cross_polar_discrimination" : 20.0,
        "horizontal_beamwidth" : 360.0,
        "vertical_beamwidth" : 65.0,
        "voltage_standing_wave_ratio" : 2.5,
        "cable_loss" : 0.15,
        "steerable" : false,
        "elevation_angle" : 90.0
      },
      "transmitter" : {
        "model" : "N5182B",
        "version" : "v1.0.0",
        "description" : "Keysight MxG X-series RF Vector Signal Generator",
        "supplemental_information" : "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf"
      },
      "center_frequency" : 4.35E8,
      "waveform" : {
        "model" : "Waveform",
        "description" : "continuous wave"
      },
      "geolocation" : {
        "type": "Point",
        "coordinates": [-107.6183682, 34.0787916, 2120.0]
      },
      "environment" : {
        "description" : "Center of the NRAO Very Large Array"
      }
    } ]
  },
  "captures" : [ ],
  "annotations" : [ ]
}
```
