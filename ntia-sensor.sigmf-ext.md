# ntia-sensor extension v1.0.0
The ntia-sensor namespace provides metadata to describe RF sensors. The ntia-sensor extensions requires the [ntia-antenna](https://github.com/ntia/sigmf-ext-ntia-antenna) extension to describe the sensor antenna. 

`ntia-sensor` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-sensor` extends the [Global object](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#61-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|

### 1.1 Sensor Object
Sensor definition follows a simplified hardware model comprised of the following elements: Antenna, Preselector, Receiver, and Host Controller. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The receiver (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

`Sensor` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique name for the sensor.|
|`antenna`|true|[Antenna](#antenna-object) |N/A|The collection of metadata that describes the sensor's antenna.|
|`preselector`|false| [Preselector](#63-preselector-object) |N/A|The collection of metadata to describe the preselector.|
|`receiver`|true| [Receiver](#62-receiver-object) |N/A|The collection of metadata to describe the receiver.|
|`host_controller`|false|string|N/A|Description of host computer. E.g. Make, model, and configuration.|
|`anti_aliasing_filter`|false|[DigitalFilter](#65-digitalfilter-object) |N/A|Describes anti-aliasing low-pass filter applied to IQ captures. |

### 1.2 Receiver Object
`Receiver` the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`model`|true|string|N/A|Make and model of the receiver. E.g., `"Ettus N210"`, `"Ettus B200"`, `"Keysight N6841A"`, `"Tektronix B206B"`.|
|`low_frequency`|false|double|Hz|Low frequency of operational range of the receiver.|
|`high_frequency`|false|double|Hz|High frequency of operational range of the receiver.|
|`noise_figure`|false|double|dB|Noise figure of the receiver.|
|`max_power`|false|double|dBm|Maximum input power of the receiver.|
|`a2d_bits`|false|int|bits|Number of bits in A/D converter.|

### 1.3 Preselector Object
`Preselector` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_paths`|false| [RFPath Object](#64-rfpath-object) array|N/A|Specification of the preselector RF paths via [RFPath Object](#rfpath-object).|

### 1.4 RFPath Object
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

## 2 Captures
`ntia-sensor` does not provide additional keys to `Captures`.

## 3 Annotations
`ntia-sensor` defines the following segments that extend `ntia-core`.

### 3.1 SensorAnnotation Segment
`SensorAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`altitude`|false|double|meters|The height of the antenna above mean sea level.|
|`speed`|false|double|m/s|Speed at which the antenna is moving.|
|`bearing`|false|double|degrees|Angle relative to true North.|
|`preselector-rf_path_number`|false|integer|N/A|The preselector RF path number.|
|`gps-fix-quality`|false|string|N/A|NMEA string denoting the quality of the GPS fix.|
|`overload-flag`|false|boolean|N/A|Flag indicator of system signal overload.|
|`receiver-attenuation`|false|double|dB|Attenuation of the receiver.|

## 4 Example
[TODO] Provide and example of `ntia-sensor`
