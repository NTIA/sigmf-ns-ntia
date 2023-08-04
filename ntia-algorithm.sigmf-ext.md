# The `ntia-algorithm` SigMF Extension Namespace v2.0.1

This document defines the `ntia-algorithm` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace contains objects which describe algorithms applied to measurements.

## 0 Datatypes

The `ntia-algorithm` extension defines the following datatypes:

| name            | long-form name               | description                                                                                                                               |
|-----------------|------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| `DigitalFilter` | digital filter specification | JSON [DigitalFilter](#01-the-digitalfilter-object) object specifying a digital filter                                                     |
| `Graph`         | Graph object                 | JSON [Graph](#02-the-graph-object) object containing metadata relevant for displaying the result of an algorithm applied to a measurement |
| `DFT`           | discrete Fourier transform   | JSON [DFT](#03-the-dft-object) object describing parameters of a discrete Fourier transform (DFT)                                         |

### 0.1 The `DigitalFilter` Object

A `DigitalFilter` object is used to describe a discrete-time linear time-invariant (LTI) highpass or lowpass filter which has been used to filter the data. Note that lowpass filters may be applied to complex-valued IQ data in order to create a bandpass filter which is centered on the baseband frequency. In this case, the metadata should describe the lowpass filter which was used, even though the intended functionality was as a bandpass filter.

| name                       | required | type                                         | unit | description                                                                                                                                                       |
|----------------------------|----------|----------------------------------------------|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `type`                     | true     | string                                       | N/A  | MUST be set to `"DigitalFilter"`. Used to identify the object type when parsing.                                                                                  |
| `id`                       | true     | string                                       | N/A  | Unique ID of the filter                                                                                                                                           |
| `filter_type`              | true     | [enum](./ntia-core.sigmf-ext.md#0-datatypes) | N/A  | Type of the digital filter, given by the [FilterType](#011-the-filtertype-enum) enum                                                                              |
| `feedforward_coefficients` | false    | double[]                                     | N/A  | Coefficients that define the feedforward filter stage (see [below](#012-detailed-description-of-a-digital-filter)).                                               |
| `feedback_coefficients`    | false    | double[]                                     | N/A  | Coefficients that define feedback filter stage (see [below](#012-detailed-description-of-a-digital-filter)). SHOULD only be present when `filter_type` is `"IIR"` |
| `attenuation_cutoff`       | false    | double                                       | dB   | Attenuation that specifies the `frequency_cutoff` (typically 3 dB)                                                                                                |
| `frequency_cutoff`         | false    | double                                       | Hz   | Frequency that characterizes boundary between passband and stopband. Beyond this frequency, the signal is attenuated by at least `attenuation_cutoff`             |
| `description`              | false    | string                                       | N/A  | Supplemental description of the filter                                                                                                                            |

#### 0.1.1 The `FilterType` Enum

The `FilterType` string-typed [enum](./ntia-core.sigmf-ext.md#0-datatypes) defines whether the filter described by the `DigitalFilter` object is a finite impulse response (FIR) or infinite impulse response (IIR) filter.

| value | description                      |
|-------|----------------------------------|
| `FIR` | Finite impulse response filter   |
| `IIR` | Infinite impulse response filter |

#### 0.1.2 Detailed Description of a Digital Filter

The most comprehensive way to describe a digital filter is by providing its coefficients directly. This approach allows for the digital filter to be entirely reconstructed from the metadata. To allow for this reconstruction, the following difference equation is provided which generally describes the output sequence $y[n]$ when either a FIR or IIR filter is applied to an input sequence $x[n]$.

$$
y[n] = \frac{1}{a_0}\Bigg(\sum_{i=0}^{P} b_i \cdot x[n-i] - \sum_{j=1}^{Q}a_j \cdot y[n-j]\Bigg)
$$

This equation directly describes an IIR filter with feedforward filter order $P$ and feedback filter order $Q$. Note that in typical IIR filter designs, $a_0=1$ and $P=Q$.

For an FIR filter, there is no feedback stage. In this case, the above equation simply reduces to describe the feedforward filter, and $P$ is the order of the FIR filter. The simplified equation becomes:

$$
y[n] = \sum_{i=0}^{P}b_i\cdot x[n-i]
$$

The `DigitalFilter` fields `feedforward_coefficients` and `feedback_coefficients` can therefore be used to fully describe either FIR or IIR filters. These fields record, respectively, $b$ and $a$ in the above equations. For FIR filters, only `feedforward_coefficients` is required to fully describe the filter. For IIR filters, both `feedforward_coefficients` and `feedback_coefficients` are required to fully describe the filter.

#### 0.1.3 Examples

Two examples of `DigitalFilter` objects are shown below. The first shows an example which uses less descriptive fields, while the seconds provides a full filter description by providing its coefficients. The second example omits the cutoff frequency and attenuation fields- perhaps the generator expects the reader to reconstruct the filter to analyze its characteristics.

```json
"DigitalFilter": {
  "id": "LOWPASS-1-LESS-INFO",
  "filter_type": "IIR",
  "frequency_cutoff": 5008000.0,
  "attenuation_cutoff": 30.0,
  "description": "Lowpass filter used as 10 MHz bandpass"
}
```

```json
"DigitalFilter": {
  "id": "LOWPASS-2-MORE-INFO",
  "filter_type": "IIR",
  "feedforward_coefficients": [0.22001755985277485, 1.8950858799155859, 8.083698129129006],
  "feedback_coefficients": [1.0, 5.984606843057637, 19.199454663117216]
}
```

### 0.2 The `Graph` Object

A `Graph` object may be used to describe a variety of processed data. Typically, a data payload will provide values along one or two axes. The axes are referred to within this object as the $x$ and $y$ axes. For example, the data may include samples of a discrete Fourier transform, and the corresponding frequency values may be specified as the $x$ axis using the `Graph` object. Instead, the data may include results of many DFTs, and the $x$ and $y$ axes may both be used to indicate a spectrogram.

The ordering of values provided in the data payload correspond to the axes described in the `Graph` object. The data is assumed to specify values for the next axis after those included in a `Graph` object. For example, if the `Graph` object specifies only the $x$ axis, the data is interpreted as the $y$ axis. If both $x$ and $y$ axes are given in the `Graph` object, the data are interpreted as $z$ values.

Because of this, the lengths of the axes specified in the `Graph` object must correspond to the data lengths. For example, if the `Graph` objects provides an `x_start`, `x_stop`, and `x_step`, the first value in the associated data represents the $y$ value at `x_start` and the next value represents the $y$ value at `x_start + x_step`. If `x_axis` is used instead, its length MUST be equal to the length of the corresponding data. See [below](#021-specifying-axes) for details about recording $x$ or $y$ axes.

| name          | required | type     | unit      | description                                                                                                                                                                                                                                                                                                                                    |
|---------------|----------|----------|-----------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `name`        | true     | string   | N/A       | The name of the data product, e.g., `"Power Spectral Density"`, `"Signal Power vs. Time"`, `"M4S Detection"`                                                                                                                                                                                                                                   |
| `series`      | false    | string[] | N/A       | The names of each series. Multiple series may be recorded as a way to notate that a graph is notating the results of multiple statistics computed from the same algorithm result, e.g., `["max", "min", "mean", "median", "sample"]` for an M4S detector.                                                                                      |
| `length`      | true     | integer  | N/A       | Length (number of samples) of each series.                                                                                                                                                                                                                                                                                                     |
| `x_units`     | false    | string   | N/A       | Units for the $x$ axis, e.g.,  `"Hz"`, `"ms"`. SHOULD use standard SI unit abbreviations and prefixes.                                                                                                                                                                                                                                         |
| `x_axis`      | false    | array    | `x_units` | $x$ axis values. Elements in the array must be uniform in type and one of `integer`, `double`, or `string`.                                                                                                                                                                                                                                    |
| `x_start`     | false    | double[] | `x_units` | The first value in the $x$ axis                                                                                                                                                                                                                                                                                                                |
| `x_stop`      | false    | double[] | `x_units` | The last value in the $x$ axis                                                                                                                                                                                                                                                                                                                 |
| `x_step`      | false    | double[] | `x_units` | The value by which subsequent values in the $x$ axis increase.                                                                                                                                                                                                                                                                                 |
| `y_units`     | false    | string   | N/A       | Units for the $y$ axis, e.g., `"dBm"`, `"watts"`, `"volts"`. SHOULD use standard SI unit abbreviations and prefixes.                                                                                                                                                                                                                           |
| `y_axis`      | false    | array    | `y_units` | $y$ axis values. Elements in the array must be uniform in type and one of `integer`, `double`, or `string`.                                                                                                                                                                                                                                    |
| `y_start`     | false    | double[] | `y_units` | The first value in the $y$ axis                                                                                                                                                                                                                                                                                                                |
| `y_stop`      | false    | double[] | `y_units` | The last value in the $y$ axis                                                                                                                                                                                                                                                                                                                 |
| `y_step`      | false    | double[] | `y_units` | The value by which subsequent values in the $y$ axis increase                                                                                                                                                                                                                                                                                  |
| `processing`  | false    | string[] | N/A       | IDs associated with the additional metadata describing the processing that produced the data product. Note: this is processing that was performed in addition to any referenced in the `Global` object's `ntia-algorithm:processing` element. If multiple IDs are provided, their order indicates the order in which processing steps occurred |
| `reference`   | false    | string   | N/A       | Data reference point, e.g.,  `"signal analyzer input"`, `"preselector input"`, `"antenna terminal"`.                                                                                                                                                                                                                                           |
| `description` | false    | string   | N/A       | Supplemental description of the graph.                                                                                                                                                                                                                                                                                                         |

#### 0.2.1 Specifying Axes

- If any of `x_axis`, `x_start`, `x_stop`, or `x_step` are provided, `x_units` MUST be provided.
- If any of `y_axis`, `y_start`, `y_stop`, or `y_step` are provided, `y_units` MUST be provided.
- If `x_axis` is provided, it takes precedence over `x_start`, `x_stop`, and `x_step`, which SHOULD NOT be provided.
- If `y_axis` is provided, it takes precedence over `y_start`, `y_stop`, and `y_step`, which SHOULD NOT be provided.
- For all of `x_start`, `x_stop`, `x_step`, `y_start`, `y_stop`, and `y_step`, arrays with single values imply that each capture shares the same value. Otherwise, the arrays MUST have a length equal to the number of captures.
- The lengths of `x_start`, `x_stop`, and `x_step` MUST always be identical. If any of these three are provided, all three MUST be provided.
- The lengths of `y_start`, `y_stop`, and `y_step` MUST always be identical. If any of these three are provided, all three MUST be provided.

### 0.3 The DFT Object

The `DFT` object provides fields to describe the parameters of a data product generated from the discrete Fourier transform (DFT). Typically, the DFT is implemented using the fast Fourier transform (FFT) algorithm.

| name                         | required | type    | unit | description                                                                                                                             |
|------------------------------|----------|---------|------|-----------------------------------------------------------------------------------------------------------------------------------------|
| `type`                       | true     | string  | N/A  | MUST be set to `"DFT"`. Used to identify the object type when parsing.                                                                  |
| `id`                         | true     | string  | N/A  | A unique ID that may be referenced to associate a data product with these parameters                                                    |
| `equivalent_noise_bandwidth` | true     | double  | Hz   | Bandwidth of brickwall filter that has the same integrated noise power as that of a sample of the DFT                                   |
| `samples`                    | true     | integer | N/A  | Length of the DFT                                                                                                                       |
| `dfts`                       | true     | integer | N/A  | Number of DFTs (each of length `samples`) integrated over by detectors, e.g., when using the Bartlett method or M4S detection           |
| `window`                     | true     | string  | N/A  | E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.                     |
| `baseband`                   | true     | boolean | N/A  | Indicates whether or not the frequency axis described in the corresponding `Graph` object should be interpreted as baseband frequencies |
| `description`                | false    | string  | N/A  | Supplemental description of the processing                                                                                              |

## 1 Global

The `ntia-algorithm` extension adds the following name/value pairs to the `global` SigMF object:

| name              | required | type                            | unit | description                                                                                                                                                                                                                                                                                                       |
|-------------------|----------|---------------------------------|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `data_products`   | false    | [Graph[]](#02-the-graph-object) | N/A  | List of data products produced for each capture                                                                                                                                                                                                                                                                   |
| `processing`      | false    | string[]                        | N/A  | IDs associated with the additional metadata describing processing applied to ALL data                                                                                                                                                                                                                             |
| `processing_info` | false    | array                           | N/A  | List of objects that describe processing used to generate some of the data products listed in `data_products`. Supported objects include [DigitalFilter](#01-the-digitalfilter-object), and [DFT](#03-the-dft-object). Any object in this array MUST have a `type` field which distinguishes it from other types of objects in this array. The IDs of any processing performed on ALL data products should be listed in `processing`. |

The `processing` array is used to record the IDs of processing objects which apply to ALL data. For example, this may include the ID of a `DigitalFilter` object which provides the metadata of a lowpass filter which was applied to each capture.

The `data_products` array consists of `Graph` objects, which may define additional `processing` object IDs. If the global level `processing` array exists and is not empty, it is assumed that `processing` IDs included in a `Graph` object occurred sequentially, following those recorded in the global level `processing` array. For example, if the global level `processing` object records the ID of a `DigitalFilter` object, and the `processing` field of a `Graph` object in the `data_products` array includes the ID of a `DFT` object, the indication is that the data product is a DFT computed on filtered data.

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
    "core:version": "1.0.0",
    "ntia-algorithm:processing_info": [
        {
          "id": "anti-alias-filter",
          "filter_type": "FIR",
          "feedforward_coefficients": [
            1.0,
            4.0,
            5.0,
            3.2
          ],
          "attenuation_cutoff": -3,
          "frequency_cutoff": 7500000,
          "description": "An example anti-aliasing filter, with dummy coefficients"
        }
    ],
    "ntia-algorithm:processing": ["anti-alias-filter"]
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
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:version" : "1.0.0",
    "core:num_channels" : 1,
    "core:extensions" : [ {
      "name" : "ntia-core",
      "version" : "v2.0.1",
      "optional" : false
    }, {
      "name" : "ntia-algorithm",
      "version" : "v2.0.1",
      "optional" : false
    } ],
    "ntia-core:classification" : "UNCLASSIFIED",
    "ntia-algorithm:data_products" : [ {
      "processing" : [ "psd_fft" ],
      "name" : "power_spectral_density",
      "description" : "Power spectral density with first and last 125 samples removed, computed from filtered data",
      "series" : [ "max", "mean" ],
      "length" : 625,
      "reference" : "calibration terminal",
      "x_units" : "Hz",
      "x_start" : [ -4992000.0 ],
      "x_stop" : [ 4992000.0 ],
      "x_step" : [ 16000.0 ],
      "y_units" : "dBm/Hz"
    }, {
      "name" : "power_vs_time",
      "description" : "Time series mean and max power computed from filtered data",
      "series" : [ "max", "mean" ],
      "length" : 400,
      "reference" : "calibration terminal",
      "y_units" : "dBm",
      "x_units" : "ms",
      "x_start" : [ 0.0 ],
      "x_stop" : [ 4000.0 ],
      "x_step" : [ 10.0 ],
    }, {
      "name" : "periodic_frame_power",
      "description" : "Periodic frame power with (min, max, mean) of mean and max detectors",
      "series" : [ "max-of-max", "mean-of-max", "min-of-max", "max-of-mean", "mean-of-mean", "min-of-mean" ],
      "length" : 560,
      "reference" : "calibration terminal",
      "x_units" : "ms",
      "x_start" : [ 0.0 ],
      "x_stop" : [ 10.0 ],
      "x_step" : [ 0.01785714285 ],
      "y_units" : "dBm"
    }, {
      "name" : "amplitude_probability_distribution",
      "description" : "Downsampled APD with 1 dBm bins",
      "length" : 151,
      "reference" : "calibration terminal",
      "y_units" : "dBm",
      "x_units" : "percent",
      "y_start" : [ -180.0 ],
      "y_stop" : [ -30.0 ],
      "y_step" : [ 1.0 ]
    } ],
    "ntia-algorithm:processing" : [ "iir_1" ],
    "ntia-algorithm:processing_info" : [ {
      "id" : "psd_fft",
      "description" : "An example DFT object for 1000x 875-sample DFTs, using the flat top window and providing amplitudes at baseband frequencies.",
      "samples" : 875,
      "dfts" : 1000,
      "window" : "flattop",
      "baseband" : true,
      "equivalent_noise_bandwidth" : 51546.33
    }, {
      "id" : "iir_1",
      "description" : "An example IIR 5 MHz lowpass filter",
      "filter_type" : "IIR",
      "feedforward_coefficients" : [ 0.22001755985277485, 1.8950858799155859, 8.083698129129006, 22.28438408611688, 43.93585109754826, 65.02462875088665, 73.93117717291233, 65.02462875088665, 43.93585109754826, 22.284384086116876, 8.083698129129006, 1.8950858799155852, 0.22001755985277482 ],
      "feedback_coefficients" : [ 1.0, 5.984606843057637, 19.199454663117216, 40.791247158352405, 63.2429677473874, 74.33110989910304, 67.69826765401139, 47.873252810169404, 26.149624421307166, 10.75285488653393, 3.2164061393115992, 0.6363986832562692, 0.07408086875619747 ],
      "attenuation_cutoff" : 80.0,
      "frequency_cutoff" : 5008000.0
    } ]
  },
  "captures" : [ ],
  "annotations" : [ ]
}
```
