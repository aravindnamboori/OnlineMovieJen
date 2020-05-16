package com.cg.sprint.ms.movie.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.ms.movie.dto.Movie;
public interface MovieDAO extends JpaRepository<Movie,Integer>
{
    public Optional<Movie> findMovieByMovieNameAndLanguage(String movieName,String language);
    public Optional<Movie> findMovieByMovieName(String movieName);
}