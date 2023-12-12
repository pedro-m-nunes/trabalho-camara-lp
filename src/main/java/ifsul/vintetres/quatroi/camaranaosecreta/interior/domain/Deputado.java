package ifsul.vintetres.quatroi.camaranaosecreta.interior.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deputado {

	@Id
	private int id;
	
	private String nome;
	
	private String siglaPartido; // id...
	
}
