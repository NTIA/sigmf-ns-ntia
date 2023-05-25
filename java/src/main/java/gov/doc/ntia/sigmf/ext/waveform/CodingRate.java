package gov.doc.ntia.sigmf.ext.waveform;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodingRate extends ArrayList<Long> implements Serializable {

  private static final long serialVersionUID = 1L;

  public CodingRate() {

    super(2);
  }

  public void setK(long k) {
    add(0, k);
  }

  public void setN(long n) {
    add(1, n);
  }

}
