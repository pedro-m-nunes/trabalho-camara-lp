package ifsul.vintetres.quatroi.camaranaosecreta.internal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsul.vintetres.quatroi.camaranaosecreta.external.APIService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.EventoRepository;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.APICloner;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.CreateService;

@Service
public class EventoCreateService implements CreateService<Evento>, APICloner<Evento> {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Evento save(Evento entity) {
		generateIdIfNecessary(entity);
		return eventoRepository.save(entity);
	}

	@Override
	public List<Evento> saveAll(Iterable<Evento> entities) {
		entities.forEach(evento -> generateIdIfNecessary(evento));
		return eventoRepository.saveAll(entities);
	}
	
	@Autowired
	private APIService apiService;

	@Override
	public Evento cloneFromAPI(int id) {
		return save(apiService.getEvento(id));
	}

	@Override
	public List<Evento> cloneAllFromAPI() {
		return saveAll(apiService.getAllEventos());
	}
	
	@Autowired
	private EventoReadService eventoReadService;
	
	private static int LAST_ID = 0;
	
	private void generateIdIfNecessary(Evento evento) {
		if(LAST_ID == 0) {
			List<Integer> eventosIds = eventoReadService.findAllIds();
			if(eventosIds.size() > 0)
				LAST_ID = eventosIds.get(eventosIds.size() - 1);
		}
		
		if(evento.getId() == null) {
			int id;
			
			do {
				 id = LAST_ID + 1;
			} while(eventoReadService.findAllIds().contains(id));
			
			evento.setId(id);
			LAST_ID = id;
		}
	}

}
