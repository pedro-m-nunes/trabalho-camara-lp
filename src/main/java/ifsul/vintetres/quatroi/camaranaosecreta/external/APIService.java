package ifsul.vintetres.quatroi.camaranaosecreta.external;

import java.util.LinkedHashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;

@Service
public class APIService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String getDataAsString(String url) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
	
	public String getDadosAbertosDataAsString(String mapping) {
		String url = APIConfig.BASE_URL + mapping;
		return getDataAsString(url);
	}
	
	private <T> T getJSONObject(String mapping, Class<T> classOfT) { // ""?
		String data = getDadosAbertosDataAsString(mapping);
		
		JSONObject jsonObject = new JSONObject(data).getJSONObject("dados");
		
		if(classOfT.equals(Deputado.class))
			jsonObject = jsonObject.getJSONObject("ultimoStatus");
		
		return new Gson().fromJson(jsonObject.toString(), classOfT);
	}
	
	private <T> Set<T> getJSONArray(String mapping, Class<T> classOfT) { // ""?
		String data = getDadosAbertosDataAsString(mapping);
		
		JSONArray jsonArray = new JSONObject(data).getJSONArray("dados");
		
		Set<T> jsonObjects = new LinkedHashSet<>(); // LinkedHashSet?
		
		for(int i = 0; i < jsonArray.length(); i++) {
			jsonObjects.add(new Gson().fromJson(jsonArray.getJSONObject(i).toString(), classOfT));
		}
			
		return jsonObjects;
	}
	
	// getJSONArray que busca todos os dados dos deputados? Pode ser necessário para cadastros.
	
	public Deputado getDeputado(int id) {
		return getJSONObject("deputados/" + id, Deputado.class);
	}
	
	public Set<Deputado> getAllDeputados() {
		return getJSONArray("deputados", Deputado.class);
	}	
	
	// partido?
	
	public Evento getEvento(int id) {
		return getJSONObject("eventos/" + id, Evento.class);
	}
	
	public Set<Evento> getAllEventos() {
		return getJSONArray("eventos", Evento.class);
	}

}
