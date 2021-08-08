package collegeproject.moviebackend.services;


import collegeproject.moviebackend.models.Movie;
import collegeproject.moviebackend.models.MovieRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> getMovies(){
        return repository.findAll();

    }

    public Optional<Movie> getMovieById(String id) throws Exception{
        Optional<Movie> movie = repository.findById(id);

        if(!movie.isPresent()){
            throw new Exception(("Movie with " + id + " is not found"));
        }
        return movie;
    }

    public List<Movie> getMovieByTitle(String name){

        //Query query = new Query();
        //query.addCriteria(Criteria.where("title").is(name));
        //List<Movie> movies = mongoTemplate.find(query, Movie.class);

        List<Movie> movies=repository.findByTitleContainingIgnoreCase(name);
        return movies;
    }

    public void insertIntoMovies(Movie movie){
        repository.insert(movie);
    }

    public void deleteMovie( String id)
    {
        repository.deleteById(id);
    }

    public Movie editMovie(String id, Movie newMovie){
        Optional<Movie> movie = repository.findById(id);

        movie.get().setTitle(newMovie.getTitle());
        movie.get().setOverview(newMovie.getOverview());
        movie.get().setGenres(newMovie.getGenres());
        movie.get().setRelease_date(newMovie.getRelease_date());

        Movie updateMovie=repository.save(movie.get());
        return updateMovie;
    }
}
