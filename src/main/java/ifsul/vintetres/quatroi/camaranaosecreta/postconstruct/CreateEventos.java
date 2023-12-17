package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoCreateService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;
import jakarta.annotation.PostConstruct;

@Component
public class CreateEventos {

	@Autowired
	private EventoReadService eventoReadService;
	
	@Autowired
	private EventoCreateService eventoCreateService;
	
	@PostConstruct
	public void run() {
		if(eventoReadService.count() == 0) {
			Set<Evento> eventos = new LinkedHashSet<>();
			
			eventos.add(new Evento("Churrasco", LocalDateTime.of(1995, 12, 1, 18, 0, 0), LocalDateTime.of(1995, 12, 2, 1, 0, 0)));
			eventos.add(new Evento("Corrida de bicicleta", LocalDateTime.of(2024, 4, 1, 12, 0, 0), LocalDateTime.of(2024, 4, 1, 13, 0, 0)));
			eventos.add(new Evento("Briga de faca", LocalDateTime.of(2023, 12, 1, 0, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59, 59)));
			
			eventoCreateService.saveAll(eventos);
		}
	}
	
}
