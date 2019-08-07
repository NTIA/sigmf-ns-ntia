# ntia-location extension v1.0.0
The ntia-location namespace provides metadata to describe a coordinate system and annotate an associated object's location. 

`ntia-location` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions. `ntia-location` SHOULD be used instead of lat/long in `sigmf-core`, where an alternative coordinate system is required.

## 1 Global
`ntia-location` extends the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object) with the following name/value pairs:

### 1.1 Coordinate System Object
`CoordinateSystem` the coordinate system used by an object (e.g. [Sensor](ntia-sensor.sigmf-ext.md)):

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for coordinate system.|
|`description`|false|string|N/A|Description of coordinate system.|
|`type`|false|string|N/A|Type of coordinate system. E.g. Number line, cartesian, polar, [Geographic](#13-geographic-coordinate-system-object), [Projected](#12-projected-coordinate-system-object).|
|`distance-unit`|true|string|N/A|Unit of horizontal distance for coordinate system. E.g. Meters, feet, decimal degrees, DMS, city blocks.|
|`origin`|false|string|N/A|Origin of cartesian coordinate system. E.g. State of CO, survey marker #MT 127.|
|`orientation-ref`|false|string|N/A|Reference vector for orientation. E.g. Magnetic north
|`orientation`|false|string|N/A|Rotation of cartesian coordinate system, from `orientation-ref` (in degrees). E.g. Annotating values as true north instead of magnetic north by including a magnetic declination (0,0,0.35)|
|`elevation-ref`|false|string|N/A|Elevation reference datum. E.g. Mean Sea Level, Above ground level, Antenna elevation.| 
|`elevation-units`|false|string|N/A|Unit of elevation for coordinate system. E.g. Meters, feet.|

### 1.2 Projected Coordinate System Object
Projected Coordinate System (`pcs`) has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for PCS, the [ESPG](http://www.epsg.org/) number is RECOMMENDED.|
|`description`|false|string|N/A|Description of the PCS.|
|`gcs`|false|[Geographic](#13-geographic-coordinate-system-object)|N/A|Underlying geographic coordinate system of PCS.| 
|`projection`|false|string|N/A|Type of projection. E.g. Conical, cylandrical, transverse mercator.|
|`false_easting`|false|double|N/A|False easting of PCS.|
|`false_northing`|false|double|N/A|False northing of PCS.|
|`central_meridian`|false|double|N/A|Central meridian of PCS.|
|`scale_factor`|false|double|N/A|Scale factor of PCS.|
|`origin_latitude`|false|double|decimal degrees|Latitude of origin of PCS.|

### 1.3 Geographic Coordinate System Object
Geographic Coordinate System (`gcs`) has the following properties:

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for GCS, the [ESPG](http://www.epsg.org/) number is RECOMMENDED. |
|`description`|false|string|N/A|Description of GCS.|
|`datum`|false|[Datum](#14-datum-object)|N/A|Datum of sphereoid or sphere. E.g. NAD27, NAD83, WGS84 |

### 1.4 Datum Object
`Datum` has the following properties: 
|`id`|true|string|N/A|Unique id for datum, the [ESPG](http://www.epsg.org/) number is RECOMMENDED.|
|`description`|false|string|N/A|Description of datum.|
|`spheroid`|false|[Spheroid](#15-spheroid-object)|N/A|Underlying sphere or spheroid of datum.|

### 1.5 Spheroid Object
`Spheroid` covers the definition of both a sphere or a spheroid. It has the following properties: 

|name|required|type|unit|description|
|----|--------------|-------|-------|-----------|
|`id`|true|string|N/A|Unique id for the spheroid, the [ESPG](http://www.epsg.org/) number is RECOMMENDED.|
|`description`|false|string|N/A|Description of the spheroid. Eg. Clarke 1866, WGS84|
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

### 4.1 Cartesian Coordinate System - Simple Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-location:coordinate_system": {
        "id": "1",
	"description": "Lab-test coordinate system",
	"type": "Cartesian",
	"distance-unit": "mm"
	"origin": "SW corner of lab",
	"orientation-ref": "Magnetic north",
	"elevation-ref": "Lab floor",
	"elevation-units": "mm",
      }
    },  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 100,
      "ntia-location:x": 50,
      "ntia-location:y": 47.3,
      "ntia-location:z": 0
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 100,
      "core:sample_count": 100,
      "ntia-location:x": 97.3,
      "ntia-location:y": 68,
      "ntia-location:z": -0.002
    }
  ]
}
```

### 4.2 Projected Coordinate System - Simple Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-location:coordinate_system": {
        "id": "5",
	"description": "Field survey 5",
	"type": "pcs",
        "ntia-location:pcs": {
	  "id": "EPSG:26753",
	  "description": "Colorado North",
	},
	"elevation-ref": "MSL",
        "elevation-unit": "Meters"
      }
    },  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1000,
      "ntia-location:x": 1987467.0893,
      "ntia-location:y": 326767.3945,
      "ntia-location:z": 1645.7
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 1000,
      "core:sample_count": 2000,
      "ntia-location:x": 1987487.0342,
      "ntia-location:y": 326812.2387,
      "ntia-location:z": 1649.7
    }
  ]
}
```

### 4.3 Projected Coordinate System - Complex Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "ntia-location:coordinate_system": {
        "id": "5",
	"description": "Field survey 5",
	"type": "pcs",
        "ntia-location:pcs": {
	  "id": "EPSG:26753",
	  "description": "Colorado North",
	  "ntia-location:gcs": {
	    "id": "EPSG 4267",
	    "description": "NAD27",
	    "ntia-location:datum": {
	      "id": "ESPG 6267",
	      "description": "North American Datum 1927",
	      "ntia-location:spheroid": {
	        "id": "EPSG 7008",
	        "description": "Clarke 1866"
	      }
	    }
	  }
	},
	"distance-unit": "Meters",
	"elevation-ref": "MSL",
        "elevation-unit": "Meters"
      }
    },  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 1000,
      "ntia-location:x": 1987467.0893,
      "ntia-location:y": 326767.3945,
      "ntia-location:z": 1645.7
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 1000,
      "core:sample_count": 2000,
      "ntia-location:x": 1987487.0342,
      "ntia-location:y": 326812.2387,
      "ntia-location:z": 1649.7
    }
  ]
}
```

### 4.4 Geographic Coordinate System - Simple Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "type: "gcs",
      "ntia-location:gcs": {
        "id": "EPSG 4326",
	"description": "WGS 84",
	"elevation-ref": "Above ground level",
	"elevation-unit": "Feet"
      }
    },  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 500,
      "ntia-location:x": -105.7743,
      "ntia-location:y": 40.7612,
      "ntia-location:z": 4.37
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 500,
      "core:sample_count": 1000,
      "ntia-location:x": -105.7573,
      "ntia-location:y": 40.7610,
      "ntia-location:z": 4.80
    }
  ]
}
```

### 4.5 Geographic Coordinate System - Complex Example
```json
{
  "global": {
    "core:datatype": "rf32_le",
    "core:sample_rate": 15360000,
    "ntia-sensor:sensor": {
      "id": "Greyhound_1",
      "type: "gcs",
      "ntia-location:gcs": {
        "id": "EPSG 4326",
	"description": "WGS 84",
        "ntia-location:datum": {
	      "id": "ESPG 6326",
	      "description": "WGS 1984",
	      "ntia-location:spheroid": {
	        "id": "EPSG 7030",
	        "description": "WGS 84"
	      }
	    },
	"distance-unit": "Decimal degrees"
	"elevation-ref": "Above ground level",
	"elevation-unit": "Feet"
      }
    },  
    "ntia-scos:task_id": 88438,
    "ntia-scos:end_time": "2019-04-22T15:41:52Z"
  },
  "captures": [
    ...
  ],
  "annotations": [
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 0,
      "core:sample_count": 500,
      "ntia-location:x": -105.7743,
      "ntia-location:y": 40.7612,
      "ntia-location:z": 4.37
    },
    {
      "ntia-core:annotation_type": "SensorAnnotation",
      "core:sample_start": 500,
      "core:sample_count": 1000,
      "ntia-location:x": -105.7573,
      "ntia-location:y": 40.7610,
      "ntia-location:z": 4.80
    }
  ]
}
```
