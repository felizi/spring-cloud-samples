package eureka.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Banco {

	public static void main(String[] args) {
        SpringApplication.run(Banco.class, args);
    }
    	
}
