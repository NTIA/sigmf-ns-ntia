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
|`measurement_type`|true|string|N/A|Method by which the signal analyzer acquires data: `"single-frequency"`or `"scan"`.|
|`time_start`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  began execution.|
|`time_stop`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  finished execution.|
|`frequency_tuned_low`|true|double|Hz|Lowest tuned frequency.|
|`frequency_tuned_high`|true|double|Hz|Highest tuned  frequency.|
|`frequency_tuned_step`|false|double|Hz|Step between tuned frequencies of a `"scan"` measurement. Either `frequency_tuned_step` or `frequencies_tuned` SHOULD be included for `"scan"` measurements.|
|`frequencies_tuned`|false|double[]|Hz|Array of tuned frequencies of a `"scan"` measurement. Either `frequency_tuned_step` or `frequencies_tuned` SHOULD be included for `"scan"` measurements.|
|`classification`|true|string|N/A|The classification markings for the acquisition, e.g., `UNCLASSIFIED`, `CONTROLLED//FEDCON`, `SECRET` ...|



## 1.2 Antenna Object
`Antenna` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`antenna_spec`|true| [HardwareSpec](#13-hardwarespec-object) |N/A|Metadata to describe antenna.|
|`type`|false|string|N/A|Antenna type. E.g. `"dipole"`, `"biconical"`, `"monopole"`, `"conical monopole"`.|
|`frequency_low`|false|double|Hz|Low frequency of operational range.|
|`frequency_high`|false|double|Hz|High frequency of operational range.|
|`polarization`|false|double|string|Antenna polarization. E.g. `"vertical"`, `"horizontal"`, `"slant-45"`, `"left-hand circular"`, `"right-hand circular"`.|
|`cross_polar_discrimination`|false|double|N/A|Cross-polarization discrimination.|
|`gain`|false|double|dBi|Antenna gain in direction of maximum radiation or reception.|
|`horizontal_gain_pattern`|false|double[]|dBi|Antenna gain pattern in horizontal plane from 0 to 359 degrees in 1 degree steps.|
|`vertical_gain_pattern`|false|double[]|dBi|Antenna gain pattern in vertical plane from -90 to +90 degrees in 1 degree steps.|
|`horizontal_beamwidth`|false|double|degrees|Horizontal 3 dB beamwidth.|
|`vertical_beamwidth`|false|double|degrees|Vertical 3 dB beamwidth.|
|`voltage_standing_wave_ratio`|false|double|volts|Voltage standing wave ratio.|
|`cable_loss`|false|double|dB|Cable loss for cable connecting antenna and preselector.|
|`steerable`|false|boolean|N/A|Defines whether the antenna is steerable.|
|`azimuth_angle`|false|double|degrees|Angle of main beam in azimuthal plane from North.|
|`elevation_angle`|false|double|degrees|Angle of main beam in elevation plane from horizontal.|

## 1.3 HardwareSpec Object
`HardwareSpec` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|false|string|N/A|Unique ID of hardware. E.g., serial number.|
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
|`annotation_type`|true|string|N/A|Annotation type, e.g. [`"CalibrationAnnotation"`](ntia-sensor.sigmf-ext.md#32-calibrationannotation-segment), [`"DigitalFilterAnnotation"`](ntia-algorithm.sigmf-ext.md#33-digitalfilterannotation-segment), [`"FrequencyDomainDetection"`](ntia-algorithm.sigmf-ext.md#32-frequencydomaindetection-segment), [`"SensorAnnotation"`](ntia-sensor.sigmf-ext.md#31-sensorannotation-segment), [`"TimeDomainDetection"`](ntia-algorithm.sigmf-ext.md#31-timedomaindetection-segment)|


## 4 Examples

### 4.1 Single-frequency Measurement Example
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
      "measurement_type" : "single-frequency",
      "classification" : "UNCLASSIFIED"
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
### 4.3 Scan Measurement Example
```json  
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:description" : "Radar data captured off the coast of San Francisco",
    "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-environment" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor" : {
      "id" : "192.168.1.53",
      "sensor_spec" : {
        "id" : "bh-5",
        "model" : "bassethound",
        "version" : "v1.0.0",
        "description" : ""
      },
      "antenna" : {
        "antenna_spec" : {
          "model" : "ARA BSB-26",
          "description" : "RF antenna ideally suited for reception of signals on the horizon for nautical and broadband surveillance applications"
        },
        "type" : "Omni-directional",
        "frequency_low" : 2.0E9,
        "frequency_high" : 6.0E9,
        "gain" : 0.0,
        "polarization" : "Slant",
        "cross_polar_discrimination" : 13.0,
        "horizontal_beamwidth" : 360.0,
        "vertical_beamwidth" : 68.38,
        "voltage_standing_wave_ratio" : 2.0,
        "cable_loss" : 0.79,
        "steerable" : false
      },
      "preselector" : {
        "cal_sources" : [ {
          "cal_source_spec" : {
            "id" : "37501",
            "model" : "Mercury Systems NS36B-1",
            "supplemental_information" : "https://www.everythingrf.com/products/noise-sources/mercury-systems/608-220-ns346b-1"
          },
          "type" : "Calibrated noise source",
          "enr" : "14.53 dB"
        } ],
        "filters" : [ {
          "filter_spec" : {
            "id" : "13FV40-00014, SN 6",
            "model" : "K&L 13FV40-3550/U200-o/o",
            "supplemental_information" : "http://www.klfilterwizard.com/klfwpart.aspx?FWS=1112001&PN=13FV40-3550%2fU200-O%2fO"
          },
          "frequency_low_passband" : 3.43E9,
          "frequency_high_passband" : 3.67E9,
          "frequency_low_stopband" : 3.39E9,
          "frequency_high_stopband" : 3.71E9
        }, { } ],
        "amplifiers" : [ {
          "amplifier_spec" : {
            "id" : "1904044",
            "model" : "MITEQ AFS3-02000400-30-25P-6",
            "supplemental_information" : "https://nardamiteq.com/docs/MITEQ_Amplifier-AFS.JS_c41.pdf"
          },
          "gain" : 32.85,
          "noise_figure" : 2.59,
          "max_power" : 13.0
        } ],
        "rf_paths" : [ {
          "name" : "Path 1",
          "cal_source_id" : "37501",
          "filter_id" : "13FV40-00014, SN 6",
          "amplifier_id" : "1904044"
        }, {
          "name" : "Bypass",
          "cal_source_id" : "37501"
        } ]
      },
      "signal_analyzer" : {
        "sigan_spec" : {
          "id" : "502725",
          "model" : "Keysight N6841A",
          "supplemental_information" : "https://www.keysight.com/us/en/assets/7018-02113/data-sheets/5990-3839.pdf"
        },
        "frequency_low" : 2.0E7,
        "frequency_high" : 6.0E9,
        "noise_figure" : 20.0,
        "max_power" : 20.0,
        "a2d_bits" : 14
      },
      "computer_spec" : {
        "id" : "MC 9",
        "description" : "Custom computer with Intel i7 processor, MSI motherboard, 16 GB of Ram and running Windows 7"
      },
      "location" : {
        "x" : -122.5309,
        "y" : 37.8204,
        "z" : 51.3522,
        "speed" : 0.0,
        "description" : "On a tower in Point Bonita, near San Francisco"
      },
      "environment" : {
        "category" : "Outside. Coastal."
      }
    },
    "ntia-location:coordinate_system" : {
      "coordinate_system_type" : "CoordinateSystem",
      "id" : "WGS_84",
      "elevation_ref" : "MSL",
      "elevation_unit" : "meter"
    },
    "ntia-sensor:calibration_datetime" : "2018-01-01T10:49:58.236Z",
    "ntia-core:measurement" : {
      "domain" : "Frequency",
      "measurement_type" : "Scan",
      "time_start" : "2018-01-01T07:59:42.792Z",
      "time_stop" : "2018-01-01T08:00:37.792Z",
      "frequency_tuned_low" : 3.45940625E9,
      "frequency_tuned_high" : 3.65190625E9,
      "frequency_tuned_step" : 1.925E7,
      "classification" : "UNCLASSIFIED"
    }
  },
  "captures" : [ {
    "core:sample_start" : 0,
    "core:frequency" : 3.5501875E9,
    "core:datetime" : "2018-01-01T07:59:42.792Z"
  } ],
  "annotations" : [ {
    "ntia-core:annotation_type" : "FrequencyDomainDetection",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
    "core:comment" : "",
    "ntia-algorithm:detector" : "fft_max_power",
    "ntia-algorithm:number_of_ffts" : 10,
    "ntia-algorithm:number_of_samples_in_fft" : 50,
    "ntia-algorithm:window" : "Gauss-top",
    "ntia-algorithm:equivalent_noise_bandwidth" : 962500.0,
    "ntia-algorithm:frequency_start" : 3.45021875E9,
    "ntia-algorithm:frequency_stop" : 3.65015625E9,
    "ntia-algorithm:frequency_step" : 437500.0
  }, {
    "ntia-core:annotation_type" : "CalibrationAnnotation",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
    "core:comment" : " Calibration is done every 6 hours.",
    "ntia-sensor:gain_preselector" : 27.241,
    "ntia-sensor:noise_figure_sensor" : 7.638,
    "ntia-sensor:enbw_sensor" : 962500.0000000001,
    "ntia-sensor:mean_noise_power_sensor" : -94.28774890829693,
    "ntia-sensor:temperature" : 14.611,
    "ntia-sensor:mean_noise_power_units" : "dBm"
  }, {
    "ntia-core:annotation_type" : "SensorAnnotation",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
    "ntia-sensor:rf_path_index" : 0,
    "ntia-sensor:overload" : false,
    "ntia-sensor:attenuation_setting_sigan" : 3.0
  }]
}
```
