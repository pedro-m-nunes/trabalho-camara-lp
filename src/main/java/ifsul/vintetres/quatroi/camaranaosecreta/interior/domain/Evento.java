package ifsul.vintetres.quatroi.camaranaosecreta.interior.domain;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

	@Id
	private int id;
	
	private String nome;
	
//	private String descricao;
	
	private LocalDateTime inicio, fim; // ""?
	
	// local?
	
	@ManyToMany
	private Set<Deputado> inscritos;
	
}
