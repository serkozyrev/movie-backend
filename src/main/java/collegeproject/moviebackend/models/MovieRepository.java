package collegeproject.moviebackend.models;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String > {

    List<Movie> findByTitleContainingIgnoreCase(String title);

}
