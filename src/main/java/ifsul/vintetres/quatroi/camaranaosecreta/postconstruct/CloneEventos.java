package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoCreateService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;
import jakarta.annotation.PostConstruct;

@Component
public class CloneEventos {

	@Autowired
	private EventoReadService eventoReadService;
	
	@Autowired
	private EventoCreateService eventoCreateService;
	
	@PostConstruct
	private void run() {
		if(eventoReadService.count() == 0) {
			eventoCreateService.cloneAllFromAPI();
		}
	}
	
}
