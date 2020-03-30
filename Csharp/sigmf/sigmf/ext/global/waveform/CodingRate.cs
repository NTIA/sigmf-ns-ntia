using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace sigmf
{
    [Serializable()]
    public class CodingRate : ArrayList

        // fix the list
    {
        private static readonly long serialVersionUID = 1L;

        protected Dictionary<string, Object> otherfields = new Dictionary<string, Object>();

        public CodingRate() {
            //this.base(2);
        }
        public void setK(long k) {
            this.Insert(0,k);
        }
        public void setN(long n) {
            this.Insert(1,n);
        }
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
