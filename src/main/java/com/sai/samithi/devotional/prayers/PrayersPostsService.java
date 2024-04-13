package com.sai.samithi.devotional.prayers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrayersPostsService {

    @Autowired
    PrayersPostsRepository postRepository;
    
    @Autowired
    ModelMapper mapper;

    public PrayerSPostsResponse add(PrayersPostsRequest postsRequest) {
    	PrayersPosts postsDb = PrayersPosts.builder()
    	.description(postsRequest.description())
    	.name(postsRequest.name())
    	.eventDateTime(postsRequest.eventDateTime())
    	.url(postsRequest.url())
    	.publishedOn(LocalDate.now())
    	.build();
    	PrayersPosts posts = postRepository.save(postsDb);
    	PrayerSPostsResponse postsResponse = mapper.map(posts, PrayerSPostsResponse.class);
    	return postsResponse ;
    }

    public List<PrayerSPostsResponse> getAll() {
    	List<PrayersPosts> postsDb = postRepository.findAll();
    	List<PrayerSPostsResponse> postsResponses = postsDb
     			.stream()
     			.map( posts -> mapper.map(posts, PrayerSPostsResponse.class))
     			.collect(Collectors.toList());
        return postsResponses;
    }
}
