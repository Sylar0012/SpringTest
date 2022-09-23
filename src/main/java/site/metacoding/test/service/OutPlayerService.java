package site.metacoding.test.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.outPlayer.OutPlayerDao;
import site.metacoding.test.domain.stadium.StadiumDao;
import site.metacoding.test.web.dto.request.outPlayer.OutPlayerSaveDto;
import site.metacoding.test.web.dto.response.player.OutPlayerList;



@RequiredArgsConstructor
@Service
public class OutPlayerService {
	
	private final OutPlayerDao outPlayerDao;

	public List<OutPlayerList> 팀별퇴출선수목록(Integer teamId){
		List<OutPlayerList> outPlayerList = outPlayerDao.findAllByTeamId(teamId);
		return outPlayerList;
	}
	public List<OutPlayerList> 퇴출선수목록( ){
		List<OutPlayerList> outPlayerList = outPlayerDao.findAll();
		return outPlayerList;
	}
	
	public void 선수퇴출(OutPlayerSaveDto outPlayerSaveDto) {
		outPlayerDao.insert(outPlayerSaveDto);
	}

	
}
