package es.cristobal;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class xmlStAXParser {

	public xmlStAXParser()
	{
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream("ejemplo.xml");
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart().equals("groupId")) 
					{
						event = eventReader.nextEvent();
						System.out.println("GroupId =================================");
						continue;
					}
				}
				if (event.isStartElement()) 
				{
					if (event.asStartElement().getName().getLocalPart().equals("artifactId")) 
					{
						event = eventReader.nextEvent();
						System.out.println("artifactId: " + event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals("version")) 
					{
						event = eventReader.nextEvent();
						System.out.println("version: " + event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals("configuration")) 
					{
						event = eventReader.nextEvent();
						System.out.println("configuration: " + event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals("parameter")) 
					{
						event = eventReader.nextEvent();
						System.out.println("parameter: " + event.asCharacters().getData());
						continue;
					}
				}
			}
		} catch (Exception ex) {
			
		}
	}
	
	public static void main(String args[])
	{
		new xmlStAXParser();
	}
	
}
