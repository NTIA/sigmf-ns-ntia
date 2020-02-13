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

### 4.2 TimeDomainDetection  Example
```json
{
  "id": "5e4575446524c8e43c6e1680",
  "global": {
    "core:datatype": "cf32_le",
    "core:sample_rate": 1.5360000011967678E7,
    "core:version": "0.0.2",
    "core:sha512": "5b522660c1406db41a7c05c564b902fa658de8755eaf77a35fea635ff97fd1293fe9e8b799c7ffca70d22cff8fa97cef0633ef29a08bdbc1b629165db72f81e3",
     "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor": {
      "id": "greyhound8.sms.internal",
      "sensor_spec": {
        "id": "",
        "model": "greyhound"
      },
      "antenna": {
        "antenna_spec": {
          "id": "",
          "model": "L-com HG3512UP-NF"
        }
      },
      "signal_analyzer": {
        "sigan_spec": {
          "id": "",
          "model": "Ettus USRP B210"
        },
        "a2d_bits": 0
      },
      "computer_spec": {
        "id": "",
        "model": "Intel NUC"
      },
      "location": {
        "x": -105.2715,
        "y": 40.0067
      }
    },
    "ntia-scos:action": {
      "name": "acquire_iq_700MHz_Verizon_UL",
      "description": "Capture time-domain IQ samples at the following 1 frequencies: 782.00 MHz.\n\n# acquire_iq_700MHz_Verizon_UL\n\n## Radio setup and sample acquisition\n\nEach time this task runs, the following process is followed:\n\n\n\nThis will take a minimum of 1000.00 ms, not including radio\ntuning, dropping samples after retunes, and data storage.\n\n## Time-domain processing\n\nIf specified, a voltage scaling factor is applied to the complex time-domain\nsignals.\n\n## Data Archive\n\nEach capture will be $15360\\; \\text{samples} \\times 8\\;\n\\text{bytes per sample} = 0.12\\; \\text{MB}$ plus metadata.\n\n",
      "summary": "Capture time-domain IQ samples at the following 1 frequencies: 782.00 MHz."
    },
    "ntia-scos:schedule": {
      "id": "UplinkIQ",
      "name": "UplinkIQ",
      "priority": 10,
      "start": "2020-02-13T16:11:33.000Z"
    },
    "ntia-location:coordinate_system": {
      "coordinate_system_type": "GeographicCoordinateSystem",
      "id": "WGS 1984",
      "distance_unit": "decimal degrees",
      "time_unit": "seconds"
    },
    "ntia-sensor:calibration_datetime": "2019-09-20T02:03:38.967Z",
    "ntia-scos:task": 1,
    "ntia-core:measurement": {
      "domain": "Time",
      "measurement_type": "single-frequency",
      "time_start": "2020-02-13T16:11:33.056Z",
      "time_stop": "2020-02-13T16:11:34.489Z",
      "frequency_tuned_low": 7.819999999999987E8,
      "frequency_tuned_high": 7.819999999999987E8
    }
  },
  "captures": [
    {
      "core:sample_start": 0,
      "core:frequency": 7.819999999999987E8,
      "core:datetime": "2020-02-13T16:11:33.063Z"
    }
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "CalibrationAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 15360000,
      "ntia-sensor:gain_sigan": 42.216536890181075,
      "ntia-sensor:noise_figure_sigan": 10.758181371190176,
      "ntia-sensor:enbw_sigan": 1.4404E7,
      "ntia-sensor:gain_preselector": -3.7534963834226445,
      "ntia-sensor:noise_figure_sensor": 14.274708903291103,
      "ntia-sensor:1db_compression_point_sensor": -26.21585482304364,
      "ntia-sensor:enbw_sensor": 1.351434420534668E7,
      "ntia-sensor:1db_compression_point_sigan": -29.94803239760001
    },
    {
      "ntia-core:annotation_type": "TimeDomainDetection",
      "core:sample_start": 0,
      "core:sample_count": 15360000,
      "ntia-algorithm:detector": "sample_iq",
      "ntia-algorithm:units": "volts",
      "ntia-algorithm:number_of_samples": 15360000
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 15360000,
      "ntia-sensor:overload": false,
      "ntia-sensor:gain_setting_sigan": 40.0
    }
  ]
}
```

### 4.3 Single-frequency FrequencyDomainDetection  Example
```json
{
  "id": "5e419a556524c8661b35f915",
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 1.5360000011967678E7,
    "core:version": "0.0.2",
    "core:sha512": "9eb4d244a563b737fbe0bf42e6749d3a9a29fef1b703e68cfac2262837e54f3e7d4e0ae1156b68070202f062900fb6cf678f82dff03f0605d7dc3a7b7b285255",
    "core:extensions" : {
      "ntia-algorithm" : "v1.0.0",
      "ntia-sensor" : "v1.0.0",
      "ntia-location" : "v1.0.0"
    },
    "ntia-sensor:sensor": {
      "id": "greyhound3.sms.internal",
      "sensor_spec": {
        "id": "",
        "model": "greyhound"
      },
      "antenna": {
        "antenna_spec": {
          "id": "",
          "model": "L-com HG3512UP-NF"
        }
      },
      "signal_analyzer": {
        "sigan_spec": {
          "id": "",
          "model": "Ettus USRP B210"
        },
        "a2d_bits": 0
      },
      "computer_spec": {
        "id": "",
        "model": "Intel NUC"
      },
      "location": {
        "x": -105.262262,
        "y": 39.99483
      }
    },
    "ntia-scos:action": {
      "name": "acquire_m4s_700MHz_Verizon_UL",
      "description": "Apply m4s detector over 300 1024-pt FFTs at 782.00 MHz.\n\n# acquire_m4s_700MHz_Verizon_UL\n\n## Radio setup and sample acquisition\n\nThis action first tunes the radio to 782.00 MHz and requests a sample\nrate of 15.36 Msps and 40 dB of gain.\n\nIt then begins acquiring, and discards an appropriate number of samples while\nthe radio's IQ balance algorithm runs. Then, $300 \\times 1024$\nsamples are acquired gap-free.\n\n## Time-domain processing\n\nFirst, the $300 \\times 1024$ continuous samples are acquired from\nthe radio. If specified, a voltage scaling factor is applied to the complex\ntime-domain signals. Then, the data is reshaped into a $300 \\times\n1024$ matrix:\n\n$$\n\\begin{pmatrix}\na_{1,1}      & a_{1,2}     & \\cdots  & a_{1,fft\\_size}     \\\\\\\\\na_{2,1}      & a_{2,2}     & \\cdots  & a_{2,fft\\_size}     \\\\\\\\\n\\vdots         & \\vdots        & \\ddots  & \\vdots                \\\\\\\\\na_{nffts,1}  & a_{nfts,2}  & \\cdots  & a_{nfts,fft\\_size}  \\\\\\\\\n\\end{pmatrix}\n$$\n\nwhere $a_{i,j}$ is a complex time-domain sample.\n\nAt that point, a Flat Top window, defined as\n\n$$w(n) = &0.2156 - 0.4160 \\cos{(2 \\pi n / M)} + 0.2781 \\cos{(4 \\pi n / M)} -\n         &0.0836 \\cos{(6 \\pi n / M)} + 0.0069 \\cos{(8 \\pi n / M)}$$\n\nwhere $M = 1024$ is the number of points in the window, is applied to\neach row of the matrix.\n\n## Frequency-domain processing\n\nAfter windowing, the data matrix is converted into the frequency domain using\nan FFT, doing the equivalent of the DFT defined as\n\n$$A_k = \\sum_{m=0}^{n-1}\na_m \\exp\\left\\\\{-2\\pi i{mk \\over n}\\right\\\\} \\qquad k = 0,\\ldots,n-1$$\n\nThe data matrix is then converted to pseudo-power by taking the square of the\nmagnitude of each complex sample individually, allowing power statistics to be\ntaken.\n\n## Applying detector\n\nNext, the M4S (min, max, mean, median, and sample) detector is applied to the\ndata matrix. The input to the detector is a matrix of size $300 \\times\n1024$, and the output matrix is size $5 \\times 1024$, with the\nfirst row representing the min of each _column_, the second row representing\nthe _max_ of each column, and so \"sample\" detector simple chooses one of the\n300 FFTs at random.\n\n## Power conversion\n\nTo finish the power conversion, the samples are divided by the characteristic\nimpedance (50 ohms). The power is then referenced back to the RF power by\ndividing further by 2. The powers are normalized to the FFT bin width by\ndividing by the length of the FFT and converted to dBm. Finally, an FFT window\ncorrection factor is added to the powers given by\n\n$$ C_{win} = 20log \\left( \\frac{1}{ mean \\left( w(n) \\right) } \\right)\n\nThe resulting matrix is real-valued, 32-bit floats representing dBm.\n\n",
      "summary": "Apply m4s detector over 300 1024-pt FFTs at 782.00 MHz."
    },
    "ntia-scos:schedule": {
      "id": "Uplink_M4",
      "name": "Uplink_M4",
      "stop": "2020-02-10T18:01:37.000Z",
      "interval": 1,
      "priority": 10,
      "start": "2020-02-10T18:00:52.000Z"
    },
    "ntia-location:coordinate_system": {
      "coordinate_system_type": "GeographicCoordinateSystem",
      "id": "WGS 1984",
      "distance_unit": "decimal degrees",
      "time_unit": "seconds"
    },
    "ntia-sensor:calibration_datetime": "2019-09-20T02:03:38.967Z",
    "ntia-scos:task": 1,
    "ntia-core:measurement": {
      "domain": "Frequency",
      "measurement_type": "single-frequency",
      "time_start": "2020-02-10T18:00:52.066Z",
      "time_stop": "2020-02-10T18:00:52.212Z",
      "frequency_tuned_low": 7.819999999999987E8,
      "frequency_tuned_high": 7.819999999999987E8
    }
  },
  "captures": [
V    {
      "core:sample_start": 0,
      "core:frequency": 7.819999999999987E8,
      "core:datetime": "2020-02-10T18:00:52.067Z"
    }
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 0,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_min_power",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "flattop",
      "ntia-algorithm:equivalent_noise_bandwidth": 56609.1951747078,
      "ntia-algorithm:frequency_start": 7.743199999940149E8,
      "ntia-algorithm:frequency_stop": 7.896799500059825E8,
      "ntia-algorithm:frequency_step": 50.0
    },
    {
      "ntia-core:annotation_type": "CalibrationAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 5120,
      "ntia-sensor:gain_sigan": 42.216536890181075,
      "ntia-sensor:noise_figure_sigan": 10.758181371190176,
      "ntia-sensor:enbw_sigan": 1.4404E7,
      "ntia-sensor:gain_preselector": -3.7534963834226445,
      "ntia-sensor:noise_figure_sensor": 14.274708903291103,
      "ntia-sensor:1db_compression_point_sensor": -26.21585482304364,
      "ntia-sensor:enbw_sensor": 1.351434420534668E7,
      "ntia-sensor:1db_compression_point_sigan": -29.94803239760001
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 5120,
      "ntia-sensor:overload": false,
      "ntia-sensor:gain_setting_sigan": 40.0
    },
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 1024,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_max_power",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "flattop",
      "ntia-algorithm:equivalent_noise_bandwidth": 56609.1951747078,
      "ntia-algorithm:frequency_start": 7.743199999940149E8,
      "ntia-algorithm:frequency_stop": 7.896799500059825E8,
      "ntia-algorithm:frequency_step": 50.0
    },
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 2048,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_mean_power",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "flattop",
      "ntia-algorithm:equivalent_noise_bandwidth": 56609.1951747078,
      "ntia-algorithm:frequency_start": 7.743199999940149E8,
      "ntia-algorithm:frequency_stop": 7.896799500059825E8,
      "ntia-algorithm:frequency_step": 50.0
    },
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 3072,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_median_power",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "flattop",
      "ntia-algorithm:equivalent_noise_bandwidth": 56609.1951747078,
      "ntia-algorithm:frequency_start": 7.743199999940149E8,
      "ntia-algorithm:frequency_stop": 7.896799500059825E8,
      "ntia-algorithm:frequency_step": 50.0
    },
    {
      "ntia-core:annotation_type": "FrequencyDomainDetection",
      "core:sample_start": 4096,
      "core:sample_count": 1024,
      "ntia-algorithm:detector": "fft_sample_power",
      "ntia-algorithm:units": "dBm",
      "ntia-algorithm:number_of_ffts": 300,
      "ntia-algorithm:number_of_samples_in_fft": 1024,
      "ntia-algorithm:window": "flattop",
      "ntia-algorithm:equivalent_noise_bandwidth": 56609.1951747078,
      "ntia-algorithm:frequency_start": 7.743199999940149E8,
      "ntia-algorithm:frequency_stop": 7.896799500059825E8,
      "ntia-algorithm:frequency_step": 50.0
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
