package ifsul.vintetres.quatroi.camaranaosecreta.internal.thymeleaf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.entities.Deputado;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.DeputadoReadService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;

@Controller
public class TemplateController {
	
	private static final boolean SHOW_HOME_PAGE = true;

	@GetMapping("/")
	public String home() {
		if(SHOW_HOME_PAGE)
			return Templates.HOME;
		else
			return "redirect:/listaDeputados";
	}

	@Autowired
	private DeputadoReadService deputadoReadService;

	@GetMapping("/" + Templates.LISTA_DEPUTADOS)
	public ModelAndView listaDeputados() {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_DEPUTADOS);

		modelAndView.addObject("deputados", deputadoReadService.findAllInAlphabeticalOrder());

		return modelAndView;
	}

	@GetMapping("/" + Templates.DEPUTADO + "/{id}")
	public ModelAndView deputado(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(Templates.DEPUTADO);

		Optional<Deputado> deputado = deputadoReadService.findById(id);

		if(deputado.isPresent())
			modelAndView.addObject("deputado", deputado.get());
		// else...

		return modelAndView;
	}

	@Autowired
	private EventoReadService eventoReadService;

	@GetMapping("/" + Templates.LISTA_EVENTOS)
	public ModelAndView listaEventos() {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_EVENTOS);
		
		modelAndView.addObject("eventosAndamento", eventoReadService.findAllCurrentEventos());
		modelAndView.addObject("eventosFuturos", eventoReadService.findAllFutureEventos());
		modelAndView.addObject("eventosPassados", eventoReadService.findAllPastEventos());

		return modelAndView;
	}

	@GetMapping("/" + Templates.LISTA_EVENTOS + "/{deputadoId}")
	public ModelAndView listaEventosDeputado(@PathVariable Integer deputadoId) {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_EVENTOS_DEPUTADO);
		
		// Map inscrito, naoInscrito?

		modelAndView.addObject("eventosInscrito", eventoReadService.findAllBySubscribedDeputado(deputadoId));
//		modelAndView.addObject("eventosInscritoAndamento", eventoReadService.findAllCurrentEventosWhereDeputadoIsSubscribed(deputadoId));
//		modelAndView.addObject("eventosInscritoFuturos", eventoReadService.findAllFutureEventosWhereDeputadoIsSubscribed(deputadoId));
//		modelAndView.addObject("eventosInscritoPassados", eventoReadService.findAllPastEventosWhereDeputadoIsSubscribed(deputadoId));
		
		modelAndView.addObject("eventosNaoInscritoAndamento", eventoReadService.findAllCurrentEventosWhereDeputadoIsNotSubscribed(deputadoId));
		modelAndView.addObject("eventosNaoInscritoFuturos", eventoReadService.findAllFutureEventosWhereDeputadoIsNotSubscribed(deputadoId));
		modelAndView.addObject("eventosNaoInscritoPassados", eventoReadService.findAllPastEventosWhereDeputadoIsNotSubscribed(deputadoId));
		
		Optional<Deputado> deputado = deputadoReadService.findById(deputadoId);

		if(deputado.isPresent())
			modelAndView.addObject("deputado", deputado.get());

		return modelAndView;
	}

	@GetMapping("/" + Templates.INSCREVER)
	public String inscrever(@RequestParam(required = false) Integer deputadoId, @RequestParam(required = false) Integer eventoId) {
		// ...
		
		return Templates.INSCREVER; // "redirect:/" + lista_eventos + id
	}

	// Put inscrever

//	@GetMapping("/" + Templates.CADASTRAR_EVENTO)
//	public String cadastrarEvento() { // ?
//		return Templates.CADASTRAR_EVENTO;
//	}
	
}
