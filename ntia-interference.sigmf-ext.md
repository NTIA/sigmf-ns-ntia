# ntia-interference Extension v1.0.0
The ntia-inteference namespace provides information about calibration factors applied to the data.

`ntia-interference` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-interference` extends the [Global object](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`interference_report`|true|object|N/A|Interference report. E.g. [NTIA-Interference-Report](#31-ntia-inteferencereport-object).|

### 3.1 NTIA-InteferenceReport Object
`NTIA-InteferenceReport` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|

### 3.2 FAA-InteferenceReport Object
`FAA-InteferenceReport` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|

### 3.3 FCC-InteferenceReport Object
`FCC-InteferenceReport` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|

### 3.3 DOD-InteferenceReport Object
`DOD-InteferenceReport` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id of the interference report.|
|`description`|false|string|N/A|Description of the interference.|
|`security_classification`|false|string|N/A|Classification of interference report. I.e., `"UNCLASSIFIED"`, `"CONFIDENTIAL"`, or `"SECRET"`.|
|`type`|false|string|N/A|Type of interference. I.e., `"GPS"`, `"SATCOM"`, or `"Terrestrial"`.|
|`aor`|false|string|N/A|Area of responsibility. E.g., `"NORTHCOM"`.|
|`service`|false|string|N/A|Military service reporting inteference. I.e., `"Army"`, `"Navy"`, or `"Air Force"`.|
|`name`|false|string|N/A|Name of person reporting inteference. E.g., `"Jane Doe".|
|`title`|false|string|N/A|Title of person reporting inteference. E.g., `"Private".|
|`telephone`|false|string|N/A|Phone number of person/office reporting inteference. E.g., `"123-456-7890".|
|`email`|false|string|N/A|Email of person/office reporting inteference. E.g., `"janedoe@agency.mil".|
|`unit`|false|string|N/A|Unit of person/office reporting inteference. E.g., `"JSC".|
|`call_sign`|false|string|N/A|Email of person/office reporting inteference. E.g., `"J3 OPS".|
|`frequency`|false|double|Hz|Frequency affected by interference.|
|`frequency_high`|false|double|N/A|High frequency affected by interference.|
|`channel`|false|string|N/A|Channel affected by inteference.|
|`latitude`|false|double|decimal degrees|Latitude of affected receiver.|
|`longitude`|false|double|decimal degrees|Longitude of affected receiver.|
|`altitude`|false|double|meters|Height above mean sea level of affected receiver.|
|`location`|false|string|N/A|Location of affected receiver. E.g., `"Annapolis, Camp Victory Front Gate".|
|`country`|false|string|N/A|Country where affected receiver is located. E.g., `"United States".|
|`state`|false|string|N/A|State where affected receiver is located. E.g., `"Maryland".|
|`system`|false|string|N/A|Name of affected system.|
|`bandwidth`|false|double|N/A|Bandwidth of affected channel.|
|`antenna`|false|string|N/A|Antenna of affected system.|

## 2 Captures
`ntia-interference` does not provide additional keys to `Captures`.

## 3 Annotations
`ntia-interference` does not provide additional segments to extend `ntia-core`.

## 4 Example
[TODO] Provide and example of `ntia-interference`
