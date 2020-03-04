# ntia-environment extension v1.0.0
The `ntia-environment` extension provides SigMF metadata extensions to characterize the environment factors around a sensor and\or emitter. 

`ntia-environment` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-environment` does not provide additional keys to [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object), but defines the [Environment](#11-environment-object) object that is referenced from [Sensor](ntia-sensor.sigmf-ext.md#12sensor-object) and [Emitter](ntia-emitter.sigmf-ext.md#11-emitter-object). 

### 1.1 Environment Object
`Environment` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`category`|false|string|N/A|Categorical description of the environment where sensor is mounted. E.g. `"indoor"`, `"outdoor-urban"`, `"outdoor-rural"`.|
|`temperature`|false|float|celsius|Environmental temperature.|
|`humidity`|false|float|%|Relative humidity.|
|`weather`|false|string|N/A|Weather around the sensor. E.g. `"rain"`, `"snow"`.)|
|`description`|false|string|N/A|A description of the environment.|


## 2 Captures
`ntia-environment` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-environment` does not extend [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).


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
