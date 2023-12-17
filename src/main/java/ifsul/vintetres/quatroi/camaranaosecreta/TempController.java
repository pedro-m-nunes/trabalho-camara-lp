//package ifsul.vintetres.quatroi.camaranaosecreta;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
//import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Evento;
//import ifsul.vintetres.quatroi.camaranaosecreta.internal.repositories.EventoRepository;
//import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;
//import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoUpdateService;
//
//@RestController
//@RequestMapping("/temp")
//public class TempController {
//	
//	@Autowired
//	private EventoUpdateService eventoUpdateService;
//	
//	@PutMapping("/inscrever/{eventoId}")
//	public Evento subscribe(@PathVariable Integer eventoId, @RequestBody Deputado deputado) {
//		return eventoUpdateService.subscribe(eventoId, deputado);
//	}
//	
//	@Autowired
//	private EventoRepository eventoRepository;
//	
//	@GetMapping("/eventos/{deputadoId}")
//	public Object findAllByDeputadoId(@PathVariable Integer deputadoId) {
//		return eventoRepository.findAllIdsByDeputadoId(deputadoId);
//	}
//	
//	@Autowired
//	private EventoReadService eventoReadService;
//	
//	@GetMapping("/eventos/{deputadoId}/nao")
//	public Object findNotSubscribed(@PathVariable Integer deputadoId) {
//		return eventoReadService.findAllCurrentEventosWhereDeputadoIsNotSubscribed(deputadoId);
//	}
//	
//}
