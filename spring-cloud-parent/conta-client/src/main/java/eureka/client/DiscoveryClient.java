package eureka.client;

import java.net.URI;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
class DiscoveryClientExample implements CommandLineRunner {

    @Autowired
    private Servico1Client servicoClient;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Override
    public void run(String... strings) throws Exception {
    	System.out.println("\n\n\n");
    	System.out.println(servicoClient.getInfo());
    	System.out.println(servicoClient.getInfo());
//    	System.out.println(servicoClient.getInfo());
//    	System.out.println(servicoClient.getInfo());
//        discoveryClient.getInstances("servico1").forEach((ServiceInstance s) -> {
//        	System.out.println(s.getUri());
//        	
//            
//        });
    	
    	ServiceInstance instance1 = loadBalancer.choose("conta-service");
    	ServiceInstance instance2 = loadBalancer.choose("conta-service");
    	ServiceInstance instance3 = loadBalancer.choose("conta-service");
    	ServiceInstance instance4 = loadBalancer.choose("conta-service");
        System.out.println(instance1.getUri());
        System.out.println(instance2.getUri());
        System.out.println(instance3.getUri());
        System.out.println(instance4.getUri());
        
    }
    
    
    @FeignClient("conta-service")
    interface Servico1Client {

        @RequestMapping(method = RequestMethod.GET, value = "/info")
        String getInfo();
    }
    
}
