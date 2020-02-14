# ntia-sensor extension v1.0.0
The ntia-sensor namespace provides metadata to describe RF sensors. 

`ntia-sensor` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-sensor` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#12-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. RECOMMENDED.|


### 1.1 Sensor Object
Sensor definition follows a simplified hardware model comprised of the following elements: Antenna, Preselector, Signal Analyzer, and Host Controller. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The signal analyzer (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

`Sensor` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique logical id for the sensor.|
|`sensor_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe/specify the sensor.|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#12-antenna-object)|N/A|Metadata to describe/specify the antenna.|
|`preselector`|false| [Preselector](#13-preselector-object)|N/A|Metadata to describe/specify the preselector.|
|`signal_analyzer`|false| [SignalAnalyzer](#12-signalanalyzer-object) |N/A|Metadata to describe/specify the signal analyzer.|
|`computer_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe/specify onboard computer.|
|`mobile`|false|boolean|N/A|Defines if the sensor is mobile.|
|`location`|false|[Location](ntia-location.sigmf-ext.md#16-location-object)|N/A|Specifies the location, speed, and bearing of the `Sensor`.|
|`environment`|false|[Environment](ntia-environment.sigmf-ext.md#11-environment-object)|N/A|Specifies the environment surrounding the `Sensor`.|

### 1.2 SignalAnalyzer Object
`SignalAnalyzer` the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sigan_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe/specify the signal analyzer.|
|`frequency_low`|false|double|Hz|Low frequency of operational range of the signal analyzer.|
|`frequency_high`|false|double|Hz|High frequency of operational range of the signal analyzer.|
|`noise_figure`|false|double|dB|Noise figure of the signal analyzer.|
|`max_power`|false|double|dBm|Maximum input power of the signal analyzer.|
|`a2d_bits`|false|integer|bits|Number of bits in A/D converter.|

### 1.3 Preselector Object
`Preselector` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`preselector_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe/specify the preselector.|
|`cal_sources`|false|[CalSource[]](#14-calsource-object)|N/A|Metadata to describe/specify the preselector calibration source.|
|`amplifiers`|false|[Amplifier[]](#12-amplifier-object)|N/A|Metadata to describe/specify the preselector low noise amplifiers.|
|`filters`|false|[Filter[]](#12-hardwarespec-object)|N/A|Metadata to describe the preselector RF filters.|
|`rf_paths`|false|[RFPath[]](#17-rfpath-object)|N/A|Metadata that describes preselector RF paths.|

### 1.4 CalSource Object
`CalSource` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`cal_source_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe the calibration source specification.|
|`type`|false|string|N/A|Type of the calibration source.|
|`enr`|false|double|dB|Excess noise ratio.|


### 1.5 Amplifier Object
`Amplifier` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`amplifier_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe the amplifier specification.|
|`gain`|false|double|dB|Gain of low noise amplifier.|
|`noise_figure`|false|double|dB|Noise figure of low noise amplifier.|
|`max_power`|false|double|dB|Maximum power of the low noise amplifier.|



### 1.6 Filter Object
`Filter` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#12-hardwarespec-object)|N/A|Metadata to describe/specify the filter specification.|
|`frequency_low_passband`|false|double|Hz|Low frequency of filter 1-dB passband.|
|`frequency_high_passband`|false|double|Hz|High frequency of filter 1-dB passband.|
|`frequency_low_stopband`|false|double|Hz|Low frequency of filter 60-dB stopband.|
|`frequency_high_stopband`|false|double|Hz|High frequency of filter 60-dB stopband.|



### 1.7 RFPath Object
`RFPath` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|false|string|N/A|Descriptive name for the RFPath.|
|`cal_source_id`|true|string|N/A|Id of the calibration source.|
|`filter_id`|true|string|N/A|Id of the filter.|
|`amplifier_id`|true|string|N/A|Id of the amplifier.|


## 2 Captures

`ntia-sensor` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).


## 3 Annotations
`ntia-sensor` defines the following segments that extend `ntia-core`.

### 3.1 SensorAnnotation Segment
`SensorAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_path_index`|false|integer|N/A|Index of the [RFPath](#14-rfpath-object) object.|
|`overload`|false|boolean|N/A|Indicator of sensor overload.|
|`attenuation_setting_sigan`|false|double|dB|Attenuation setting of the signal analyzer.|
|`gain_setting_sigan`|false|double|dB|Gain setting of the signal analyzer.|
|`gps_nmea`|false|string|NMEA|[NMEA message](https://en.wikipedia.org/wiki/NMEA_0183) from gps receiver.|

### 3.2 CalibrationAnnotation Segment
`CalibrationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`gain_sigan`|false|double|N/A|Gain of signal analyzer (may differ with signal analyzer gain setting).|
|`noise_figure_sigan`|false|double|dB|Noise figure of signal analyzer.|
|`1db_compression_point_sigan`|false|double|dBm|Maximum input of signal analyzer.|
|`enbw_sigan`|false|double|Hz|Equivalent noise bandwidth of signal analyzer.|
|`gain_preselector`|false|double|dB|Gain of sensor preselector.|
|`noise_figure_sensor`|false|double|dB|Noise figure of sensor.|
|`1db_compression_point_sensor`|false|double|dBm|Maximum input of sensor.|
|`enbw_sensor`|false|double|Hz|Equivalent noise bandwidth of sensor.|
|`mean_noise_power_sensor`|false|double|Defined in `mean_noise_power_units`|Mean noise power density of sensor.|
|`mean_noise_power_units`|false|string|N/A|The units of the mean_noise_power|
|`temperature`|false|double|celsius|The temperature during calibration.|


## 4 Example

### 4.1 Sensor Global Object and Annotations 
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
        "id" : "BH-5",
        "model" : "Basset hound",
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
        "horizontal_beam_width" : 360.0,
        "vertical_beam_width" : 68.38,
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
      "frequency_tuned_low" : 3.45021875E9,
      "frequency_tuned_high" : 3.65015625E9,
      "frequency_tuned_step" : 2.1875E7
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
  }, {
    "ntia-core:annotation_type" : "AntennaAnnotation",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
    "ntia-core:azimuth_angle" : 90.0,
    "ntia-core:elevation_angle" : 0.0
  } ]
}
```


