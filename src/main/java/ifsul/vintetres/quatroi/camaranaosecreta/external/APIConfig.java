package ifsul.vintetres.quatroi.camaranaosecreta.external;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class APIConfig {

	static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
