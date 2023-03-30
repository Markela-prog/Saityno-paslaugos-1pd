package lt.viko.eif.emarkevicius.casino.util;

import javax.xml.XMLConstants;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;


/**
 * A utility class that provides a method to validate an XML file against a specified XSD schema file.
 *
 * @author Ernestas
 * @see XMLValidator
 * @since 1.0
 */
public class XMLValidator {
    /**
     * Validates an XML file against a specified XSD schema file.
     *
     * @param xmlFile the path to the XML file to be validated.
     *
     * @param xsdFile the path to the XSD schema file.
     *
     * @return true if the validation succeeds, false otherwise.
     */
    public static boolean validateXML(String xmlFile, String xsdFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
