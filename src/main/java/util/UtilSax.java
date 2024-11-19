package util;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class UtilSax {

	private UtilSax() {
		
	}

	/**
	 * Parsea un documento XML mediante SAX
	 * @param entradaXML documento a leer
	 * @param clazz Clase en la que se maneja el documento. Debe heredar de {@link DefaultHandler}
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static void getSax(String entradaXML, Class<? extends DefaultHandler> clazz) throws ParserConfigurationException, SAXException, IOException, NoSuchMethodException, SecurityException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		Object parserSax = clazz.getDeclaredConstructor(); 
		parser.parse(entradaXML, clazz.cast(parserSax));
	}
}
