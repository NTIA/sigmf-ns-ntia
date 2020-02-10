using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace sigmf
{
    public class SigMFReader
    {
        public static MetaDoc read(string fileName) {
            MetaDoc meta = JsonConvert.DeserializeObject<MetaDoc>(File.ReadAllText(fileName));
            return meta;
        }
    }
}
