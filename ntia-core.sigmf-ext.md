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

## 5 Example

This example snippet shows the `ntia-core` extension being used to indicate that the corresponding data are unclassified, and how to record the use of `ntia-core` in the Global `core:extensions` array. Examples showing the [Antenna](#01-the-antenna-object) and [HardwareSpec](#02-the-hardwarespec-object) objects may be found in the [examples](./ntia-sensor.sigmf-ext.md#5-example) for `ntia-sensor` and the [example](./ntia-emitter.sigmf-ext.md#5-example) for `ntia-emitter`.

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
  ...
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
```
