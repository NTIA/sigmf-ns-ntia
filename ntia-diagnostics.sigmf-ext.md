# The `ntia-diagnostics` SigMF Extension Namespace v1.0.0

The `ntia-diagnostics` namespace provides metadata to describe system diagnostic information.

`ntia-diagnostics` is fully compliant with the [SigMF](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global

`ntia-sensor` extends the [Global](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#global-object) with the following name/value pairs:

| name                   |required| type                                  |unit| description                                   |
|------------------------|--------------|---------------------------------------|-------|-----------------------------------------------|
| `diagnostics`          |false| [Diagnostics](#11-diagnostics-object) |N/A| Metadata for capturing component diagnostics. |

### 1.1 Diagnostics Object

`Diagnostics` has the following properties:

| name             |required| type                                              | unit    | description                                                                         |
|------------------|--------------|---------------------------------------------------|---------|-------------------------------------------------------------------------------------|
| `datetime`       |false| string                                            |[ISO-8601](https://www.ietf.org/rfc/rfc3339.txt) with UTC `time_offset`, i.e., `YYYY-MM-DDTHH:MM:SS.SSSZ` with any number of digits for fractional seconds.| The time at which the diagnostics were gathered. |
| `preselector`    |false| [Preselector](#12-preselector-diagnostics-object) | N/A     | Metadata to capture preselector diagnostics.                                        |
| `spu`            |false| [SPU](#13-spu-diagnostics-object)                 | N/A     | Metadata to capture sensor processing unit diagnostics.                             |
| `computer`       |false| [CPU](#14-computer-diagnostics-object)            | N/A     | Metadata to capture computer diagnostics.                                           |
| `action_runtime` |false| double                                            | seconds | Total action execution time.                                                        |

### 1.2 Preselector Diagnostics Object

The `Preselector` diagnostics object has the following properties:

| name                   |required| type                                  | unit           | description                                                     |
|------------------------|--------------|---------------------------------------|----------------|-----------------------------------------------------------------|
|`internal_temp`|false|double| degree Celsius | Temperature inside the preselector enclosure.                   |
|`noise_diode_temp`|false|double| degree Celsius | Temperature of the noise diode.                                 |
|`lna_temp`|false|double| degree Celsius | Temperature of the low noise amplifier.                         |
|`humidity`|false|double| percent        | Relative humidity inside the preselector enclosure.             |
|`door_closed`|false|boolean| N/A            | Boolean indicating whether the door of the enclosure is closed. |

### 1.3 SPU Diagnostics Object

The `SPU` diagnostics object has the following properties:

| name                  |required| type    | unit           | description                                              |
|-----------------------|--------------|---------|----------------|----------------------------------------------------------|
| `rf_tray_powered`     |false| boolean | N/A            | Boolean indicating if the RF tray is powered.            |
| `preselector_powered` |false| boolean | N/A            | Boolean indicating if the preselector is powered.        |
| `28v_aux_powered`     |false| boolean | N/A            | Boolean indicating if the 28 volt auxillary power is on. |
| `pwr_box_temp`        |false| double  | degree Celsius | Ambiant temperature at power distribution.               |
| `pwr_box_humidity`    |false| double  | percent        | Humidity at power distribution.                          |
| `rf_box_temp`         |false| double  | degree Celsius | Ambiant temperature around the signal analyzer.          |
| `sigan_internal_temp` |false| double  | degree Celsius | Internal temperature reported by the signal analyzer     |

### 1.4 Computer Diagnostics Object

The `Computer` diagnostics object has the following properties:

| name               |required| type                            | unit           | description                                                                                             |
|--------------------|--------------|---------------------------------|----------------|---------------------------------------------------------------------------------------------------------|
| `min_clock_speed`  |false| double                          | MHz            | Minimum sampled clock speed.                                                                            |
| `max_clock_speed`  |false| double                          | MHz            | Maximum sampled clock speed.                                                                            |
| `mean_clock_speed` |false| double                          | MHz            | Mean sampled clock speed.                                                                               |
| `boot_time`        |false| string                          |[ISO-8601](https://www.ietf.org/rfc/rfc3339.txt) with UTC `time_offset`, i.e., `YYYY-MM-DDTHH:MM:SS.SSSZ` with any number of digits for fractional seconds.| The time at which the computer last started.                        |
| `cpu_usage`        |false| double                          | percent        | CPU utilization during action execution.                                                                |
| `load_5m`          |false| double                          | percent        | Number of processes in a runnable state over the previous 5 minutes as a percent of the number of CPUs. |
| `memory_usage`     |false| double                          | percent        | Percent of memory used at the end of action execution.                                                  |
| `overheating`      |false| boolean                         | N/A            | True if cpu is overheating.                                                                             |
| `drive_usage`      |false| double                          | percent        | Percent of persistent storage used.                                                                     |
| `temp`             |false| double                          | degree Celsius | Computer temperature.                                                                                   |
| `scos_start`       |false| string                          |[ISO-8601](https://www.ietf.org/rfc/rfc3339.txt) with UTC `time_offset`, i.e., `YYYY-MM-DDTHH:MM:SS.SSSZ` with any number of digits for fractional seconds.| The time at which the SCOS API container started.                   |
| `scos_uptime`      |false| double                          | days           | Number of days since the scos api container started.                                                    |
| `ssd_smart_data`   |false| [SsdSmartData](15-ssdsmartdata) | days           | Information provided by the drive Self-Monitoring, Analysis, and Reporting Technology.                  |

### 1.5 SsdSmartData

The `SsdSmartData` diagnostics object has the following properties:

| name                        |required| type    | unit           | description                                                                                                                                                                                                                                                                                                                                                                                           |
|-----------------------------|--------------|---------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `test_passed`               |false| boolean | N/A            | SMART overall-health self-assessment test result.                                                                                                                                                                                                                                                                                                                                                     |
| `critical_warning`          |false| int     | N/A            | Critical warnings from smartctl.                                                                                                                                                                                                                                                                                                                                                                      |
| `temp`                      |false| double  | degree Celsius | Drive temperature.                                                                                                                                                                                                                                                                                                                                                                                    |
| `available_spare`           |false| double  | percent        | Normalized percentage (0 to 100%) of the remaining spare capacity available.                                                                                                                                                                                                                                                                                                                          |
| `available_spare_threshold` |false| double  | days           | When the available_spare falls below the threshold indicated in this field, an asynchronous event completion may occur. The value is indicated as a normalized percentage (0 to 100%).                                                                                                                                                                                                                |
| `percentage_used`           |false| double  | percent        | Contains a vendor specific estimate of the percentage of NVM subsystem life used based on the actual usage and the manufacturer’s prediction of NVM life. A value of 100 indicates that the estimated endurance of the NVM in the NVM subsystem has been consumed, but may not indicate an NVM subsystem failure. Values may exceed 100 and percentages greater than 254 shall be represented as 255. |
| `unsafe_shutdowns`          |false| int     | N/A            | Number of unsafe shutdowns.                                                                                                                                                                                                                                                                                                                                                                           |
| `integrity_errors`          |false| int     | N/A            | Number of occurrences where the controller detected an unrecovered data integrity error                                                                                                                                                                                                                                                                                                               |

## 2 Captures

`ntia-diagnostics` does not provide additional keys to [Captures](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#captures-array).

## 3 Annotations

`ntia-diagnostics` does not extend [Annotations](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#annotations-array).

## 4 Example

### 4.1 Diagnostics example

```json
{
  "global": {
    "core:version": "v1.0.0",
    "core:extensions": [
      {
        "name": "ntia-diagnostics",
        "version": "v1.0.0",
        "optional": false
      }
    ],
    "core:datatype": "rf16",
    "core:sample_rate": 14000000.0,
    "core:num_channels": 15,
    "ntia-diagnostics:diagnostics": {
      "datetime": "2023-04-06T21:31:39.356Z",
      "preselector": {
        "noise_diode_temp": 22.7,
        "door_closed": false
      },
      "spu": {
        "rf_tray_powered": true,
        "preselector_powered": true,
        "28v_aux_powered": true,
        "pwr_box_temp": 26.0,
        "rf_box_temp": 26.1,
        "pwr_box_humidity": 11.2,
        "sigan_internal_temp": 54.44
      },
      "computer": {
        "cpu_temp": 59.0,
        "cpu_overheating": false,
        "cpu_uptime": 21.04,
        "cpu_max_clock": 4533.5,
        "cpu_min_clock": 1240.5,
        "cpu_mean_clock": 3222.1,
        "action_cpu_usage": 42.1,
        "system_load_5m": 18.1,
        "memory_usage": 14.9,
        "scos_start_time": "2023-04-06T21:28:45.532Z",
        "scos_uptime": 0.002,
        "ssd_smart_data": {
          "test_passed": true,
          "critical_warning": "0x00",
          "temp": 35,
          "available_spare": 100,
          "available_spare_threshold": 10,
          "percentage_used": 1,
          "unsafe_shutdowns": 18,
          "integrity_errors": 0
        }
      },
      "action_runtime": 81.8970819178503
    }
  },
  "captures": [
    ...
  ],
  "annotations": []
}
```
