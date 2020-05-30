package com.supercode.springdotsay.repositotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supercode.springdotsay.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
