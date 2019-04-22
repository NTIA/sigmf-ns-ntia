# ntia-emitter Extension v1.0.0

The ntia-emitter namespace provides emiter defintion and properties. 

`ntia-emitter` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-emitter` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
emitter|false|[Emitter](#11-emitter-object)|N/A|Metadata that describes emitter

### 1.1 Emitter Object
`Emitter` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of the emitter.|
|`description`|false|string|N/A|Description of the emitter.|
|`power`|false|double|dBm|Power referenced to antenna input.|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#antenna)|N/A|Metadata that describes the emitter's antenna|
|`waveform`|false| [Waveform](ntia-waveform.sigmf-ext.md)|N/A|Metadata that describes transmitted waveform.
|`latitude`|false|double|decimal degrees|Latitude.|
|`longitude`|false|double|decimal degrees|Longitude.|
|`altitude`|false|double|meters|Height above mean sea level.|
|`speed`|false|double|m/s|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to true North).|

## 2 Captures
`ntia-emitter` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-emitter` defines the following segments that extend `ntia-core`.

### 3.1 EmitterAnnotation Segment
`EmitterAnnotation` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of the emitter.|
|`power`|false|double|dBm|Power referenced to antenna input.|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#antenna)|N/A|Metadata that describes the emitter's antenna|
|`waveform`|false| [Waveform](ntia-waveform.sigmf-ext.md)|N/A|Metadata that describes transmitted waveform.
|`latitude`|false|double|decimal degrees|Latitude.|
|`longitude`|false|double|decimal degrees|Longitude.|
|`altitude`|false|double|meters|Height above mean sea level.|
|`speed`|false|double|m/s|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to true North).|

## 5 Example

### 5.1 Emitter Global Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-emitter:emitters": [
      {
        "id": "EmitterXYZ",
        "description": "A fictitious emitter to demonstrate the extensions format.",
        "power": -60
      }
    ]

  },
  "captures": [
    ...
  ],
  "annotations": [
    ...
  ]
}
```

### 5.2 EmitterAnnotation Example
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
      "ntia-core:annotation_type": "EmitterAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "core:latitude": 40.5,
      "core:longitude": -105.7,
      "ntia-emitter:id": "emiter_1"
    },
    {
      "ntia-core:annotation_type": "EmitterAnnotation",
      "core:sample_start": 1024,
      "core:sample_count": 1024,
      "core:latitude": 41.5,
      "core:longitude": -105.3,
      "ntia-emitter:id": "emiter_1"
    }
  ]
}

}
```