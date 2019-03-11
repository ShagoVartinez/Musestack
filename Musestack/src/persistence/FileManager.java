package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileManager {
	
	private ArrayList<Object> objectsList;
	
	public FileManager() {		
	}
	
//	public void readArtists() throws SAXException, IOException, ParserConfigurationException{
//		File fXmlFile = new File("./data/ArtistsData.xml");
//		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fXmlFile);
//		document.getDocumentElement().normalize();
//		System.out.println(document.getDocumentElement().getNodeName());
//		
//		NodeList readArtistsList = document.getElementsByTagName("Artist");
//		
//		
//		System.out.println(readArtistsList.getLength());
//		
//		for (int i = 0 ; i < readArtistsList.getLength() ; i++) {
//			NodeList artistItems = readArtistsList.item(i).getChildNodes();
//			String name = artistItems.item(1).getTextContent();
//	System.out.println(artistItems.getLength());
//			int id = Integer.parseInt(artistItems.item(5).getTextContent());
//			String email = artistItems.item(7).getTextContent();
//	System.out.println( artistItems.item(9).getChildNodes().getLength());
//			String country = artistItems.item(9).getChildNodes().item(3).getTextContent();
//			String city = artistItems.item(9).getChildNodes().item(1).getTextContent();
//			//add elemnts to object
//			objectsList.add(new Object());
//			
//			System.out.println("no se han agregado localidades XD \n" + objectsList.toString());
//		}
		
//	}

//	System.out.println("readArtist outcome: \n name:" +  + "\n id:" +  + "\n email:" +  + "\n :" +  + "\n :" +  + "\n :" +  +);
	
}
