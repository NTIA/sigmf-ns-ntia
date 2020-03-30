using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable]
    public class Extension
    {
        private static readonly long serialVersionUID = 1L;

        protected String name;

        protected String version;

        public string Name { get => name; set => name = value; }
        public string Version { get => version; set => version = value; }
    }
}
