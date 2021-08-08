package collegeproject.moviebackend.controllers;


import collegeproject.moviebackend.CustomizedResponse;
import collegeproject.moviebackend.models.Movie;
import collegeproject.moviebackend.models.Show;
import collegeproject.moviebackend.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService service;

    @GetMapping("/shows")
    public ResponseEntity getShows(){
        return new ResponseEntity(service.getShows(), HttpStatus.OK);
    }

    @GetMapping("/shows/{id}")
    public ResponseEntity getShowById(@PathVariable("id") String id){


        CustomizedResponse customizedResponse= null;
        try {
            customizedResponse = new CustomizedResponse(" Show with id " + id, Collections.singletonList(service.getShowById(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @PostMapping(value="/shows", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createShows(@RequestBody Show show){
        service.insertIntoShows(show);
        return new ResponseEntity(show, HttpStatus.OK);
    }

    @GetMapping("/shows/search")
    public ResponseEntity getShowsByTitle(@RequestParam(value="title") String name){
        var customizedResponse=new CustomizedResponse("A list of shows with the title : ", service.getShowByTitle(name));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity deleteShow(@PathVariable("id") String id){
        service.deleteShow(id);
        return new ResponseEntity( HttpStatus.OK);
    }

    @PutMapping(value="/shows/{id}", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity editShow(@PathVariable("id") String id, @RequestBody Show newShow){
        var customizedResponse = new CustomizedResponse(" Show with ID:  " + id + "was updated successfully " , Collections.singletonList(service.editShow(id, newShow)));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
}
