using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable]
    public class Extensions
    {
        private static readonly long serialVersionUID = 1L;

        protected Extension[] extensions;

        public Extensions()
        {
            extensions = new Extension[400];
        }
        public Extension[] getExtensions()
        {
            return extensions;
        }

        public void setExtensions(Extension[] extensions)
        {
            this.extensions = extensions;
        }

        public int addExtension(Extension extension, int index)
        {
            extensions[index] = extension;
            return index + 1;
        }
    }
}
