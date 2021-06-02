using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace sigmf
{
    public class AnnotationComparator<T> : IComparer<Annotation>
    {
        public int Compare(Annotation a1, Annotation a2) {
            return a1.SampleStart.CompareTo(a2.SampleStart);
        }

    }
}
