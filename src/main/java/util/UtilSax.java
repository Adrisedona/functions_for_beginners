package util;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

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
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T extends DefaultHandler> void getSax(String entradaXML, Class<T> clazz) throws ParserConfigurationException, SAXException, IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		T parserSax = clazz.getDeclaredConstructor().newInstance(); 
		parser.parse(entradaXML, parserSax);
	}
}
