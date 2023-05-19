package gov.doc.ntia.sigmf;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
      return validate(metaDoc);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static MetaDoc fromString(String doc) {
    ObjectMapper mapper = new ObjectMapper();
    MetaDoc metadoc = null;
    try {
      metadoc = mapper.readValue(doc, MetaDoc.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return validate(metadoc);
  }

  public static MetaDoc validate(MetaDoc metaDoc) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<MetaDoc>> violations = validator.validate(metaDoc);
    if (!violations.isEmpty()) {

      throw new ValidationException(violations.toString());
    }
    return metaDoc;
  }
}
