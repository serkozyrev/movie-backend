package collegeproject.moviebackend.controllers;


import collegeproject.moviebackend.CustomizedResponse;
import collegeproject.moviebackend.models.UserModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody UserModel user){
        JSONObject jsonObject = new JSONObject();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            var response = new CustomizedResponse("You login Successfully", null);
            jsonObject.put("response",response.getMessage());
            jsonObject.put("userID", user.getUsername());
            return new ResponseEntity( jsonObject.toString(), HttpStatus.OK);
        } catch (BadCredentialsException ex){

            var response = new CustomizedResponse( "You username or password were entered incorrectly..", null);

            return new ResponseEntity( response, HttpStatus.OK);
        }

    }

}
