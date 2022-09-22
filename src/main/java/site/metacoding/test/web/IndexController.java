package site.metacoding.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String main() {
		return "/main";
	}

	@GetMapping("/stardium/stardiumList")
	public String stardiumList() {
		return "/stardium/stardiumList";
	}

	@GetMapping("/stardium/stardiumSaveForm")
	public String stardiumSaveForm() {
		return "/stardium/stardiumSaveForm";
	}

	@GetMapping("/team/teamList")
	public String teamList() {
		return "/team/teamList";
	}

	@GetMapping("/team/teamSaveForm")
	public String teamSaveForm() {
		return"/team/teamSaveForm";
	}
	
	@GetMapping("/player/playerList")
	public String playerList() {
		return "/player/playerList";
	}
	
	@GetMapping("/player/playerSaveForm")
	public String playerSaveForm() {
		return "/player/playerSaveForm";
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
