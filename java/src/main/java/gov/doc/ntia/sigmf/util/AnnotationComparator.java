package gov.doc.ntia.sigmf.util;



import gov.doc.ntia.sigmf.Annotation;

import java.util.Comparator;

public class AnnotationComparator<T extends Annotation> implements Comparator<Annotation> {
    @Override
    public int compare(Annotation o1, Annotation o2) {
        return o1.getSampleStart().compareTo(o2.getSampleStart());
    }
}
