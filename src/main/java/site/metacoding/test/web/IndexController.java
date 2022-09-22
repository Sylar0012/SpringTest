package site.metacoding.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String main() {
		return "/main";
	}







	

	

	
	@GetMapping("/team/teamPositionList")
	public String teamPositionList() {
		return "/team/teamPositionList";
	}
	
	@GetMapping("/player/outPlayerList")
	public String outPlayerList() {
		return "/player/outPlayerList";
	}
	
	@GetMapping("/player/playerOutForm")
	public String playerOutForm() {
		return "/player/playerOutForm";
	}
}
