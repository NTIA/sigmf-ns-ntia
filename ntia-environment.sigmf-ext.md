# ntia-environment extension v1.0.0
The ntia-environment extension provides SigMF metadata extensions to characterize the environment factors around a sensor and\or emitter. 

`ntia-environment` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-environment` does not provide additional keys to `Global`. 

## 2 Captures
`ntia-environment` does not provide additional keys to `Captures`.

## 3 Annotations
`ntia-environment` defines the following segments that extend `ntia-core`.

### 3.1 SensorEnvironment Segment
`SensorEnvironment` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temparature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the sensor (rain, snow...)|

### 3.2 EmitterEnvironment Segment
`EmitterEnvironment` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitter_id`|true|string|N/A|Unique emitter id|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temparature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the emitter (rain, snow...)|

## 4 Example
[TODO] Provide and example of `ntia-environment`
