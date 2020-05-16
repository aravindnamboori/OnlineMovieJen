package com.cg.sprint.movie.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.ms.movie.dto.Movie;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class MovieApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	
	@LocalServerPort
	int localServerPort;

	@Test
	public void testAddMovie_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"addMovie";
		Movie movie=new Movie(3010,"F3","Telugu","AR","vv","tm",144,LocalDate.now(),"Comedy");
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, movie, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	/*
	@Test
	public void testAddMovie_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"addMovie";
		Movie movie=null;
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, movie, String.class);
		Assertions.assertEquals(400, response.getStatusCodeValue());
	}*/
     @Test
	public void testDeleteMovie_Positive() throws Exception
	{
    	 String url="http://localhost:"+localServerPort+"deleteMovie/3008";
 		ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
 		 Assertions.assertEquals(200, response.getStatusCodeValue());
	}
     @Test
 	public void testDeleteMovie_Negative() throws Exception
 	{
 		String url="http://localhost:"+localServerPort+"deleteMovie/3099";
 		ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
 		 Assertions.assertEquals(400, response.getStatusCodeValue());
 	}
     @Test
 	public void testGetMovie_Positive() throws Exception
 	{
 		String url="http://localhost:"+localServerPort+"getMovie/3001";
 		ResponseEntity<Movie> movie=testRestTemplate.getForEntity(url, Movie.class);
 		Assertions.assertEquals(200, movie.getStatusCodeValue());
 	}
 	
 	@Test
 	public void testGetMovie_Negative() throws Exception
 	{
 		String url="http://localhost:"+localServerPort+"getMovie/3009";
 		ResponseEntity<Movie> movie=testRestTemplate.getForEntity(url, Movie.class);
 		Assertions.assertEquals(404, movie.getStatusCodeValue());
 	}
 	 @Test
  	public void testGetMovieByMovieName_Positive() throws Exception
  	{
  		String url="http://localhost:"+localServerPort+"getMovieByMovieName/BLI";
  		ResponseEntity<Movie> movie=testRestTemplate.getForEntity(url, Movie.class);
  		Assertions.assertEquals(200, movie.getStatusCodeValue());
  	}
  	
  	@Test
  	public void testGetMovieByMovieName_Negative() throws Exception
  	{
  		String url="http://localhost:"+localServerPort+"getMovieByMovieName/xyz";
  		ResponseEntity<Movie> movie=testRestTemplate.getForEntity(url, Movie.class);
  		Assertions.assertEquals(404, movie.getStatusCodeValue());
  	}

	
}
