package eureka.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "conta-service", configuration = ContaClient.ProductsRibbonConfiguration.class)
public class ContaClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ContaClient.class)
                .web(false)
                .run(args);
    }
    
    @Configuration
    public static class ProductsRibbonConfiguration {
        @Bean
        public IRule ribbonRule() {
            return new RoundRobinRule();
        }
    }
}
