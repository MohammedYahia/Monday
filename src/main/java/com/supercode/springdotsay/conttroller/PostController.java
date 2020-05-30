package com.supercode.springdotsay.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.supercode.springdotsay.model.Post;
import com.supercode.springdotsay.service.PostService;

@Controller
public class PostController {

	private PostService postService;
	
	@Autowired
	public PostController(PostService thePostService) {
		postService = thePostService;
	}
    @GetMapping("/posts/list")
    public String findAll(Model theModel){
    	
    	List<Post> thePost = postService.findAll();
    	theModel.addAttribute("post",thePost);
    	
    	return "posts/post_list";
    }
    @GetMapping("/posts/{id}")
    public String findPost(@PathVariable("id") int id , Model theModel) {
    	
    	Post tempPost = postService.findById(id);
    	if(tempPost == null) {
    		throw new RuntimeException("the Post NOT_FOUND--" + id);
    	}
    
    	return "post";
    
    }
    @PostMapping("post/create")
    public String createPost(Post post) {
    	postService.create(post);
    	
    	return "index";
    }

    @PostMapping("post/edit")
    public String editPost(Post post) {
    	
   
    	postService.edit(post);
    	
    	return "index";
    } 
    @DeleteMapping("/post/{id}")
	public void deleteById(@PathVariable("id") int id, Model theModel) {
	Post delPost = postService.findById(id);
	if(delPost == null) {
		throw new RuntimeException("the user NOT_FOUND--" +id);
		
	}
	    theModel.addAttribute("post",delPost);
	    postService.deleteById(id);
	
	
	}









}
