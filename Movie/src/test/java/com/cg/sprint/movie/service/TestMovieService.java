package com.cg.sprint.movie.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint.ms.movie.dto.Movie;
import com.cg.sprint.ms.movie.service.MovieService;

@SpringBootTest
public class TestMovieService 
{
	@Autowired
    MovieService movieService;
	 @Test
     public void testGetMovieByMovieName_Positive() throws Exception
     {
   	    Optional<Movie> movie = movieService.getMovieByMovieName("BLI");
   	    Assertions.assertEquals(true,movie.isPresent());
     }
     
     @Test
     public void testGetMovieByMovieName_Negative() throws Exception
     {
   	    Optional<Movie> movie = movieService.getMovieByMovieName("xyz");
   	    Assertions.assertEquals(false,movie.isPresent());
     }

     /*@Test
     public void testInsertMovie_Positive() throws Exception
     {
   	  Movie movie = new Movie(3009,"YMDk","Telugu","RJML","PB","An",186,LocalDate.now(),"Action");
   	  Movie m= movieService.insertMovie(movie);
   	  Assertions.assertEquals(m.getMovieName(), movie.getMovieName());
     }*/
    
     /*@Test
 	public void testInsertMovie_Negative() throws Exception
 	{
 		 Movie movie=null;
 		Movie m=movieService.insertMovie(movie);
 		Assertions.assertEquals(null,m.getMovieName());
 	}*/
     @Test
     public void testGetMovie_Positive() throws Exception
     { 
    	 Optional<Movie> movie = movieService.getMovie(3007);
 	    Assertions.assertEquals(true,movie.isPresent());
     }
     @Test
     public void testGetMovie_Negative() throws Exception
     {
    	 Optional<Movie> movie = movieService.getMovie(3012);
 	    Assertions.assertEquals(false,movie.isPresent());
     }
     @Test
      public void testDeleteMovie_Positive() throws Exception
      {
    	 movieService.deleteMovie(3003);
    	 Optional<Movie> m=movieService.getMovie(3009);
    	 Assertions.assertEquals(false,m.isPresent());
      }
      
    /* @Test
     public void testDeleteMovie_Negative() throws Exception
     {
    	 movieService.deleteMovie(3050);
    	 Assertions.assertNull(movieService.getMovie(3050));
     }*/

}
