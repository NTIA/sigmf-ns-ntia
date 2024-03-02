# The `ntia-diagnostics` SigMF Extension Namespace v2.2.0

This document defines the `ntia-diagnostics` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace provides metadata to describe system diagnostic information.

## 0 Datatypes

The `ntia-diagnostics` extension defines the following datatypes:

| name               | long-form name                      | description                                                                                                                                                |
|--------------------|-------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Diagnostics`      | general diagnostics information     | JSON [Diagnostics](#01-the-diagnostics-object) object containing general diagnostics information and sub-objects with diagnostics from specific components |
| `Preselector`      | preselector diagnostics             | JSON [Preselector](#02-the-preselector-diagnostics-object) object containing diagnostics for a preselector                                                 |
| `SPU`              | signal processing unit diagnostics  | JSON [SPU](#03-the-spu-diagnostics-object) object containing diagnostics for a signal processing unit                                                      |
| `Computer`         | computer diagnostics                | JSON [Computer](#04-the-computer-diagnostics-object) object containing diagnostics for a computer                                                          |
| `Software`         | software versions                   | JSON [Software](#06-the-software-versions-object) object containing software version information                                                           |
| `SsdSmartData`     | solid-state drive SMART diagnostics | JSON [SsdSmartData](#05-the-ssdsmartdata-diagnostics-object) object containing results of SMART diagnostics for an SSD                                     |
| `ScosPlugin`       | SCOS plugins                        | JSON [ScosPlugin](#07-the-scos-plugin-object) object containing SCOS plugin names and versions                                                             |
| `DiagnosticSensor` | Diagnostic sensor                   | JSON [DiagnosticSensor](#08-the-diagnostic-sensor-object) object describing a temperature sensor                                                           |

Multiple key/value pairs in the objects defined by this extension MUST be ISO-8601 strings, as defined by [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt), where the only allowed `time-offset` is `z`, indicating the UTC/Zulu timezone. Thus, timestamps take the form of `YYYY-MM-DDTHH:MM:SS.SSSZ`, where any number of digits for fractional seconds is permitted.

### 0.1 The `Diagnostics` Object

`Diagnostics` has the following properties:

| name             | required | type                                                  | unit                 | description                                             |
|------------------|----------|-------------------------------------------------------|----------------------|---------------------------------------------------------|
| `datetime`       | false    | string                                                | ISO-8601 (see above) | The time at which the diagnostics were gathered.        |
| `preselector`    | false    | [Preselector](#02-the-preselector-diagnostics-object) | N/A                  | Metadata to capture preselector diagnostics.            |
| `spu`            | false    | [SPU](#03-the-spu-diagnostics-object)                 | N/A                  | Metadata to capture signal processing unit diagnostics. |
| `computer`       | false    | [Computer](#04-the-computer-diagnostics-object)       | N/A                  | Metadata to capture computer diagnostics.               |
| `software`       | false    | [Software](#06-the-software-versions-object)          | N/A                  | Metadata to capture software versions.                  |

### 0.2 The `Preselector` Diagnostics Object

The `Preselector` diagnostics object has the following properties:

| name                       | required | type    | unit           | description                                                     |
|----------------------------|----------|---------|----------------|-----------------------------------------------------------------|
| `temp`                     | false    | double  | degree Celsius | Temperature inside the preselector enclosure.                   |
| `noise_diode_temp`         | false    | double  | degree Celsius | Temperature of the noise diode.                                 |
| `lna_temp`                 | false    | double  | degree Celsius | Temperature of the low noise amplifier.                         |
| `humidity`                 | false    | double  | percent        | Relative humidity inside the preselector enclosure.             |
| `door_closed`              | false    | boolean | N/A            | Boolean indicating whether the door of the enclosure is closed. |
| `noise_diode_powered`      | false    | boolean | N/A            | Boolean indicating whether the noise diode is powered.          |
| `lna_powered`              | false    | boolean | N/A            | Boolean indicating whether the low noise amplifier is powered.  |
| `antenna_path_enabled`     | false    | boolean | N/A            | Boolean indicating whether the antenna path is enabled.         |
| `noise_diode_path_enabled` | false    | boolean | N/A            | Boolean indicating whether the noise diode path is enabled.     |

### 0.3 The `SPU` Diagnostics Object

The `SPU` diagnostics object has the following properties:

| name                          | required | type                                                      | unit           | description                                                        |
|-------------------------------|----------|-----------------------------------------------------------|----------------|--------------------------------------------------------------------|
| `sigan_powered`               | false    | boolean                                                   | N/A            | Boolean indicating if the signal analyzer is powered.              |
| `preselector_powered`         | false    | boolean                                                   | N/A            | Boolean indicating if the preselector is powered.                  |
| `humidity_sensors`            | false    | [DiagnosticSensor[]](#08-the-diagnostic-sensor-object)    | percent        | Humidity at specified locations.                                   |
| `temperature_sensors`         | false    | [DiagnosticSensor[]](#08-the-diagnostic-sensor-object)    | degree Celsius | Temperature at specified locations.                                |
| `power_sensors`               | false    | [DiagnosticSensor[]](#08-the-diagnostic-sensor-object)    | Volts          | Power readings at specified locations.                             |
| `door_closed`                 | false    | boolean                                                   | N/A            | Boolean indicating whether the door of the enclosure is closed.    |
| `temperature_control_powered` | false    | boolean                                                   | N/A            | Boolean indicating whether the temperature control is powered.     |
| `heating`                     | false    | boolean                                                   | N/A            | Boolean indicating whether the heat is on.                         |
| `cooling`                     | false    | boolean                                                   | N/A            | Boolean indicating whether the cooling is on.                      |
| `battery_backup`              | false    | boolean                                                   | N/A            | Boolean indicating True if the device is running on battery backup |
| `low_battery`                 | false    | boolean                                                   | N/A            | Boolean indicating True if the battery backup is low               |
| `replace_battery`             | false    | boolean                                                   | N/A            | Boolean indicating True if the battery backup needs to be replaced |
| `ups_healthy`                 | false    | boolean                                                   | N/A            | Boolean indicating false if the UPS has a failure                  |

### 0.4 The `Computer` Diagnostics Object

The `Computer` diagnostics object has the following properties:

| name               | required | type                                                    | unit                 | description                                                                                             |
|--------------------|----------|---------------------------------------------------------|----------------------|---------------------------------------------------------------------------------------------------------|
| `cpu_min_clock`    | false    | double                                                  | MHz                  | Minimum sampled clock speed.                                                                            |
| `cpu_max_clock`    | false    | double                                                  | MHz                  | Maximum sampled clock speed.                                                                            |
| `cpu_mean_clock`   | false    | double                                                  | MHz                  | Mean sampled clock speed.                                                                               |
| `cpu_uptime`       | false    | double                                                  | days                 | Number of days since the computer started                                                               |
| `action_cpu_usage` | false    | double                                                  | percent              | CPU utilization during action execution.                                                                |
| `action_runtime`   | false    | double                                                  | seconds              | Total action execution time.                                                                            |
| `system_load_5m`   | false    | double                                                  | percent              | Number of processes in a runnable state over the previous 5 minutes as a percent of the number of CPUs. |
| `memory_usage`     | false    | double                                                  | percent              | Average percent of memory used during action execution.                                                 |
| `cpu_overheating`  | false    | boolean                                                 | N/A                  | True if the CPU is overheating.                                                                         |
| `cpu_temp`         | false    | double                                                  | degree Celsius       | CPU temperature.                                                                                        |
| `software_start`   | false    | string                                                  | ISO-8601 (see above) | The time at which the sensor software started.                                                          |
| `software_uptime`  | false    | double                                                  | days                 | Number of days since the sensor software started.                                                       |
| `ssd_smart_data`   | false    | [SsdSmartData](#05-the-ssdsmartdata-diagnostics-object) | N/A                  | Information provided by the drive Self-Monitoring, Analysis, and Reporting Technology.                  |
| `ntp_active`       | false    | boolean                                                 | N/A                  | True if NTP service is active on the computer                                                           |
| `ntp_sync`         | false    | boolean                                                 | N/A                  | True if the system clock is synchronized with NTP                                                       |
| `disk_usage`       | false    | double                                                  | percent              | Percentage of total disk usage on the computer                                                          |

### 0.5 The `SsdSmartData` Diagnostics Object

The `SsdSmartData` diagnostics object has the following properties:

| name                        | required | type    | unit           | description                                                                                                                                                                                                                                                                                                                                                                                           |
|-----------------------------|----------|---------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `test_passed`               | false    | boolean | N/A            | SMART overall-health self-assessment test result.                                                                                                                                                                                                                                                                                                                                                     |
| `critical_warning`          | false    | string  | N/A            | Critical warning message from smartctl, a string containing a hexadecimal value, e.g., `"0x00"`                                                                                                                                                                                                                                                                                                       |
| `temp`                      | false    | double  | degree Celsius | Drive temperature.                                                                                                                                                                                                                                                                                                                                                                                    |
| `available_spare`           | false    | double  | percent        | Normalized percentage (0 to 100%) of the remaining spare capacity available.                                                                                                                                                                                                                                                                                                                          |
| `available_spare_threshold` | false    | double  | percent        | When the available_spare falls below the threshold indicated in this field, an asynchronous event completion may occur. The value is indicated as a normalized percentage (0 to 100%).                                                                                                                                                                                                                |
| `percentage_used`           | false    | double  | percent        | Contains a vendor specific estimate of the percentage of NVM subsystem life used based on the actual usage and the manufacturer’s prediction of NVM life. A value of 100 indicates that the estimated endurance of the NVM in the NVM subsystem has been consumed, but may not indicate an NVM subsystem failure. Values may exceed 100 and percentages greater than 254 shall be represented as 255. |
| `unsafe_shutdowns`          | false    | int     | N/A            | Number of unsafe shutdowns.                                                                                                                                                                                                                                                                                                                                                                           |
| `integrity_errors`          | false    | int     | N/A            | Number of occurrences where the controller detected an unrecovered data integrity error                                                                                                                                                                                                                                                                                                               |

### 0.6 The Software Versions Object

The `Software` versions object has the following properties:

| name                      | required | type         | description                                                                                                                                          |
|---------------------------|----------|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| `system_platform`         | false    | string       | A human-readable representation of the generator's software platform, e.g. "Linux-5.4.0-153-generic-x86_64-with-glibc2.29"                           |
| `python_version`          | false    | string       | [Semantic version](https://semver.org/) of Python used by the generator                                                                              |
| `scos_sensor_version`     | false    | string       | The [SCOS Sensor](https://github.com/NTIA/scos-sensor) version of the generator, in the form output by `git describe --tags`, e.g., "1.0.0-gebbc956" |
| `scos_actions_version`    | false    | string       | [Semantic version](https://semver.org/) of the [SCOS Actions](https://github.com/NTIA/scos-actions) plugin used by the generator                     |
| `scos_sigan_plugin`       | false    | `ScosPlugin` | [ScosPlugin](#07-the-scos-plugin-object) object containing the name and version of the plugin implementing the signal analyzer interface             |
| `preselector_api_version` | false    | string       | [Semantic version](https://semver.org/) of the [ITS Preselector API](https://github.com/NTIA/Preselector) used by the generator                      |
| `sigan_firmware_version`  | false    | string       | The version of the signal analyzer firmware, e.g. `"1.2"`, `"2.3.5"`, `"V3.4"`                                                                       |
| `sigan_api_verision`      | false    | string       | The version of the signal analyzer API, e.g. `"v1.1.5"`, `"1.0.0"`, etc.                                                                             |

### 0.7 The SCOS Plugin Object

The ``ScosPlugin`` object has the following properties:

| name      | required | type   | description                                                  |
|-----------|----------|--------|--------------------------------------------------------------|
| `name`    | true     | string | Python package name as it is imported, e.g., `"scos_tekrsa`" |
| `version` | true     | string | [Semantic version](https://semver.org/) of the SCOS plugin   |

### 0.8 The Diagnostic Sensor Object

The ``DiagnosticSensor`` object has the following properties:

| name              | required | type   | description                                                             |
|-------------------|----------|--------|-------------------------------------------------------------------------|
| `name`            | true     | string | Then name of the sensor                                                 |
| `description`     | false    | string | A description of the sensor                                             |
| `expected_value`  | false    | double | The value expected from the sensor                                      |
| `maximum_allowed` | false    | double | The maximum value allowed from the sensor before action should be taken |
| `minimum_allowed` | false    | double | The minimum value allowed from the sensor before action should be taken |
| `value`           | true     | double | The value provided by the sensor                                        |

## 1 Global

The `ntia-diagnostics` extension adds the following name/value pairs to the `global` SigMF object:

| name          | required | type                                      | unit | description                                   |
|---------------|----------|-------------------------------------------|------|-----------------------------------------------|
| `diagnostics` | false    | [Diagnostics](#01-the-diagnostics-object) | N/A  | Metadata for capturing component diagnostics. |

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
      "version" : "v2.2.0",
      "optional" : false
    } ],
    "ntia-core:classification" : "UNCLASSIFIED",
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
        "software_uptime" : 1.0,
        "software_start" : "2024-03-02T00:04:45.204Z",
        "ntp_active" : true,
        "ntp_sync" : true,
        "disk_usage" : 25.0,
        "ssd_smart_data" : {
          "temp" : 41.0,
          "test_passed" : true,
          "critical_warning" : "0x00",
          "available_spare" : 100.0,
          "available_spare_threshold" : 10.0,
          "percentage_used" : 1.0,
          "unsafe_shutdowns" : 18,
          "integrity_errors" : 0
        },
        "action_runtime" : 100.0
      },
      "datetime" : "2024-03-02T00:04:45.191Z",
      "preselector" : {
        "temp" : 20.0,
        "humidity" : 65.0,
        "noise_diode_temp" : 21.8,
        "lna_temp" : 22.5,
        "door_closed" : true,
        "noise_diode_path_enabled" : false,
        "antenna_path_enabled" : true,
        "noise_diode_powered" : false,
        "lna_powered" : true
      },
      "software" : {
        "system_platform" : "Linux-9.9.9-example-platform",
        "python_version" : "3.11.5",
        "scos_sensor_version" : "1.0.0-gcbb75ad",
        "scos_actions_version" : "2.0.0",
        "scos_sigan_plugin" : {
          "name" : "scos_tekrsa",
          "version" : "3.1.4"
        },
        "preselector_api_version" : "1.0.0",
        "sigan_firmware_version" : "1.2.3",
        "sigan_api_version" : "V1.0.0"
      },
      "spu" : {
        "cooling" : false,
        "heating" : false,
        "low_battery" : false,
        "battery_backup" : false,
        "preselector_powered" : true,
        "sigan_powered" : true,
        "door_closed" : true,
        "humidity_sensors" : [ {
          "name" : "internal_humidity",
          "value" : 17.0
        } ],
        "temperature_sensors" : [ {
          "name" : "internal_temp",
          "value" : 32.0
        } ],
        "power_sensors" : [ {
          "name" : "5V_power_monitor",
          "value" : 5.0,
          "expected_value" : 5.0
        } ],
        "ups_healthy" : true,
        "replace_battery" : false
      }
    }
  },
  ...
  "captures" : [ ... ],
  "annotations" : [ ... ]
}
```
