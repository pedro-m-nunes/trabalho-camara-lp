package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoCreateService;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn("cloneEventos")
public class InsertEventos {

	@Autowired
	private EventoCreateService eventoCreateService;
	
	@PostConstruct
	private void run() {
		Set<Evento> eventos = new LinkedHashSet<>();
		
		eventos.add(new Evento("Churrasco", "Venha participar de um churrasco exclusivo, onde a política encontra o sabor! Junte-se a nós para uma tarde descontraída entre deputados, boa comida e conversas animadas. Será um evento imperdível de camaradagem e sabores intensos. Contamos com a sua presença!"));
		
		eventoCreateService.saveAll(eventos);
	}
	
}
