# ntia-emitter Extension v1.0.0

The ntia-emitter namespace provides emiter defintion and properties. 

`ntia-emitter` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-emitter` extends the [Global object](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
emitter|false|[Emitter]()|N/A|Emitter metada

### 1.1 Emitter Object
`Emitter` object has the following properties:
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|The unique id of the emitter.|
|`description`|false|string|N/A|A description of the emitter.|
|`power`|false|double|dBm|Emitter power going into antenna.|
|`antenna`|false|[Antenna](#antenna-object) |N/A|See [ntia-antenna](#antenna-object) extension.|
|`waveform`|false| [Waveform](https://github.com/NTIA/sigmf-ns-waveform)|N/A|See [ntia-waveform extension](https://github.com/NTIA/sigmf-ns-waveform)
|`latitude`|false|double|decimal degrees|Latitude of emitter.|
|`longitude`|false|double|decimal degrees|Longitude of emitter.|
|`altitude`|false|double|meters|The height above mean sea level of the antenna.|
|`speed`|false|double|m/s|Speed at which the antenna is moving.|
|`bearing`|false|double|degrees|Angle relative to true North.|

## 2 Captures
`ntia-emitter` does not provide additional keys to `Captures`.

## 3 Annotations
`ntia-emitter` defines the following segments that extend `ntia-core`.

### 3.1 EmitterAnnotation Segment
`EmitterAnnotation` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of an emitter defined in global.|
|`power`|false|double|dBm|Emitter power going into antenna.|
|`antenna`|false|[Antenna](#antenna-object) |N/A|See [ntia-antenna](#antenna-object) extension.|
|`waveform`|false| [Waveform](https://github.com/NTIA/sigmf-ns-waveform)|N/A|See [ntia-waveform extension](https://github.com/NTIA/sigmf-ns-waveform)
|`latitude`|false|double|decimal degrees|Latitude of emitter.|
|`longitude`|false|double|decimal degrees|Longitude of emitter.|
|`altitude`|false|double|meters|The height of the antenna above mean sea level.|
|`speed`|false|double|m/s|Speed at which the antenna is moving.|
|`bearing`|false|double|degrees|Angle relative to true North.|

## 5 Example
[TODO] Provide and example of `ntia-emitter`