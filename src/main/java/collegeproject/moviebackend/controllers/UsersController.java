package collegeproject.moviebackend.controllers;

import collegeproject.moviebackend.CustomizedResponse;
import collegeproject.moviebackend.models.UserModel;
import collegeproject.moviebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        var response = new CustomizedResponse( " A list of all users ", userService.getUsers());

        return new ResponseEntity( response, HttpStatus.OK);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity getAUsers(@PathVariable("username") String username)
    {

        var response = new CustomizedResponse( " User with id  : " + username, Collections.singletonList(userService.getAUser(username)));

        return new ResponseEntity( response, HttpStatus.OK);

    }

    @PostMapping(value = "/users", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createUsers(@RequestBody UserModel user)
    {


        var response = new CustomizedResponse( " User created successfully", Collections.singletonList(userService.addUser(user)));

        return new ResponseEntity( response, HttpStatus.OK);

    }
}
