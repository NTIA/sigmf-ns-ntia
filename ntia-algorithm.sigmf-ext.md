# The `ntia-algorithm` SigMF Extension Namespace v2.0.0

This document defines the `ntia-algorithm` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace contains objects which describe algorithms applied to measurements.

## 0 Datatypes

The `ntia-algorithm` extension defines the following datatypes:

| name             | long-form name                | description                                                                                         |
|------------------|-------------------------------|-----------------------------------------------------------------------------------------------------|
| `DigitalFilter`  | digital filter specification  | JSON [DigitalFilter](#01-the-digitalfilter-object) object specifying a digital filter               |
| `Graph`          | Graph object                  | JSON [Graph](#02-the-graph-object) object containing metadata for a frequency-domain algorithm result |
| `FFT`            | Fast Fourier Transform object | JSON [FFT](#03-the-fft-object) object containing metadata that describes an FFT.                    |


### 0.1 The `DigitalFilter` Object

A `DigitalFilter` object is used to describe a digital filter (FIR or IIR) which has been used to filter the data.

| name                           | required | type     | unit | description                                                          |
|--------------------------------|----------|----------|------|----------------------------------------------------------------------|
| `id`                           | true     | string   | N/A  | Unique ID of the filter.                                             |
| `filter_type`                  | false    | string   | N/A  | Description of digital filter, e.g., `"FIR"`, `"IIR"`                |
| `FIR_coefficients`             | false    | double[] | N/A  | Coefficients that define FIR filter.                                 |
| `IIR_numerator_coefficients`   | false    | double[] | N/A  | Coefficients that define IIR filter.                                 |
| `IIR_denominator_coefficients` | false    | double[] | N/A  | Coefficients that define IIR filter.                                 |
| `attenuation_cutoff`           | false    | double   | dB   | Attenuation that specifies the `cutoff_frequency` (typically 3 dB).  |
| `frequency_cutoff`             | false    | double   | Hz   | Frequency that characterizes boundary between passband and stopband. |
| `ripple_passband`              | false    | double   | dB   | Ripple in passband.                                                  |
| `attenuation_stopband`         | false    | double   | dB   | Attenuation of stopband.                                             |
| `frequency_stopband`           | false    | double   | Hz   | Point in filter frequency response where stopband starts.            |
| `description`                  | false    | string   | N/A  | Description of the filter.                                           |


### 0.2 The `Graph` Object

A `Graph` object may be used to describe a variety of processed data. Typically, a data payload will provide values along an axis. The values provided in
the data payload correspond to the axes described in the `Graph` object. For example, if the `Graph` objects provides an x_start, x_stop, and x_step, 
the first value in the associated data represents the y value at x_start and the next value represents the y-value at x_start + x_step. 
Similarly, if the `Graph` provides a y_start, y_stop, and y_step, the first value 
in the associated data represents the x-value at y-start. 

| name          | required | type     | unit | description                                                                                                                                                                                                               |
|---------------|----------|----------|------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `name`        | true     | string   |N/A| The name of the data product.                                                                                                                                                                                             |
| `series`      | false    | string[] | N/A  | The names of each series.                                                                                                                                                                                                 |
| `length`      | true     | integer  | N/A  | Length of each series.                                                                                                                                                                                                    |
| `x_label`     | false    | string   | N/A  | X-axis label, e.g.,  `"frequency"`,`"dBm"`, `"Time"`                                                                                                                                                                      |
| `x_start`     | false    | double[] | N/A  | The first value in the x-axis. An array with a single value may be used when the value is the same for all captures, otherwise the length of the array should match the number of captures.                                                                                                                                                                                            |
| `x_stop`      | false    | double[] | N/A  | The last value in the x-axis. An array with a single value may be used when the value is the same for all captures, otherwise the length of the array should match the number of captures.                                |
| `x_step`      | false    | double[] | N/A  | The value by which subsequent values in the x-axis increase.                                                                                                                                                              |
| `y_start`     | false    | double[] | N/A  | The first value in the y-axis. An array with a single value may be used when the value is the same for all captures, otherwise the length of the array should match the number of captures.                               |
| `y_stop`      | false    | double[] | N/A  | The last value in the y-axis.  An array with a single value may be used when the value is the same for all captures, otherwise the length of the array should match the number of captures.                               |
| `y_step`      | false    | double[] | N/A  | The value by which subsequent values in the y-axis increase. An array with a single value may be used when the value is the same for all captures, otherwise the length of the array should match the number of captures. |
| `y_label`     | false    | string   | N/A  | Y-axis label, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                                                                        |
| `processing`  | false    | string[] |N/A| The IDs associated with the additional metadata describing the processing that produced the data product.                                                                                                                 |
| `reference`   | false    | string   | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element.                                                |
| `description` | false    | string   | N/A  | A description of the graph.                                                                                                                                                                                               |



### 0.3 The FFT Object


| name                         | required | type    | unit | description                                                                                                         |
|------------------------------|----------|---------|------|---------------------------------------------------------------------------------------------------------------------|
| `id`                         | true     | string  |N/A| A unique ID that may be reference to associate data products to this data processing.                               |
| `equivalent_noise_bandwidth` | true     | double  | Hz | Bandwidth of brickwall filter that has the same integrated noise power as that of the actual filter.                |
| `samples`                    | false    | integer | N/A  | Length of the output of each FFT. This SHOULD be provided if any data are discarded.                                |
| `ffts`                       | true     | integer | N/A  | Number of FFTs integrated over by detectors.                                                                        |
| `window`                     | true     | string  | N/A  | E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`. |
| `units`                      | false    | string  | N/A  | E.g. `"dBm/Hz"`.                                                                                                    |
| `baseband`                   | true     | boolean | N/A  | Boolean indicating whether or not the results should be interpreted as baseband.                                    |


## 1 Global

The `ntia-algorithm` extension adds the following name/value pairs to the `global` SigMF object:

| name                       |required| type     |unit| description                                                                                                                                                                                                                                                                                                                           |
|----------------------------|--------------|----------|-------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `data_products`            |false| array    |N/A| The list of data products produced for each capture. Allowable types are limited to  include [Graph](#02-the-graph-object) objects.                                                                                                                                                                                                   |
| `data_products_processing` |false| string[] |N/A| The list of data products produced for each capture                                                                                                                                                                                                                                                                                   |
| `data_processing`          |false| array    |N/A| The list of data processing objects that describe processing that was performed on some or all of the data products. Supported objects include [DigitalFilter](#01-the-digitalfilter-object), and [FFT](#03-the-fft-object). The IDs of any processing performed on all data products should be listed in `data_products_processing`. |


## 2 Captures

The `ntia-algorithm` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-algorithm` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-algorithm` extension does not extend the `collection` SigMF object.

## 5 Examples

### 5.1 Anti-aliasing filter example

```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "core:version": "0.0.2",
    "ntia-algorithm:data_processing": [
        {
          "id": "anti-alias-filter",
          "filter_type": "FIR",
          "FIR_coefficients": [
            1.0,
            4.0,
            5.0,
            3.2
          ],
          "attenuation_cutoff": -3,
          "frequency_cutoff": 7500000,
          "ripple_passband": -5,
          "attenuation_stopband": -10,
          "frequency_stopband": 7000000
        }
    ],
    "ntia-algorithm:data_products_processing": ["anti-alias-filter"]
  },
  "captures": [
    ...
  ],
  "annotations": [
    ...
  ]
}
```

### 5.2 Data Products Example

```json
{
  "global": {
    "core:version": "v1.0.0",
    "core:extensions": [
      {
        "name": "ntia-algorithm",
        "version": "v2.0.0",
        "optional": false
      },
      {
        "name": "ntia-core",
        "version": "v1.0.0",
        "optional": false
      },
      {
        "name": "ntia-environment",
        "version": "v1.0.0",
        "optional": false
      },
      {
        "name": "ntia-sensor",
        "version": "v2.0.0",
        "optional": false
      },
      {
        "name": "ntia-nasctn-sea",
        "version": "v0.4",
        "optional": false
      }
    ],
    "core:geolocation": {
      "type": "Point",
      "coordinates": [
        -100.0,
        100.0,
        50.0
      ]
    },
    "core:datatype": "rf16",
    "core:sample_rate": 14000000.0,
    "core:num_channels": 15,
    "ntia-core:classification":"unclassified",
    "ntia-sensor:sensor": {
      "id": "NASCTN SEA Sensor",
      "sensor_spec": {
        "id": "NASCTN SEA Sensor",
        "model": "NASCTN SEA Sensor",
        "version": "Prototype Rev. 3"
      }
    },
    "ntia-algorithm:data_products_reference": "noise source output",
    "ntia-algorithm:data_products": [
      {
        "name": "power_spectral_density",
        "series": [ "max","mean"],
        "length": 625,
        "processing": ["fft"],
        "y_label": "dBm/Hz",
        "x_start": [-5000000],
        "x_step": [16000],
        "x_stop": [5000000],
        "processing": ["fft"]
      },
      {
        "name": "time_series_power",
        "series": ["max", "mean"],
        "length": 400,
        "y_label": "dBm",
        "x_start": [0],
        "x_stop": [4000],
        "x_step": [10]
      },
      {
        "name": "periodic_frame_power",
        "series": [ "mean of min", "mean of max",
          "mean of mean", "max of min", "max of max",
          "max of mean"],
        "length": 560,
        "y_label": "dBm",
        "x_start": [0],
        "x_stop": [10.0061],
        "x_step": [0.0179],
        "x_label": "Cyclic Time (ms)"
      },
      {
        "name": "amplitude_probability_distribution",
        "length": 151,
        "y_label": "dBm",
        "y_step": [1.0],
        "y_start": [-180],
        "y_stop": [-30],
        "x_label": "Percent Exceeding Ordinate"
      }
    ],
    "ntia-algorithm:data_products_processing": ["iir_1"],
    "ntia-algorithm:data_processing": [
      {
        "id": "iir_1",
        "filter_type": "IIR",
        "IIR_numerator_coefficients": [
          0.22001755985277486,
          1.8950858799155859,
          8.083698129129007,
          22.28438408611688,
          43.93585109754826,
          65.02462875088665,
          73.93117717291233,
          65.02462875088665,
          43.93585109754826,
          22.284384086116878,
          8.083698129129007,
          1.8950858799155853,
          0.22001755985277483
        ],
        "IIR_denominator_coefficients": [
          1.0,
          5.984606843057637,
          19.199454663117217,
          40.791247158352408,
          63.2429677473874,
          74.33110989910304,
          67.69826765401139,
          47.873252810169407,
          26.149624421307168,
          10.75285488653393,
          3.2164061393115994,
          0.6363986832562693,
          0.07408086875619748
        ],
        "ripple_passband": 0.1,
        "attenuation_stopband": 40,
        "frequency_stopband": 5008000.0,
        "frequency_cutoff": 5000000.0
      },
      {
        "id": "fft",
        "equivalent_noise_bandwidth": 60323.94,
        "samples": 875,
        "ffts": 64000,
        "window": "flattop",
        "baseband": true
      }
    ],
    "ntia-nasctn-sea:max_of_max_channel_powers": [
      -65.3125,
      -64.875,
      -64.375,
      -64.8125,
      -75.5625,
      -55.375,
      -55.125,
      -52.90625,
      -55.09375,
      -56.75,
      -56.4375,
      -70.0625,
      -70.5625,
      -47.03125,
      -42.8125
    ],
    "ntia-nasctn-sea:median_of_mean_channel_powers": [
      -83.875,
      -84.4375,
      -83.6875,
      -82.1875,
      -93.25,
      -77.375,
      -79.25,
      -74.25,
      -78.3125,
      -81.0625,
      -82.4375,
      -93.5,
      -91.875,
      -92.0625,
      -85.8125
    ],
    "ntia-diagnostics:diagnostics": {
      "datetime": "2023-04-06T21:31:39.356Z",
      "preselector": {
        "noise_diode_temp": 22.7,
        "door_closed": false
      },
      "spu": {
        "rf_tray_powered": true,
        "preselector_powered": true,
        "28v_aux_powered": true,
        "pwr_box_temp": 26.0,
        "rf_box_temp": 26.1,
        "pwr_box_humidity": 11.2,
        "sigan_internal_temp": 54.44
      },
      "computer": {
        "cpu_temp": 59.0,
        "cpu_overheating": false,
        "cpu_uptime": 21.04,
        "cpu_max_clock": 4533.5,
        "cpu_min_clock": 1240.5,
        "cpu_mean_clock": 3222.1,
        "action_cpu_usage": 42.1,
        "system_load_5m": 18.1,
        "memory_usage": 14.9,
        "scos_start_time": "2023-04-06T21:28:45.532Z",
        "scos_uptime": 0.002,
        "ssd_smart_data": {
          "test_passed": true,
          "critical_warning": "0x00",
          "temp": 35,
          "available_spare": 100,
          "available_spare_threshold": 10,
          "percentage_used": 1,
          "unsafe_shutdowns": 18,
          "integrity_errors": 0
        }
      },
      "action_runtime": 81.8970819178503
    }
  },
  "captures": [
    {
      "core:frequency": 3555000000.0,
      "core:datetime": "2023-04-06T21:30:17.539Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.159,
        "gain": 23.008,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:17.134Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 0
    },
    {
      "core:frequency": 3565000000.0,
      "core:datetime": "2023-04-06T21:30:24.572Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.662,
        "gain": 23.826,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:20.970Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 5561
    },
    {
      "core:frequency": 3575000000.0,
      "core:datetime": "2023-04-06T21:30:29.212Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.781,
        "gain": 23.581,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:25.184Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 11122
    },
    {
      "core:frequency": 3585000000.0,
      "core:datetime": "2023-04-06T21:30:34.219Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.599,
        "gain": 23.95,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:29.543Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 16683
    },
    {
      "core:frequency": 3595000000.0,
      "core:datetime": "2023-04-06T21:30:39.435Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.133,
        "gain": 22.916,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:33.413Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 22244
    },
    {
      "core:frequency": 3605000000.0,
      "core:datetime": "2023-04-06T21:30:44.047Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.007,
        "gain": 24.246,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:38.360Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 27805
    },
    {
      "core:frequency": 3615000000.0,
      "core:datetime": "2023-04-06T21:30:49.851Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.42,
        "gain": 23.082,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:43.220Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 33366
    },
    {
      "core:frequency": 3625000000.0,
      "core:datetime": "2023-04-06T21:30:54.471Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.126,
        "gain": 23.348,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:46.985Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 38927
    },
    {
      "core:frequency": 3635000000.0,
      "core:datetime": "2023-04-06T21:30:59.081Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.72,
        "gain": 24.127,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:51.247Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 44488
    },
    {
      "core:frequency": 3645000000.0,
      "core:datetime": "2023-04-06T21:31:04.096Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.131,
        "gain": 23.257,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:29:55.695Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 50049
    },
    {
      "core:frequency": 3655000000.0,
      "core:datetime": "2023-04-06T21:31:09.311Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.79,
        "gain": 23.964,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:30:00.613Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 55610
    },
    {
      "core:frequency": 3665000000.0,
      "core:datetime": "2023-04-06T21:31:15.107Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.373,
        "gain": 22.784,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:30:04.457Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 61171
    },
    {
      "core:frequency": 3675000000.0,
      "core:datetime": "2023-04-06T21:31:19.727Z",
      "ntia-sensor:overload": false,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 5.789,
        "gain": 23.731,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:30:08.362Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 66732
    },
    {
      "core:frequency": 3685000000.0,
      "core:datetime": "2023-04-06T21:31:24.355Z",
      "ntia-sensor:overload": true,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.267,
        "gain": 23.017,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:30:12.516Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 72293
    },
    {
      "core:frequency": 3695000000.0,
      "core:datetime": "2023-04-06T21:31:29.350Z",
      "ntia-sensor:overload": true,
      "ntia-sensor:duration": 4000,
      "ntia-sensor:sensor_calibration": {
        "noise_figure": 6.041,
        "gain": 23.427,
        "temperature": 22.6,
        "datetime": "2023-04-06T21:30:17.430Z"
      },
      "ntia-sensor:sigan_settings": {
        "reference_level": -25.0,
        "attenuation": 0.0,
        "preamp_enable": true
      },
      "core:sample_start": 77854
    }
  ],
  "annotations": []
}
```
