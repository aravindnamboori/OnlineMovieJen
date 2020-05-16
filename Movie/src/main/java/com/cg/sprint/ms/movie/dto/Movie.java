package com.cg.sprint.ms.movie.dto;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="moviedetails")
@SequenceGenerator(name = "movie_id_gen",initialValue = 3000,allocationSize = 1)
public class Movie 
{
     @Id
     @GeneratedValue(generator = "movie_id_gen",strategy = GenerationType.SEQUENCE)	
     @Column(name="movie_id")
     int movieId;
     @Column(name="movie_name")
     String movieName;
     String language;
     @Column(name="director")
     String directorName;
     @Column(name="hero")
     String heroName;
     @Column(name="heroine")
     String heroineName; 
     int duration;
     @Column(name="release_date")
     LocalDate releaseDate;
     String type;
     public Movie() 
     {
    	 
     }
	 public Movie(int movieId, String movieName, String language, String directorName, String heroName,String heroineName, int duration, LocalDate releaseDate,String type) 
	 {
		  this.movieId = movieId;
		  this.movieName = movieName;		
		  this.language = language;
		  this.directorName = directorName;
		  this.heroName = heroName;
		  this.heroineName=heroineName; 
		  this.duration = duration;
		  this.releaseDate = releaseDate; 
		  this.type=type;
	 }
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getHeroineName() {
		return heroineName;
	}
	public void setHeroineName(String heroineName) {
		this.heroineName = heroineName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}