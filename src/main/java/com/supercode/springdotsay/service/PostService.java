package com.supercode.springdotsay.service;

import java.util.List;

import com.supercode.springdotsay.model.Post;

public interface PostService {
	
	public List<Post> findAll();
	
	public Post findById(int id);
	
	public Post create(Post post);
	
	public Post edit (Post post);
	
	public void deleteById(int id);

}
