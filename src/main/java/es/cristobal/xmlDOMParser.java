package es.cristobal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class xmlDOMParser {

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
	
	public xmlDOMParser()
	{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.
			newInstance();
			
			
			
			// Para parsear SIN VALIDACIÓN
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
			
			
			// Para parsear CON VALIDACIÓN DE UN XSD EXTERNO
			/*
			factory.setValidating(false);
			factory.setNamespaceAware(true);
			SchemaFactory schemaFactory = SchemaFactory.newInstance("http:/www.w3.org/2001/XMLSchema");
			factory.setSchema(schemaFactory.newSchema( new Source[]{new StreamSource("ejemplo.xsd")} ));
			*/
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new SimpleErrorHandler());
			Document doc = builder.parse("ejemplo.xml");
			NodeList list = doc.getElementsByTagName("*");
			for (int i = 0; i < list.getLength(); i++) 
			{
				Element element = (Element) list.item(i);
				
				//System.out.println(element.getNodeName() + " " + element.getTextContent());
				if (element.getNodeName().equalsIgnoreCase("groupId")) {
					System.out.println("groupId= " + element.getTextContent()); //+ element.getAttribute("id"));
				}
				if (element.getNodeName().equalsIgnoreCase("artifactId")) {
					System.out.println("artifactId= " + element.getTextContent()); //+ element.getAttribute("kind"));
				}
			}		
		} catch (Exception ex) {
			
		}
	}
	
	
  public static void main(String args[])
  {
    new xmlDOMParser();

    return;
  }

}
