package ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface ReadService<T, ID> {

	List<T> findAll();
	
	long count();
	
	Optional<T> findById(ID id);
	
	boolean existsById(ID id);
	
}
