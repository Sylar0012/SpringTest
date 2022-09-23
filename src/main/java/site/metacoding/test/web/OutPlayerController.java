package site.metacoding.test.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.service.OutPlayerService;
import site.metacoding.test.service.PlayerService;
import site.metacoding.test.web.dto.request.outPlayer.OutPlayerSaveDto;
import site.metacoding.test.web.dto.response.CMRespDto;
import site.metacoding.test.web.dto.response.player.OutPlayerList;

@RequiredArgsConstructor
@Controller
public class OutPlayerController {
	
	private final OutPlayerService outPlayerService;
	
	@GetMapping("/player/outPlayerList/{teamId}")
	public String outPlayerList(@PathVariable Integer teamId, Model model) {
		List<OutPlayerList> outPlayerList = outPlayerService.팀별퇴출선수목록(teamId);
		model.addAttribute("outPlayerList",outPlayerList);
		return "player/outPlayerList";
	}
	
	@GetMapping("/player/playerOutForm")
	public String playerOutForm(Model model) {
		List<OutPlayerList> outPlayerList = outPlayerService.퇴출선수목록();
		model.addAttribute("outPlayerList",outPlayerList);
		return "/player/playerOutForm";
	}
	
	@PostMapping("/player/outPlayer")
	public @ResponseBody CMRespDto<?> playerOut(@RequestBody OutPlayerSaveDto outPlayerSaveDto){
		outPlayerService.선수퇴출(outPlayerSaveDto);
		return new CMRespDto<>(1, "선수 퇴출 이유 등록 성공", null);
	}
}
