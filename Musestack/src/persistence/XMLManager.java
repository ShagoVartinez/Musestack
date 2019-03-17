package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManager {
	
	private Document document;
	
	public ArrayList<Object> readFile() {
		ArrayList<Object> objectList = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(new File("./data/hl7-sample.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		document.getDocumentElement().normalize();
		System.out.println(document.getDocumentElement().getNodeName());
		createObject(document);
		return objectList;
	}
	
	public Object createObject(Document document) {
		String idExt = getAtribute(document, "patientRole", "id", "extension");
		String patientFirstName = getElement(document, "patientPatient", "given");
		String patientLastName = getElement(document, "patientPatient", "family");
		String assignedDoctorFirstName = getElement(document, "assignedPerson", "given");
		String assignedDoctorLastName = getElement(document, "assignedPerson", "family");
		String healtCondition = getElement(document, "custodian", "name");
		int id = Integer.parseInt(idExt);
		String patientName = patientFirstName+" "+patientLastName;
		String assignedDoctorName = assignedDoctorFirstName+" "+assignedDoctorLastName;
		System.out.println(id+"|"+patientName+"|"+assignedDoctorName+"|"+healtCondition);
//		Object object = Object(){id, patientName, assignedDoctorName, healtCondition};
		return null;
	}
	
	
	
	private String getAtribute(Document document, String elementA, String elementB, String tagName) {
		NodeList elementList = document.getElementsByTagName(elementA);
		for (int i = 0; i < elementList.getLength(); i++) {
			Element element = (Element)elementList.item(i);
			NodeList idList = element.getElementsByTagName(elementB);
			for (int j = 0; j < idList.getLength(); j++) {
				elementB = ((Element)(idList.item(0))).getAttribute(tagName);
			}
		}
		return elementB;
	}
	
	private String getElement(Document document, String element, String tagName) {
		NodeList list = document.getElementsByTagName(element);
		for (int i = 0; i < list.getLength(); i++) {
			element = ((Element) (list.item(i))).getElementsByTagName(tagName).item(0).getTextContent();
		}
		return element;
	}
	
//	public void writeFile(Object object) {
//		try {
//			Document documentBF = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//			Element root = documentBF.createElement("medicalHistory");
//			documentBF.appendChild(root);
//			
//			root.appendChild(createElement(document, , patient.getPatientName(),
//					patient.getAssignedDoctorName(), patient.getHealtCondition()));
//			
//			Transformer transformer = TransformerFactory.newInstance().newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//			transformer.transform(new DOMSource(document), new StreamResult(new File("./data/patient_report.xml")));
//			
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
//	}
	
//	private static Element createElement(Document document, int id, String patientName, String asignedDoctor, String healthCondition) {
//		Element patientElement = document.createElement("patient");
//		patientElement.setAttribute("ID", ""+id);
//
//		Element patientNameElement = document.createElement("patientName");
//		patientNameElement.setTextContent(patientName);
//
//		Element asignedDoctorElement = document.createElement("asignedDoctor");
//		asignedDoctorElement.setTextContent(asignedDoctor);
//
//		Element healthConditionElement = document.createElement("healthCondition");
//		healthConditionElement.setTextContent(healthCondition);
//
//		patientElement.appendChild(patientNameElement);
//		patientElement.appendChild(asignedDoctorElement);
//		patientElement.appendChild(healthConditionElement);
//		
//		return patientElement;
//	}
}