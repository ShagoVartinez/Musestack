package persistence;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class JSONManager {
	
//	public ArrayList<Object> readFile() throws FileNotFoundException, IOException, ParseException {
//		ArrayList<Object> list = new ArrayList<>();
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(new FileReader("resources/subvenciones.json"));
//		
//		JSONObject jsonObject = (JSONObject)obj;
//		
//		JSONArray listJSON = (JSONArray)jsonObject.get("campos deportivos");
//		
//		@SuppressWarnings("unchecked")
//		Iterator<Object> iteratorEntities = listJSON.iterator();
//		while (iteratorEntities.hasNext()) {
//			JSONObject objectEnt = (JSONObject)iteratorEntities.next();
//			String asociacion = (String)objectEnt.get("ASOCIACIÃ“N");
//			System.out.println("names: " + asociacion);
//			
//			String cif = (String)objectEnt.get("CIF");
//			System.out.println("names: " + cif);
//			
//			int id = Integer.parseInt(String.valueOf(objectEnt.get("SUBVENCIÃ“N EN EUROS")));
//			System.out.println("id: " + id);
//			list.add(new Object[]{asociacion, cif, id});
//		}
//		return list;
//	}
//	
//	public ArrayList<Object> readFile2() throws FileNotFoundException, IOException, ParseException {
////		ArrayList<Object> list = new ArrayList<>();
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(new FileReader("resources/pistas.geojson"));
//		
//		JSONObject jsonObject = (JSONObject)obj;
//		
//		// []se lee con JSONArray   {}se lee con JSONObject
//		
//		JSONArray listJSON = (JSONArray)jsonObject.get("features");
//		
//		@SuppressWarnings("unchecked")
//		Iterator<Object> iteratorEntities = listJSON.iterator();
//		while (iteratorEntities.hasNext()) {
//			JSONObject objectEnt = (JSONObject)iteratorEntities.next();
//			String tipo = (String)objectEnt.get("type");
//			System.out.println("TIPO: " + tipo);
//			
//			JSONObject objj = (JSONObject)objectEnt.get("properties");
//			
//			String name = (String)objj.get("NOMBRE");
//			System.out.println("NOMBRE: "+name);
//			
//			JSONObject objGeo = (JSONObject)objectEnt.get("geometry");
//			
//			JSONArray listGoe = (JSONArray)objGeo.get("coordinates");
//			System.out.println("COORD:");
//			System.out.println("X: "+listGoe.get(0));
//			System.out.println("Y: "+listGoe.get(1));
//			
//		}
//		return null;
//	}
}