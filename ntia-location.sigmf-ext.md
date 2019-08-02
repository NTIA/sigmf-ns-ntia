# ntia-location extension v1.0.0
The ntia-location namespace provides metadata to define a coordinate system, and record an object's location. 

`ntia-location` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions. `ntia-location` can be used instead of lat/long in `sigmf-core`, where the use of custom coordinate system is required.

## 1 Global
`ntia-location` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`coordinate_system`|false|[Coordinate System](#11-coordinate-system-object)|N/A|Defines a coordinate system used by an object (e.g. Sensor). This object is RECOMMENDED.|

### 1.1 Coordinate System Object
`Coordinate System` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for coordinate system.|
|`description`|false|string|N/A|Description of coordinate system.|
|`type`|true|string|N/A|Type of coordinate system. E.g. Number line, cartesian, polar, [Geographic](#13-geographic-coordinate-system-object), [Projected](#12-projected-coordinate-system-object).|
|`origin`|false|string|N/A|Origin of coordinate system. E.g. (0,0)|
|`unit`|true|string|N/A|Unit of distance of coordinate system. E.g. Meters, feet, decimal degrees, DMS, city blocks.|

### 1.2 Projected Coordinate System Object
`Projected Coordinate System` (PCS) has the following properties:

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
`Geographic Coordinate System` (GCS) has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for GCS.|
|`description`|false|string|N/A|Description of GCS.|
|`datum`|false|string|N/A|Datum of sphereoid or sphere. E.g. |
|`spheroid`|false|[Geographic](#14-spheroid-object)|N/A|Underlying sphere/spheroid of GCS.|

### 1.4 Spheroid Object
For simplicity, a Spheroid can define either a sphere or a spheroid.

`Spheroid` has the following properties:

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

### 4.1 Sensor Global Object Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-core:antenna": {
        "model": "model_X",
        "type": "omnidirectional",
        "low_frequency": 300000000,
        "high_frequency": 3000000000,
        "gain": 2,
        "cross_polar_discrimination": 9.1,
        "cable_loss": 1,
        "azimuth_angle": 45,
        "elevation_angle": 10.3
      },
      "preselector": {
        "rf_paths": [
          {
            "low_frequency_passband": 700000000,
            "high_frequency_passband": 750000000,
            "low_frequency_stopband": 700000000,
            "high_frequency_stopband": 750000000,
            "lna_noise_figure": 2.5,
            "cal_source_type": "calibrated noise source"
          }
        ]
      },
      "receiver": {
        "model": "Receiver 123xyz",
        "low_frequency": 300000000,
        "high_frequency": 3000000000,
        "noise_figure": 2,
        "max_power": -5,
        "a2d_bits": 256
      },
      "host_controller": "Host Controller 123"
    },
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

### 4.2 SensorAnnotation Example
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
      "core:latitude": 40.5,
      "core:longitude": -105
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 100,
      "core:sample_count": 100,
      "core:latitude": 40.56,
      "core:longitude": -105.03
    }
  ]
}
```
