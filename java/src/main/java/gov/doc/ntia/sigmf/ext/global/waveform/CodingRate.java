package gov.doc.ntia.sigmf.ext.global.waveform;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodingRate extends ArrayList<Long> implements Serializable {

  private static final long serialVersionUID = 1L;

  protected Map<String, Object> otherFields = new HashMap<>();

  public CodingRate() {

    super(2);
  }

  public void setK(long k) {
    add(0, k);
  }

  public void setN(long n) {
    add(1, n);
  }

  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    otherFields.put(key, value);
  }
}
