package ifsul.vintetres.quatroi.camaranaosecreta.internal.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private Integer id;
	
	@Column(nullable = false)
	private String descricaoTipo;
	
	@Column(length = 2047) // ?
	private String descricao;
	
//	@Column(nullable = false)
//	private LocalDateTime dataHoraInicio, dataHoraFim; // fim > inicio // JsonDeserializer
	
	// local?
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Deputado> inscritos;

	public Evento(Integer id, String descricaoTipo, String descricao) {
		super();
		this.id = id;
		this.descricaoTipo = descricaoTipo;
		this.descricao = descricao;
	}
	
	public Evento(String descricaoTipo, String descricao) {
		super();
		this.descricaoTipo = descricaoTipo;
		this.descricao = descricao;
	}
	
}
