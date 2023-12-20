package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.DeputadoReadService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoUpdateService;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn({"cloneDeputados", "cloneEventos", "insertEventos"})
public class Subscribe {

	@Autowired
	private EventoUpdateService eventoUpdateService;
	
	@Autowired
	private EventoReadService eventoReadService;
	
	@Autowired
	private DeputadoReadService deputadoReadService;
	
	@PostConstruct
	private void run() {
		List<Deputado> deputados = deputadoReadService.findAllInAlphabeticalOrder();
		List<Integer> eventosIds = eventoReadService.findAllIds();
		
		eventoUpdateService.subscribe(eventosIds.get(0), deputados.get(0));
		eventoUpdateService.subscribe(eventosIds.get(1), deputados.get(0));
		eventoUpdateService.subscribe(eventosIds.get(2), deputados.get(0));
		
		eventoUpdateService.subscribe(eventosIds.get(0), deputados.get(1));
		eventoUpdateService.subscribe(eventosIds.get(5), deputados.get(1));
		eventoUpdateService.subscribe(eventosIds.get(7), deputados.get(1));
		eventoUpdateService.subscribe(eventosIds.get(3), deputados.get(1));

		for(Integer eventoId : eventosIds) {
			eventoUpdateService.subscribe(eventoId, deputados.get(2));
		}

//		// "Vermelho", "Celso Russomanno" e "Lebrão" em "Show do Eminem"
//		eventoUpdateService.subscribe(71583, deputadoReadService.findById(204396).get());
//		eventoUpdateService.subscribe(71583, deputadoReadService.findById(73441).get());
//		eventoUpdateService.subscribe(71583, deputadoReadService.findById(220600).get());
//		
//		// Deputados do PCdoB (e "Vermelho") em "LEGO Fortnite do PCdoB"
//		for(Deputado deputado : deputadoReadService.findAllBySiglaPartido("PCdoB"))
//			eventoUpdateService.subscribe(71582, deputadoReadService.findById(deputado.getId()).get());
//		
//		eventoUpdateService.subscribe(71582, deputadoReadService.findById(204396).get());
	}
	
}
