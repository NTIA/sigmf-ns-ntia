# ntia-core Extension v1.0.0

The `ntia-core` namespace adds generally useful metadata fields. 

`ntia-core` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-core` defines an `Antenna` object that is referenced through other global extensions ([ntia-sensor](ntia-sensor.sigmf-ext.md), [ntia-emitter](ntia-emitter.sigmf-ext.md)) and extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`measurement`|false|[Measurement](#11-measurement-object)|N/A|Summarizes the basic information of the measurement. This object SHOULD be included for any measurement.|. ntia-core 


### 1.1 Measurement Object
The Measurement object summarizes the basic measurement information including  when the measurement was conducted, the frequency range, the domain of the sensed data and the type of measurement that was conducted.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`domain`|true|string|N/A| `"time"` or  `"frequency"`|
|`measurement_type`|true|string|N/A|Method that signal analyzer acquires data: `"single-frequency"`or `"scan"`.|
|`time_start`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  began execution.|
|`time_stop`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  finished execution.|
|`frequency_tuned_low`|true|double|Hz|Lowest tuned frequency.|
|`frequency_tuned_high`|true|double|Hz|Highest tuned  frequency.|
|`frequency_tuned_step`|false|double|Hz|Step between tuned frequencies of a `"scan"` measurement. Either `frequency_tuned_step` or `frequencies_tuned` SHOULD be included for `"scan"` measurements.|
|`frequencies_tuned`|false|double[]|Hz|Array of tuned frequencies of a `"scan"` measurement. Either `frequency_tuned_step` or `frequencies_tuned` SHOULD be included for `"scan"` measurements.|


## 1.2 Antenna Object
`Antenna` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`antenna_spec`|true| [HardwareSpec](#12-hardwarespec-object) |N/A|Metadata to describe antenna.|
|`type`|false|string|N/A|Antenna type. E.g. `"dipole"`, `"biconical"`, `"monopole"`, `"conical monopole"`.|
|`frequency_low`|false|double|Hz|Low frequency of operational range.|
|`frequency_high`|false|double|Hz|High frequency of operational range.|
|`polarization`|false|double|string|Antenna polarization. E.g. `"vertical"`, `"horizontal"`, `"slant-45"`, `"left-hand circular"`, `"right-hand circular"`.|
|`cross_polar_discrimination`|false|double|N/A|Cross-polarization discrimination.|
|`gain`|false|double|dBi|Antenna gain in direction of maximum radiation or reception.|
|`horizontal_gain_pattern`|false|double[]|dBi|Antenna gain pattern in horizontal plane from 0 to 359 degrees in 1 degree steps.|
|`vertical_gain_pattern`|false|double[]|dBi|Antenna gain pattern in vertical plane from -90 to +90 degrees in 1 degree steps.|
|`horizontal_beam_width`|false|double|degrees|Horizontal 3-dB beamwidth.|
|`vertical_beam_width`|false|double|degrees|Vertical 3-dB beamwidth.|
|`voltage_standing_wave_ratio`|false|double|volts|Voltage standing wave ratio.|
|`cable_loss`|false|double|dB|Cable loss for cable connecting antenna and preselector.|
|`steerable`|false|boolean|N/A|Defines if the antenna is steerable. If steerable, then `azimuth_angle` and `elevation_angle` are specified in annotation segment.|

## 1.2 HardwareSpec Object
`HardwareSpec` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|false|string|N/A|Unique id of hardware. E.g., serial number.|
|`model`|false|string|N/A|Hardware make and model.|
|`version`|false|string|N/A|Hardware version.|
|`description`|false|string|N/A|Description of the hardware.|
|`supplemental_information`|false|string|N/A|Information about hardware, e.g., url to on-line data sheets.|

## 2 Captures
`ntia-core` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-core` extends [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array) with segments of different types defined throughout the set of NTIA extensions to the core SigMF specification. `annotation_type` is defined with the following name/value pair:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`annotation_type`|true|string|N/A|Annotation type, e.g. [`"AntennaAnnotation"`](#31-antennaannotation-segment),[`"CalibrationAnnotation"`](ntia-calibration.sigmf-ext.md#31-calibrationannotation-segment), [`"DigitalFilterAnnotation"`](ntia-algorithm.sigmf-ext.md#33-digitalfilterannotation-segment), [`"EmitterAnnotation"`](ntia-emitter.sigmf-ext.md#31-emitterannotation-segment), [`"FrequencyDomainDetection"`](ntia-algorithm.sigmf-ext.md#32-frequencydomaindetection-segment), [`"SensorAnnotation"`](ntia-sensor.sigmf-ext.md#31-sensorannotation-segment), [`"TimeDomainDetection"`](ntia-algorithm.sigmf-ext.md#31-timedomaindetection-segment)|

The following segments are of general use across the set of NTIA extensions. 

### 3.1 AntennaAnnotation Segment
`AntennaAnnotation` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of an antenna defined in global.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|

## 4 Examples

### 4.1 Measurement Example
```json
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:extensions" : {
      "ntia-core" : "v1.0.0",
    },
    "ntia-core:measurement" : {
      "time_start" : "2018-03-01T14:01:00.000874Z",
      "time_stop" : "2018-03-01T14:01:00.000904Z",
      "frequency_tuned_low" : 3.45021875E9,
      "frequency_tuned_high" : 3.45021875E9,
      "domain" : "frequency",
      "measurement_type" : "single-frequency"
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
### 4.2 Antenna Global Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor" : {
      "id" : "Radar_Sensor_1",
      "antenna" : {
        "antenna_spec" : {
          "model" : "ARA BSB-26",
          "description" : "RF antenna ideally suited for reception of signals on the horizon for nautical and broadband surveillance applications"
        },
        "type" : "omni-directional",
        "frequency_low" : 2.0E9,
        "frequency_high" : 6.0E9,
        "gain" : 0.0,
        "polarization" : "slant",
        "cross_polar_discrimination" : 13.0,
        "horizontal_beam_width" : 360.0,
        "vertical_beam_width" : 68.38,
        "voltage_standing_wave_ratio" : 2.0,
        "cable_loss" : 0.62,
        "steerable" : false
      },
      "preselector" : {
        "cal_source" : {
          "cal_source_spec" : {
            "id" : "MY53400510",
            "model" : "Keysight 346B",
            "supplemental_information" : "https://www.keysight.com/en/pd-1000001299%3Aepsg%3Apro-pn-346B/noise-source-10-mhz-to-18-ghz-nominal-enr-15-db?cc=US&lc=eng"
          }
        },
        "filters" : [ {
          "filter_spec" : {
            "id" : "13FV40-00014",
            "model" : "K&L 13FV40-3550/U200-o/o",
            "supplemental_information" : "http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO"
          },
          "frequency_low_passband" : 3.43E9,
          "frequency_high_passband" : 3.67E9,
          "frequency_low_stopband" : 3.39E9,
          "frequency_high_stopband" : 3.71E9
        } ],
        "amplifiers" : [ {
          "amplifier_spec" : {
            "id" : "1904043",
            "model" : "MITEQ AFS3-02000400-30-25P-6",
            "supplemental_information" : "https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf"
          },
          "gain" : 30.61,
          "noise_figure" : 2.76,
          "max_power" : 13.0
        } ],
        "rf_paths" : [ {
          "cal_source_id" : "Calibrated noise source",
          "filter_id" : "13FV40-00014",
          "amplifier_id" : "1904043"
        } ]
      }
      ...
  },
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
```
### 4.3 AntennaAnnotation Example
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
      "ntia-core:annotation_type": "AntennaAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "elevation_angle": 25.0, 
      "azimuth_angle": 70.0

    }
  ]
}
```
