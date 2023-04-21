# The `ntia-algorithm` SigMF Extension Namespace v2.0.0

This document defines the `ntia-algorithm` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace contains objects which describe algorithms applied to measurements.

## 0 Datatypes

The `ntia-algorithm` extension defines the following datatypes:

|name|long-form name|description|
|----|--------------|-----------|
|`DigitalFilter`|digital filter specification|JSON [`DigitalFilter`](#01-the-digitalfilter-object) object specifying a digital filter|
|`DataProducts`|data products information|JSON [`DataProducts`](#02-the-dataproducts-object) object specifying one or multiple algorithm results referred to by the metadata, with additional information in sub-objects|
|`PowerSpectralDensity`|frequency domain detection|JSON [`PowerSpectralDensity`](#03-the-powerspectraldensity-object) object containing metadata for a frequency-domain algorithm result|
|`TimeSeriesPower`|time domain detection|JSON [`TimeSeriesPower`](#04-the-timeseriespower-object) object containing metadata for a time-series/time-domain algorithm result|
|`PeriodicFramePower`|cyclostationary detection|JSON [`PeriodicFramePower`](#05-the-periodicframepower-object) object containing metadata for a periodic-frame cyclostationary algorithm result|
|`AmplitudeProbabilityDistribution`|amplitude probability distribution|JSON [`AmplitudeProbabilityDistribution`](#06-the-amplitudeprobabilitydistribution-object) object containing metadata for a full or binned amplitude probability distribution result|
|`Trace`|trace specification|JSON [`Trace`](#07-the-trace-object) object defining one or two traces of a data product|

### 0.1 The `DigitalFilter` Object

A `DigitalFilter` object is used to describe a digital filter (FIR or IIR) which has been used to filter the data.

| name                           | required |type|unit| description                                          |
|--------------------------------|----------|-------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------|
| `id`                           | true     |string|N/A| Unique ID of the filter.                             |
| `filter_type`                  | false    |string|N/A| Description of digital filter, e.g., `"FIR"`, `"IIR"` |
| `FIR_coefficients`             | false    |double[]|N/A| Coefficients that define FIR filter.                 |
| `IIR_numerator_coefficients`   | false    |double[]|N/A| Coefficients that define IIR filter.                 |
| `IIR_denominator_coefficients` | false    |double[]|N/A| Coefficients that define IIR filter.                 |
| `attenuation_cutoff`           | false    |double|dB| Attenuation that specifies the `cutoff_frequency` (typically 3 dB). |
| `frequency_cutoff`             | false    |double|Hz| Frequency that characterizes boundary between passband and stopband. |
| `ripple_passband`              | false    |double|dB| Ripple in passband.                                  |
| `attenuation_stopband`         | false    |double|dB| Attenuation of stopband.                             |
| `frequency_stopband`           | false    |double|Hz| Pointegerin filter frequency response where stopband starts. |

### 0.2 The `DataProducts` Object

`DataProducts` provide descriptions of processing performed on signal data and provide information necessary to parse the data file.
The `reference` element may be used when each of the data products share the same reference point. The other
elements each represent the output of various algorithms. Each data product listed shall be included for every capture and the order of the data products for each capture
follows the order in which they are specified in the JSON.

| name                                 | required | type                                                                     |unit| description                                                                                                                                                                                                                        |
|--------------------------------------|----------|--------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `reference`                          | false        | string                                                                   |N/A| Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. If the data products do not share the same reference point, the reference pointegershould be specified within each data product. |
| `power_spectral_density`             | false    | [PowerSpectralDensity](#03-the-powerspectraldensity-object)                         |N/A| Quantifies the distribution of signal power with respect to frequency within a waveform capture.                                                                                                                                   |
| `time_series_power`                  | false    | [TimeSeriesPower](#04-the-timeseriespower-object)                                   |N/A| Quantifies the time-progression of channel power values across the duration of a waveform capture.                                                                                                                                 |
| `periodic_frame_power`               | false    | [PeriodicFramePower](#05-the-periodicframepower-object)                             |N/A| Provides occupancy patterns accross fixed time frames to differentiate emitters.                                                                                                                                                   |
| `amplitude_probability_distribution` | false    | [AmplitudeProbabilityDistribution](#06-the-amplitudeprobabilitydistribution-object) |N/A| Complementary cumulative distribution function (CCDF) of the instantaneous channel power, evaluated empirically..                                                                                                                  |
| `digital_filter`                     | false    | string                                                                   |N/A|ID of the digital filter used in each data product. If different data products use different filters, the filter should be specified in each data product.

### 0.3 The `PowerSpectralDensity` Object

A `PowerSpectralDensity` object is used to describe the result of a frequency-domain detection. Despite its name, the `units` field provides flexibility for other types of power spectra. Results of FFT processing, and statistical detectors applied to FFT results, will generally be annotated by this object.

| name                               | required | type                 | unit | description                                                                                                                                                                |
|------------------------------------|---------|----------------------|------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`                           | true    | [Trace](#07-the-trace-object)[] | N/A  | Traces in the order they appear in the data file.                                                                                                                          |
| `length`                           | true    | integer                 | N/A  | Length of the output.                                                                                                                                                      |
| `equivalent_noise_bandwidth`       | true    | double               | Hz | Bandwidth of brickwall filter that has the same integrated noise power as that of the actual filter.                                                                       |
| `samples`                          | true    | integer                 | N/A  | Number of samples in the FFT.                                                                                                                                              |
| `ffts`                             | true    | integer                 | N/A  | Number of FFTs integrated over by detectors.                                                                                                                               |
| `units`                            | true    | string               | N/A  | Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `window`                           | true    | string               | N/A  | E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.                                                        |
| `reference`                        |false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string               |N/A| The ID of the digital filter used in this data product.            |

### 0.4 The `TimeSeriesPower` Object

A `TimeSeriesPower` object is used to provide information related to time-series amplitude data. Despite its name, the `units` and `reference` fields allows this object to be generalizable to multiple situations, including volts-versus-time or amplitude-versus-time. The `traces` and `samples` fields provide flexibility for this object to describe the result of detectors applied to a time series.

| name        | required | type   |unit| description                                              |
|-------------|----------|--------|-------|----------------------------------------------------------|
| `traces`    | true     |  [Trace](#07-the-trace-object)[] |N/A| Traces in the order they appear in the data file.              |
| `length`    | true     | integer   |N/A| Length of the output.                    |
| `samples`   | true     | integer   |N/A| Number of samples used to compute the time series power. |
| `units`     | true     | string |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.         |
| `reference` |false    | string | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string      |N/A| The ID of the digital filter used in this data product.            |

### 0.5 The `PeriodicFramePower` Object

A `PeriodicFramePower` object is used to describe the results of cyclostationary power detection.

| name        | required | type                 |unit| description                                                                                                                                                                |
|-------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`    | true     | [Trace](#07-the-trace-object)[] |N/A| E.g. `[min, max, mean, median, sample]`.                                                                                                                                  |
| `length`    | true     | integer                 |N/A| Length of the output.                                                                                                                                                      |
| `units`     | true     | string               |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `reference` |false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`                   | false    | string      |N/A| The ID of the digital filter used in this data product.            |

### 0.6 The `AmplitudeProbabilityDistribution` Object

An `AmplitudeProbabilityDistribution` object is used to describe an APD, and supports binned/downsampled APD results in a number of ways. In the binned-APD case, the data represents the probability values, and the `amplitude_bin_size`, `amplitude_min`, and `amplitude_max` values MUST be provided.

| name                 | required | type                 |unit| description                                                                                                                                                                |
|----------------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `traces`             | true     | [Trace](#07-the-trace-object)[] |N/A| Traces in the order they appear in the data file.                                                                                                                          |
| `length`             | true     | integer                 |N/A| Length of the abscissa.                                                                                                                                                    |
| `samples`            | true     | integer                 |N/A| Number of samples used to compute the amplitude probability distrubtion.                                                                                                   |
| `units`              | true     | string               |N/A| Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.                                                                                                                           |
| `amplitude_bin_size` | true     | double               |`units`| Step/tick size of the amplitude, or y-axis.                                                                                                                                |
| `amplitude_min`      | true     | double               |`units`| Minimum value of the amplitude, or y-axis.                                                                                                                                 |
| `amplitude_max`      | true     | double               |`units`| Maximum value of the amplitude, or y-axis.                                                                                                                                  |
| `reference`          | false    | string               | N/A  | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`. Shall be included when not specified within  `data_products` element. |
| `digital_filter`     | false    | string               |N/A| The ID of the digital filter used in this data product.                                                                                                                    |

### 0.7 The `Trace` Object

A `Trace` object is used to indicate that a certain data product includes multiple detector results applied to the same input. If both `detector` and `statistic` are provided, the `statistic` is assumed to have been computed on the result of `detector`.

| name             | required | type                 |unit| description                                                                                                                                                                |
|------------------|----------|----------------------|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `detector`       | false    | string |N/A| E.g., `peak`, `rms`                 |
| `statistic`      | false    | string |N/A| E.g., `min`, `max`, `median`,`mean` |

## 1 Global

The `ntia-algorithm` extension adds the following name/value pairs to the `global` SigMF object:

| name              |required| type                                        |unit| description                                                                                                                                                  |
|-------------------|--------------|---------------------------------------------|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `digital_filters` |false| [DigitalFilter[]](#01-the-digitalfilter-object) |N/A| Digital filters applied to the data. If only one digital filter is listed, it is not necessary to reference it in the [DataProducts](12-dataproducts-object) |
| `data_products`   |false| [DataProducts](#02-the-dataproducts-object)     |N/A| The list of data products produced for each capture                                                                                                          |

                                                             |

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
