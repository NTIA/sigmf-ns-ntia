# ntia-waveform Extension v1.0.0

The `ntia-waveform` namespace provides models and parameters for textbook and standardized complex-baseband waveforms. The intention is to build a library of simulated waveforms for testing and training signal identification algorithms. The waveform library can also be used for signal generation purposes in system level interference tests.

`ntia-waveform` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global

`ntia-waveform` does not directly extend the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object). `ntia-waveform` defines a waveform object and additional extensions of the waveform object.  The waveform objects may be utilized within the `emitter` object provided by [ntia-emitter](ntia-emitter.sigmf-ext.md).

### 1.1 Waveform Object

The waveform object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`model`|true|string|N/A|The type of the waveform E.g. `"IEEE80211p"`.|
|`description`|false|string|N/A|Description of the waveform.|

### 1.2 IEEE80211p Object

IEEE 802.11p is an approved amendment to the IEEE 802.11 standard that adds wireless access in vehicular environments (WAVE), a vehicular communication system. It defines enhancements to 802.11 (the basis of products marketed as Wi-Fi) required to support Intelligent Transportation Systems (ITS) applications. This includes data exchange between high-speed vehicles and between the vehicles and the roadside infrastructure, so called V2X communication, in the licensed ITS band of 5.9 GHz (5.85-5.925 GHz).

`IEEE80211p` extends Waveform with the following additional properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`info_bit_generation`|false|string|N/A|Model that defines information bit generation. E.g. `"PN"`.|
|`coding_rate`|false|integer[]|bits|An integer[] of length 2 of the form [k, n] that describes an encoder that generates n bits of data for every k bits of useful information.|
|`packet_length`|false|integer|bits|Packet length.|
|`modulation`|false|string|N/A|Modulation, e.g., `"BPSK"`, `"QPSK"`, `"16QAM"`, `"64QAM"`.|
|`encoder`|false|string|N/A|Description of encoder. E.g. `"Convolutional"`.|
|`number_of_subcarriers`|false|integer|N/A|Number of subcarriers.|
|`number_of_data_subcarriers`|false|integer|N/A|Number of data subcarriers.|
|`number_of_pilots`|false|integer|N/A|Number of pilots.|
|`cyclic_prefix`|false|integer|bits|Size of cyclic prefix.|
|`short_inter_frame_space`|false|float|microseconds|Time required to process a received frame and to respond with a response frame.|
|`preamble_frame`|false|integer[]|N/A|Preamble of 0's and 1's used for synchronization and to ID beginning of frame.|
|`number_of_info_bits`|false|integer|N/A|Number of information bits.|
|`signal_to_noise_ratio`|false|float|dB|Signal-to-noise ratio. If unspecified, assumed no noise present.|

## 2 Captures

`ntia-waveform` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations

`ntia-waveform` does not extend [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array)..

## 4 Example

```json
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "ntia-emitter:emitters" : [ {
      "id" : "test80211pEmitter",
      "description" : "Simulated IEEE 802.11p",
      "waveform" : {
        "model" : "IEEE80211p",
        "info_bit_generation" : "random",
        "coding_rate" : [ 1, 2 ],
        "packet_length" : 3200,
        "modulation" : "16QAM",
        "encoder" : "convolutional",
        "number_of_subcarriers" : 64,
        "number_of_data_subcarriers" : 48,
        "number_of_pilots" : 4,
        "short_inter_frame_space" : 80000.0
      }
    } ]
  } ... ,
  "captures" : [ ... ],
  "annotations" : [... ]
}
```
