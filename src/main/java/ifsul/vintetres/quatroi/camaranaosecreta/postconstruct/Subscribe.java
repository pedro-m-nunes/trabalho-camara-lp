package ifsul.vintetres.quatroi.camaranaosecreta.postconstruct;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({"cloneDeputados", "cloneEventos", "insertEventos"})
public class Subscribe {

}
