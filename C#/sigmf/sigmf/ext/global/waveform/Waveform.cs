using System;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class Waveform : IEEE80211p
    {
        private static readonly long serialVersionUID = 1L;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public Dictionary<string, object> getOtherFields()
        {
            return otherfields;
        }
        public void add(string key, object value)
        {
            otherfields.Add(key, value);
        }
    }
}
