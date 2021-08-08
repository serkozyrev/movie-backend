package collegeproject.moviebackend.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedMovieRepository extends MongoRepository<FeaturedMovie, String > {
}
