package util;

import org.w3c.dom.*;
import org.w3c.dom.ls.*;
import org.w3c.dom.bootstrap.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class UtilDom {

	private UtilDom() {
	}

	/**
	 * Genera el arbol DOM del archivo parametro
	 * 
	 * @param ruta          archivo xml del que generar el arbol
	 * @param ignoreComents <code>true</code> para ignorar comentarios,
	 *                      <code>false</code> para no;
	 * @return objeto conteniendo el arbol generado, <code>null</code> si ocurre
	 *         algun error
	 */
	public static Document creaArbol(String ruta, boolean ignoreComments) {
		Document doc = null;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			factoria.setIgnoringComments(ignoreComments);
			doc = factoria.newDocumentBuilder().parse(ruta);
		} catch (Exception e) {
			System.out.println("Error generando el árbol DOM: " + e.getMessage());
		}
		return doc;
	}

	/**
	 * Guarda un arbol DOM en el archivo especificado
	 * 
	 * @param doc               arbol a grabar en disco
	 * @param ruta              ruta del archivo xml para el guardado, si no existe
	 *                          lo crea
	 * @param removeIndentation true si se desea quitar la indentacion, false si no
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws FileNotFoundException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	public static void grabarDOM(Document doc, String ruta, boolean removeIndentation)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		if (removeIndentation) {
			removeIndentation(doc);
		}
		DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
		DOMImplementationLS ls = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");

		LSOutput output = ls.createLSOutput();
		output.setEncoding("UTF-8");

		output.setByteStream(new FileOutputStream(ruta));

		LSSerializer serializer = ls.createLSSerializer();

		serializer.setNewLine("\r\n");
		serializer.getDomConfig().setParameter("format-pretty-print", true);

		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(ruta)));

	}

	/**
	 * Guarda un arbol DOM en el archivo especificado
	 * 
	 * @param doc               arbol a grabar en disco
	 * @param ruta              ruta del archivo xml para el guardado, si no existe
	 *                          lo crea
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws FileNotFoundException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	public static void grabarDOM(Document doc, String ruta) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		grabarDOM(doc, ruta, false);
	}

	/**
	 * Quita la indentacion de un arbol DOM
	 * 
	 * @param doc arbol del cual quitar la indentacion
	 */
	public static void removeIndentation(Document doc) {
		removeWhitespaces(doc.getDocumentElement());
	}

	private static void removeWhitespaces(Element element) {
		NodeList children = element.getChildNodes();
		for (int i = children.getLength() - 1; i >= 0; i--) {
			Node child = children.item(i);
			if (child instanceof Text
					&& ((Text) child).getData().trim().isEmpty()) {
				element.removeChild(child);
			} else if (child instanceof Element) {
				removeWhitespaces((Element) child);
			}
		}
	}
}
