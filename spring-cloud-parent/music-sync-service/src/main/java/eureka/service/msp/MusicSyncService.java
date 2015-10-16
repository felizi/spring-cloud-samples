package eureka.service.msp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MusicSyncService {

	public static void main(String[] args) {
        SpringApplication.run(MusicSyncService.class, args);
    }
    	
}
