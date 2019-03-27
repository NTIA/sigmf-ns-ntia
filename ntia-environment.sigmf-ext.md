# ntia-environment extension v1.0.0
The ntia-environment extension provides SigMF metadata extensions to characterize the environment factors around a sensor and\or emitter. 

## 2. Conventions Used in this Document

The SCOS specification uses and is fully compliant with the SigMF specification and conventions. Building upon the [SigMF core namespace](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces), the specification is enhanced through the implementation of a `ntia-scos` namespace, the details of which follow.  


## 3. Global
Global information is applicable to the entire dataset. The ntia-environment namespace does not provide any global extensions.

## 4. Captures
Per SigMF, the `Captures` value is an array of capture segment objects that describe the parameters of the signal capture. The `ntia-environment` specification does not add any enhancements to this section.

## 5. Annotations
Per SigMF, the `Annotations` value is an array of annotation segment objects that describe anything regarding the signal data not part of the `global` and `captures` objects. The ntia-environment namespace provides the following annotations to describe the environment around sensors and\or emitters, and any changes to that may occur throughout the dataset. 


### 5.1 SensorEnvironment Segment Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`sensor-id`|true|string|N/A|The unique id of the sensor around which the environemnt has changed|
|`temperature`|false|float|celsius|The environmental temparature.|
|`humidity`|false|float|?|Specific or relative humidity?.|
|`weather`|false|string|N/A|The weather around the sensor(rain, snow...)|
|`environment`|false|string|N/A|A description of the environment where antenna is mounted. E.g. `"indoor"` or `"outdoor"`.|

### 5.2 EmitterEnvironment Segment Object
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`emitter-id`|true|string|N/A|The unique id of the sensor around which the environemnt is being reported|
|`temperature`|false|float|celsius|The environmental temparature.|
|`humidity`|false|float|?|Specific or relative humidity?.|
|`weather`|false|string|N/A|The weather around the emitter(rain, snow...)|







