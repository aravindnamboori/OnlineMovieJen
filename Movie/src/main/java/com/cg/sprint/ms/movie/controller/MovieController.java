package com.cg.sprint.ms.movie.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.ms.movie.dto.Movie;
import com.cg.sprint.ms.movie.service.MovieService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MovieController 
{
	 @Autowired
	 MovieService movieService;
	 public void setMovieService(MovieService movieService) { this.movieService = movieService; }
	 
	/*@GetMapping(value="/getMovieBy/movieName/{movieName}/language/{language}",produces="application/json")
	 public ResponseEntity<Optional<Movie>> getMovieByMovieNameAndLanguage(@PathVariable String movieName,@PathVariable String language)
	 {
		 System.out.println("hello");
		 System.out.println(movieName+"  "+language);
		 Optional<Movie> movie =  movieService.getMovieByMovieNameAndLanguage(movieName, language);
		 if(movie.isPresent())
	  		  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
	  	  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.NOT_FOUND);
	 }*/
	 @GetMapping(value="/getMovieByMovieName/{movieName}",produces="application/json")
	 public ResponseEntity<Optional<Movie>> getMovieByMovieName(@PathVariable String movieName)
	 {
		 System.out.println("hello");
		 System.out.println(movieName);
		 Optional<Movie> movie =  movieService.getMovieByMovieName(movieName);
		 if(movie.isPresent())
	  		  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
	  	  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.NOT_FOUND);
	 }
    @GetMapping(value="/getMovie/{movieId}",produces="application/json")
    public ResponseEntity<Optional<Movie>> getMovieDetails(@PathVariable int movieId)
    {
    	System.out.println("hi "+movieId);
  	  Optional<Movie> movie =  movieService.getMovie(movieId);
  	  if(movie.isPresent())
  		  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
  	  return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value="/getMovies",produces="application/json")
    public List<Movie> getMoviesDetails()
    {
  	  return movieService.getMovies();
    }
    
    @PostMapping(value="/addMovie",consumes="application/json")
    public ResponseEntity<String> addMovieDetails(@RequestBody() Movie movie)
    {
  	  try
  	  {
  	      movieService.insertMovie(movie);
  	      return new ResponseEntity<String>("Movie Added",HttpStatus.OK);
  	  }
  	  catch(Exception ex)
  	  {
  	    	return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
  	  } 
    }
    
    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<String> deleteMovieDetails(@PathVariable int movieId)
    {
  	  try
  	  {
  	    movieService.deleteMovie(movieId);
  	    return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
  	  }
  	  catch(Exception ex)
  	  {
  		  return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
  	  }
    }
}

