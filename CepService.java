package br.com.republicavirtual.cep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CepService {

	public static void main(String[] args) {


		// Define o CEP
		String cep = "00000000";
		
		// a string da url		
		String urlString = "http://cep.republicavirtual.com.br/web_cep.php";

		// os parametros a serem enviados
		Properties parameters = new Properties();
		parameters.setProperty("cep", cep);
		parameters.setProperty("formato", "xml");

		// o iterador, para criar a URL
		Iterator i = parameters.keySet().iterator();
		// o contador
		int counter = 0;

		// enquanto ainda existir parametros
		while (i.hasNext()) {

			// pega o nome
			String name = (String) i.next();
			// pega o valor
			String value = parameters.getProperty(name);

			// adiciona com um conector (? ou &)
			// o primeiro � ?, depois s�o &
			urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
			
		}

		try {
			// cria o objeto url
			URL url = new URL(urlString);

			// cria o objeto httpurlconnection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// seta o metodo
			connection.setRequestProperty("Request-Method", "GET");

			// seta a variavel para ler o resultado
			connection.setDoInput(true);
			connection.setDoOutput(false);

			// conecta com a url destino
			connection.connect();

			// abre a conex�o pra input
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// le ate o final
			StringBuffer newData = new StringBuffer();
			String s = "";
			while (null != ((s = br.readLine()))) {
				newData.append(s);
			}
			br.close();

			// Controi classe a partir do XML 
			XStream xstream = new XStream(new DomDriver());
			Annotations.configureAliases(xstream, CepServiceVO.class);
			xstream.alias("webservicecep", CepServiceVO.class);
			CepServiceVO cepServiceVO = (CepServiceVO) xstream.fromXML(newData.toString());
			
			// Imprime Resuntado Final 
			System.out.println(new String(newData));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
