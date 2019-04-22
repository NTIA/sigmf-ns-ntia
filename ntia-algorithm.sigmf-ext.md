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
|`FIR_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`IIR_numerator_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`IIR_denominator_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`frequency_cutoff`|false|double|Hz|Frequency at which the magnitude response decreases (from its maximum) by `attenuation_cutoff`.|
|`attenuation_cutoff`|false|double|dB|Magnitude response threshold (below maximum) that specifies `frequency_cutoff`.|
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
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"time"`.|
|`number_of_samples`|true|integer|N/A|Number of samples to be integrated over by detector.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

### 3.2 FrequencyDomainDetection Segment
Frequency-domain detection algorithms are applied to discrete Fourier transforms of gap-free IQ time series captured at a single frequency. The `FrequencyDomainDetection` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|E.g. `"fft_sample_iq"`, `"fft_sample_power"`, `"fft_mean_power"`, `"fft_max_power"`, `"fft_min_power"`, `"fft_median_power"`.|
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"frequency"`.|
|`number_of_ffts`|true|integer|N/A|Number of FFTs to be integrated over by detector.|
|`number_of_samples_in_fft`|true|integer|N/A|Number of samples in FFT to calcluate delta_f = [`samplerate`](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object)/`number_of_samples_in_fft`.|
|`window`|true|string|N/A|E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.|
|`equivalent_noise_bandwidth`|false|double|Hz|Bandwidth of brickwall filter that has same integrated noise power as that of the actual filter.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

### 3.3 DigitalFilterAnnotation Segment
`DigitalFilterAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`filter_type`|false|string|N/A|Description of digital filter, e.g., `"FIR"`, `"IIR"`|
|`FIR_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`IIR_numerator_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`IIR_denominator_coefficients`|false|array of doubles|N/A|Coefficients that defines FIR filter.|
|`frequency_cutoff`|false|double|Hz|Frequency at which the magnitude response decreases (from its maximum) by `attenuation_cutoff`.|
|`attenuation_cutoff`|false|double|dB|Magnitude response threshold (below maximum) that specifies `frequency_cutoff`.|
|`ripple_passband`|false|double|dB|Ripple in passband.|
|`attenuation_stopband`|false|double|dB|Attenuation of stopband.|
|`frequency_stopband`|false|double|Hz|Point in filter frequency response where stopband starts.|

## 4 Example
[TODO] Provide and example of `ntia-algoritm`
