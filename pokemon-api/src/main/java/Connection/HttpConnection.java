package Connection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import POJO.Pokemon;

public class HttpConnection {

	private static String BASE_URL  = "https://pokeapi.co/api/v2/pokemon/";
	private static String url;
	
	public HttpConnection(String randomId) {
		url = BASE_URL + randomId;
	}
	
	public String read() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
		String json = "";
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			json = response.body();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public Pokemon getJson() {
		Gson gson = new Gson();
		Pokemon pokemon = gson.fromJson(read(), Pokemon.class);
		
		return pokemon;
	}
	
}
