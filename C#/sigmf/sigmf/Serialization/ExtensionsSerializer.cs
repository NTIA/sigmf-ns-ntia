using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;
using System.Text.Json;

namespace sigmf
{
    public class ExtensionsSerializer<T> 
    {
        public ExtensionsSerializer() {
            
        }

        public void serialize(Extensions exts) {

          JsonConvert.SerializeObject(exts);

        }
    }
}
