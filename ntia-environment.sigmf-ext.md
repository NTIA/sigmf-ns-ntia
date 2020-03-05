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

### 4.1 Environment Example

```json
{
  "global": {
    "core:datatype": "cf32_le",
    "core:sample_rate": 1.5360000011967678E7,
    "core:version": "0.0.2",
    "core:sha512": "5b522660c1406db41a7c05c564b902fa658de8755eaf77a35fea635ff97fd1293fe9e8b799c7ffca70d22cff8fa97cef0633ef29a08bdbc1b629165db72f81e3",
     "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor": {
      "id": "greyhound8.sms.internal",
      "sensor_spec": {
        "model": "greyhound"
      },
      "antenna": {
        "antenna_spec": {
          "model": "L-com HG3512UP-NF"
        }
      },
      "signal_analyzer": {
        "sigan_spec": {
          "model": "Ettus USRP B210"
        },
        "a2d_bits": 0
      },
      "computer_spec": {
        "model": "Intel NUC"
      },
      "location": {
        "x": -105.2715,
        "y": 40.0067
      },
      "environment":{
        "category": "outside",
        "description": "Mounted on a pole on top of the Fleming building at CU Boulder."
      }
    }
  },
  "captures": [
    ...
  ],
  "annotations": [
    ...
  ]
}
```


