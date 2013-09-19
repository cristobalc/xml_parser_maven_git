package es.cristobal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class xmlXPATHParser {

	public xmlXPATHParser()
	{
		try {
			Document xmlDocument;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.
			newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			xmlDocument = builder.parse("ejemplo.xml");
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			String groupId = xPath.evaluate("/project/build/plugins/plugin/groupId", xmlDocument);
			System.out.println("GroupId: " + groupId);
			NodeList nodes = (NodeList) xPath.evaluate("//book", xmlDocument, XPathConstants.NODESET);
			String artifactId = xPath.evaluate("/project/build/plugins/plugin/artifactId", xmlDocument);
			System.out.println("ArtifactId: " + artifactId);
		} 
		catch (Exception ex) 
		{
			
		}
	}
		
	public static void main(String args[])
	{
		new xmlXPATHParser();
	}
}
