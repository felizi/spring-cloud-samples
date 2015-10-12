package eureka.conta.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ServicoTeste {
	private static final int random = new Random().nextInt();
	
	@RequestMapping(method = RequestMethod.GET)
    String teste() {
        return "OK" + random;
    }
	
}
