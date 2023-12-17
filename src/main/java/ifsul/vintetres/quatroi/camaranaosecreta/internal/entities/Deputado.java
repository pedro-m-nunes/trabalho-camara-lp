package ifsul.vintetres.quatroi.camaranaosecreta.internal.entities;

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
	// GeneratedValue só se for incluído o cadastro de deputados.
	private Integer id;
	
	private String nome;
	
	private String siglaPartido; // id...
	
}
