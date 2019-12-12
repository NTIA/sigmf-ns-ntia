# ntia-location extension v1.0.0
The ntia-location namespace provides metadata to describe a coordinate system and annotate an associated object's location. 

`ntia-location` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions. `ntia-location` SHOULD be used instead of lat/long in `sigmf-core`, where an alternative coordinate system is required.

## 1 Global
`ntia-location` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:
|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`coordinate_system`|false|[CoordinateSystem](#11-coordinatesystem-object)|N/A|Unique id for coordinate system.|

### 1.1 CoordinateSystem Object
The base CoordinateSystem object used to describe the coordinate system. 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for the spatial reference system.|
|`description`|false|string|N/A|Description of the spatial reference system.|
|`coordinate_system_type`|true|string|N/A|Type of the spatial reference system. CoordinateSystem, GeographicCoordinateSystem, or ProjectedCoordinateSystem|
|`distance_unit`|true|string|N/A|Unit of horizontal distance for coordinate system. E.g. Meters, feet, decimal degrees, DMS, city blocks.|
|`time_unit`|true|string|N/A|Unit of time for speed measurements. E.g. Hours, seconds.|
|`origin`|false|string|N/A|Origin of cartesian coordinate system. E.g. State of CO, survey marker #MT 127.|
|`orientation_ref`|false|string|N/A|Reference vector for orientation. E.g. Magnetic north
|`orientation`|false|string|N/A|Rotation of cartesian coordinate system, from `orientation_ref` (in degrees). E.g. Annotating values as true north instead of magnetic north by including a magnetic declination (0,0,0.35)|
|`elevation_ref`|false|string|N/A|Elevation reference datum. E.g. Mean Sea Level, Above ground level, Antenna elevation.| 
|`elevation_unit`|false|string|N/A|Unit of elevation for coordinate system. E.g. Meters, feet.|


### 1.2 ProjectedCoordinateSystem Object
The ProjectedCoordinateSystem object extends CoordinateSystem and adds the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`false_easting`|false|double|N/A|False easting of PCS.|
|`false_northing`|false|double|N/A|False northing of PCS.|
|`central_meridian`|false|double|N/A|Central meridian of PCS.|
|`scale_factor`|false|double|N/A|Scale factor of PCS.|
|`origin_latitude`|false|double|decimal degrees|Latitude of origin of PCS.|

### 1.3 GeographicCoordinateSystem Object
A GeographicCoordinateSystem extends CoordinateSystem and adds the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------| 
|`datum`|false|[Datum](#14-datum-object)|N/A|Datum of sphereoid or sphere. E.g. NAD27, NAD83, WGS84 |

### 1.4 Datum Object
`Datum` has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|false|string|N/A|Unique id for datum, the [ESPG](http://www.epsg.org/) number is RECOMMENDED.|
|`description`|false|string|N/A|Description of datum.|
|`spheroid`|false|[Spheroid](#15-spheroid-object)|N/A|Underlying sphere or spheroid of datum.|

### 1.5 Spheroid Object
`Spheroid` covers the definition of both a sphere or a spheroid. It has the following properties: 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|false|string|N/A|Unique id for the spheroid, the [ESPG](http://www.epsg.org/) number is RECOMMENDED.|
|`description`|false|string|N/A|Description of the spheroid. Eg. Clarke 1866, WGS84|
|`semiminor`|false|double|N/A|Semiminor axis radii of spheroid.|
|`semimajor`|false|double|N/A|Semimajor axis radii of spheroid.|
|`flattening`|false|double|N/A|Flattening value of spheroid.|
|`angular_unit`|false|string|N/A|Angular unit of measure of spheroid. E.g. degrees, radians, grads|
|`prime_meridian`|false|string|N/A|The longitude origin.|


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
|`speed`|false|double|`distance_unit`/`time_unit`|Speed.|
|`bearing`|false|double|degrees|Direction (angle relative to `orientation_ref`).|

## 4 Example

### 4.1 Speed and Bearing - Simple Example
```json

  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-scos:task_id": 418350,
    "ntia-location:coordinate_system": {
      "coordinate_system_type": "CoordinateSystem",
      "id": "SpeedAndBearing_1",
      "description": "System used for relative positioning in tunnels.",
      "distance_unit": "miles",
      "time_unit": "hours",
      "origin": "Tunnel Entrance",
      "orientation_ref": "Magnetic north",
      "elevation_ref": "Tunnel Entrance",
      "elevation_unit": "feet"
    }
  },
  "captures": [
    {
      "core:sample_start": 0,
      "core:frequency": 700000000,
      "core:datetime": "2019-12-12T22:01:59.000310Z"
    }
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "LocationAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 100,
      "z": -3.23,
      "speed": 3.0,
      "bearing": 89.7
    }
  ]
}
```



### 4.3 Projected Coordinate System 
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-scos:task_id": 392566,
    "ntia-location:coordinate_system": {
      "coordinate_system_type": "ProjectedCoordinateSystem",
      "id": "EPSG:2029",
      "description": "NAD27(76) / UTM zone 17N",
      "gcs": {
        "coordinate_system_type": "GeographicCoordinateSystem",
        "id": "EPSG:4608",
        "description": "NAD27(76)"
      }
    }
  },
  "captures": [
    {
      "core:sample_start": 0,
      "core:frequency": 700000000,
      "core:datetime": "2019-12-12T22:01:59.000304Z"
    }
  ],
  "annotations": [
    
  ]
}
```

### 4.6 Geographic Coordinate System - Complex Example
```json 
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-scos:task_id": 162782,
    "ntia-location:coordinate_system": {
      "coordinate_system_type": "GeographicCoordinateSystem",
      "id": "EPSG:4326",
      "description": "World Geodetic System 1984 - Horizontal component of 3D system. Used by the GPS satellite navigation system and for NATO military geodetic surveying.",
      "datum": {
        "spheroid": {
          "semiminor": 6356752.3142,
          "semimajor": 6378137.0,
          "flattening": 0.0033528106647474805,
          "prime_meridian": "Greenwich"
        }
      }
    }
  },
  "captures": [
    {
      "core:sample_start": 0,
      "core:frequency": 700000000,
      "core:datetime": "2019-12-12T22:01:59.000289Z"
    }
  ],
  "annotations": [
    
  ]
}

```
