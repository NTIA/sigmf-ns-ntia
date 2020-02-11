# ntia-algorithm Extension v1.0.0
The ntia-algorithm namespace describes algorithms applied to measurements. 

`ntia-algorithm` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-algorithm` extends [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs: 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`anti_aliasing_filter`|false|[DigitalFilter](#11-digitalfilter-object)|N/A|Digital filter applied to data to avoid aliasing|

### 1.1 DigitalFilter Object
`DigitalFilter` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_type`|false|string|N/A|Description of digital filter, e.g., `"FIR"`, `"IIR"`|
|`FIR_coefficients`|false|double[]|N/A|Coefficients that defines FIR filter.|
|`IIR_numerator_coefficients`|false|double[]|N/A|Coefficients that defines IIR filter.|
|`IIR_denominator_coefficients`|false|double[]|N/A|Coefficients that defines IIR filter.|
|`attenuation_cutoff`|false|double|dB|Attenuation that specifies the `cutoff_frequency` (typically 3 dB).|
|`frequency_cutoff`|false|double|Hz|Frequency that characterizes boundary between passband and stopband.|
|`ripple_passband`|false|double|dB|Ripple in passband.|
|`attenuation_stopband`|false|double|dB|Attenuation of stopband.|
|`frequency_stopband`|false|double|Hz|Point in filter frequency response where stopband starts.|

## 2 Captures
`ntia-algorithm` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-algorithm` defines the following segments that extend `ntia-core`.

### 3.1 TimeDomainDetection Segment
Time-domain detection algorithms are applied to gap-free IQ time series captured at a single frequency. The `TimeDomainDetection` has the following properties:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|E.g. `"sample_power"`, `"mean_power"`, `"max_power"`, `"min_power"`, `"median_power"`, `"m4s_power"`.|
|`number_of_samples`|true|integer|N/A|Number of samples to be integrated over by detector.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

### 3.2 FrequencyDomainDetection Segment
Frequency-domain detection algorithms are applied to discrete Fourier transforms of gap-free IQ time series. The IQ time series can be measured at a single center frequency, a set of center frequencies, or a scan of center frequencies. Scans result in frequency-domain data with a constant frequency step for a span greater than the bandwidth of the signal analyzer, similar to the traditional spectrum analyzer swept-tuned measurement. 

The `FrequencyDomainDetection` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|E.g. `"fft_sample_iq"`, `"fft_sample_power"`, `"fft_mean_power"`, `"fft_max_power"`, `"fft_min_power"`, `"fft_median_power"`.|
|`number_of_ffts`|true|integer|N/A|Number of FFTs to be integrated over by detector.|
|`number_of_samples_in_fft`|true|integer|N/A|Number of samples in FFT to calcluate delta_f = [`samplerate`](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object)/`number_of_samples_in_fft`.|
|`window`|true|string|N/A|E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.|
|`equivalent_noise_bandwidth`|false|double|Hz|Bandwidth of brickwall filter that has same integrated noise power as that of the actual filter.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|
|`frequency_start`|false|double|Hertz|Frequency of first data point.|
|`frequency_stop`|false|double|Hertz|Frequency of last data point.|
|`frequency_step`|false|double|Hertz|Frequency step between data points.|
|`frequencies`|false|double[]|Hertz|An array of the frequencies of the data points.|



### 3.3 DigitalFilterAnnotation Segment
`DigitalFilterAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_type`|false|string|N/A|Description of digital filter, e.g., `"FIR"`, `"IIR"`|
|`FIR_coefficients`|false|double[]|N/A|Coefficients that defines FIR filter.|
|`IIR_numerator_coefficients`|false|double[]|N/A|Coefficients that defines FIR filter.|
|`IIR_denominator_coefficients`|false|double[]|N/A|Coefficients that defines FIR filter.|
|`attenuation_cutoff`|false|double|dB|Attenuation that specifies the `frequency_cutoff` (typically 3 dB).|
|`frequency_cutoff`|false|double|Hz|Frequency that characterizes boundary between passband and stopband.|
|`ripple_passband`|false|double|dB|Ripple in passband.|
|`attenuation_stopband`|false|double|dB|Attenuation of stopband.|
|`frequency_stopband`|false|double|Hz|Point in filter frequency response where stopband starts.|

## 4 Example

### 4.1 anti_aliasing_filter example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "core:version": "0.0.2",
    "ntia-algorithm:anti_aliasing_filter": {
      "filter_type": "FIR",
      "FIR_coefficients": [
        1.0,
        4.0,
        5.0,
        3.2
      ],
      "cutoff_attenuation": -3,
      "cutoff_frequency": 7500000,
      "ripple_passband": -5,
      "attenuation_stopband": -10,
      "frequency_stopband": 7000000
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

### 4.2 TimeDomainDetection Annotation Example
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
      "ntia-core:annotation_type": "TimeDomainDetection",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "mean",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:reference": "antenna output",
      "ntia-algorithm:number_of_samples": 1024
    }
  ]
}
```

### 4.3 FrequencyDomainDetection Annotation Example
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
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_mean_power",
      "ntia-algorithm:reference": "antenna output",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024
    },
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 1024,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_max_power",
      "ntia-algorithm:reference": "antenna output",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024
    }
  ]
}
```

### 4.4  Scan FrequencyDomainDetection Example
```json  
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:description" : "Radar data captured off the coast of San Diego",
    "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-environment" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor" : {
      "id" : "192.168.1.13",
      "sensor_spec" : {
        "id" : "Radar_Sensor_1",
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
        "polarization" : "slant",
        "cross_polar_discrimination" : 13.0,
        "horizontal_beam_width" : 360.0,
        "vertical_beam_width" : 68.38,
        "voltage_standing_wave_ratio" : 2.0,
        "cable_loss" : 0.62,
        "steerable" : false
      },
      "preselector" : {
        "cal_sources" : [ {
          "cal_source_spec" : {
            "id" : "MY53400510",
            "model" : "Keysight 346B",
            "supplemental_information" : "https://www.keysight.com/en/pd-1000001299%3Aepsg%3Apro-pn-346B/noise-source-10-mhz-to-18-ghz-nominal-enr-15-db?cc=US&lc=eng"
          },
          "type" : "Calibrated noise source",
          "enr" : "14.6 dB"
        } ],
        "filters" : [ {
          "filter_spec" : {
            "id" : "13FV40-00014, SN 7",
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
          "cal_source_id" : "MY53400510",
          "filter_id" : "13FV40-00014, SN 7",
          "amplifier_id" : "1904043"
        }]
      },
      "signal_analyzer" : {
        "sigan_spec" : {
          "id" : "US54230178",
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
        "id" : "MC 5",
        "description" : "Custom computer with Intel i7 processor, MSI motherboard, 16 GB of Ram and running Windows 7"
      },
      "location" : {
        "x" : -117.24711,
        "y" : 32.68927,
        "z" : 119.8,
        "speed" : 0.0
      },
      "environment" : {
        "category" : "Outside. Coastal, San Diego"
      }
    },
    "ntia-location:coordinate_system" : {
      "coordinate_system_type" : "CoordinateSystem",
      "id" : "WGS_84",
      "elevation_ref" : "MSL",
      "elevation_unit" : "meter"
    },
    "ntia-sensor:calibration_datetime" : "2018-01-01T11:12:13.073Z",
    "ntia-core:measurement" : {
      "domain" : "Frequency",
      "measurement_type" : "Scan",
      "time_start" : "2018-01-01T07:59:30.442Z",
      "time_stop" : "2018-01-01T08:00:25.442Z",
      "frequency_tuned_low" : 3.45021875E9,
      "frequency_tuned_high" : 3.65015625E9,
      "frequency_tuned_step" : 2.1875E7
    }
  },
  "captures" : [ {
    "core:sample_start" : 1,
    "core:frequency" : 3.5501875E9,
    "core:datetime" : "2018-01-01T07:59:30.442Z"
  } ],
  "annotations" : [ {
    "ntia-core:annotation_type" : "FrequencyDomainDetection",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
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
    "ntia-sensor:gain_preselector" : 26.128,
    "ntia-sensor:noise_figure_sensor" : 8.399,
    "ntia-sensor:enbw_sensor" : 962500.0000000001,
    "ntia-sensor:mean_noise_power_sensor" : -93.70812445414842,
    "ntia-sensor:temperature" : 15.333,
    "ntia-sensor:mean_noise_power_units" : "dBm"
  }, {
    "ntia-core:annotation_type" : "SensorAnnotation",
    "core:sample_start" : 0,
    "core:sample_count" : 458,
    "ntia-sensor:rf_path_index" : 1,
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


### 4.5  DigitalFilterAnnotation  Example
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
      "ntia-core:annotation_type": "DigitalFilterAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1000,
      "ntia-algorithm:filter_type": "FIR",
      "ntia-algorithm:FIR_coefficients": [
        1.0,
        4.0,
        5.0,
        3.2
      ],
      "cutoff_attenuation": -3,
      "cutoff_frequency": 7500000,
      "ntia-algorithm:ripple_passband": -5,
      "ntia-algorithm:attenuation_stopband": -10,
      "ntia-algorithm:frequency_stopband": 7000000
    }
  ]
}
```
