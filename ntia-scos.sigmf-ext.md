# ntia-scos extension v1.0.0
The ntia-scos extension provides SigMF metadata extensions for the NTIA/ITS Spectrum Characterization and Occupancy Sensing (SCOS) system.

## 2. Conventions Used in this Document

The SCOS specification uses and is fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces), the specification is enhanced through the implementation of a `ntia-scos` namespace, the details of which follow.  


## 3. Global
Global information is applicable to the entire dataset. The ntia-scos namespace defines the following static estensions to the Global object.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`action`|true|[Action](#51-action-object)|N/A|Describes a sensor action.|
|`schedule`|false| [ScheduleEntry](#52-scheduleentry-object)|N/A|Describes the schedule that caused an action to be performed|
|`task_id`|true|integer|N/A|A unique identifier that increments with each task performed as a result of a `schedule_entry`.|

## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-scos` specification does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. The ntia-scos namespace does not provide any annotation extensions


## 5. Object Definitions

### 5.1 Action Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`name`|true|string|N/A|The identification string assigned to the schedule entry. MUST be unique on the sensor.|
|`description`|false|string|N/A|A description of what the action does.|
|`type`|true|string array|N/A|The type(s) of measurements the action produces.|



### 5.2 ScheduleEntry Object
The `ScheduleEntry` object is associated with the SCOS control plane, which is implemented through the use of a RESTful API residing on the sensor, see [SCOS Sensor](https://github.com/NTIA/scos-sensor) and [SCOS Control Plane API Reference](https://ntia.github.io/scos-sensor/). A sensor advertises its **capabilities**, among which are **actions** that users can schedule the sensor to do. Sensor actions are scheduled by posting a **schedule entry** to the sensor's **schedule**. The scheduler periodically reads the schedule and populates a task queue in priority order. A **task** represents an action at a _specific_ time. Therefore, a schedule entry represents a range of tasks. The scheduler continues populating its task queue until the schedule is exhausted. When executing the task queue, the scheduler makes a best effort to run each task at its designated time, but the scheduler SHOULD NOT in most cases cancel a running task to start another task, even of higher priority. **priority** is used to disambiguate two or more tasks that are scheduled to start at the same time.

The `ScheduleEntry` object contains the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|The identification string assigned to the schedule entry. MUST be unique on the sensor.|
|`start`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Requested time to schedule the first task. If unspecified, task will start as soon as possible.|
|`relative_stop`|false*|integer|seconds|Relative seconds after `start` when the task will end.|
|`absolute_stop`|false*|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Absolute time when the task will end.| 
|`interval`|false|integer|seconds|Interval between tasks. If unspecified, task will run exactly once and then mark the entry inactive.|
|`priority`|false|integer|N/A|Priority of the entry, similar to applying [nice](https://en.wikipedia.org/wiki/Nice_(Unix)). Lower numbers are higher priority. Default is 10.|
|`action`|true|string|N/A|Name of action to be performed.|
|`callback_url`|false|string|N/A|Name of action to be performed.|

\* If both `relative_stop` and `absolute_stop` are unspecified, the task will carry on forever. Specifying both `relative_stop` and `absolute_stop` will result in an error.



