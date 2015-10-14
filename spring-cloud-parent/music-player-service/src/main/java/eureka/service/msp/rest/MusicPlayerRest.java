package eureka.service.msp.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MusicPlayerRest {

	@RequestMapping(method = RequestMethod.GET, value = "/artistas")
	String artistas() {
		return "1 - AA\n2 - BB";
	}

}
