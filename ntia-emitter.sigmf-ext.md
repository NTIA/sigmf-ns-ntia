# ntia-emitter Extension v1.0.0

The ntia-emitter namespace provides emitter defintion and properties. 

`ntia-emitter` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-emitter` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
`emitters`|false|[Emitter](#11-emitter-object)[]|N/A|Metadata that describe emitters

### 1.1 Emitter Object
`Emitter` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique ID of the emitter.|
|`description`|false|string|N/A|Description of the emitter.|
|`power`|false|double|dBm|Power referenced to antenna input.|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#antenna)|N/A|Metadata that describes the antenna.|
|`transmitter`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12hardwarespec-object)|N/A|Metadata that describes the transmitter.|
|`center_frequency`|false|double|Hz|Center frequency.|
|`waveform`|false| [Waveform](ntia-waveform.sigmf-ext.md)|N/A|Metadata that describes transmitted waveform.|
|`location`|false|[Location](ntia-location.sigmf-ext.md#16-location-object)|N/A|Specifies the location, speed, and bearing of the `Emitter`.|
|`environment`|false|[Environment](ntia-environment.sigmf-ext.md#11-environment-object)|N/A|Specifies the environment surrounding the `Emitter`.|


## 2 Captures
`ntia-emitter` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-emitter` does not extend [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).


## 4 Example

### 4.1  Example
```json
{
  "global" : {
    "ntia-emitter:emitters" : [ {
	"power" : 19,
	"center_frequency" : 435000000,
	"waveform" : {
		"description" : "Continuous Wave"
		},
    "antenna" : {
        "antenna_spec" : {
          "model" : "Cobham_OA2-0.3-10.0V/1505",
          "description" : "Ultra Wide Band Omni Antenna",
          "supplemental_information" : "https://www.european-antennas.co.uk/media/1638/ds1505-060510.pdf"
			},
        "type" : "Omni-directional",
        "frequency_low" : 3.0E8,
        "frequency_high" : 1.0E10,
        "gain" : 2.0,
        "polarization" : "Horizontal",
        "cross_polar_discrimination" : 20.0,
        "horizontal_beam_width" : 360.0,
        "vertical_beam_width" : 65.0,
        "voltage_standing_wave_ratio" : 2.5,
        "cable_loss" : 0.15,
        "steerable" : false
        },
    "transmitter" : {
        "model" : "N5182B",
        "version" : "v1.0.0",
        "description" : "Keysight MxG X-series RF Vector Signal Generator",
        "supplemental_information" : "https://www.keysight.com/us/en/assets/7018-03380/data-sheets/5991-0038.pdf"
        },
    "location" : {
        "x" : -79.980916,
        "y" : 40.304983,
        "z" : 310.0,
        "speed" : 0.0,
        "description" : "NIOSH mine, Pittsburgh PA"
        },
    "environment" : {
        "category" : "Underground, coal mine"
        }
    }]
  },
  "captures" : [ ],
  "annotations" : [ {
    "ntia-core:annotation_type" : "AntennaAnnotation",
    "ntia-core:azimuth_angle" : 0.0,
    "ntia-core:elevation_angle" : 90.0
  } ]
}
```



