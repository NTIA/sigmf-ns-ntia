# ntia-antenna SigMF Extension v0.0.1

## 1. Description
The ntia-antenna namespace defines static sensor parameters that extend the global SigMF object and dynamic sensor parameters that extend the annotations SigMF object. The ntia-sensor extensions requires the [ntia-antenna](https://github.com/ntia/sigmf-ext-ntia-antenna) extension to describe the sensor antenna. 

## 2. Conventions Used in this Document
The `ntia-antenna` fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces).  

## 3. Global
Global information is applicable to the entire dataset. The ntia-antenna namespace does not directly extend the global object, but rather defines an [Antenna object](#61-antenna-object) type that may be referenced by Global extensions found in the `ntia-sensor` and the `ntia-emitter` extensions.


## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-antenna` specification does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. Each SigMF annotation segment object must contain a `core:sample_start` name/value pair, which indicates the first index at which the rest of the segment's name/value pairs apply.  The ntia-antenna namespace provides the following additional annotations. 

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
