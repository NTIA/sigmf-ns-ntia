# ntia-environment extension v1.0.0
The `ntia-environment` extension provides SigMF metadata extensions to characterize the environment factors around a sensor and\or emitter. 

`ntia-environment` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-environment` does not provide additional keys to [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object). 

## 2 Captures
`ntia-environment` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-environment` defines the following segments that extend `ntia-core`.

### 3.1 SensorEnvironment Segment
`SensorEnvironment` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temperature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the sensor. E.g. `"rain"`, `"snow"`.)|

### 3.2 EmitterEnvironment Segment
`EmitterEnvironment` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitter_id`|true|string|N/A|Unique emitter id|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temparature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the sensor. E.g. `"rain"`, `"snow"`.)|

## 4 Example

### 4.1 SensorEnvironment Example

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
      "ntia-core:annotation_type": "SensorEnvironment",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-environment:category": "indoor"
    },
    {
      "ntia-core:annotation_type": "SensorEnvironment",
      "core:sample_start": 1024,
      "core:sample_count": 1024,
      "ntia-environment:category": "outdoor"
    }
  ]
}
```

### 4.1 EmitterEnvironment Example

```json

  "global": {
	...
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "EmitterEnvironment",
      "core:sample_count": 0,
      "ntia-environment:category": "outdoor-urban",
      "ntia-environment:emitter_id": "emitter_123"
    },
    {
      "ntia-core:annotation_type": "EmitterEnvironment",
      "core:sample_start": 1024,
      "core:sample_count": 1024,
      "ntia-environment:category": "indoor",
      "ntia-environment:emitter_id": "emitter_123"
    }
  ]
}
```
