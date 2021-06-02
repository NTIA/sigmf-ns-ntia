using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf.Serialization
{
    public class ExtensionsDeserializer 
    {
        public ExtensionsDeserializer()
        {
        }
        public Extensions deserialize(string json)
        { 
            return JsonConvert.DeserializeObject<Extensions>(json);

        }


    }
}
