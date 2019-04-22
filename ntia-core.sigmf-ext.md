The ntia-core namespace adds generally useful metadata fields. 

`ntia-core` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-core` doe not directly extend the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object). ntia-core defines an `Antenna` object that is referenced through other global extensions ([ntia-sensor](ntia-sensor.sigmf-ext.md), [ntia-emitter](ntia-emitter.sigmf-ext.md))


## 1.1 Antenna Object
`Antenna` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of the antenna.|
|`model`|true|string|N/A|Antenna make and model number. E.g. `"ARA CSB-16"`, `"L-com HG3512UP-NF"`.|
|`type`|false|string|N/A|Antenna type. E.g. `"dipole"`, `"biconical"`, `"monopole"`, `"conical monopole"`.|
|`low_frequency`|false|double|Hz|Low frequency of operational range.|
|`high_frequency`|false|double|Hz|High frequency of operational range.|
|`polarization`|false|double|string|Antenna polarization. E.g. `"vertical"`, `"horizontal"`, `"slant-45"`, `"left-hand circular"`, `"right-hand circular"`.|
|`cross_polar_discrimination`|false|double|N/A|Cross-polarization discrimination.|
|`gain`|false|double|dBi|Antenna gain in direction of maximum radiation or reception.|
|`horizontal_gain_pattern`|false|array of doubles|dBi|Antenna gain pattern in horizontal plane from 0 to 359 degrees in 1 degree steps.|
|`vertical_gain_pattern`|false|array of double|dBi|Antenna gain pattern in vertical plane from -90 to +90 degrees in 1 degree steps.|
|`horizontal_beam_width`|false|double|degrees|Horizontal 3-dB beamwidth.|
|`vertical_beam_width`|false|double|degrees|Vertical 3-dB beamwidth.|
|`voltage_standing_wave_ratio`|false|double|volts|Voltage standing wave ratio.|
|`cable_loss`|false|double|dB|Cable loss for cable connecting antenna and preselector.|
|`steerable`|false|boolean|N/A|Defines if the antenna is steerable. If steerable, then `azimuth_angle` and `elevation_angle` are specified in annotation segment.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|

## 2 Captures
`ntia-core` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-core` extends [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array) with segments of different types defined throughout the set of ntia extensions to the core SigMF specification. `annotation_type` is defined with the following name/value pair:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`annotation_type`|true|string|N/A|Annotation type, e.g., `AntennaAnnotation`|

The following segments are of general use across the set of ntia extensions. 

### 3.1 AntennaAnnotation Segment
`AntennaAnnotation` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of an antenna defined in global.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|

## 4 Example

### 4.1 Antenna Global Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-core:antenna": {
        "id": "antenna1",
        "model": "model_X",
        "type": "omnidirectional",
        "low_frequency": 300000000,
        "high_frequency": 3000000000,
        "gain": 2,
        "cross_polar_discrimination": 9.1,
        "cable_loss": 1,
        "azimuth_angle": 45,
        "elevation_angle": 10.3
      }
      ...
  },
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
```
### 4.2 AntennaAnnotation Example
```json
{
  "global": {
    ...
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "AntennaAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-core:antenna_id": "antenna1",
      "ntia-core:azimuth_angle": 15,
      "ntia-core:elevation_angle": 20
    }
  ]
}
```