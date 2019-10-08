package app.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("wakeUp")
public class WakeUpController {

	@GetMapping 
	private ResponseEntity wakeUp(){

		return ResponseEntity.ok().build();
	}
}
