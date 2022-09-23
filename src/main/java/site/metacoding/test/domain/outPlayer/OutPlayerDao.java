package site.metacoding.test.domain.outPlayer;

import java.util.List;

import site.metacoding.test.web.dto.request.outPlayer.OutPlayerSaveDto;
import site.metacoding.test.web.dto.response.player.OutPlayerList;

public interface OutPlayerDao {
	public void insert(OutPlayerSaveDto outPlayerSaveDto);
	public List<OutPlayerList> findAll();
	public List<OutPlayerList> findAllByTeamId(Integer teamId);
	public OutPlayer findById(Integer id);
	public void update(OutPlayer outPlayer);
	public void deleteById(Integer id);
}
