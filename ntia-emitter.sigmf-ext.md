# ntia-emitter Extension v1.0.0

The ntia-emitter namespace extension extends the global object to describe static emitter properties and the annotations object to describe dynamic emitter properties. 

## 2. Conventions Used in this Document

The SCOS specification uses and is fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces), the specification is enhanced through the implementation of a `ntia-emitter` namespace, the details of which follow.  

## 3. Global
Global information is applicable to the entire dataset. The ntia-emitter namespace defines the followin extensions to the global object:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitter`|false|[Emitter](#61-emitter-object) |N/A|The description of the static properties of an emitter. The attributes specified in this global object are applicable to the entire dataset.|


## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-emitter` specification does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. As dictated by the SigMF specification, each annotation segment object must contain a `core:sample_start` name/value pair, which indicates the first index at which the rest of the segment's name/value pairs apply.  In addition, each of the annotation extensions below must include the id of the emitter. The ntia-emitter extension defines the following additional annotations:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|The id of the emitter.|
|`power`|false|double|dBm|Emitter power going into antenna.|
|`antenna`|false|[Antenna](#antenna-object) |N/A|See [ntia-antenna](#antenna-object) extension.|
|`waveform`|false| [Waveform](https://github.com/NTIA/sigmf-ns-waveform)|N/A|See [ntia-waveform extension](https://github.com/NTIA/sigmf-ns-waveform)
|`latitude`|false|double|decimal degrees|Latitude of emitter.|
|`longitude`|false|double|decimal degrees|Longitude of emitter.|
|`altitude`|false|double|meters|The height of the antenna above mean sea level.|
|`speed`|false|double|m/s|Speed at which the antenna is moving.|
|`bearing`|false|double|degrees|Angle relative to true North.|

## 6. Object Definitions

### 6.1 Emitter Object
The `Emitter` object contains the following name/value pairs:  

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|The unique id of the emitter.|
|`description`|false|string|N/A|A description of the emitter.|

