package com.sai.samithi.home.posts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    PostsRepository postRepository;
    
    @Autowired
    ModelMapper mapper;

    public PostsResponse add(PostsRequest postsRequest) {
    	Posts postsDb = Posts.builder()
    	.description(postsRequest.description())
    	.name(postsRequest.name())
    	.eventDateTime(postsRequest.eventDateTime())
    	.url(postsRequest.url())
    	.publishedOn(LocalDate.now())
    	.build();
    	Posts posts = postRepository.save(postsDb);
    	PostsResponse postsResponse = mapper.map(posts, PostsResponse.class);
    	return postsResponse ;
    }

    public List<PostsResponse> getAll() {
    	List<Posts> postsDb = postRepository.findAll();
    	List<PostsResponse> postsResponses = postsDb
     			.stream()
     			.map( posts -> mapper.map(posts, PostsResponse.class))
     			.collect(Collectors.toList());
        return postsResponses;
    }
}
