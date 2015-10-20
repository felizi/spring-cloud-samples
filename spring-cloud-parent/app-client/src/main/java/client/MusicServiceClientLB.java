package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MusicServiceClientLB {

	@Autowired
    private RestTemplate restTemplate;
	
	
	public String listarArtistas(){
		
		ResponseEntity<String> exchange =
                this.restTemplate.exchange(
                        "http://music-player-service/artistas",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {
                        });
		
		return exchange.getBody();
	}
}
