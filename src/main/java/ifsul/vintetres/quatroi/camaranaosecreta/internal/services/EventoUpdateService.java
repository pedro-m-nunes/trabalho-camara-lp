package ifsul.vintetres.quatroi.camaranaosecreta.internal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.EventoRepository;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.UpdateService;

@Service
public class EventoUpdateService implements UpdateService<Evento, Integer> {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Evento update(Integer id, Evento updatedEntity) {
		Evento evento = updatedEntity;
		
		evento.setId(id);
		
		return eventoRepository.save(evento);
	}
	
	public Evento subscribe(Integer id, Deputado deputado) {
		Evento evento = eventoRepository.findById(id).get();
		
		evento.getInscritos().add(deputado);
		
		return eventoRepository.save(evento);
	}
	
	// subscribeAll?
	
	// unsubscribe?

}
