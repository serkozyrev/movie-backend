package collegeproject.moviebackend.services;

import collegeproject.moviebackend.models.FeaturedMovie;
import collegeproject.moviebackend.models.FeaturedMovieRepository;
import collegeproject.moviebackend.models.FeaturedShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class FeaturedMovieService {
    @Autowired
    private FeaturedMovieRepository repository;

    public List<FeaturedMovie> getFeaturedMovies(){
        return repository.findAll();
    }

    public Optional<FeaturedMovie> getFeaturedMovieById(String id){
        Optional<FeaturedMovie> featuredMovie=repository.findById(id);

        return featuredMovie;
    }

    public void insertIntoFeaturedMovies(FeaturedMovie featuredMovie){
        repository.insert(featuredMovie);
    }
}
