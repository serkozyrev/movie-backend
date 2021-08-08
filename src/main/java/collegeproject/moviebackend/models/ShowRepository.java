package collegeproject.moviebackend.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show, String > {
    List<Show> findByTitleContainingIgnoreCase(String title);
}
