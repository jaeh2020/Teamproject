package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.BadWords;
import amdn.anywhere.mapper.BadWordsMapper;

@Service
public class BadWordsService {
	private final BadWordsMapper badWordsMapper;
	
	@Autowired
	public BadWordsService(BadWordsMapper badWordsMapper) {
		this.badWordsMapper = badWordsMapper;
	}
	
	public List<BadWords> getBadWordsList(){
		List<BadWords> badWordsList = badWordsMapper.getBadWordsList();
		
		return badWordsList;
	}
}
