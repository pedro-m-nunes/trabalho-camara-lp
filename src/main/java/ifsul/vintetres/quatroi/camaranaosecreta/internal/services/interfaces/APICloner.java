package ifsul.vintetres.quatroi.camaranaosecreta.internal.services.interfaces;

import java.util.List;

public interface APICloner<T> {

	T cloneFromAPI(int id);
	
	List<T> cloneAllFromAPI();
	
}
