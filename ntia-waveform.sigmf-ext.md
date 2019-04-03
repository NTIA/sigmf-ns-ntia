# ntia-waveform Extension v1.0.0
The ntia-waveform namespace provides models and parameters for textbook and standardized complex-baseband waveforms. The intention is to build a library of simulated waveforms for testing and training signal identification algorithms. The waveform library can also be used for signal generation purposes in system level interference tests.   

`ntia-waveform` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-waveform` extends the [Global object](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`waveform_model`|true|object|N/A|Waveform model and parameters. E.g. [IEEE80211p Object](#31-ieee80211p-object).|

### 3.1 IEEE80211p Object
IEEE 802.11p is an approved amendment to the IEEE 802.11 standard that adds wireless access in vehicular environments (WAVE), a vehicular communication system. It defines enhancements to 802.11 (the basis of products marketed as Wi-Fi) required to support Intelligent Transportation Systems (ITS) applications. This includes data exchange between high-speed vehicles and between the vehicles and the roadside infrastructure, so called V2X communication, in the licensed ITS band of 5.9 GHz (5.85-5.925 GHz). 

`IEEE80211p` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`waveform_name`|true|string|N/A|Waveform name, i.e., `"IEEE 802.11p"`.|
|`info_bit_generation`|false|string|N/A|Model that defines information bit generation. E.g. `"PN"`.|
|`coding_rate`|false|array [k, n]|bits|For every k bits of useful information the coder generates n bits of data. E.g. [1, 2], [2, 3], [3, 4].|
|`packet_length`|false|integer|bits|Packet length.|
|`modulation`|false|string|N/A|Modulation, e.g., `"BPSK"`, `"QPSK"`, `"16QAM"`, `"64QAM"`.|
|`encoder`|false|string|N/A|Description of encoder. E.g. `"Convolutional"`.|
|`number_of_subcarriers`|false|integer|N/A|Number of subcarriers.|
|`number_of_data_subcarriers`|false|integer|N/A|Number of data subcarriers.|
|`number_of_pilots`|false|integer|N/A|Number of pilots.|
|`cyclic_prefix`|false|integer|bits|Size of cyclic prefix.|
|`short_inter_frame_space`|false|float|microseconds|Time required to process a received frame and to respond with a response frame.|
|`preamble_frame`|false|array|N/A|Preamble of 0's and 1's used for synchronization and id beginning of frame.|
|`number_of_info_bits`|false|integer|N/A|Number of information bits.|
|`signal_to_noise_ratio`|false|float|dB|Signal-to-noise ratio. If unspecified, assumed no noise present.|

## 2 Captures
`ntia-waveform` does not provide additional keys to `Captures`.

## 3 Annotations
`ntia-waveform` does not provide additional segments to extend `ntia-core`.

## 4 Example
[TODO] Provide and example of `ntia-waveform`