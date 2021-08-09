package collegeproject.moviebackend.services;

import collegeproject.moviebackend.models.UserModel;
import collegeproject.moviebackend.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserModel addUser(UserModel user){

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        UserModel insertedUser = userRepository.insert(user);

        return insertedUser;
    }

    public List<UserModel> getUsers()
    {
        return userRepository.findAll();
    }

    public UserModel getAUser(String username)
    {
        return userRepository.findByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel foundUser= userRepository.findByUsername(username);
        String userN=foundUser.getUsername();
        String password= foundUser.getPassword();

        return new User(userN, password, new ArrayList<>());
    }
}
