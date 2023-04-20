# ntia-algorithm Extension v2.0.0
The ntia-algorithm namespace describes algorithms applied to measurements. 

`ntia-algorithm` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-algorithm` extends [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs: 

| name              |required| type                                        |unit| description                                                                                                                                                 |
|-------------------|--------------|---------------------------------------------|-------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `digital_filters` |false| [DigitalFilter[]](#11-digitalfilter) |N/A| Digital filters applied to the data. If only one digital filter is listed, it is not necessary to reference it in the [DataProducts](12-dataproduts-object) |
| `data_products`   |false| [DataProducts](#12-dataproducts-object)     |N/A| The list of data products produced for each capture                                                                                                         |


### 1.1 DigitalFilter 
`DigitalFilter` has the following properties:

| name                           | required |type|unit| description                                          |
|--------------------------------|----------|-------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------|
| `id`                           | true     |string|N/A| Unique id of the filter.                             |
| `filter_type`                  | false    |string|N/A| Description of digital filter, e.g., `"FIR"`, `"IIR"` |
| `FIR_coefficients`             | false    |double[]|N/A| Coefficients that define FIR filter.                 |
| `IIR_numerator_coefficients`   | false    |double[]|N/A| Coefficients that define IIR filter.                 |
| `IIR_denominator_coefficients` | false    |double[]|N/A| Coefficients that define IIR filter.                 |
| `attenuation_cutoff`           | false    |double|dB| Attenuation that specifies the `cutoff_frequency` (typically 3 dB). |
| `frequency_cutoff`             | false    |double|Hz| Frequency that characterizes boundary between passband and stopband. |
| `ripple_passband`              | false    |double|dB| Ripple in passband.                                  |
| `attenuation_stopband`         | false    |double|dB| Attenuation of stopband.                             |
| `frequency_stopband`           | false    |double|Hz| Point in filter frequency response where stopband starts. |

### 1.2 DataProducts Object
`DataProducts` provide descriptions of processing performed on signal data and provide information necessary to parse the data file. 
The `reference` element may be used when each of the data products share the same reference point. The other 
elements each represent the output of various algorithms. Each data product listed shall be included for every capture and the order of the data products for each capture
follows the order in which they are specified in the JSON. 

| name                                 | required | type                                                                     |unit| description                                                                                                                                                                                                                        |
|--------------------------------------|----------|--------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `reference`                          | false        | string                                                                   |N/A| Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. If the data products do not share the same reference point, the reference point should be specified within each data product. |
| `power_spectral_density`             | false    | [PowerSpectralDensity](#13-powerspectraldensity)                         |N/A| Quantifies the distribution of signal power with respect to frequency within a waveform capture.                                                                                                                                   |
| `time_series_power`                  | false    | [TimeSeriesPower](#14-timeseriespower)                                   |N/A| Quantifies the time-progression of channel power values across the duration of a waveform capture.                                                                                                                                 |
| `periodic_frame_power`               | false    | [PeriodicFramePower](#15-periodicframepower)                             |N/A| Provides occupancy patterns accross fixed time frames to differentiate emitters.                                                                                                                                                   |
| `amplitude_probability_distribution` | false    | [AmplitudeProbabilityDistribution](#16-amplitudeprobabilitydistribution) |N/A| Complementary cumulative distribution function (CCDF) of the instantaneous channel power, evaluated empirically..                                                                                                                  |
| `digital_filter`                     | false    | string                                                                   |N/A| The id of the digital filter used in each data product. If different data products use different filters, the filter should be specified in each data product.                                                                     |


### 1.3 PowerSpectralDensity

| name                               | required | type                 | unit | description                                                                                                                                                                |
|------------------------------------|---------|----------------------|------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`                           | true    | [Trace](#17-trace)[] | N/A  | Traces in the order they appear in the data file.                                                                                                                          |
| `length`                           | true    | uint                 | N/A  | Length of the output.                                                                                                                                                      |
| `equivalent_noise_bandwidth`       | true    | double               | N/A  | Bandwidth of brickwall filter that has the same integrated noise power as that of the actual filter.                                                                       |
| `samples`                          | true    | uint                 | N/A  | Number of samples in the FFT.                                                                                                                                              |
| `ffts`                             | true    | int                  | N/A  | Number of FFTs integrated over by detectors.                                                                                                                               |
| `units`                            | true    | string               | N/A  | Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `window`                           | true    | string               | N/A  | E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.                                                        |
| `reference`                        |false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string               |N/A| The id of the digital filter used in this data product.            |


### 1.4 TimeSeriesPower

| name        | required | type   |unit| description                                              |
|-------------|----------|--------|-------|----------------------------------------------------------|
| `traces`    | true     |  [Trace](#17-trace)[] |N/A| Traces in the order they appear in the data file.              |
| `length`    | true     | uint   |N/A| Length of the output.                    |
| `samples`   | true     | uint   |N/A| Number of samples used to compute the time series power. |
| `units`     | true     | string |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.         |
| `reference` |false    | string | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string      |N/A| The id of the digital filter used in this data product.            |


### 1.5 PeriodicFramePower

| name        | required | type                 |unit| description                                                                                                                                                                |
|-------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`    | true     | [Trace](#17-trace)[] |N/A| E.g. `[min, max, mean, meadian, sample]`.                                                                                                                                  |
| `length`    | true     | uint                 |N/A| Length of the output.                                                                                                                                                      |
| `units`     | true     | string               |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `reference` |false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string      |N/A| The id of the digital filter used in this data product.            |


### 1.6 AmplitudeProbabilityDistribution

| name                 | required | type                 |unit| description                                                                                                                                                                |
|----------------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`             | true     | [Trace](#17-trace)[] |N/A| Traces in the order they appear in the data file.                                                                                                                          |
| `length`             | true     | uint                 |N/A| Length of the abscissa.                                                                                                                                                    |
| `samples`            | true     | uint                 |N/A| Number of samples used to compute the amplitude probability distrubtion.                                                                                                   |
| `units`              | true     | string               |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `amplitude_bin_size` | true     | double               |N/A| Step/tick size of the amplitude, or y-axis.                                                                                                                                |
| `amplitude_min`      | true     | double               |N/A| Minimum value of the amplitude, or y-axis.                                                                                                                                 |
| `amplitude_max`      | true     | double               |N/A| Maximum value of the amplitud, or y-axis.                                                                                                                                  |
| `reference`          | false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`     | false    | string               |N/A| The id of the digital filter used in this data product.                                                                                                                    |

### 1.7 Trace
A `Trace`

| name             | required | type                 |unit| description                                                                                                                                                                |
|------------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `detector`       | false    | string |N/A| E.g., `peak`, `rms`                 |
| `statistic`      | false    | string |N/A| E.g., `min`, `max`, `median`,`mean` |


## 2 Captures
`ntia-algorithm` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-algorithm` does not extend [Annotations](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#annotations-array).



## 4 Example

### 4.1 Anti-aliasing filter example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "core:version": "0.0.2",
    "ntia-algorithm:digital_filters": [
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

### 4.2 Data Products Example
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
        "name": "ntia-scos",
        "version": "v1.0.0",
        "optional": true
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
    "ntia-sensor:sensor": {
      "id": "NASCTN SEA Sensor",
      "sensor_spec": {
        "id": "NASCTN SEA Sensor",
        "model": "NASCTN SEA Sensor",
        "version": "Prototype Rev. 3"
      }
    },
    "ntia-algorithm:digital_filters": [
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
      }
    ],
    "ntia-algorithm:data_products": {
      "digital_filter": "iir_1",
      "reference": "noise source output",
      "power_spectral_density": {
        "traces": [
          {
            "statistic": "max"
          },
          {
            "statistic": "mean"
          }
        ],
        "length": 625,
        "equivalent_noise_bandwidth": 60323.94,
        "samples": 875,
        "ffts": 64000,
        "units": "dBm/Hz",
        "window": "flattop"
      },
      "time_series_power": {
        "traces": [
          {
            "detector": "max"
          },
          {
            "detector": "mean"
          }
        ],
        "length": 400,
        "samples": 56000000,
        "units": "dBm"
      },
      "periodic_frame_power": {
        "traces": [
          {
            "detector": "mean",
            "statistic": "min"
          },
          {
            "detector": "mean",
            "statistic": "max"
          },
          {
            "detector": "mean",
            "statistic": "mean"
          },
          {
            "detector": "max",
            "statistic": "min"
          },
          {
            "detector": "max",
            "statistic": "max"
          },
          {
            "detector": "max",
            "statistic": "mean"
          }
        ],
        "length": 560,
        "units": "dBm"
      },
      "amplitude_probability_distribution": {
        "length": 151,
        "samples": 56000000,
        "units": "dBm",
        "probability_units": "percent",
        "amplitude_bin_size": 1.0,
        "min_amplitude": -180,
        "max_amplitude": -30
      }
    }
  },
  "captures": [
    ...
  ]
  "annotations": [
    ...
  ]
}
```


