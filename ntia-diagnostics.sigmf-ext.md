# The `ntia-diagnostics` SigMF Extension Namespace v1.0.0

This document defines the `ntia-diagnostics` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace provides metadata to describe system diagnostic information.

## 0 Datatypes

The `ntia-diagnostics` extension defines the following datatypes:

|name|long-form name|description|
|----|--------------|-----------|
|`Diagnostics`|general diagnostics information|JSON [Diagnostics](#01-the-diagnostics-object) object containing general diagnostics information and sub-objects with diagnostics from specific components|
|`Preselector`|preselector diagnostics|JSON [Preselector](#02-the-preselector-diagnostics-object) object containing diagnostics for a preselector|
|`SPU`|signal processing unit diagnostics|JSON [SPU](#03-the-spu-diagnostics-object) object containing diagnostics for a signal processing unit|
|`Computer`|computer diagnostics|JSON [Computer](#04-the-computer-diagnostics-object) object containing diagnostics for a computer which runs SCOS|
|`SsdSmartData`|solid-state drive SMART diagnostics|JSON [SsdSmartData](#05-the-ssdsmartdata-diagnostics-object) object containing results of SMART diagnostics for an SSD|

Multiple key/value pairs in the objects defined by this extension MUST be ISO-8601 strings, as defined by [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt), where the only allowed `time-offset` is `z`, indicating the UTC/Zulu timezone. Thus, timestamps take the form of `YYYY-MM-DDTHH:MM:SS.SSSZ`, where any number of digits for fractional seconds is permitted.

### 0.1 The `Diagnostics` Object

`Diagnostics` has the following properties:

| name             |required| type                                                  | unit    | description                                                                         |
|------------------|--------------|-------------------------------------------------------|---------|-------------------------------------------------------------------------------------|
| `datetime`       |false| string                                                |ISO-8601 (see above)| The time at which the diagnostics were gathered. |
| `preselector`    |false| [Preselector](#02-the-preselector-diagnostics-object) | N/A     | Metadata to capture preselector diagnostics.                                        |
| `spu`            |false| [SPU](#03-the-spu-diagnostics-object)                 | N/A     | Metadata to capture signal processing unit diagnostics.                             |
| `computer`       |false| [Computer](#04-the-computer-diagnostics-object)       | N/A     | Metadata to capture computer diagnostics.                                           |
| `action_runtime` |false| double                                                | seconds | Total action execution time.                                                        |

### 0.2 The `Preselector` Diagnostics Object

The `Preselector` diagnostics object has the following properties:

| name                   |required| type                                  | unit           | description                                                     |
|------------------------|--------------|---------------------------------------|----------------|-----------------------------------------------------------------|
|`temp`|false|double| degree Celsius | Temperature inside the preselector enclosure.                   |
|`noise_diode_temp`|false|double| degree Celsius | Temperature of the noise diode.                                 |
|`lna_temp`|false|double| degree Celsius | Temperature of the low noise amplifier.                         |
|`humidity`|false|double| percent        | Relative humidity inside the preselector enclosure.             |
|`door_closed`|false|boolean| N/A            | Boolean indicating whether the door of the enclosure is closed. |

### 0.3 The `SPU` Diagnostics Object

The `SPU` diagnostics object has the following properties, which are defined based on the components of an SPU in a NASCTN SEA Prototype Rev3 sensor:

| name                  |required| type    | unit           | description                                              |
|-----------------------|--------------|---------|----------------|----------------------------------------------------------|
| `rf_tray_powered`     |false| boolean | N/A            | Boolean indicating if the RF tray is powered.            |
| `preselector_powered` |false| boolean | N/A            | Boolean indicating if the preselector is powered.        |
| `28v_aux_powered`     |false| boolean | N/A            | Boolean indicating if the 28 volt auxillary power is on. |
| `pwr_box_temp`        |false| double  | degree Celsius | Ambient temperature at power distribution.               |
| `pwr_box_humidity`    |false| double  | percent        | Humidity at power distribution.                          |
| `rf_box_temp`         |false| double  | degree Celsius | Ambient temperature around the signal analyzer.          |
| `sigan_internal_temp` |false| double  | degree Celsius | Internal temperature reported by the signal analyzer     |

### 0.4 The `Computer` Diagnostics Object

The `Computer` diagnostics object has the following properties:

| name               |required| type                                                    | unit           | description                                                                                             |
|--------------------|--------------|---------------------------------------------------------|----------------|---------------------------------------------------------------------------------------------------------|
| `cpu_min_clock`  |false| double                                                  | MHz            | Minimum sampled clock speed.                                                                            |
| `cpu_max_clock`  |false| double                                                  | MHz            | Maximum sampled clock speed.                                                                            |
| `cpu_mean_clock` |false| double                                                  | MHz            | Mean sampled clock speed.                                                                               |
| `cpu_uptime`        |false| double                                                  |days| Number of days since the computer started                        |
| `action_cpu_usage`        |false| double                                                  | percent        | CPU utilization during action execution.                                                                |
| `system_load_5m`          |false| double                                                  | percent        | Number of processes in a runnable state over the previous 5 minutes as a percent of the number of CPUs. |
| `memory_usage`     |false| double                                                  | percent        | Average percent of memory used during action execution.                                                  |
| `cpu_overheating`      |false| boolean                                                 | N/A            | True if the CPU is overheating.                                                                             |
| `cpu_temp`             |false| double                                                  | degree Celsius | CPU temperature.                                                                                   |
| `scos_start`       |false| string                                                  |ISO-8601 (see above)| The time at which the SCOS API container started.                   |
| `scos_uptime`      |false| double                                                  | days           | Number of days since the SCOS API container started.                                                    |
| `ssd_smart_data`   |false| [SsdSmartData](#05-the-ssdsmartdata-diagnostics-object) | N/A           | Information provided by the drive Self-Monitoring, Analysis, and Reporting Technology.                  |

### 0.5 The `SsdSmartData` Diagnostics Object

The `SsdSmartData` diagnostics object has the following properties:

| name                        |required| type    | unit           | description                                                                                                                                                                                                                                                                                                                                                                                           |
|-----------------------------|--------------|---------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `test_passed`               |false| boolean | N/A            | SMART overall-health self-assessment test result.                                                                                                                                                                                                                                                                                                                                                     |
| `critical_warning`          |false| string     | N/A            | Critical warning message from smartctl, a string containing a hexadecimal value, e.g., `"0x00"`                                                                                                                                                                                                                                                                                                                                                                      |
| `temp`                      |false| double  | degree Celsius | Drive temperature.                                                                                                                                                                                                                                                                                                                                                                                    |
| `available_spare`           |false| double  | percent        | Normalized percentage (0 to 100%) of the remaining spare capacity available.                                                                                                                                                                                                                                                                                                                          |
| `available_spare_threshold` |false| double  | percent           | When the available_spare falls below the threshold indicated in this field, an asynchronous event completion may occur. The value is indicated as a normalized percentage (0 to 100%).                                                                                                                                                                                                                |
| `percentage_used`           |false| double  | percent        | Contains a vendor specific estimate of the percentage of NVM subsystem life used based on the actual usage and the manufacturer’s prediction of NVM life. A value of 100 indicates that the estimated endurance of the NVM in the NVM subsystem has been consumed, but may not indicate an NVM subsystem failure. Values may exceed 100 and percentages greater than 254 shall be represented as 255. |
| `unsafe_shutdowns`          |false| int     | N/A            | Number of unsafe shutdowns.                                                                                                                                                                                                                                                                                                                                                                           |
| `integrity_errors`          |false| int     | N/A            | Number of occurrences where the controller detected an unrecovered data integrity error                  |

## 1 Global

The `ntia-sensor` extension adds the following name/value pairs to the `global` SigMF object:

| name                   |required| type                                  |unit| description                                   |
|------------------------|--------------|---------------------------------------|-------|-----------------------------------------------|
| `diagnostics`          |false| [Diagnostics](#01-the-diagnostics-object) |N/A| Metadata for capturing component diagnostics. |

## 2 Captures

The `ntia-diagnostics` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-diagnostics` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-diagnostics` extension does not extend the `collection` SigMF object.

## 5 Example

```json
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:version" : "1.0.0",
    "core:num_channels" : 1,
    "core:extensions" : [ {
      "name" : "ntia-core",
      "version" : "v2.0.0",
      "optional" : false
    }, {
      "name" : "ntia-diagnostics",
      "version" : "v1.0.0",
      "optional" : false
    } ],
    "ntia-core:classification": "UNCLASSIFIED",
    "ntia-diagnostics:diagnostics" : {
      "computer" : {
        "cpu_max_clock" : 4800.0,
        "cpu_min_clock" : 1120.0,
        "cpu_mean_clock" : 3100.0,
        "action_cpu_usage" : 44.3,
        "system_load_5m" : 24.62,
        "memory_usage" : 23.8,
        "cpu_temp" : 67.0,
        "cpu_overheating" : false,
        "cpu_uptime" : 10.0,
        "scos_uptime" : 1.0,
        "scos_start_time" : "2023-05-31T19:39:34.399Z",
        "ssd_smart_data" : {
          "temp" : 41.0,
          "test_passed" : true,
          "critical_warning" : "0x00",
          "available_spare" : 100.0,
          "available_spare_threshold" : 10.0,
          "percentage_used" : 1.0,
          "unsafe_shutdowns" : 18,
          "integrity_errors" : 0
        }
      },
      "datetime" : "2023-05-31T19:39:34.378Z",
      "preselector" : {
        "temp" : 21.6,
        "humidity" : 65.0,
        "noise_diode_temp" : 21.8,
        "lna_temp" : 21.8,
        "door_closed" : true
      },
      "spu" : {
        "rf_tray_powered" : true,
        "preselector_powered" : true,
        "28v_aux_powered" : true,
        "pwr_box_temp" : 28.8,
        "rf_box_temp" : 31.4,
        "pwr_box_humidity" : 11.2,
        "sigan_internal_temp" : 50.0
      },
      "action_runtime" : 100.0
    }
  },
  ...
  "captures" : [ ... ],
  "annotations" : [ ... ]
}
```
