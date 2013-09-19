package es.cristobal;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class xmlSAXParser {
	
	public class SimpleHandler extends DefaultHandler {
		
		public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
		throws SAXException {
			if ("groupId".equals(localName)) {
			System.out.print("groupId details: " + atts.getValue("id"));
			} else {
			System.out.print(localName + ": ");
			}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.print(new String(ch, start, length));
		}
		
		public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
			if ("groupId".equals(localName)) {
				System.out.println("\n=================================");
			}
		}
		
	}
	
	public class SimpleErrorHandler implements ErrorHandler 
	{
		public void warning(SAXParseException e) throws SAXException
		{
			System.out.println(e.getMessage());
		}

		public void error(SAXParseException e) throws SAXException 
		{
			System.out.println(e.getMessage());
		}

		public void fatalError(SAXParseException e) throws SAXException {
			System.out.println(e.getMessage());
		}
	}
	
	public xmlSAXParser()
	{
		try {
			SAXParser saxParser;
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(true);
			saxParser = factory.newSAXParser();
			saxParser.setProperty(
			"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
			"http://www.w3.org/2001/XMLSchema");
			XMLReader reader = saxParser.getXMLReader();
			reader.setErrorHandler(new SimpleErrorHandler());
			reader.setContentHandler(new SimpleHandler());
			reader.parse("ejemplo.xml");
		} catch (Exception ex) {
			
		}
	}
	
	public static void main(String args[]) 
	{
		new xmlSAXParser();
	}
	
}
