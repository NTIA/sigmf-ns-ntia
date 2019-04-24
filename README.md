# SigMF-NS-NTIA

This Signal Metadata Format [SigMF](https://github.com/gnuradio/SigMF) namespace extension describes the National
Telecommunications and Information Administration (NTIA)'s open data format for
recorded signal datasets.

## Introduction

SigMF is a simple, extensible standard for
storing recorded signal datasets. The
[Introduction](https://github.com/gnuradio/SigMF/blob/master/sigmf-spec.md#introduction)
to the core specification document explains why such a standard is useful:

> Sharing sets of recorded signal data is an important part of science and engineering. It enables multiple parties to collaborate, is often a necessary part of reproducing scientific results (a requirement of scientific rigor), and enables sharing data with those who do not have direct access to the equipment required to capture it.

> Unfortunately, these datasets have historically not been very portable, and there is not an agreed upon method of sharing metadata descriptions of the recorded data itself. This is the problem that SigMF solves.

> By providing a standard way to describe data recordings, SigMF facilitates the sharing of data, prevents the "bitrot" of datasets wherein details of the capture are lost over time, and makes it possible for different tools to operate on the same dataset, thus enabling data portability between tools and workflows.

At NTIA, we have traditionally used several proprietary or internally-designed
metadata formats for storing recorded signal datasets. In an effort to reduce
duplication of effort and improve our ability to store and share our datasets
in accordance with open data initiatives, we have developed this set of
extensions to the core SigMF specification.

- [`ntia-core`](ntia-core.sigmf-ext.md) adds generally useful metadata fields
- [`ntia-sensor`](ntia-sensor.sigmf-ext.md) defines hardware components and settings
- [`ntia-algorithm`](ntia-algorithm.sigmf-ext.md) describes the measurement performed (detectors, algorithms, etc)
- [`ntia-calibration`](ntia-calibration.sigmf-ext.md) provides information about calibration factors applied to the data
- [`ntia-emitter`](ntia-emitter.sigmf-ext.md) gives information about the emitter being measured
- [`ntia-environment`](ntia-environment.sigmf-ext.md) gives information about the environment around a sensor or emitter
- [`ntia-waveform`](ntia-waveform.sigmf-ext.md) provides metadata to describe measured or transmitted waveforms
- [`ntia-interference`](ntia-interference.sigmf-ext.md) provides metadata for interference reporting
- [`ntia-scos`](ntia-scos.sigmf-ext.md) provides metadata for the NTIA Spectrum Characterization and Occupancy Sensing (SCOS) implementation
