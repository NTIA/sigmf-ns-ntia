# ntia-nasctn-sea extension v0.4.0
The `ntia-nasctn-sea` namespace provides SigMF metadata extensions for the NASCTN Sharing Ecosystem Assessment (SEA) project.

`ntia-scos` is fully compliant with the [SigMF](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#namespaces) specification and conventions.

## 1 Global
`ntia-nasctn-sea` defines the following keys that extend the [Global](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#global-object):

| name                            |required| type     |unit| description                                   |
|---------------------------------|--------------|----------|-------|-----------------------------------------------|
| `max_of_max_channel_powers`     |true| double[] |N/A| The maximum of the maximum power per channel. |
| `median_of_mean_channel_powers` |false| double[] |N/A| The median of the mean power per channel.     |


## 4 Example
```json
{
  "global": {
    "core:version": "v1.0.0",
    "core:extensions": [
      {
        "name": "ntia-nasctn-sea",
        "version": "v0.4.0",
        "optional": false
      }
    ],
    "core:geolocation": {
      "type": "Point",
      "coordinates": [
        -100.0,
        100.0,
        50.0
      ]
    },
    "core:datatype": "rf16",
    "core:sample_rate": 14000000.0,
    "core:num_channels": 15,
    "ntia-nasctn-sea:max_of_max_channel_powers": [
      -65.3125,
      -64.875,
      -64.375,
      -64.8125,
      -75.5625,
      -55.375,
      -55.125,
      -52.90625,
      -55.09375,
      -56.75,
      -56.4375,
      -70.0625,
      -70.5625,
      -47.03125,
      -42.8125
    ],
    "ntia-nasctn-sea:median_of_mean_channel_powers": [
      -83.875,
      -84.4375,
      -83.6875,
      -82.1875,
      -93.25,
      -77.375,
      -79.25,
      -74.25,
      -78.3125,
      -81.0625,
      -82.4375,
      -93.5,
      -91.875,
      -92.0625,
      -85.8125
    ]
  }
  "captures" : [... ],
  "annotations" : [ ...]
}
```
