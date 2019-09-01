# ntia-sensor extension v1.0.0
The ntia-sensor namespace provides metadata to describe RF sensors. 

`ntia-sensor` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-sensor` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor`|false|[Sensor](#11-sensor-object)|N/A|Describes the sensor model components. This object is RECOMMENDED.|
|`calibration_datetime`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Time of last calibration. RECOMMENDED.|

### 1.1 Sensor Object
Sensor definition follows a simplified hardware model comprised of the following elements: Antenna, Preselector, Receiver, and Host Controller. The antenna converts electromagnetic energy to a voltage. The preselector can provide local calibration signals, RF filtering to protect from strong out-of-band signals, and low-noise amplification to improve sensitivity. The receiver (e.g., software defined radio) provides tuning, down conversion, sampling, and digital signal processing. Sensor implementations are not required to have each component, but metadata SHOULD specify the presence, model numbers, and operational parameters associated with each.

`Sensor` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique name for the sensor.|
|`antenna`|true|[Antenna](ntia-core.sigmf-ext.md#antenna) |N/A|Metadata that describes the sensor's antenna.|
|`preselector`|false| [Preselector](#13-preselector-object) |N/A|Metadata to describe the preselector.|
|`receiver`|true| [Receiver](#12-receiver-object) |N/A|Metadata to describe the receiver.|
|`host_controller`|false|string|N/A|Description of host computer. E.g. Make, model, and configuration.|
|`mobile`|false|boolean|N/A|Defines if the sensor is mobile.|
|`latitude`|false|double|decimal degrees|Latitude.|
|`longitude`|false|double|decimal degrees|Longitude.|
|`altitude`|false|double|meters|Height above mean sea level.|
|`speed`|false|double|m/s|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to true North).|
|`gps_nmea`|false|string|NMEA|[NMEA message](https://en.wikipedia.org/wiki/NMEA_0183) from gps receiver.|

### 1.2 Receiver Object
`Receiver` the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`model`|true|string|N/A|Make and model of the receiver. E.g., `"Ettus N210"`, `"Ettus B200"`, `"Keysight N6841A"`, `"Tektronix B206B"`.|
|`low_frequency`|false|double|Hz|Low frequency of operational range of the receiver.|
|`high_frequency`|false|double|Hz|High frequency of operational range of the receiver.|
|`noise_figure`|false|double|dB|Noise figure of the receiver.|
|`max_power`|false|double|dBm|Maximum input power of the receiver.|
|`a2d_bits`|false|int|bits|Number of bits in A/D converter.|

### 1.3 Preselector Object
`Preselector` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_paths`|false| Array of [RFPath](#14-rfpath-object)|N/A|Metadata that describes preselector RF paths.|

### 1.4 RFPath Object
`RFPath` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`low_frequency_passband`|false|double|Hz|Low frequency of filter 1-dB passband.|
|`high_frequency_passband`|false|double|Hz|High frequency of filter 1-dB passband.|
|`low_frequency_stopband`|false|double|Hz|Low frequency of filter 60-dB stopband.|
|`high_frequency_stopband`|false|double|Hz|High frequency of filter 60-dB stopband.|
|`lna_gain`|false|double|dB|Gain of low noise amplifier.|
|`lna_noise_figure`|false|double|dB|Noise figure of low noise amplifier.|
|`cal_source_type`|false|string|N/A|E.g., `"calibrated noise source"`.|

## 2 Captures
`ntia-sensor` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-sensor` defines the following segments that extend `ntia-core`.

### 3.1 SensorAnnotation Segment
`SensorAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`rf_path_index`|false|integer|N/A|Index of the [RFPath](#14-rfpath-object) object.|
|`overload_flag`|false|boolean|N/A|Flag indicator of system signal overload.|
|`receiver_attenuation`|false|double|dB|Attenuation of the receiver.|
|`altitude`|false|double|meters|Height above mean sea level.|
|`speed`|false|double|m/s|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to true North).|
|`gps_nmea`|false|string|NMEA|[NMEA message](https://en.wikipedia.org/wiki/NMEA_0183) from gps receiver.|

### 3.2 CalibrationAnnotation Segment
`CalibrationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`scaling_factor_sigan`|false|double|N/A|Factor that converts signal analyzer A/D output to volts.|
|`noise_figure_sigan`|false|double|dB|Noise figure of signal analyzer.|
|`1db_compression_point_sigan`|false|double|dBm|Maximum input of signal analyzer.|
|`enbw_sigan`|false|double|Hz|Equivalent noise bandwidth of signal analyzer.|
|`gain_sensor`|false|double|dB|Gain of sensor.|
|`noise_figure_sensor`|false|double|dB|Noise figure of sensor.|
|`1db_compression_point_sensor`|false|double|dBm|Maximum input of sensor.|
|`mean_noise_power_sensor`|false|double|dBm/Hz|Mean noise power density of sensor.|

## 4 Example

### 4.1 Sensor Global Object Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-core:antenna": {
        "model": "model_X",
        "type": "omnidirectional",
        "low_frequency": 300000000,
        "high_frequency": 3000000000,
        "gain": 2,
        "cross_polar_discrimination": 9.1,
        "cable_loss": 1,
        "azimuth_angle": 45,
        "elevation_angle": 10.3
      },
      "preselector": {
        "rf_paths": [
          {
            "low_frequency_passband": 700000000,
            "high_frequency_passband": 750000000,
            "low_frequency_stopband": 700000000,
            "high_frequency_stopband": 750000000,
            "lna_noise_figure": 2.5,
            "cal_source_type": "calibrated noise source"
          }
        ]
      },
      "receiver": {
        "model": "Receiver 123xyz",
        "low_frequency": 300000000,
        "high_frequency": 3000000000,
        "noise_figure": 2,
        "max_power": -5,
        "a2d_bits": 256
      },
      "host_controller": "Host Controller 123"
    },
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
```

### 4.2 SensorAnnotation Example
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
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 100,
      "core:latitude": 40.5,
      "core:longitude": -105
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 100,
      "core:sample_count": 100,
      "core:latitude": 40.56,
      "core:longitude": -105.03
    }
  ]
}
```
