package ifsul.vintetres.quatroi.camaranaosecreta.exterior;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import ifsul.vintetres.quatroi.camaranaosecreta.interior.domain.Deputado;

@Service
public class APIService {
	
	static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String getDataAsString(String url) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
	
	public String getDadosAbertosDataAsString(String mapping) {
		String url = BASE_URL + mapping;
		return getDataAsString(url);
	}
	
	private <T> T getJSONObject(String mapping, Class<T> classOfT) { // ""?
		String data = getDadosAbertosDataAsString(mapping);
		
		JSONObject jsonObject = new JSONObject(data).getJSONObject("dados").getJSONObject("ultimoStatus");
		
		return new Gson().fromJson(jsonObject.toString(), classOfT);
	}
	
	private <T> List<T> getJSONArray(String mapping, Class<T> classOfT) { // ""?
		String data = getDadosAbertosDataAsString(mapping);
		
		JSONArray jsonArray = new JSONObject(data).getJSONArray("dados");
		
		List<T> jsonObjects = new ArrayList<>(); // LinkedHashSet?
		
		for(int i = 0; i < jsonArray.length(); i++) {
			jsonObjects.add(new Gson().fromJson(jsonArray.getJSONObject(i).toString(), classOfT));
		}
			
		return jsonObjects;
	}
	
	// getJSONArray que busca todos os dados dos deputados? Pode ser necessário para cadastros.
	
	public Deputado getDeputado(int id) {
		return getJSONObject("deputados/" + id, Deputado.class);
	}
	
	public List<Deputado> getAllDeputados() {
		return getJSONArray("deputados", Deputado.class);
	}
	
	// clone // if is array, cloneAll (?)
	// cloneAll

}
