package ifsul.vintetres.quatroi.camaranaosecreta.internal.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.EventoRepository;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.ReadService;

@Service
public class EventoReadService implements ReadService<Evento, Integer> {

	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}

	@Override
	public long count() {
		return eventoRepository.count();
	}

	@Override
	public Optional<Evento> findById(Integer id) {
		return eventoRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return eventoRepository.existsById(id);
	}

	public List<List<Evento>> findSubscribedAndNotByDeputado(Integer deputadoId) {
		List<Evento> subscribedEventos = eventoRepository.findAllBySubscribedDeputado(deputadoId);
		List<Evento> notSubscribedEventos = eventoRepository.findAllByNotSubscribedDeputado(deputadoId);

		return Arrays.asList(subscribedEventos, notSubscribedEventos);
	}
	
//	public List<Evento> findAllInChronologicalOrder() {
//		return eventoRepository.findAllByOrderByInicio();
//	}
	
//	public List<Evento> findAllPastEventos() {
//		LocalDateTime now = LocalDateTime.now();
//		return eventoRepository.findAllByFimLessThanEqualOrderByInicio(now);
//	}
//	
//	public List<Evento> findAllCurrentEventos() {
//		LocalDateTime now = LocalDateTime.now();
//		return eventoRepository.findAllByInicioLessThanEqualAndFimGreaterThanOrderByInicio(now, now);
//	}
//	
//	public List<Evento> findAllFutureEventos() {
//		LocalDateTime now = LocalDateTime.now();
//		return eventoRepository.findAllByInicioGreaterThanOrderByInicio(now);
//	}
//	
//	public List<Evento> findAllBySubscribedDeputado(Integer deputadoId) {
//		return eventoRepository.findAllByDeputadoId(deputadoId);
//	}
//
//	public List<Integer> findAllIdsBySubscribedDeputado(Integer deputadoId) {
//		return eventoRepository.findAllIdsByDeputadoId(deputadoId);
//	}
//
//	public List<Evento> findAllPastEventosWhereDeputadoIsNotSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByFimLessThanEqualAndIdNotInOrderByInicio(now, subscribedEventosIds);
//	}
//	
//	public List<Evento> findAllCurrentEventosWhereDeputadoIsNotSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByInicioLessThanEqualAndFimGreaterThanAndIdNotInOrderByInicio(now, now, subscribedEventosIds);
//	}
//	
//	public List<Evento> findAllFutureEventosWhereDeputadoIsNotSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByInicioGreaterThanAndIdNotInOrderByInicio(now, subscribedEventosIds);
//	}
//	
//	public List<Evento> findAllPastEventosWhereDeputadoIsSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByFimLessThanEqualAndIdInOrderByInicio(now, subscribedEventosIds);
//	}
//	
//	public List<Evento> findAllCurrentEventosWhereDeputadoIsSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByInicioLessThanEqualAndFimGreaterThanAndIdInOrderByInicio(now, now, subscribedEventosIds);
//	}
//	
//	public List<Evento> findAllFutureEventosWhereDeputadoIsSubscribed(Integer deputadoId) {
//		LocalDateTime now = LocalDateTime.now();
//		List<Integer> subscribedEventosIds = findAllIdsBySubscribedDeputado(deputadoId);
//		
//		if(subscribedEventosIds.isEmpty())
//			return findAllCurrentEventos();
//		else
//			return eventoRepository.findAllByInicioGreaterThanAndIdInOrderByInicio(now, subscribedEventosIds);
//	}
	
}
