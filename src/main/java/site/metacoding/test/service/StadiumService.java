package site.metacoding.test.service;



import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.stadium.Stadium;
import site.metacoding.test.domain.stadium.StadiumDao;
import site.metacoding.test.web.dto.request.stadium.StadiumSaveDto;


@RequiredArgsConstructor
@Service
public class StadiumService {
	private final StadiumDao stadiumDao;
	
	public List<Stadium> 경기장목록보기(){
		List<Stadium> stadiumList = stadiumDao.findAll();
		return stadiumList;
	}
	
	public void 경기장추가(StadiumSaveDto stadiumInsertDto) {
		stadiumDao.insert(stadiumInsertDto);
	}

}
