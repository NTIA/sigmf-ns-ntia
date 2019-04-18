# ntia-calibration Extension v1.0.0
The ntia-calibration namespace provides information about calibration factors applied to the data.

`ntia-calibration` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces#namespaces) specification and conventions.

## 1 Global
`ntia-calibration` does not provide additional keys to  [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object). 

## 2 Captures
`ntia-calibration` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-calibration` defines the following segments that extend `ntia-core`.

### 3.1 CalibrationAnnotation Segment
`CalibrationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`receiver_scaling_factor`|false|double|N/A|Factor that converts receiver A/D output to volts.|
|`receiver_1db_compression_point`|false|double|dBm|Maximum input of receiver.|
|`receiver_system_noise_power`|false|[SystemNoise](#32-systemnoise-object)|N/A|Metadata that describes sytems noise. This object is RECOMMENDED.|

### 3.2 SystemNoise Object 
`SystemNoise` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`mean_power_density`|true|double|N/A|Mean power density of the system noise.|
|`reference`|true|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`.|
|`units`|true|string|N/A|Units, e.g., `"dBm/Hz"`.|

## 4 Example
[TODO] Provide and example of `ntia-calibration`
