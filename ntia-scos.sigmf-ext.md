# The `ntia-scos` SigMF Extension Namespace v1.0.0

This document defines the `ntia-scos` extension namespace for the Signal Metadata Format (SigMF) specification. This extension namespace contains objects to help store information related to the NTIA/ITS Spectrum Characterization and Occupancy Sensing (SCOS) system.

## 0 Datatypes

The `ntia-scos` extension defines the following datatypes:

|name|long-form name|description|
|----|--------------|-----------|
|`ScheduleEntry`|SCOS schedule entry|JSON [`ScheduleEntry`](#01-the-scheduleentry-object) object containing information related to the SCOS schedule entry|
|`Action`|SCOS action|JSON [`Action`](#02-the-action-object) object containing information related to the SCOS action|

### 0.1 The `ScheduleEntry` Object

A `ScheduleEntry` object is used to describe the SCOS schedule entry which triggered the action which yielded the data and metadata. The `start` and `stop` key/value pairs MUST be ISO-8601 strings, as defined by [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt), where the only allowed `time-offset` is `z`, indicating the UTC/Zulu timezone. Thus, timestamps take the form of `YYYY-MM-DDTHH:MM:SS.SSSZ`, where any number of digits for fractional seconds is permitted.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique identifier for the `ScheduleEntry`|
|`name`|true|string|N/A|User specified name of the schedule.|
|`start`|false|string|ISO-8601 (see above)|Requested time to schedule the first task.|
|`stop`|false|string|ISO-8601 (see above)|Requested time to end execution of tasks under the schedule.|
|`interval`|false|integer|seconds|Seconds between tasks. If unspecified, the task  is assumed to have executed once, after which the schedule became inactive|
|`priority`|false|integer|N.A|The priority of the schedule. Lower numbers indicate higher priority.|
|`roles`|false|string[]|N.A|The user roles that are allowed to access acquisitions from the schedule.|

### 0.2 The `Action` Object

The `Action` object is used to describe the SCOS action which was triggered by the scheduler, and which yielded the data and metadata.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|true|string|N/A|Name of the action assigned to the schedule entry. MUST be unique on the sensor.|
|`description`|false|string|N/A|A detailed description of what the action does.|
|`summary`|false|string|N/A|A short summary of what the action does.|

## 1 Global

The `ntia-scos` extension adds the following fields to the `global` SigMF object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`schedule`|true| [`ScheduleEntry`](#01-the-scheduleentry-object)|N/A|Metadata that describes the schedule that caused an action to be performed.|
|`action`|true|[`Action`](#02-the-action-object)|N/A|Metadata that describes the action that was performed.|
|`task`|true|integer|N/A|Unique identifier that increments with each task performed as a result of a schedule entry.|
|`recording`|false|integer|N/A|Unique identifier that increments with each recording performed in a task. The recording SHOULD be indicated for tasks that perform multiple recordings. |

## 2 Captures

The `ntia-scos` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-scos` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-scos` extension does not extend the `collection` SigMF object.

## 5 Example

```json
{
  "global" : {
    ...
    "core:extensions": [
      {
        "name": "ntia-scos",
        "version": "v1.0.0",
        "optional": true
      }
    ],
    "ntia-scos:action": {
      "name": "acquire_m4s_700MHz_Verizon_UL",
      "summary": "Apply M4S detector over 300 1024-pt FFTs at 782 MHz."
    },
    "ntia-scos:schedule": {
      "id": "m4_123",
      "name": "M4 every Second",
      "stop": "2020-02-03T15:35Z",
      "interval": 1,
      "start": "2020-01-27T15:35:45.000610Z"
    },
    "ntia-scos:task": 1,
    "ntia-scos:recording": 1,
    ...
  },
  "captures": [...],
  "annotations": [...]
}
```
