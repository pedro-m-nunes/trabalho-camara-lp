package ifsul.vintetres.quatroi.camaranaosecreta.exterior;

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
	
	@GetMapping("/temp")
	public Object temp() { // temp
		return apiService.getDeputado(220593);
	}
	
	@GetMapping("/temp2")
	public Object temp2() { // temp
		return apiService.getAllDeputados();
	}
	
}
