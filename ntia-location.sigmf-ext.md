# ntia-location extension v1.0.0
The ntia-location namespace provides metadata to define a coordinate system, and record an object's location. 

`ntia-location` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions. `ntia-location` can be used instead of lat/long in `sigmf-core`, where the use of custom coordinate system is required.

## 1 Global
`ntia-location` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

### 1.1 Coordinate System Object
`CoordinateSystem` the coordinate system used by an object (e.g. Sensor):

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for coordinate system.|
|`description`|false|string|N/A|Description of coordinate system.|
|`type`|false|string|N/A|Type of coordinate system. E.g. Number line, cartesian, polar, [Geographic](#13-geographic-coordinate-system-object), [Projected](#12-projected-coordinate-system-object).|
|`origin`|false|string|N/A|Origin of coordinate system. E.g. (0,0)|
|`unit`|true|string|N/A|Unit of distance of coordinate system. E.g. Meters, feet, decimal degrees, DMS, city blocks.|

### 1.2 Projected Coordinate System Object
`Projected` Coordinate System (PCS) has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for PCS.|
|`description`|false|string|N/A|Description of the PCS.|
|`geographic_coordinate_system`|false|[Geographic](#13-geographic-coordinate-system-object)|N/A|Underlying geographic coordinate system of PCS.| 
|`projection`|false|string|N/A|Type of projection. E.g. Conical, cylandrical, transverse mercator.|
|`false_easting`|false|double|N/A|False easting of PCS.|
|`false_northing`|false|double|N/A|False northing of PCS.|
|`central_meridian`|false|double|N/A|Central meridian of PCS.|
|`scale_factor`|false|double|N/A|Scale factor of PCS.|
|`origin_latitude`|false|double|decimal degrees|Latitude of origin of PCS.|

### 1.3 Geographic Coordinate System Object
`Geographic` Coordinate System (GCS) has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for GCS.|
|`description`|false|string|N/A|Description of GCS.|
|`datum`|false|string|N/A|Datum of sphereoid or sphere. E.g. |
|`spheroid`|false|[Geographic](#14-spheroid-object)|N/A|Underlying sphere/spheroid of GCS.|

### 1.4 Spheroid Object
`Spheroid` covers the definition of both a sphere or a spheroid. It has the following properties: 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for the spheroid.|
|`description`|false|string|N/A|Description of the spheroid.|
|`semiminor`|false|double|N/A|Semiminor axis radii of spheroid.|
|`semimajor`|false|double|N/A|Semimajor axis radii of spheroid.|
|`flattening`|false|double|N/A|Flattening value of spheroid.|
|`angular_unit`|false|string|N/A|Angular unit of measure of spheroid. E.g. degrees, radians, grads|
|`prime_meridian`|false|double|N/A|Longitude that passes through Greenwich, England.|

## 2 Captures
`ntia-location` does not provide additional keys to [Captures](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#captures-array).

## 3 Annotations
`ntia-location` defines the following segments:

### 3.1 LocationAnnotation Segment
`LocationAnnotation` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`x`|false|double|N/A|Location of object releative to x-axis origin.|
|`y`|false|double|N/A|Location of object releative to y-axis origin.|
|`z`|false|double|N/A|Location of object releative to z-axis origin.|

## 4 Example

### 4.1 Coordinate System Object Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-location:coordinate_system": {
        "id": "Colorado State Plane",
	"description": "Colorado State Plane Coordinate system",
	"type": "Projected",
	"unit": "Meters"
      }
    }  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
   ...
  ]
}
```

### 4.2 LocationAnnotation Example
```json
{
  "global": {
	...
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 100,
      "ntia-location:x": 40.5,
      "ntia-location:y": -105
      "ntia-location:z": 0
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 100,
      "core:sample_count": 100,
      "ntia-location:x": 40.56,
      "ntia-location:y": -105.03
      "ntia-location:z": -0.5
    }
  ]
}
```
