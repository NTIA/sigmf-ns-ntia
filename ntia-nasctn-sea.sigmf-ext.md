# The `ntia-nasctn-sea` SigMF Extension Namespace v0.6.0

This document defines the `ntia-nasctn-sea` extension namespace for the Signal Metadata Format (SigMF) specification. This namespace extension provides metadata objects specifically suited for the NASCTN Sharing Ecosystem Assessment (SEA) project.

## 0 Datatypes

The `ntia-nasctn-sea` extension does not define any additional datatypes.

## 1 Global

The `ntia-nasctn-sea` extension adds the following fields, which provide summary power statistics for each capture in a recording, to the `global` SigMF object:

| name                            | required | type     | unit | description                                   |
|---------------------------------|----------|----------|------|-----------------------------------------------|
| `max_of_max_channel_powers`     | false    | double[] | dBm  | The maximum of the maximum power per channel. |
| `mean_channel_powers`           | false    | double[] | dBm  | The mean power per channel.                   |
| `median_channel_powers`         | false    | double[] | dBm  | The median power per channel.                 |
| `median_of_mean_channel_powers` | false    | double[] | dBm  | The median of the mean power per channel.     |

## 2 Captures

The `ntia-nasctn-sea` extension does not extend the `captures` SigMF object.

## 3 Annotations

The `ntia-nasctn-sea` extension does not extend the `annotations` SigMF object.

## 4 Collection

The `ntia-nasctn-sea` extension does not extend the `collection` SigMF object.

## 5 Example

The example shown below uses this extension to record channel power summaries for a 4-channel capture. In this case, the Captures array should have 4 elements.

```json
{
  "global" : {
    "core:datatype" : "rf32_le",
    "core:sample_rate" : 2.8E7,
    "core:version" : "1.0.0",
    "core:num_channels" : 4,
    "core:extensions" : [ {
      "name" : "ntia-core",
      "version" : "v2.0.0",
      "optional" : false
    }, {
      "name" : "ntia-nasctn-sea",
      "version" : "v0.6.0",
      "optional" : false
    } ],
    "ntia-core:classification" : "UNCLASSIFIED",
    "ntia-nasctn-sea:max_of_max_channel_powers" : [ -89.0, -93.0, -95.0 ],
    "ntia-nasctn-sea:mean_channel_powers" : [ -98.0, -102.0, -104.0 ],
    "ntia-nasctn-sea:median_channel_powers" : [ -98.5, -102.5, -104.5 ],
    "ntia-nasctn-sea:median_of_mean_channel_powers" : [ -99.0, -103.0, -105.0 ]
  },
  ...
  "captures" : [ ... ],
  "annotations" : [ ... ]
}
```
