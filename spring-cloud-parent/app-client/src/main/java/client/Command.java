package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Command implements CommandLineRunner {
	
	@Autowired
	private MusicServiceClientLB musicServiceClient;
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true){
			
			
			String artistas = musicServiceClient.listarArtistas();
		
			System.out.println("\n\nArtistas");
			System.out.println(artistas);
			
			Thread.sleep(1000);
		}
	}
}
