# ntia-interference Extension v1.0.0
The ntia-inteference namespace provides information that comprises an interference report.

`ntia-interference` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-interference` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`interference_report`|false|[InterferenceReport](#11-interference-report-object)|N/A|Describes inteference event.|

### 1.1 InterferenceReport Object
The following information is to be provided by spectrum user to report an inteference event.

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of the interference report.|
|`description`|false|string|N/A|Description of the interference.|
|`security_classification`|false|string|N/A|Classification of interference report. I.e., `"UNCLASSIFIED"`, `"CONFIDENTIAL"`, or `"SECRET"`.|
|`name`|false|string|N/A|Name of person reporting inteference. E.g., `"Jane Doe".|
|`telephone`|false|string|N/A|Phone number of person/office reporting inteference. E.g., `"123-456-7890".|
|`email`|false|string|N/A|Email of person/office reporting inteference. E.g., `"janedoe@agency.mil".|
|`system`|false|string|N/A|Name of affected system.|
|`latitude`|false|double|decimal degrees|Latitude of affected receiver.|
|`longitude`|false|double|decimal degrees|Longitude of affected receiver.|
|`altitude`|false|double|meters|Height above mean sea level of affected receiver.|
|`frequency_low`|false|double|Hz|Low frequency affected by interference.|
|`frequency_high`|false|double|Hz|High frequency affected by interference.|
|`time_start`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|Start date/time of interference.|
|`time_end`|false|datetime|[ISO-8601](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#the-datetime-pair)|End date/time of interference.|

## 2 Captures
`ntia-interference` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-interference` does not provide additional segments to extend `ntia-core`.

## 4 Example
[TODO] Provide and example of `ntia-interference`
