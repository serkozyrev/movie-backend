package collegeproject.moviebackend.services;

import collegeproject.moviebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeaturedShowService {
    @Autowired
    private FeaturedShowRepository repository;

    public List<FeaturedShow> getFeaturedShows(){
        return repository.findAll();
    }

    public Optional<FeaturedShow> getFeaturedShowById(String id){
        Optional<FeaturedShow> featuredShow=repository.findById(id);

        return featuredShow;
    }

    public void insertIntoFeaturedShows(FeaturedShow featuredShow){
        repository.insert(featuredShow);
    }
}
