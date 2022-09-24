package site.metacoding.test.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.outPlayer.OutPlayerDao;
import site.metacoding.test.domain.stadium.StadiumDao;
import site.metacoding.test.web.dto.request.outPlayer.OutPlayerSaveDto;
import site.metacoding.test.web.dto.response.player.OutPlayerListDto;



@RequiredArgsConstructor
@Service
public class OutPlayerService {
	
	private final OutPlayerDao outPlayerDao;

	public List<OutPlayerListDto> 팀별퇴출선수목록(Integer teamId){
		List<OutPlayerListDto> outPlayerList = outPlayerDao.findAllByTeamId(teamId);
		return outPlayerList;
	}
	public List<OutPlayerListDto> 퇴출선수목록( ){
		List<OutPlayerListDto> outPlayerList = outPlayerDao.findAll();
		return outPlayerList;
	}
	
	public void 선수퇴출(OutPlayerSaveDto outPlayerSaveDto) {
		outPlayerDao.insert(outPlayerSaveDto);
	}

	
}
