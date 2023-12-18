package ifsul.vintetres.quatroi.camaranaosecreta.internal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.DeputadoRepository;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.ReadService;

@Service
public class DeputadoReadService implements ReadService<Deputado, Integer> {
    
	@Autowired
	private DeputadoRepository deputadoRepository;

	@Override
	public List<Deputado> findAll() {
		return deputadoRepository.findAll();
	}

	@Override
	public long count() {
		return deputadoRepository.count();
	}

	@Override
	public Optional<Deputado> findById(Integer id) {
		return deputadoRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return deputadoRepository.existsById(id);
	}
	
	public List<Deputado> findAllInAlphabeticalOrder() {
		return deputadoRepository.findAllByOrderByNomeAsc();
	}
	
	public List<Deputado> findAllBySiglaPartido(String siglaPartido) {
		return deputadoRepository.findAllBySiglaPartido(siglaPartido);
	}
	
}
