# ntia-sensor extension v1.0.0
The ntia-sensor namespace provides metadata to describe RF sensors. 

`ntia-sensor` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-sensor` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#12-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. RECOMMENDED.|


### 1.2 Sensor Object
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
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor" : {
      "id" : "Radar_Sensor_1",
      "antenna" : {
        "antenna_spec" : {
          "id" : "antenna_1",
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
    },
    ...
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type" : "SensorAnnotation",
      "ntia-sensor:rf_path_index" : 0,
      "ntia-sensor:overload" : false,
      "ntia-sensor:attenuation_setting_sigan" : 6.0,
      "core:sample_start":0,
      "core:sample_count": 1000
    },
    {
      "ntia-core:annotation_type": "CalibrationAnnotation",
      "ntia-sensor:gain_sigan": 41.464266174671376,
      "ntia-sensor:noise_figure_sigan": 10.59849353429361,
      "ntia-sensor:enbw_sigan": 9173161.088949349,
      "ntia-sensor:gain_sensor": 39.974129616887843,
      "ntia-sensor:noise_figure_sensor": 12.66185043866723,
      "ntia-sensor:enbw_sensor": 7767553.942299673,
      "ntia-sensor:mean_noise_power_sensor": -161.338149561,
      "core:sample_start":0,
      "core:sample_count": 1000
    }
  ]
}
```


