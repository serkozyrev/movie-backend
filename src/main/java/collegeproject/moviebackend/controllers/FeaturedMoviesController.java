package collegeproject.moviebackend.controllers;

import collegeproject.moviebackend.models.FeaturedMovie;
import collegeproject.moviebackend.services.FeaturedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FeaturedMoviesController {
    @Autowired
    private FeaturedMovieService service;
    @GetMapping("/featured-movies")
    public ResponseEntity getFeaturedMovies(){
        return new ResponseEntity(service.getFeaturedMovies(), HttpStatus.OK);
    }

    @GetMapping("/featured-movies/{id}")
    public ResponseEntity getFeaturedMovieById(@PathVariable("id") String id){


        return new ResponseEntity(service.getFeaturedMovieById(id), HttpStatus.OK);
    }

    @PostMapping(value="/featured-movies", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createFeaturedMovies(@RequestBody FeaturedMovie featuredMovie){
        service.insertIntoFeaturedMovies(featuredMovie);

        return new ResponseEntity(featuredMovie, HttpStatus.OK);
    }
}
