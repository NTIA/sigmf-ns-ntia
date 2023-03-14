# The `ntia-sensor` SigMF Extension Namespace v2.0.0

This document defines the `ntia-sensor` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace provides metadata to describe the attributes of a radio frequency (RF) sensor.

## 0 Datatypes

This extension defines the following datatypes:

|name|long-form name|description|
|----|--------------|-----------|
|`Sensor`|RF sensor| JSON [`Sensor`](#01-the-sensor-object) object containing metadata describing the RF sensor|
|`SignalAnalyzer`|signal analyzer|JSON [`SignalAnalyzer`](#02-the-signalanalyzer-object) object containing metadata describing a signal analyzer|
|`Preselector`|preselector|JSON [`Preselector`](#03-the-preselector-object) object containing metadata describing a preselector|
|`CalSource`|calibration source|JSON [`CalSource`](#04-the-calsource-object) object containing metadata describing a calibration source|
|`Amplifier`|low-noise amplifier|JSON [`Amplifier`](#05-the-amplifier-object) object containing metadata describing a low-noise amplifier (LNA)|
|`Filter`|filter|JSON [`Filter`](#06-the-filter-object) object containing metadata describing a hardware RF filter|
|`RFPath`|RF path|JSON [`RFPath`](#07-the-rfpath-object) object which identifies a combination of a calibration source, filter, and amplifier which comprise a single RF path in a sensor|

### 0.1 The `Sensor` Object

Sensor definition follows a simplified hardware model composed of the following elements: antenna, preselector, signal analyzer, and computer. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The signal analyzer (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`id`|true|string|N/A|Unique logical ID for the sensor|
|`sensor_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe/specify the sensor|
|`antenna`|false|[Antenna](ntia-core.sigmf-ext.md#12-antenna-object)|N/A|Metadata to describe/specify the antenna|
|`preselector`|false|[Preselector](#03-the-preselector-object)|N/A|Metadata to describe/specify the preselector|
|`signal_analyzer`|false|[SignalAnalyzer](#02-the-signalanalyzer-object) |N/A|Metadata to describe/specify the signal analyzer|
|`computer_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe/specify the onboard computer|
|`mobile`|false|boolean|N/A|Defines whether the sensor is mobile|
|`environment`|false|[Environment](ntia-environment.sigmf-ext.md#11-environment-object)|N/A|Specifies the environment surrounding the sensor`|

### 0.2 The `SignalAnalyzer` Object

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`sigan_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe/specify the signal analyzer|
|`frequency_low`|false|double|Hz|Low frequency of operational range of the signal analyzer|
|`frequency_high`|false|double|Hz|High frequency of operational range of the signal analyzer|
|`noise_figure`|false|double|dB|Noise figure of the signal analyzer|
|`max_power`|false|double|dBm|Maximum input power of the signal analyzer|
|`a2d_bits`|false|integer|bits|Number of bits in A/D converter|

### 0.3 The `Preselector` Object

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`preselector_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe/specify the preselector|
|`cal_sources`|false|[CalSource[]](#04-the-calsource-object)|N/A|Metadata to describe/specify the preselector calibration source(s)|
|`amplifiers`|false|[Amplifier[]](#05-the-amplifier-object)|N/A|Metadata to describe/specify the preselector low-noise amplifier(s)|
|`filters`|false|[Filter[]](#06-the-filter-object)|N/A|Metadata to describe the preselector RF filter(s)|
|`rf_paths`|false|[RFPath[]](#07-the-rfpath-object)|N/A|Metadata to describe the preselector RF path(s)|

### 0.4 The `CalSource` Object

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`cal_source_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe the calibration source specification|
|`type`|false|string|N/A|Type of the calibration source|
|`enr`|false|double|dB|Excess noise ratio|

### 0.5 The `Amplifier` Object

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`amplifier_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe the low-noise amplifier specification|
|`gain`|false|double|dB|Gain of the low-noise amplifier|
|`noise_figure`|false|double|dB|Noise figure of the low-noise amplifier|
|`max_power`|false|double|dB|Maximum power of the low-noise amplifier|

### 0.6 The `Filter` Object

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`filter_spec`|false|[HardwareSpec](ntia-core.sigmf-ext.md#13-hardwarespec-object)|N/A|Metadata to describe/specify the filter specification|
|`frequency_low_passband`|false|double|Hz|Low frequency of filter 1 dB passband|
|`frequency_high_passband`|false|double|Hz|High frequency of filter 1 dB passband|
|`frequency_low_stopband`|false|double|Hz|Low frequency of filter 60 dB stopband|
|`frequency_high_stopband`|false|double|Hz|High frequency of filter 60 dB stopband|

### 0.7 The `RFPath` Object

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|false|string|N/A|Descriptive name for the RF path|
|`cal_source_id`|false|string|N/A|ID of the calibration source.|
|`filter_id`|false|string|N/A|ID of the filter|
|`amplifier_id`|false|string|N/A|ID of the amplifier|

## 1 Global

The `ntia-sensor` extension adds the following fields to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`sensor`|false|[Sensor](#01-the-sensor-object)|N/A|Describes the sensor model components. RECOMMENDED.|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. RECOMMENDED.|

## 2 Captures

The `ntia-sensor` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-sensor` extension defines the following segments that extend `ntia-core`.

### 3.1 SensorAnnotation Segment

`SensorAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------|----|----|-----------|
|`rf_path_index`|false|integer|N/A|Index of the [RFPath](#07-the-rfpath-object) object.|
|`overload`|false|boolean|N/A|Indicator of sensor overload.|
|`attenuation_setting_sigan`|false|double|dB|Attenuation setting of the signal analyzer.|
|`gain_setting_sigan`|false|double|dB|Gain setting of the signal analyzer.|
|`gps_nmea`|false|string|NMEA|[NMEA message](https://en.wikipedia.org/wiki/NMEA_0183) from GPS receiver.|

### 3.2 CalibrationAnnotation Segment

`CalibrationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------|----|----|-----------|
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
|`mean_noise_power_reference`|false|string|N/A| Reference source for the mean_noise_power, e.g., `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`|
|`temperature`|false|double|celsius|The temperature during calibration.|

## 4 Collection

The `ntia-sensor` extension does not extend the `collection` SigMF object.

## 5 Examples

Here is an example showing the use of `ntia-sensor` to document a sensor specification in the `global` object:

### 5.1 Sensor Global Object and Annotations

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
      "environment" : {
        "category" : "Outside. Coastal."
      }
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
  } ]
}
```
