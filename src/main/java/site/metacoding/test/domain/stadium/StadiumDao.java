package site.metacoding.test.domain.stadium;

import java.util.List;

import site.metacoding.test.web.dto.request.stadium.StadiumSaveDto;

public interface StadiumDao {
	public void insert(StadiumSaveDto stadiumInsertDto);
	public List<Stadium> findAll();
	public Stadium findById(Integer id);
	public void update(Stadium stardium);
	public void deleteById(Integer id);
}
