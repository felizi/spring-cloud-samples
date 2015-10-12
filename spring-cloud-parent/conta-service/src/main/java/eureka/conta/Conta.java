package eureka.conta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Conta {

	public static void main(String[] args) {
        SpringApplication.run(Conta.class, args);
    }
    	
}
