package com.cg.sprint.ms.movie.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint.ms.movie.dao.MovieDAO;
import com.cg.sprint.ms.movie.dto.Movie;
@Service
public class MovieService 
{
    @Autowired
    MovieDAO mDao;
	public void setmDao(MovieDAO mDao) 
	{
		this.mDao = mDao;
	}
	
	/*@Transactional(readOnly=true)
	public Optional<Movie> getMovieByMovieNameAndLanguage(String movieName,String language)
	{
		return mDao.findMovieByMovieNameAndLanguage(movieName, language);
	}*/
	@Transactional(readOnly=true)
	public Optional<Movie> getMovieByMovieName(String movieName)
	{
		return mDao.findMovieByMovieName(movieName);
	}
    
	@Transactional(readOnly=true)
	public Optional<Movie> getMovie(int movieId)
	{
		return mDao.findById(movieId);
	}
	
	@Transactional(readOnly=true)
	public List<Movie> getMovies()
	{
		return mDao.findAll();
	}
	
	@Transactional
	public Movie insertMovie(Movie movie)
	{
		 return mDao.save(movie);
	}
	
	@Transactional
	public void deleteMovie(int movieId)
	{
		  mDao.deleteById(movieId);
	}
}
