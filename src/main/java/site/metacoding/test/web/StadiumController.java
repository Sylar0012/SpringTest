package site.metacoding.test.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.stadium.Stadium;
import site.metacoding.test.service.StadiumService;
import site.metacoding.test.web.dto.request.stadium.StadiumSaveDto;
import site.metacoding.test.web.dto.request.stadium.StadiumUpdateDto;
import site.metacoding.test.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class StadiumController {

	private final StadiumService stadiumService;

	@GetMapping("/stardium/stardiumList")
	public String getStadiumList(Model model) {
		List<Stadium> stadiumList = stadiumService.경기장목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "/stardium/stardiumList";
	}

	@GetMapping("/stardium/stardiumSaveForm")
	public String stardiumSaveForm() {
		return "/stardium/stardiumSaveForm";
	}

	@PostMapping("/stadium/stardiumSave")
	public @ResponseBody CMRespDto<?> stardiumSave(@RequestBody StadiumSaveDto stadiumInsertDto) {
		stadiumService.경기장추가(stadiumInsertDto);
		return new CMRespDto<>(1, "경기장 등록 성공", null);
	}

	@GetMapping("/stadium/updateForm/{id}")
	public String stadiumUpdateForm(@PathVariable Integer id, Model model) {
		Stadium stadium = stadiumService.경기장한건보기(id);
		model.addAttribute("stadium", stadium);
		return "/stardium/stardiumUpdateForm";
	}

	@PutMapping("/stadium/update/{id}")
	public @ResponseBody CMRespDto<?> stadiumUpdateForm(@PathVariable  Integer id, @RequestBody StadiumUpdateDto stadiumUpdateDto) {
		Stadium stadiumPS = stadiumService.경기장한건보기(id);
		stadiumService.경기장명수정(id, stadiumUpdateDto);
		return new CMRespDto<>(1, "경기장명 수정 성공", null);
	}
	
	@DeleteMapping("/stadium/delete/{id}")
	public @ResponseBody CMRespDto<?> stadiumDelete(@PathVariable Integer id){
		stadiumService.경기장삭제(id);
		return new CMRespDto<>(1, "경기장 삭제 성공", null);
	}
}
