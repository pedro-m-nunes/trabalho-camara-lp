package ifsul.vintetres.quatroi.camaranaosecreta.internal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsul.vintetres.quatroi.camaranaosecreta.external.APIService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.DeputadoRepository;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.APICloner;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces.CreateService;

@Service
public class DeputadoCreateService implements CreateService<Deputado>, APICloner<Deputado> {

	@Autowired
	private DeputadoRepository deputadoRepository;
	
	@Override
	public Deputado save(Deputado entity) {
		return deputadoRepository.save(entity);
	}

	@Override
	public List<Deputado> saveAll(Iterable<Deputado> entities) {
		return deputadoRepository.saveAll(entities);
	}
	
	@Autowired
	private APIService apiService;

	@Override
	public Deputado cloneFromAPI(int id) {
		return save(apiService.getDeputado(id));
	}

	@Override
	public List<Deputado> cloneAllFromAPI() {
		return saveAll(apiService.getAllDeputados());
	}
	
}
