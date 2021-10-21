package amdn.anywhere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.mapper.ReviewMapper;



@Service
@Transactional
public class ReviewService {
	
	 private final ReviewMapper reviewMapper;
	 
	  @Autowired 
	  public ReviewService(ReviewMapper reviewMapper) { 
		  this.reviewMapper = reviewMapper;
	 }
	  
	 
	

}
