package persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class WEBManager {
	
	public static void readGallery() {
		String webService = "http://nexo.carm.es/nexo/archivos/recursos/opendata/json/GalerasdeArte.json";
		URL url;
		try {
			url = new URL(webService);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
			
			URLConnection connection = url.openConnection(proxy);
			
			System.out.println(connection);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			String web = "";
			while ((line = bufferedReader.readLine()) != null){
//				web += line + "\n";
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new WEBManager();
		WEBManager.readGallery();
	}

}
