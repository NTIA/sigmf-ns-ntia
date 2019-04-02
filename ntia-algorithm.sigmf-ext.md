# ntia-algorithm Extension v1.0.0
The ntia-algorithm namespace describes algorithms applied to measurements. 

`ntia-algorithm` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-algorithm` does not add additional keys to `Global`. 

## 2 Captures
`ntia-algorithm` does not add addional keys to `Captures`.

## 3 Annotations
`ntia-algorithm` defines the following segments that extend the [Annotation segment object](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).

### 3.1 TimeDomainDetection annotation segments
Time-domain detection algorithms are applied to gap-free IQ time series captured at a single frequency. The `TimeDomainDetection` annotation segments contains the following name/value pairs:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`type`|true|string|N/A|Annotation segment type|
|`detector`|true|string|N/A|E.g. `"sample_power"`, `"mean_power"`, `"max_power"`, `"min_power"`, `"median_power"`, `"m4s_power"`.|
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"time"`.|
|`number_of_samples`|true|integer|N/A|Number of samples to be integrated over by detector.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

### 3.2 FrequencyDomainDetection annotation segments
Frequency-domain detection algorithms are applied to discrete Fourier transforms of gap-free IQ time series captured at a single frequency. The `FrequencyDomainDetection` annotation segments contain the following name/value pairs:  
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`type`|true|string|N/A|Annotation segment type|
|`detector`|true|string|N/A|E.g. `"fft_sample_iq"`, `"fft_sample_power"`, `"fft_mean_power"`, `"fft_max_power"`, `"fft_min_power"`, `"fft_median_power"`.|
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"frequency"`.|
|`number_of_ffts`|true|integer|N/A|Number of FFTs to be integrated over by detector.|
|`number_of_samples_in_fft`|true|integer|N/A|Number of samples in FFT to calcluate delta_f = [`samplerate`](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object)/`number_of_samples_in_fft`.|
|`window`|true|string|N/A|E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.|
|`equivalent_noise_bandwidth`|false|double|Hz|Bandwidth of brickwall filter that has same integrated noise power as that of the actual filter.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

## 4 Example
[TODO] Provide and example of `ntia-algoritm`

