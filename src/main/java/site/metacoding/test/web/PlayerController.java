package site.metacoding.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.player.Player;
import site.metacoding.test.service.PlayerService;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.response.CMRespDto;
import site.metacoding.test.web.dto.response.player.OutPlayerList;
import site.metacoding.test.web.dto.response.player.PlayerListDto;
import site.metacoding.test.web.dto.response.team.TeamListDto;


@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player/playerList")
	public String playerList(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "player/playerList";
	}
	
	@GetMapping("/player/playerSaveForm")
	public String playerSaveForm(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "player/playerSaveForm";
	}
	
	@PostMapping("/player/playerSave")
	public @ResponseBody CMRespDto<?> teamSave(@RequestBody PlayerSaveDto playerSaveDto){
		playerService.선수추가(playerSaveDto);
		return new CMRespDto<>(1, "팀 등록 성공", null);
	}
	
	@GetMapping("/player/updateForm/{id}")
	public String playerUpdateForm(@PathVariable Integer id, Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		Player player = playerService.선수한명보기(id);
		model.addAttribute("playerList",playerList);
		model.addAttribute("player",player);
		return "player/palyerUpdateForm";
	}
}
