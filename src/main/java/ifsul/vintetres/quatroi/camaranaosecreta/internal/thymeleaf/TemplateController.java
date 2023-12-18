package ifsul.vintetres.quatroi.camaranaosecreta.internal.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.DeputadoReadService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoReadService;
import ifsul.vintetres.quatroi.camaranaosecreta.internal.services.EventoUpdateService;

@Controller
public class TemplateController {
	
	private static final boolean SHOW_HOME_PAGE = true;
	
	@Autowired
	private DeputadoReadService deputadoReadService;

	@Autowired
	private EventoReadService eventoReadService;
	
	@Autowired
	private EventoUpdateService eventoUpdateService;

	@GetMapping("/")
	public String home() {
		if(SHOW_HOME_PAGE)
			return Templates.HOME;
		else
			return "redirect:/listaDeputados";
	}

	@GetMapping("/" + Templates.LISTA_DEPUTADOS)
	public ModelAndView listaDeputados() {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_DEPUTADOS);

		modelAndView.addObject("deputados", deputadoReadService.findAllInAlphabeticalOrder());

		return modelAndView;
	}

//	@GetMapping("/" + Templates.DEPUTADO + "/{id}")
//	public ModelAndView deputado(@PathVariable Integer id) {
//		ModelAndView modelAndView = new ModelAndView(Templates.DEPUTADO);
//
//		addDeputadoToModelIfPresent(modelAndView, id); // exception?
//
//		return modelAndView;
//	}

	@GetMapping("/" + Templates.LISTA_EVENTOS)
	public ModelAndView listaEventos() {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_EVENTOS);
		
		modelAndView.addObject("eventos", eventoReadService.findAll());

		return modelAndView;
	}

	@GetMapping("/" + Templates.LISTA_EVENTOS + "/{deputadoId}")
	public ModelAndView listaEventosDeputado(@PathVariable Integer deputadoId) {
		ModelAndView modelAndView = new ModelAndView(Templates.LISTA_EVENTOS_DEPUTADO);

		modelAndView.addObject("listasEventos", eventoReadService.findSubscribedAndNotByDeputado(deputadoId));
		
		deputadoReadService.findById(deputadoId).ifPresent(deputado -> modelAndView.addObject("deputado", deputado));

		return modelAndView;
	}

	@GetMapping("/" + Templates.INSCREVER)
	public ModelAndView inscreverTemplate(@RequestParam(required = false) Integer eventoId, @RequestParam(required = false) Integer deputadoId) {
		ModelAndView modelAndView = new ModelAndView(Templates.INSCREVER);
		
		if(deputadoId == null) deputadoId = -1;
		if(eventoId == null) eventoId = -1;
		
		deputadoReadService.findById(deputadoId).ifPresent(deputado -> modelAndView.addObject("deputado", deputado));
		
		eventoReadService.findById(eventoId).ifPresent(evento -> modelAndView.addObject("evento", evento));
		
		modelAndView.addObject("eventosNaoInscrito", eventoReadService.findWhereDeputadoIsNotSubscribed(deputadoId));
		modelAndView.addObject("deputados", deputadoReadService.findAllInAlphabeticalOrder());
		
		return modelAndView;
	}
	
	@PutMapping("/" + Templates.INSCREVER)
	public String inscreverAction(@RequestParam(required = false) Integer eventoId, @RequestParam(required = false) Integer deputadoId) {
		deputadoReadService.findById(deputadoId).ifPresent(deputado -> eventoUpdateService.subscribe(eventoId, deputado));
		
		return "redirect:/" + Templates.LISTA_EVENTOS + "/" + deputadoId;
	}
	
	@PutMapping("/" + Templates.DESINSCREVER)
	public String desinscreverAction(@RequestParam(required = false) Integer eventoId, @RequestParam(required = false) Integer deputadoId) {
		deputadoReadService.findById(deputadoId).ifPresent(deputado -> eventoUpdateService.unsubscribe(eventoId, deputadoId));
		
		return "redirect:/" + Templates.LISTA_EVENTOS + "/" + deputadoId;
	}
	
}
