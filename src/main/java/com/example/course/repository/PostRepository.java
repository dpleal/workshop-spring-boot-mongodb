package com.example.course.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.course.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // consulta personalizada usando uma query Json do MongoDb // ?0 quer dizer que éo primeiro parâmetro que virá (parecido com o DART)
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); // consulta completa montada pelo SpringBoot (ver material de apoio aula 349)
	
	

}
