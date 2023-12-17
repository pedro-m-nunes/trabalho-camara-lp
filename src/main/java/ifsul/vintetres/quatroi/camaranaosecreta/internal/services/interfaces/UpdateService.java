package ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces;

public interface UpdateService<T, ID> {

	T update(ID id, T updatedEntity);
	
}
