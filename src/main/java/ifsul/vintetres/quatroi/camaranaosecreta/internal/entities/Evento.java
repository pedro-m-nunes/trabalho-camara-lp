package ifsul.vintetres.quatroi.camaranaosecreta.internal.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
//	private String descricao;
	
	@Column(nullable = false)
	private LocalDateTime inicio, fim; // ""? // fim > inicio
	
	// local...
	
	@ManyToMany
	private Set<Deputado> inscritos;

	public Evento(String nome, LocalDateTime inicio, LocalDateTime fim) { // ?
		super();
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
	}
	
}
