# ntia-calibration Extension v1.0.0
The ntia-calibration namespace provides information about calibration factors applied to the data.

`ntia-calibration` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces#namespaces) specification and conventions.

## 1 Global
`ntia-calibration` extends [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. This is RECOMMENDED.|
|`scaling_factor_sigan`|false|double|N/A|Factor that converts signal analyzer A/D output to volts.|
|`noise_figure_sigan`|false|double|dB|Noise figure of signal analyzer.|
|`1db_compression_point_sigan`|false|double|dBm|Maximum input of signal analyzer.|
|`gain_sensor`|false|double|N/A|Gain of sensor.|
|`noise_figure_sensor`|false|double|dB|Noise figure of sensor.|
|`1db_compression_point_sensor`|false|double|dBm|Maximum input of sensor.|
|`system_noise_power_sensor`|false|[SystemNoise](#32-systemnoise-object)|N/A|Metadata that describes sytems noise. This object is RECOMMENDED.|

### 1.1 SystemNoise Object 
`SystemNoise` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`mean_power_density`|true|double|N/A|Mean power density of the system noise.|
|`reference`|true|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`.|
|`units`|true|string|N/A|Units, e.g., `"dBm/Hz"`.|

## 2 Captures
`ntia-calibration` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-calibration` defines the following segments that extend `ntia-core`.

### 3.1 CalibrationAnnotation Segment
`CalibrationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. This is RECOMMENDED.|
|`scaling_factor_sigan`|false|double|N/A|Factor that converts signal analyzer A/D output to volts.|
|`noise_figure_sigan`|false|double|dB|Noise figure of signal analyzer.|
|`1db_compression_point_sigan`|false|double|dBm|Maximum input of signal analyzer.|
|`gain_sensor`|false|double|N/A|Gain of sensor.|
|`noise_figure_sensor`|false|double|dB|Noise figure of sensor.|
|`1db_compression_point_sensor`|false|double|dBm|Maximum input of sensor.|
|`system_noise_power_sensor`|false|[SystemNoise](#32-systemnoise-object)|N/A|Metadata that describes sytems noise. This object is RECOMMENDED.|

## 4 Example

```<updated example needed>
```
