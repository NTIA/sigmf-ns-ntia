using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable]
    public class Extensions
    {
        private static readonly long serialVersionUID = 1L;

        protected List<Extension> extensions;

        public Extensions()
        {
            extensions = new List<Extension>();
        }
        public List<Extension> getExtensions()
        {
            return extensions;
        }

        public void setExtensions(List<Extension> extensions)
        {
            this.extensions = extensions;
        }

        public void addExtension(Extension extension)
        {
            extensions.Add(extension);
        }
    }
}
