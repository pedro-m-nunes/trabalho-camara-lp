package ifsul.vintetres.quatroi.camaranaosecreta.external;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;

@RestController
@RequestMapping("/dadosabertos")
public class APIController {

	@Autowired
	private APIService apiService;
	
	@GetMapping("/{mapping}")
	public String get(@PathVariable String mapping) {
		mapping = mapping.replace("_", "/");
		return apiService.getDadosAbertosDataAsString(mapping);
	}
	
	@GetMapping("/d/{id}") // 220593, 204379, 220714, 221328...
	public Deputado getDeputado(@PathVariable int id) { // temp
		return apiService.getDeputado(id);
	}
	
	@GetMapping("/d/all")
	public Set<Deputado> getAllDeputados() { // temp
		return apiService.getAllDeputados();
	}
	
	@GetMapping("/e/{id}") // 71077...
	public Evento getEvento(@PathVariable int id) { // temp
		return apiService.getEvento(id);
	}
	
	@GetMapping("/e/all")
	public Set<Evento> getAllEventos() { // temp
		return apiService.getAllEventos();
	}
	
}
