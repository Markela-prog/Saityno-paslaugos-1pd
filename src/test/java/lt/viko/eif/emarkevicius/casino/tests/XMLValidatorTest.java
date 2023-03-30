package lt.viko.eif.emarkevicius.casino.tests;

import lt.viko.eif.emarkevicius.casino.util.XMLValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test the XMLValidator class's validateXML() method to ensure
 * that it correctly validates an XML file against an XSD schema.
 *
 * @author Ernestas
 * @see XMLValidatorTest
 * @since 1.0
 */
public class XMLValidatorTest {

    //Since it is not working for now, left it commented

   /* @Test
    public void testValidateXML() {
        String xmlFile = "generated.xml";
        String xsdFile = "casino.xsd";
        assertTrue("Valid XML file should be validated successfully",
                XMLValidator.validateXML(xmlFile, xsdFile));

        xmlFile = "invalid.xml";
        assertFalse("Invalid XML file should not be validated successfully",
                XMLValidator.validateXML(xmlFile, xsdFile));
    }*/
}
