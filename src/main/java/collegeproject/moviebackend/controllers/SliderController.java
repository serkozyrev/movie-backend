package collegeproject.moviebackend.controllers;


import collegeproject.moviebackend.models.Slider;
import collegeproject.moviebackend.services.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SliderController {

    @Autowired
    private SliderService service;

    @GetMapping("/slider")
    public ResponseEntity getSlider(){
        return new ResponseEntity(service.getSlider(), HttpStatus.OK);
    }

    @PostMapping(value="/slider", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createSlider(@RequestBody Slider slider){
        service.insertIntoSlider(slider);
        return new ResponseEntity(slider, HttpStatus.OK);
    }
}
