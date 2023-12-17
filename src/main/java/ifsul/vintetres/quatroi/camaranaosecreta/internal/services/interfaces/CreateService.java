package ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces;

import java.util.List;

public interface CreateService<T> {
	
	T save(T entity);
	
	List<T> saveAll(Iterable<T> entities);

}
