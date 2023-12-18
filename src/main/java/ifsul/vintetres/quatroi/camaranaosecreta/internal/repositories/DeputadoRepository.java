package ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;

public interface DeputadoRepository extends JpaRepository<Deputado, Integer> {
	
	public List<Deputado> findAllByOrderByNomeAsc();
	
	public List<Deputado> findAllBySiglaPartido(String siglaPartido);
	
	// query por partido
	
	// query por nome
	
	// query por outro atributo?
	
	// query por nome de evento inscrito
	
}
