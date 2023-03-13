# ntia-location extension v2.0.0

The ntia-location namespace provides metadata to describe a coordinate system and specify location.

`ntia-location` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions. `ntia-location` SHOULD be used instead of lat/long in `sigmf-core`.

## 1 Global

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|

### 1.6 Location Object

The `Location` object is used within the [Sensor](ntia-sensor.sigmf-ext.md#12-sensor-object), and [Emitter](ntia-emitter.sigmf-ext.md#11-emitter-object) objects to specify their locations. The `Location` object has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`x`|false|double|N/A|Location of object releative to x-axis origin. MUST contain longitude for a Geographic Coordinate System.|
|`y`|false|double|N/A|Location of object releative to y-axis origin. MUST contain latitude for a Geographic Coordinate System.|
|`z`|false|double|N/A|Location of object releative to z-axis origin.|
|`speed`|false|double|`distance_unit`/`time_unit`|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to `orientation_ref`).|
|`description`|false|string|N/A|A brief textual description of the location.|

## 2 Captures

`ntia-location` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations

`ntia-location` does not extend [Annotations](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#annotations-array).

## 4 Example

```json
```
