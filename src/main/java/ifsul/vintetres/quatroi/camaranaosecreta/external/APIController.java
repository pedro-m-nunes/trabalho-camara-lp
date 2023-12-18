package ifsul.vintetres.quatroi.camaranaosecreta.external;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> get(@PathVariable String mapping) {
		mapping = mapping.replace("_", "/");
		return ResponseEntity.ok(apiService.getDadosAbertosDataAsString(mapping));
	}
	
	@GetMapping("/d/{id}") // 220593, 204379, 220714, 221328...
	public ResponseEntity<Deputado> getDeputado(@PathVariable int id) { // temp
		return ResponseEntity.ok(apiService.getDeputado(id));
	}
	
	@GetMapping("/d/all")
	public ResponseEntity<Set<Deputado>> getAllDeputados() { // temp
		return ResponseEntity.ok(apiService.getAllDeputados());
	}
	
	@GetMapping("/e/{id}") // 71077...
	public ResponseEntity<Evento> getEvento(@PathVariable int id) { // temp
		return ResponseEntity.ok(apiService.getEvento(id));
	}
	
	@GetMapping("/e/all")
	public ResponseEntity<Set<Evento>> getAllEventos() { // temp
		return ResponseEntity.ok(apiService.getAllEventos());
	}
	
}
