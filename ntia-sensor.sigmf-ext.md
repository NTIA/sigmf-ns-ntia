# ntia-sensor extension v1.0.0

The ntia-sensor namespace provides metadata to describe RF sensors.  The extension defines static sensor parameters that extend the global SigMF object and dynamic sensor parameters that extend the annotations SigMF object. The ntia-sensor extensions requires the [ntia-antenna](https://github.com/ntia/sigmf-ext-ntia-antenna) extension to describe the sensor antenna. 

## 2. Conventions Used in this Document

The SCOS specification uses and is fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces), the specification is enhanced through the implementation of a `ntia-sensor` namespace, the details of which follow.  

## 3. Global
Global information is applicable to the entire dataset. The ntia-sensor namespace provides the following global object extensions:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#61-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|

## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-sensor` specification does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. Each SigMF annotation segment object must contain a `core:sample_start` name/value pair, which indicates the first index at which the rest of the segment's name/value pairs apply.  The sntia-sensor namespace provides the following additional annotations. 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`altitude`|false|double|meters|The height of the antenna above mean sea level.|
|`speed`|false|double|m/s|Speed at which the antenna is moving.|
|`bearing`|false|double|degrees|Angle relative to true North.|
|`preselector-rf_path_number`|false|integer|N/A|The preselector RF path number.|
|`gps-fix-quality`|false|string|N/A|NMEA string denoting the quality of the GPS fix.|
|`overload-flag`|false|boolean|N/A|Flag indicator of system signal overload.|
|`receiver-attenuation`|false|double|dB|Attenuation of the receiver.|
|`receiver-scaling_factor`|false|double|N/A|Factor that converts receiver A/D output to volts.|
|`receiver-1db_compression_point`|false|double|dBm|Maximum input of receiver.|
|`receiver-system_noise_power`|false|[SystemNoise](#66-systemnoise-object)|N/A|The system noise power. This object is RECOMMENDED.|


## 6. Object Definitions

### 6.1 Sensor Object
Sensor definition follows a simplified hardware model comprised of the following elements: Antenna, Preselector, Receiver, and Host Controller. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The receiver (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

The `Sensor` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique name for the sensor.|
|`antenna`|true|[Antenna](#antenna-object) |N/A|The collection of metadata that describes the sensor's antenna.|
|`preselector`|false| [Preselector](#63-preselector-object) |N/A|The collection of metadata to describe the preselector.|
|`receiver`|true| [Receiver](#62-receiver-object) |N/A|The collection of metadata to describe the receiver.|
|`host_controller`|false|string|N/A|Description of host computer. E.g. Make, model, and configuration.|
|`anti_aliasing_filter`|false|[DigitalFilter](#65-digitalfilter-object) |N/A|Describes anti-aliasing low-pass filter applied to IQ captures. |

### 6.2 Receiver Object
The `Receiver` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`model`|true|string|N/A|Make and model of the receiver. E.g., `"Ettus N210"`, `"Ettus B200"`, `"Keysight N6841A"`, `"Tektronix B206B"`.|
|`low_frequency`|false|double|Hz|Low frequency of operational range of the receiver.|
|`high_frequency`|false|double|Hz|High frequency of operational range of the receiver.|
|`noise_figure`|false|double|dB|Noise figure of the receiver.|
|`max_power`|false|double|dBm|Maximum input power of the receiver.|
|`a2d_bits`|false|int|bits|Number of bits in A/D converter.|

### 6.3 Preselector Object
The `Preselector` object may the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_paths`|false| [RFPath Object](#64-rfpath-object) array|N/A|Specification of the preselector RF paths via [RFPath Object](#rfpath-object).|

### 6.4 RFPath Object
Each `RFPath` object may contain the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_path_number`|false|integer|N/A|RF path number.|
|`low_frequency_passband`|false|double|Hz|Low frequency of filter 1-dB passband.|
|`high_frequency_passband`|false|double|Hz|High frequency of filter 1-dB passband.|
|`low_frequency_stopband`|false|double|Hz|Low frequency of filter 60-dB stopband.|
|`high_frequency_stopband`|false|double|Hz|High frequency of filter 60-dB stopband.|
|`lna_gain`|false|double|dB|Gain of low noise amplifier.|
|`lna_noise_figure`|false|double|dB|Noise figure of low noise amplifier.|
|`cal_source_type`|false|string|N/A|E.g., `"calibrated noise source"`.|

### 6.5 DigitalFilter Object
Each `DigitalFilter` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_type`|false|string|N/A|Description of digital filter, e.g., `"FIR"`: Finite impulse response|
|`length`|false|integer|N/A|Number of taps.|
|`frequency_cutoff`|false|double|Hz|Frequency at which the magnitude response decreases (from its maximum) by `attenuation_cutoff`.|
|`attenuation_cutoff`|false|double|dB|Magnitude response threshold (below maximum) that specifies `frequency_cutoff`.|
|`ripple_passband`|false|double|dB|Ripple in passband.|
|`attenuation_stopband`|false|double|dB|Attenuation of stopband.|
|`frequency_stopband`|false|double|Hz|Point in filter frequency response where stopband starts.|

### 6.6 SystemNoise Object
System noise is inherent to every measurement. The `SystemNoise` object contains the following name/value pairs:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|Determination method of system noise. E.g. `"mean"` or `"peak"`.|
|`reference`|true|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`.|
|`system_noise`|true|double|N/A|Mean power of the system noise.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|





