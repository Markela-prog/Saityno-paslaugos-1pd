package lt.viko.eif.emarkevicius.casino.util;

import jakarta.xml.bind.*;
import lt.viko.eif.emarkevicius.casino.model.*;

import java.io.*;

/**
 * The JaxbUtil class provides utility methods for converting a Casino object to XML using JAXB.
 *
 * @author Ernestas
 * @see JaxbUtil
 * @since 1.0
 */
public final class JaxbUtil {

    /**
     * Converts a Casino object to XML and writes the output to a file named "generated.xml".
     *
     * @param casino the Casino object to convert to XML
     *
     * @throws RuntimeException if an error occurs during the conversion process
     */
    public static void convertToXML(Casino casino){
        try{
            JAXBContext context = JAXBContext.newInstance(Casino.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.setProperty("jaxb.fragment", Boolean.TRUE);
            OutputStream os = new FileOutputStream("generated.xml");
            os.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n".getBytes());
            os.write("<!DOCTYPE casino SYSTEM \"casino.dtd\">".getBytes("UTF-8"));
            marshaller.marshal(casino, os);
        }
        catch (JAXBException | IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts an XML file to a Casino object.
     *
     * @param filePath the path of the XML file to convert
     *
     * @return the Casino object created from the XML file
     *
     * @throws RuntimeException if an error occurs during the conversion process
     */
    public static Casino convertFromXML(String filePath) {
        try {
            System.setProperty("javax.xml.accessExternalDTD", "all");
            JAXBContext context = JAXBContext.newInstance(Casino.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File file = new File(filePath);
            return (Casino) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
