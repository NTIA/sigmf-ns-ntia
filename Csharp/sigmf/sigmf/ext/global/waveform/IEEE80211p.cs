using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class IEEE80211p
    {
      private static readonly long serialVersionUID = 1L;

        [JsonProperty("info_bit_generation")]
        protected string infoBitGeneration;

        [JsonProperty("coding_rate")]
        protected CodingRate codingRate;

        [JsonProperty("packet_length")]
        protected long packetLength;

        [JsonProperty("modulation")]
        protected string modulation;

        [JsonProperty("encoder")]
        protected string encoder;

        [JsonProperty("number_of_subcarriers")]
        protected long numberOfSubcarriers;

        [JsonProperty("numberOfDataSubcarriers")]
        protected long numberOfDataSubcarriers;

        [JsonProperty("number_of_pilots")]
        protected long numberOfPilots;

        [JsonProperty("cyclic_prefix")]
        protected long cyclicPrefix;

        [JsonProperty("short_inter_frame_space")]
        protected double shortInterFrameSpace;

        [JsonProperty("preamble_frame")]
        protected int[] preambleFrame;

        [JsonProperty("number_of_info_bits")]
        protected long numberOfInfoBits;

        [JsonProperty("signal_to_noise_ratio")]
        protected double signalToNoiseRation;

        public string InfoBitGeneration { get => infoBitGeneration; set => infoBitGeneration = value; }
        public CodingRate CodingRate { get => codingRate; set => codingRate = value; }
        public long PacketLength { get => packetLength; set => packetLength = value; }
        public string Modulation { get => modulation; set => modulation = value; }
        public string Encoder { get => encoder; set => encoder = value; }
        public long NumberOfSubcarriers { get => numberOfSubcarriers; set => numberOfSubcarriers = value; }
        public long NumberOfDataSubcarriers { get => numberOfDataSubcarriers; set => numberOfDataSubcarriers = value; }
        public long NumberOfPilots { get => numberOfPilots; set => numberOfPilots = value; }
        public long CyclicPrefix { get => cyclicPrefix; set => cyclicPrefix = value; }
        public double ShortInterFrameSpace { get => shortInterFrameSpace; set => shortInterFrameSpace = value; }
        public int[] PreambleFrame { get => preambleFrame; set => preambleFrame = value; }
        public long NumberOfInfoBits { get => numberOfInfoBits; set => numberOfInfoBits = value; }
        public double SignalToNoiseRation { get => signalToNoiseRation; set => signalToNoiseRation = value; }

        public IEEE80211p()
        {

        }

    }
}
