# ntia-scos extension v1.0.0
The `ntia-scos` namespace provides SigMF metadata extensions for the NTIA/ITS Spectrum Characterization and Occupancy Sensing (SCOS) system.

`ntia-scos` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-scos` defines the following keys that extend the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object):

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`action`|true|[Action](#11-action-object)|N/A|Metadata that describes a sensor action.|
|`schedule`|false| [ScheduleEntry](#12-scheduleentry-object)|N/A|Metadata that describes the schedule that caused an action to be performed.|
|`task_id`|true|integer|N/A|Unique identifier that increments with each task performed as a result of a `schedule_entry`.|

### 1.1 Action Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|true|string|N/A|Name of the action assigned to the schedule entry. MUST be unique on the sensor.|
|`description`|false|string|N/A|A description of what the action does.|
|`type`|true|string array|N/A|The type(s) of measurements the action produces.|

[TODO] Capture Control Plane from Greyhound. Figure out `name` v. `id` (primary key choice).

## 2 Captures
`ntia-scos` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-scos` does not provide additional segments to [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).

## 4 Example
[TODO] Provide and example of `ntia-scos`
