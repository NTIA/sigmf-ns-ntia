using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Numerics;
using System.Text;

namespace sigmf
{
    public class DoubleSerializer 
    {
        public void serialize(Double value)
        {
            JsonConvert.SerializeObject(value);
        }
    }
}
