package ifsul.vintetres.quatroi.camaranaosecreta.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
//	@GetMapping("/deputados/{id}") // 220593, 204379, 220714, 221328...
//	public Deputado getDeputado(@PathVariable int id) { // temp
//		return apiService.getDeputado(id);
//	}
//	
//	@GetMapping("/deputados")
//	public List<Deputado> getAllDeputados() { // temp
//		return apiService.getAllDeputados();
//	}
	
//	@GetMapping("/clone/deputados/{id}")
//	public Deputado cloneDeputado(@PathVariable int id) {
//		return apiService.cloneDeputado(id);
//	}
//	
//	@GetMapping("/clone/deputados/all") // ""?
//	public List<Deputado> cloneAllDeputados() {
//		return apiService.cloneAllDeputados();
//	}
	
}
