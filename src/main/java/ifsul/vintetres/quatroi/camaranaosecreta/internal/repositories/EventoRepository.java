package ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
	@Query("SELECT e.id FROM Evento e")
	public List<Integer> findAllIds();
	
	@Query("SELECT e FROM Evento e INNER JOIN e.inscritos d WHERE d.id = ?1")
	public List<Evento> findAllBySubscribedDeputado(Integer deputadoId);
	
	@Query("SELECT e.id FROM Evento e INNER JOIN e.inscritos d WHERE d.id = ?1")
	public List<Integer> findAllIdsBySubscribedDeputado(Integer deputadoId);
	
	@Query("SELECT e FROM Evento e WHERE e.id NOT IN (SELECT e.id FROM Evento e INNER JOIN e.inscritos d WHERE d.id = ?1)")
	public List<Evento> findAllByNotSubscribedDeputado(Integer deputadoId);
	
//	public List<Evento> findAllByOrderByDataHoraInicio();
	
//	public List<Evento> findAllByFimLessThanEqualOrderByInicio(LocalDateTime fimMaximo); // (params = now) Eventos passados.
//	
//	public List<Evento> findAllByInicioLessThanEqualAndFimGreaterThanOrderByInicio(LocalDateTime inicioMaximo, LocalDateTime fimMinimo); // (params = now) Eventos em andamento.
//	
//	public List<Evento> findAllByInicioGreaterThanOrderByInicio(LocalDateTime inicioMinimo); // (params = now) Eventos futuros.
//	
//	public List<Evento> findAllByFimLessThanEqualAndIdNotInOrderByInicio(LocalDateTime fimMaximo, Iterable<Integer> excludingIds);
//	
//	public List<Evento> findAllByInicioLessThanEqualAndFimGreaterThanAndIdNotInOrderByInicio(LocalDateTime inicioMaximo, LocalDateTime fimMinimo, Iterable<Integer> excludingIds);
//	
//	public List<Evento> findAllByInicioGreaterThanAndIdNotInOrderByInicio(LocalDateTime inicioMinimo, Iterable<Integer> excludingIds);
//	
//	public List<Evento> findAllByFimLessThanEqualAndIdInOrderByInicio(LocalDateTime fimMaximo, Iterable<Integer> ids);
//	
//	public List<Evento> findAllByInicioLessThanEqualAndFimGreaterThanAndIdInOrderByInicio(LocalDateTime inicioMaximo, LocalDateTime fimMinimo, Iterable<Integer> ids);
//	
//	public List<Evento> findAllByInicioGreaterThanAndIdInOrderByInicio(LocalDateTime inicioMinimo, Iterable<Integer> ids);
	
}
