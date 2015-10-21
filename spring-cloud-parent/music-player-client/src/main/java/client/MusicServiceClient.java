package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class MusicServiceClient {
	
	@Autowired
	private MusicClient musicClient;
	
	public String listarArtistasFallback(){
		return "Nenhum artista encontrado";
	}
	
	@HystrixCommand(groupKey="MusicGroup", commandKey = "ListarArtistasCommand", fallbackMethod = "listarArtistasFallback")
	public String listarArtistas(){
		return musicClient.listarArtistas();
	}
	
	@FeignClient("music-player-service")
	interface MusicClient {
	
		@RequestMapping(method = RequestMethod.GET, value = "/artistas")
		String listarArtistas();
	}
	
}
