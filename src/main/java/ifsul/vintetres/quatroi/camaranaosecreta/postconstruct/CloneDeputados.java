package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.DeputadoCreateService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.DeputadoReadService;
import jakarta.annotation.PostConstruct;

@Component
public class CloneDeputados {

	@Autowired
	private DeputadoReadService deputadoReadService;
	
	@Autowired
	private DeputadoCreateService deputadoCreateService;
	
	@PostConstruct
	private void run() {
		if(deputadoReadService.count() == 0) {
			deputadoCreateService.cloneAllFromAPI();
		}
	}
	
}
