# ntia-scos extension v1.0.0

The `ntia-scos` namespace provides SigMF metadata extensions for the NTIA/ITS Spectrum Characterization and Occupancy Sensing (SCOS) system.

`ntia-scos` is fully compliant with the [SigMF](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global

`ntia-scos` defines the following keys that extend the [Global](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#global-object):

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`schedule`|true| [ScheduleEntry](#11-scheduleentry-object)|N/A|Metadata that describes the schedule that caused an action to be performed.|
|`action`|true|[Action](#12-action-object)|N/A|Metadata that describes the action that was performed.|
|`task`|true|integer|N/A|Unique identifier that increments with each task performed as a result of a `schedule_entry`.|
|`recording`|false|integer|N/A|Unique identifier that increments with each recording performed in a task. The recording SHOULD be indicated for tasks that perform multiple recordings. |

### 1.1 ScheduleEntry Object

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique identifier for the `ScheduleEntry`|
|`name`|true|string|N/A|User specified name of the schedule.|
|`start`|false|string|[ISO-8601](https://www.ietf.org/rfc/rfc3339.txt) with UTC `time_offset`, i.e., `YYYY-MM-DDTHH:MM:SS.SSSZ` with any number of digits for fractional seconds.|Requested time to schedule the first task.|
|`stop`|false|string|[ISO-8601](https://www.ietf.org/rfc/rfc3339.txt) with UTC `time_offset`, i.e., `YYYY-MM-DDTHH:MM:SS.SSSZ` with any number of digits for fractional seconds.|Requested time to end execution of tasks under the schedule.|
|`interval`|false|integer|Seconds|Seconds between tasks. If unspecified, the task will execute once and the schedule will become inactive|
|`priority`|false|integer|N.A|The priority of the schedule. Lower numbers indicate higher priority.|
|`roles`|false|string[]|N.A|The user roles that are allowed to access acquisitions from the schedule.|

### 1.2 Action Object

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|true|string|N/A|Name of the action assigned to the schedule entry. MUST be unique on the sensor.|
|`description`|false|string|N/A|A detailed description of what the action does.|
|`summary`|false|string|N/A|A short summary of what the action does.|

## 2 Captures

`ntia-scos` does not provide additional keys to [Captures](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#captures-array).

## 3 Annotations

`ntia-scos` does not extend [Annotations](https://github.com/sigmf/SigMF/blob/sigmf-v1.x/sigmf-spec.md#annotations-array).

## 4 Example

```json
{
  "global" : {
    ...
    "core:extensions" : {
      "ntia-scos" : "v1.0.0"
    },
    "ntia-scos:action" : {
      "name" : "acquire_m4s_700MHz_Verizon_UL",
      "summary" : "Apply m4s detector over 300 1024-pt FFTs at 782 MHz."
    },
    "ntia-scos:schedule" : {
      "id" : "m4_123",
      "name" : "M4 every Second",
      "stop" : "2020-02-03T15:35Z",
      "interval" : 1,
      "start" : "2020-01-27T15:35:45.000610Z"
    },
    "ntia-scos:task":1 
    ...
  },
  "captures" : [... ],
  "annotations" : [ ...]
}
```
