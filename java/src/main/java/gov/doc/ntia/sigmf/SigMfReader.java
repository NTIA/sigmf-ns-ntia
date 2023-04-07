package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class SigMfReader {

  /**
   * Reads a MetaDoc from a JSON file.
   *
   * @param fileName The full path to a MetaDoc JSON file.
   * @return The MetaDoc defined in fileName.
   */
  public static MetaDoc read(String fileName) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      MetaDoc metaDoc = mapper.readValue(new File(fileName), MetaDoc.class);
      return metaDoc;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
