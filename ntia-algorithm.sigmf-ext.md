# ntia-algorithm Extension v1.0.0
The ntia-algorithm namespace defines additional metadata elements useful in describing algorithms that have been applied to measurements. 

## 2. Conventions Used in this Document

The SCOS specification uses and is fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces), the specification is enhanced through the implementation of a `ntia-algorithm` namespace, the details of which follow.  

## 3. Global
The ntia-algorithm namespace does not provide any additional keys for the global object. 

## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-algorithm` namespace does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. Each SigMF annotation segment object must contain a `core:sample_start` name/value pair, which indicates the first index at which the rest of the segment's name/value pairs apply. The `ntia-algorithm` extension defines two additonal annotation segment types:  `TimeDomainDetection` and  `FrequencyDomainDetection` segments.

### 5.1 TimeDomainDetection annotation segments
Time-domain detection algorithms are applied to IQ time series captured at a single frequency. The `TimeDomainDetection` annotation segments contains the following name/value pairs:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|E.g. `"sample_power"`, `"mean_power"`, `"max_power"`, `"min_power"`, `"median_power"`, `"m4s_power"`.|
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"time"`.|
|`number_of_samples`|true|integer|N/A|Number of samples to be integrated over by detector.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|

### 5.2 FrequencyDomainDetection annotation segments
Frequency-domain detection algorithms are applied to discrete Fourier transforms of IQ time series captured at a single frequency. The `FrequencyDomainDetection` annotation segments contain the following name/value pairs in addition to the name/value pairs required of all annotation segments:  
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`detector`|true|string|N/A|E.g. `"fft_sample_iq"`, `"fft_sample_power"`, `"fft_mean_power"`, `"fft_max_power"`, `"fft_min_power"`, `"fft_median_power"`.|
|`detection_domain`|true|string|N/A|Domain in which detector is applied, i.e., `"frequency"`.|
|`number_of_ffts`|true|integer|N/A|Number of FFTs to be integrated over by detector.|
|`units`|true|string|N/A|Data units, e.g., `"dBm"`, `"watts"`, `"volts"`.|
|`reference`|false|string|N/A|Data reference point, e.g., `"receiver input"`, `"antenna output"`, `"output of isotropic antenna"`.|
|`number_of_samples_in_fft`|true|integer|N/A|Number of samples in FFT to calcluate delta_f = [`samplerate`](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object)/`number_of_samples_in_fft`.|
|`window`|true|string|N/A|E.g. `"blackman-harris"`, `"flattop"`, `"gaussian_a3.5"`, `"gauss top"`, `"hamming"`, `"hanning"`, `"rectangular"`.|
|`equivalent_noise_bandwidth`|false|double|Hz|Bandwidth of brickwall filter that has same integrated noise power as that of the actual filter.|

