package com.example.course.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.domain.Post;
import com.example.course.repository.PostRepository;
import com.example.course.resources.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;


	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	
}
