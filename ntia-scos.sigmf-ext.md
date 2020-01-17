# ntia-scos extension v1.0.0
The `ntia-scos` namespace provides SigMF metadata extensions for the NTIA/ITS Spectrum Characterization and Occupancy Sensing (SCOS) system.

`ntia-scos` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-scos` defines the following keys that extend the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object):

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`schedule`|true| [ScheduleEntry](#11-scheduleentry-object)|N/A|Metadata that describes the schedule that caused an action to be performed.|
|`action`|true|[Action](#12-action-object)|N/A|Metadata that describes the action that was performed.|
|`task`|true|[Task](#13-task-object)|N/A|Metadata that describes the task that was performed.|


### 1.1 ScheduleEntry Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique identifier for the `ScheduleEntry`|
|`name`|true|string|N/A|User specified name of the schedule.|
|`start`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Requested time to schedule the first task.|
|`stop`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Requested time to end execution of tasks under the schedule.|
|`relative_stop`|false|integer|Seconds|Seconds after start when the schedule will end.|
|`interval`|false|integer|Seconds|Seconds between tasks. If unspecified, the task will execute once and the schedule will become inactive|
|`priority`|false|integer|N.A|The priority of the schedule. Lower numbers indicate higher priority.|



### 1.2 Action Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|true|string|N/A|Name of the action assigned to the schedule entry. MUST be unique on the sensor.|
|`description`|false|string|N/A|A description of what the action does.|


### 1.3 Task Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|integer|N/A|Unique identifier that increments with each task performed as a result of a `schedule_entry`.|
|`recording`|false|integer|N/A|Unique identifier that increments with each recording performed in a task. The recording should be indicated for tasks that perform multiple recordings. |
|`start_time`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  began execution.|
|`end_time`|true|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|When the action  finished execution.|
|`low_frequency`|false|double|Hertz|The lowest frequency specified for a sensing task. This SHOULD be included for all sensing tasks. |
|`center_frequency`|false|double|Hertz|The center frequency specified for a sensing task. This SHOULD be included for all sensing tasks.|
|`high_frequency`|false|double|Hertz|The highest frequency specified for a sensing task. This SHOULD be included for all sensing tasks.|
|`domain`|true|string|N/A|Time or Frequency|
|`measurement_type`|false|string|N/A|Method that signal analyzer acquires data, e.g. `"single-frequency"`, `"survey"`, `"scan"`. This SHOULD be specified for all sensing tasks.|



[TODO] Capture Control Plane from Greyhound. Figure out `name` v. `id` (primary key choice).

## 2 Captures
`ntia-scos` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-scos` does not provide additional segments to [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).

## 4 Example
[TODO] Provide and example of `ntia-scos`
