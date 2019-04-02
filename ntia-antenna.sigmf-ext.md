# ntia-antenna SigMF Extension v0.0.1

## 1. Description
The `ntia-antenna` namespace provides antenna definition and configuration parameters.

## 2. Conventions Used in this Document
`ntia-antenna` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 3. Global
`Global` information is applicable to the entire SigMF dataset. `ntia-antenna` does not directly extend `Global`. Rather, it defines an [Antenna object](#61-antenna-object) type that may be referenced by Global extensions, e.g.,  `ntia-sensor` and `ntia-emitter`.


## 4. Captures
`Captures` information describes parameters of the SigMF signal capture. `ntia-antenna` does not add enhancements to `Captures`.

## 5. Annotations
`Annotations` information provides parameters at sample resolution. `ntia-antenna` provides the following enhancements to `Annotations` .

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|

## 6. Object Definitions

The `Antenna` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`model`|true|string|N/A|Antenna make and model number. E.g. `"ARA CSB-16"`, `"L-com HG3512UP-NF"`.|
|`type`|false|string|N/A|Antenna type. E.g. `"dipole"`, `"biconical"`, `"monopole"`, `"conical monopole"`.|
|`low_frequency`|false|double|Hz|Low frequency of operational range.|
|`high_frequency`|false|double|Hz|High frequency of operational range.|
|`gain`|false|double|dBi|Antenna gain in direction of maximum radiation or reception.|
|`horizontal_gain_pattern`|false|array of doubles|dBi|Antenna gain pattern in horizontal plane from 0 to 359 degrees in 1 degree steps.|
|`vertical_gain_pattern`|false|array of double|dBi|Antenna gain pattern in vertical plane from -90 to +90 degrees in 1 degree steps.|
|`horizontal_beam_width`|false|double|degrees|Horizontal 3-dB beamwidth.|
|`vertical_beam_width`|false|double|degrees|Vertical 3-dB beamwidth.|
|`cross_polar_discrimination`|false|double|N/A|Cross-polarization discrimination.|
|`voltage_standing_wave_ratio`|false|double|volts|Voltage standing wave ratio.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|
|`polarization`|false|double|string|E.g. `"vertical"`, `"horizontal"`, `"slant-45"`, `"left-hand circular"`, `"right-hand circular"`.|
|`cable_loss`|false|double|dB|Cable loss for cable connecting antenna and preselector.|
|`steerable`|false|boolean|N/A|Defines if the antenna is steerable or not.|
|`mobile`|false|boolean|N/A|Defines if the antenna is mobile or not.|
