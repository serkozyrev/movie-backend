package collegeproject.moviebackend.controllers;

import collegeproject.moviebackend.CustomizedResponse;
import collegeproject.moviebackend.models.Movie;
import collegeproject.moviebackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;



    @GetMapping("/movies")

    public ResponseEntity getMovies(){

        var customizedResponse=new CustomizedResponse(" A list of movies", service.getMovies());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getMovieById(@PathVariable("id") String id){

        CustomizedResponse customizedResponse= null;
        try {
            customizedResponse = new CustomizedResponse(" Movie with id " + id, Collections.singletonList(service.getMovieById(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/movies/search")
    public ResponseEntity getMoviesByTitle(@RequestParam(value="title") String name){
        var customizedResponse=new CustomizedResponse("A list of movies with the title : ", service.getMovieByTitle(name));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") String id){
        service.deleteMovie(id);
        return new ResponseEntity( HttpStatus.OK);
    }

    @PostMapping(value="/movies", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createMovies(@RequestBody Movie movie){
        service.insertIntoMovies(movie);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @PutMapping(value="/movies/{id}", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity editMovie(@PathVariable("id") String id, @RequestBody Movie newMovie){
        var customizedResponse = new CustomizedResponse(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(service.editMovie(id, newMovie)));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
}
