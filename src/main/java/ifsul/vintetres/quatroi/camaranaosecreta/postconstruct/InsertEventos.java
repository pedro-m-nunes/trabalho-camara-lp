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
		
		eventos.add(new Evento(1, "Abertura da Câmara", "Os 10 mandamentos devem ser as únicas leis ou devemos criar novas?"));
		eventos.add(new Evento("Lolzinho", "5v5. Só não vale Yuumi."));
		eventos.add(new Evento("Lolzinho", "5v5 tradicional."));
		eventos.add(new Evento("Lolzinho", "5v5 double jungle."));
		eventos.add(new Evento("LEGO Fortnite do PCdoB", "Pautas: projetar um veículo para destruirmos as construções do PL; construir um curral."));
		eventos.add(new Evento("Show do Eminem", "Grande cantor."));
		eventos.add(new Evento("Racha de moto", "Um simples racha de moto."));
		eventos.add(new Evento("Rachão de moto", "Um racha de moto mais sofisticado."));
		
		eventoCreateService.saveAll(eventos);
	}
	
}
