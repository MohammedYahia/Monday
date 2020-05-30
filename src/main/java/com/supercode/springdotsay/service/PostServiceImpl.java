package com.supercode.springdotsay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercode.springdotsay.model.Post;
import com.supercode.springdotsay.repositotry.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepo ;
	
	@Autowired
	public PostServiceImpl(PostRepository thePostRepo) {
		postRepo = thePostRepo;
	}
	@Override
	public List<Post> findAll() {
		
		return postRepo.findAll();
	}

	@Override
	public Post findById(int id) {
		
		Optional<Post> result = postRepo.findById(id);
		
		Post thePost = null;
		if(result.isPresent()) {
			thePost= result.get();
		}
		return thePost;
	}

	@Override
	public Post create(Post post) {
		
		return postRepo.save(post);
	}

	@Override
	public Post edit(Post post) {
		
		return postRepo.save(post);
	}

	@Override
	public void deleteById(int id) {
		 postRepo.deleteById(id);

	}

}
